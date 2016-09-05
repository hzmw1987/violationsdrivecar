package com.test.violationsdrivecarMS.service;

import com.test.violationsdrivecarCommon.exception.ApplicationException;
import com.test.violationsdrivecarCommon.view.ResponseModel;

public interface LoginService {
	
	ResponseModel<Object> login(String userName,String password) throws ApplicationException;

}
