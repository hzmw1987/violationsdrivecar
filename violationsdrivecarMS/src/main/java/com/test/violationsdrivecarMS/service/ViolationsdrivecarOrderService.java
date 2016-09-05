package com.test.violationsdrivecarMS.service;

import com.test.violationsdrivecarCommon.exception.ApplicationException;
import com.test.violationsdrivecarCommon.model.ViolationsOrder;
import com.test.violationsdrivecarMS.response.FindListResp;

public interface ViolationsdrivecarOrderService {
	/**
	 * 查询订单列表
	 * @param startTime
	 * 查询时段开始时间
	 * @param endTime
	 * 查询时段结束时间
	 * @param status
	 * 状态
	 * @param orderNo
	 * 订单号
	 * @param shopSign
	 * 车牌号
	 * @param phone
	 * 手机号
	 * @param name
	 * 姓名
	 * @return
	 * @throws ApplicationException
	 */
	FindListResp<ViolationsOrder> findViolationsdrivecarOrderList(String startTime,String endTime,int status,String orderNo,
			String shopSign,String phone,String name,int page ,int pageSize)throws ApplicationException;

}
