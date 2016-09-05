package com.test.violationsdrivecarCommon.model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.context.i18n.LocaleContextHolder;

import com.test.violationsdrivecarCommon.util.StringUtils;


public class ErrorStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String KEY_SUCCESS = "200";//请求成功
	public static final String KEY_INTERNAL_SERVER_ERROR = "500";
	public static final String KEY_REQUECT_ERROR = "400";
	public static final String KEY_NOT_LOGIN = "300";
	
	/**
	 * 资源束名称
	 */
	private static final String RESOURCE_BUNDLE_NAME = "error_message";
	
	/**
	 * 根据指定的错误消息KEY获取错误状态对象
	 * 
	 * @param key
	 *            错误消息KEY
	 * @param args
	 *            可选的附加格式化参数
	 * @return 错误状态对象
	 */
	public static ErrorStatus getErrorStatus(String key,Object... args) {
		return new ErrorStatus(getErrorCode(key), getErrorText(key,args));
	}

	/**
	 * 获取字符串资源
	 * 
	 * @param key
	 *            错误消息KEY
	 * @param args
	 *            可变格式化参数
	 * @return 资源值字符串
	 */
	public static String getErrorText(String key, Object... args) {
		Locale locale = LocaleContextHolder.getLocale();
		ResourceBundle resourceBundle = ResourceBundle
				.getBundle(RESOURCE_BUNDLE_NAME, locale);
		// 从资源文件获取错误字符串.
		String value = resourceBundle.getString(key);
		if (StringUtils.nullOrEmpty(value)){
			value = "N/A";
		}
		// 替换格式化参数
		for (int i = 0; i < args.length; i++) {
			Object arg = args[i];
			value = value.replace("{" + i + "}",
					arg == null ? "(null)" : arg.toString());
		}
		return value;
	}

	/**
	 * 获取错误号
	 * 
	 * @param key
	 *            错误消息KEY
	 * @return 错误号
	 */
	public static int getErrorCode(String key) {
		return StringUtils.getInt(key, 500);
	}
	private int errorCode = -1;
	private String errorText = "";
	public ErrorStatus() {
		super();
		this.errorCode = getErrorCode(ErrorStatus.KEY_SUCCESS);
		this.errorText = getErrorText(ErrorStatus.KEY_SUCCESS);
	}

	public ErrorStatus(int errorCode, String errorText) {
		this.errorCode = errorCode;
		this.errorText = errorText;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorText() {
		try {
			errorText = new String(errorText.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return errorText;
	}
}
