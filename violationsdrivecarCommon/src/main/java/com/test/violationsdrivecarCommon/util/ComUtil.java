package com.test.violationsdrivecarCommon.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class ComUtil {

	/**
	 * 将文件读成字符串
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException 
	 */
	public static String readToString(String filePath){
		InputStream in = ComUtil.class.getResourceAsStream(filePath);
		byte[] filecontent = new byte[2048];
		try {
			in.read(filecontent);
			in.close(); 
			return new String(filecontent).trim();//返回文件内容,默认编码
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获得Map结构的 http请求的参数
	 *
	 * @return 请求的参数
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public static Map<String, Object> mapEncoder(Map<String, Object> map) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		for (String key : map.keySet()) {
			System.out.println("key= "+ key + " and value= " + map.get(key));
			if(map.get(key) instanceof String){
				try {
					map.put(key, URLEncoder.encode((String)map.get(key), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}

		return map;
	}

	/**
	 * 生成随机码
	 * 字母+数字
	 * 
	 * @param length
	 *            生成多长的随机码
	 * @return
	 */

	public static String generateRandomCode(int length) {
		Random random = new Random();
		String val = "";
		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字

			if ("char".equalsIgnoreCase(charOrNum)) { // 字符串
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	/**
	 * 生成订单号
	 * @param merchantNo
	 * @return
	 */
	public static String getOrderNo(String merchantNo){
		SimpleDateFormat sfd = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		StringBuffer orderNo = new StringBuffer();
		orderNo.append(merchantNo);
		orderNo.append(sfd.format(new Date()));
		orderNo.append(generateRandomCode(3));
		return orderNo.toString();
	}
	/**
	 * 判断一个对象是否为空
	 * 
	 * @param obj
	 * @return
	 */

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {

		if (obj == null)
			return true;

		if (obj instanceof String) {
			String str = (String) obj;
			if ("".equals(str))
				return true;
			if("null".equals(str))
				return true;
			if("''".equals(str))
				return true;
		}
		if (obj instanceof Collection) {
			Collection c = (Collection) obj;
			if (c.isEmpty())
				return true;
		}

		if (obj instanceof Map) {
			Map map = (Map) obj;
			if (map.isEmpty())
				return true;
		}

		if (obj.getClass().isArray()) {
			if (Array.getLength(obj) <= 0)
				return true;
		}

		return false;
	}
	/**
	 * <pre> 
	 *
	 * 生成纯数字随机数
	 *</pre> 
	 * @param length
	 * @return String
	 */
	public static String generateRandomCodeNum(int length) {
		Random random = new Random();
		StringBuffer val = new StringBuffer();
		for (int i = 0; i < length; i++) {
			val.append(random.nextInt(10));
		}
		return val.toString();
	}

	/**
	 * <pre> 
	 *
	 * 生成一个指定长度的流水(时间戳17位+随机数)
	 * length必须大于等于20，否则默认为20位
	 *</pre> 
	 * @param length
	 * @return String
	 */
	public static String initSerialno(int length) {
		if(length<20){
			length = 20;
		}
		String s = DateTimeUtil.currentDatetime2();
		StringBuffer sb = new StringBuffer();
		return sb.append(s).append(generateRandomCode(length-s.length())).toString();
	}
	/**
	 * MD5
	 *
	 * @param target
	 * @return String
	 * @throws NoSuchAlgorithmException
	 */
	public static String md5(String target) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		return digest(target, "MD5");
	}
	/**
	 * 摘要算法
	 * 
	 * @param target
	 * @param algorithm
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException 
	 */
	public static String digest(String target, String algorithm) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		MessageDigest digest = MessageDigest.getInstance(algorithm);
		digest.update(target.getBytes("utf-8"));
		byte[] md5Bytes = digest.digest();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < md5Bytes.length; i++) {
			sb.append(Character.forDigit(md5Bytes[i] >>> 4 & 0xf, 16));
			sb.append(Character.forDigit(md5Bytes[i] & 0xf, 16));
		}
		return sb.toString();
	}
	/**
	 * 去除list中重复的值
	 * @param list
	 * @return
	 */
	public static List<Integer> removeDuplicate(List<Integer> list)   { 
		 HashSet<Integer> h = new HashSet<Integer>(list); 
		 list.clear(); 
		 list.addAll(h);  
		 return list;
	} 
	/** 
	 * @Title: getIpAddr  
	 * @author kaka  www.zuidaima.com 
	 * @Description: 获取客户端IP地址   
	 * @param @return     
	 * @return String    
	 * @throws 
	 */  
	public static String getIpAddr(HttpServletRequest request) {   
	       String ip = request.getHeader("x-forwarded-for");   
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
	           ip = request.getHeader("Proxy-Client-IP");   
	       }   
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
	           ip = request.getHeader("WL-Proxy-Client-IP");   
	       }   
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
	           ip = request.getRemoteAddr();   
	           if(ip.equals("127.0.0.1")){     
	               //根据网卡取本机配置的IP     
	               InetAddress inet=null;     
	               try {     
	                   inet = InetAddress.getLocalHost();     
	               } catch (UnknownHostException e) {     
	                   e.printStackTrace();     
	               }     
	               ip= inet.getHostAddress();     
	           }  
	       }   
	       // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
	       if(ip != null && ip.length() > 15){    
	           if(ip.indexOf(",")>0){     
	               ip = ip.substring(0,ip.indexOf(","));     
	           }     
	       }     
	       return ip;   
	}  


}
