package com.test.violationsdrivecarMS.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.violationsdrivecarCommon.dao.CmModelDao;
import com.test.violationsdrivecarCommon.dao.UserDao;
import com.test.violationsdrivecarCommon.exception.ApplicationException;
import com.test.violationsdrivecarCommon.model.CmModel;
import com.test.violationsdrivecarCommon.model.ErrorStatus;
import com.test.violationsdrivecarCommon.model.User;
import com.test.violationsdrivecarCommon.util.ComUtil;
import com.test.violationsdrivecarCommon.util.FormValidator;
import com.test.violationsdrivecarCommon.util.SecurityUtils;
import com.test.violationsdrivecarCommon.view.ResponseModel;
import com.test.violationsdrivecarMS.request.LoginForm;
@Controller
@RequestMapping(value = "/user" ,produces = "application/json;charset=UTF-8")
public class LoginController extends BaseController{

	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private UserDao userDao;
	@Autowired
	private CmModelDao modelDao;
	/**
	 * 登陆
	 * @param form
	 * @param request
	 * @return
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody Object login(LoginForm form,HttpServletRequest request) throws ApplicationException{
		log.info("login(username{},password{})",form.getUsername(),form.getPassword());
		FormValidator.validate(form, LoginForm.loginGroup.class);
		User user = userDao.getUserByName(form.getUsername());
		if(ComUtil.isEmpty(user)){
			log.info("用户名{},不存在",form.getUsername());
			throw new ApplicationException();
		}
		if(!SecurityUtils.verifyPassword(form.getPassword(), user.getUserPsd())){
			log.info("用户名{}对应的密码{}错误",form.getUsername(),form.getPassword());
			throw new ApplicationException();
		}
		request.getSession().setAttribute("user", user);
		String requestIp = ComUtil.getIpAddr(request);
		userDao.updateUserLoginTime(requestIp, user.getUserName());
		return new ResponseModel<Object>(ErrorStatus.getErrorStatus(ErrorStatus.KEY_SUCCESS),user);
	}
	/**
	 * 获取用户权限
	 * @param request
	 * @return
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/getRole", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody Object getRole(HttpServletRequest request) throws ApplicationException{
		User user = (User) request.getSession().getAttribute("user");
		if(ComUtil.isEmpty(user)){
			log.info("用户信息不存在，请充新登录");
			throw new ApplicationException(ErrorStatus.KEY_NOT_LOGIN);
		}
		//获取用户的角色
		List<CmModel> list = Collections.emptyList();
		list = modelDao.findModelByModelIds(user.getRoleId());
		String requestIp = ComUtil.getIpAddr(request);
		userDao.updateUserLoginTime(requestIp, user.getUserName());
		return new ResponseModel<Object>(ErrorStatus.getErrorStatus(ErrorStatus.KEY_SUCCESS),list);
	}


}
