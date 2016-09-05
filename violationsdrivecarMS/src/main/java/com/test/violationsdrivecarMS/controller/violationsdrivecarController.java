package com.test.violationsdrivecarMS.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.violationsdrivecarCommon.exception.ApplicationException;
import com.test.violationsdrivecarCommon.model.ViolationsOrder;
import com.test.violationsdrivecarMS.request.FindOrderListForm;
import com.test.violationsdrivecarMS.response.FindListResp;
import com.test.violationsdrivecarMS.service.ViolationsdrivecarOrderService;
@Controller
@RequestMapping(value = "/order" ,produces = "application/json;charset=UTF-8")
public class violationsdrivecarController extends BaseController{
	
	private static Logger log = LoggerFactory.getLogger(violationsdrivecarController.class);
	@Autowired
	private ViolationsdrivecarOrderService violationsOrderService;

	@RequestMapping(value = "/orderList", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody FindListResp<ViolationsOrder> findAllOrderList(FindOrderListForm form) throws ApplicationException {
		log.info("findAllOrderList({})",form.toString());
		return violationsOrderService.findViolationsdrivecarOrderList(form.getStartTime(), form.getEndTime(),
				form.getStatus(), form.getOrderNo(), form.getShopSign(), form.getPhone(), form.getName(),
				form.getPage(), form.getPageSize());
	}
}
