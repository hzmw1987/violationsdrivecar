package com.test.violationsdrivecarCommon.util;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

	public static boolean nullOrEmpty(String str) {
		return str == null || str.length() == 0;
	}

	public static int getInt(String str) {
		return Integer.parseInt(str);
	}

	public static int getInt(String str, int defaultValue) {
		try {
			if (nullOrEmpty(str))
				return defaultValue;
			return getInt(str);
		} catch (RuntimeException e) {
			return defaultValue;
		}
	}

	public static long getLong(String str) {
		return Long.parseLong(str);
	}

	public static long getLong(String str, long defaultValue) {
		try {
			if (nullOrEmpty(str))
				return defaultValue;
			return getLong(str);
		} catch (RuntimeException e) {
			return defaultValue;
		}
	}

	public static boolean getBoolean(String str, boolean defaultValue) {
		try {
			if (nullOrEmpty(str))
				return defaultValue;
			return getBoolean(str);
		} catch (RuntimeException e) {
			return defaultValue;
		}
	}

	public static boolean getBoolean(String str) {
		if (str == null)
			throw new NullPointerException("Input string can not be null");

		if ("1".equals(str) || "true".equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str))
			return true;
		else if ("0".equals(str) || "false".equalsIgnoreCase(str) || "no".equalsIgnoreCase(str))
			return false;
		else
			throw new IllegalArgumentException("Input string '" + str + "' can not convert to boolean value.");
	}

	public static Date getDate(String s) {
		return getDate(s, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date getDate(String str, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			return null;
		} catch (RuntimeException e) {
			return null;
		}
	}

	public static String toString(Date date) {
		return toString(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String toString(Date date, String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		return sdf.format(date);
	}
	
	/**
	 * 将字符串东八区时间格式化为UTC时间(将订单服务器时间转为UTC时间用)
	 * @param dateStr
	 * @return
	 */
	/*public static Date dateToUTC(String dateStr){
    	Date date = StringUtils.getDate(dateStr + "+0800", "yyyy-MM-dd HH:mm:ssZ");
    	return date = DateUtils.toUTC(date);
    }*/

	public static String toHexString(byte[] value) {
		StringBuilder result = new StringBuilder(value.length * 2);
		for (byte ch : value) {
			result.append(toHexString(ch));
		}
		return result.toString();
	}

	public static String toHexString(byte value) {
		final char[] HEX_TABLE = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B',
				'C', 'D', 'E', 'F' };

		byte low = (byte) (value & 0x0f);
		byte high = (byte) ((value & 0xf0) >> 4);
		StringBuilder result = new StringBuilder(2);
		result.append(HEX_TABLE[high]);
		result.append(HEX_TABLE[low]);

		return result.toString();
	}
	
	/**
	 * 
	 * @Description: TODO(将字符串中间字段用“*”替换)
	 * @Detail:（将身份证，卡号等敏感信息部分用“*”替换） 
	 * @param str
	 * @return
	 * String
	 *
	 */
	public static String subStringChange(String str){
		return str.substring(0, 3)+"*****"+str.substring(str.length()-4);
	}
	
	
	/**
	 * 将文件读成字符串
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException 
	 */
	public static String readToString(String filePath) throws IOException {
		File file=new File(filePath);
        Long filelength = file.length();     //获取文件长度
        byte[] filecontent = new byte[filelength.intValue()];
        FileInputStream in = new FileInputStream(file);
        in.read(filecontent);
        in.close(); 
        return new String(filecontent);//返回文件内容,默认编码
	}
	
	/**
	 * 计算百分比
	 * @param num
	 * @param sumNum
	 * @return
	 */
	public static String percent(String num,String sumNum) {
		BigDecimal a1 = new BigDecimal(sumNum).setScale(7, BigDecimal.ROUND_HALF_UP);
        BigDecimal a2 = new BigDecimal(num).setScale(7, BigDecimal.ROUND_HALF_UP);

        BigDecimal r = (a2).divide(a1, 4, BigDecimal.ROUND_HALF_EVEN).setScale(4,
            BigDecimal.ROUND_HALF_UP);

        BigDecimal max = new BigDecimal(99.5);
        BigDecimal min = new BigDecimal(1);
        NumberFormat percent = NumberFormat.getPercentInstance();
        if(r.compareTo(max)==1 || r.compareTo(min)==-1){
        	percent.setMaximumFractionDigits(2);
        }else{
        	percent.setMaximumFractionDigits(0);
        }
        
        return percent.format(r.doubleValue());
	}
	
}
