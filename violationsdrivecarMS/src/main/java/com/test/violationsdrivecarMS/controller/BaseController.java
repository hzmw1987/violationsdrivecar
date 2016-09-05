package com.test.violationsdrivecarMS.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.violationsdrivecarCommon.exception.ApplicationException;
import com.test.violationsdrivecarCommon.model.ErrorStatus;
import com.test.violationsdrivecarCommon.view.ResponseModel;

public class BaseController {
	
	private static Logger log = LoggerFactory.getLogger(BaseController.class);
	
	/**
	 * 异常处理
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Throwable.class)
	public @ResponseBody Object handleException(Throwable ex) {

		log.warn("handling exception: {}...", ex.getClass().getName());
		ResponseModel<Object> msg = null;
		if (ex instanceof ApplicationException) {
			ApplicationException e = (ApplicationException) ex;
			msg = e.getResponseModel();
			log.warn("error status: {}, {}", msg.getRespCode(), msg.getReMark());
		} else {
			msg = new ResponseModel<Object>(ErrorStatus.getErrorStatus(ErrorStatus.KEY_INTERNAL_SERVER_ERROR));
			log.warn("unexpected error: {}", ex);
			ex.printStackTrace();
		}
		return msg;
	}

}
