package com.test.violationsdrivecarCommon.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;


public class HttpUtil {
	private static final String tongji = "";
	/**
	 * 
	 * @Title: doPost 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param surl 地址
	 * @param @param map 参数和值
	 * @param @param encoding 编码
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String doPost(String surl,Map<String,Object> map, String encoding) {
		//将map中的key和value添加到surl中
		int length = map.size();
		String[] keyArray = new String[length];// 参数名数组
		Object[] valueArray = new Object[length];// 参数值数组
		Iterator<String> it = map.keySet().iterator();
		int i = -1;
		StringBuilder sbd = new StringBuilder();
		while (it.hasNext())
		{
			i++;
			keyArray[i] = it.next();
			valueArray[i] = map.get(keyArray[i]);
		}
		
		for(int j=0;j<keyArray.length;j++){
			if(j==0){
				sbd.append(keyArray[j]+"=").append(valueArray[j]);
			}else{
				sbd.append("&"+keyArray[j]+"=").append(valueArray[j]);
			}
		}
		surl = surl+"?"+sbd.toString();
		String sresult = "";
		HttpURLConnection conn = null;
		surl = surl.replace("?&", "?");
		try {
			if (!surl.contains("?")) {
				surl = surl + "?";
			}
			String urlAddr = surl.substring(0, surl.indexOf("?"));
			String params = surl.substring(surl.indexOf("?") + 1);
			URL url = new URL(urlAddr + tongji);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", String.valueOf(params
					.length()));
			//conn.setRequestProperty("Accept-Language", "en-EN");
			//conn.setRequestProperty("Accept-Language", "zh-CN");
			
			conn.setDoInput(true);
			conn.connect();
			
			OutputStreamWriter out = new OutputStreamWriter(conn
					.getOutputStream(), encoding);
			out.write(params);
			out.flush();
			out.close();
			InputStream in = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(in, encoding);
			char[] b = new char[255];
			StringBuffer sb = new StringBuffer();
			int len = 0;
			while ((len = isr.read(b)) > 0) {
				sb.append(b, 0, len);
			}
			sresult = sb.toString();
			isr.close();
			in.close();
			conn.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		return sresult;
	}

}
