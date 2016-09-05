package com.test.violationsdrivecarCommon.exception;

import com.test.violationsdrivecarCommon.model.ErrorStatus;
import com.test.violationsdrivecarCommon.view.ResponseModel;

public class ApplicationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResponseModel<Object> responseModel;
	
	
	public ApplicationException() {
		this(ErrorStatus.KEY_INTERNAL_SERVER_ERROR);
	}

	public ApplicationException(String errorKey) {
		this.responseModel = new ResponseModel<Object>(ErrorStatus.getErrorStatus(errorKey));
	}

	public ResponseModel<Object> getResponseModel() {
		return responseModel;
	}

	public void setResponseModel(ResponseModel<Object> responseModel) {
		this.responseModel = responseModel;
	}


}
