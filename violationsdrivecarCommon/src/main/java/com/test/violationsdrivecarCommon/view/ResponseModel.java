package com.test.violationsdrivecarCommon.view;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.test.violationsdrivecarCommon.model.ErrorStatus;

public class ResponseModel<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String respCode;
	private String reMark;
	private T body;
	@JsonSerialize
	public class Body {
	}
	public ResponseModel() {
		super();
	}
	
	public ResponseModel(ErrorStatus errorStatus, T body) {
		super();
		this.respCode = errorStatus.getErrorCode() + "";
		this.reMark = errorStatus.getErrorText();
		this.body = body;
	}
	@SuppressWarnings("unchecked")
	public ResponseModel(ErrorStatus errorStatus) {
		super();
		this.respCode = errorStatus.getErrorCode() + "";
		this.reMark = errorStatus.getErrorText();
		this.body = (T) new Body();
	}

	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getReMark() {
		return reMark;
	}
	public void setReMark(String reMark) {
		this.reMark = reMark;
	}
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
	@Override
	public String toString(){
		ObjectMapper om = new ObjectMapper();
		try {
			return om.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}
	

}
