package com.test.violationsdrivecarMS.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.test.violationsdrivecarCommon.dao.ViolationsOrderDao;
import com.test.violationsdrivecarCommon.exception.ApplicationException;
import com.test.violationsdrivecarCommon.model.ViolationsOrder;
import com.test.violationsdrivecarCommon.util.ComUtil;
import com.test.violationsdrivecarCommon.util.DateTimeUtil;
import com.test.violationsdrivecarMS.response.FindListResp;
import com.test.violationsdrivecarMS.response.PageMsg;
import com.test.violationsdrivecarMS.service.ViolationsdrivecarOrderService;
@Component
public class ViolationsdrivecarOrderServiceImpl implements ViolationsdrivecarOrderService{

	private static Logger log = LoggerFactory.getLogger(ViolationsdrivecarOrderServiceImpl.class);
	@Autowired
	private ViolationsOrderDao violationsOrderDao;
	
	@Override
	public FindListResp<ViolationsOrder> findViolationsdrivecarOrderList(
			String startTime, String endTime, int status, String orderNo,
			String shopSign, String phone, String name,int page ,int pageSize)
					throws ApplicationException {
		List<ViolationsOrder> list = Collections.emptyList();
		PageMsg pageMsg = null;
		try {
			Date startDate = DateTimeUtil.strtimeToDate(startTime);
			Date endDate = DateTimeUtil.strtimeToDate(endTime);
			int count = (int)questionListSize(startDate,endDate,status,orderNo,shopSign,phone,name);
			if(count > 0){
				list = findOrderList(startDate,endDate,status,orderNo,shopSign,phone,name,page,pageSize);
			}
			int pageCount = count / pageSize;
			pageCount = (count % pageSize == 0) ? pageCount : pageCount + 1;
			pageMsg = new PageMsg(page, pageSize, pageCount, count) ;
		} catch (Exception e) {
			log.error("查询发生异常{}" ,e.getMessage());
			throw new ApplicationException();
		}
		return new FindListResp<ViolationsOrder>(pageMsg,list);
	}
	/**
	 * 分页查询订单
	 * @param startDate
	 * @param endDate
	 * @param status
	 * @param orderNo
	 * @param shopSign
	 * @param phone
	 * @param name
	 * @param page
	 * @param pageSize
	 * @return
	 */
	private List<ViolationsOrder> findOrderList(Date startDate,Date endDate,int status, String orderNo,
			String shopSign, String phone, String name,int page ,int pageSize){
		PageRequest pageParam = new PageRequest(page,pageSize,Sort.Direction.ASC,"createTime");
		Page<ViolationsOrder> pages = questionList(startDate,endDate,status,orderNo,shopSign,phone,name,pageParam);
		if(!ComUtil.isEmpty(pages)){
			return pages.getContent();
		}
		return null;
		
	}
	/**
	 * 分页查询满足条件的列表
	 * @param startDate
	 * @param endDate
	 * @param status
	 * @param orderNo
	 * @param shopSign
	 * @param phone
	 * @param name
	 * @param pageable
	 * @return
	 */
	@Transactional(readOnly=true)
	private Page<ViolationsOrder> questionList(final Date startDate,final Date endDate,final int status ,final String orderNo,
			final String shopSign,final String phone,final String name,Pageable pageable) {
		Page<ViolationsOrder> question = violationsOrderDao.findAll(new Specification<ViolationsOrder>() {
			@Override
			public Predicate toPredicate(Root<ViolationsOrder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				List<Expression<Boolean>> expressions = predicate.getExpressions();
				if(!ComUtil.isEmpty(startDate) && !ComUtil.isEmpty(endDate)){
					expressions.add(cb.between(root.get("createTime").as(Date.class), startDate, endDate)); 
				}
				if(status > 0) {
					expressions.add(cb.equal(root.<Integer>get("status"), status)); 
				}
				if(!ComUtil.isEmpty(orderNo)){
					expressions.add(cb.equal(root.<String>get("chaOrderNo"), orderNo)); 
				}
				if(!ComUtil.isEmpty(shopSign)){
					expressions.add(cb.like(root.<String>get("shopSign"), "%"+shopSign +"%")); 
				}
				if(!ComUtil.isEmpty(phone)){
					expressions.add(cb.like(root.<String>get("phone"), phone +"%")); 
				}
				if(!ComUtil.isEmpty(name)){
					expressions.add(cb.like(root.<String>get("name"), "%"+phone +"%")); 
				}
				return predicate;
			}
		},pageable);
		return question;
	}
	/**
	 * 获取满足条件的订单总数
	 * @param startDate
	 * @param endDate
	 * @param status
	 * @param orderNo
	 * @param shopSign
	 * @param phone
	 * @param name
	 * @return
	 */
	@Transactional(readOnly=true)
	private long questionListSize(final Date startDate,final Date endDate,final int status ,final String orderNo,
			final String shopSign,final String phone,final String name) {
		long question = violationsOrderDao.count(new Specification<ViolationsOrder>() {
			@Override
			public Predicate toPredicate(Root<ViolationsOrder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				List<Expression<Boolean>> expressions = predicate.getExpressions();
				if(!ComUtil.isEmpty(startDate) && !ComUtil.isEmpty(endDate)){
					expressions.add(cb.between(root.get("createTime").as(Date.class), startDate, endDate)); 
				}
				if(status > 0) {
					expressions.add(cb.equal(root.<Integer>get("status"), status)); 
				}
				if(!ComUtil.isEmpty(orderNo)){
					expressions.add(cb.equal(root.<String>get("chaOrderNo"), orderNo)); 
				}
				if(!ComUtil.isEmpty(shopSign)){
					expressions.add(cb.like(root.<String>get("shopSign"), "%"+shopSign +"%")); 
				}
				if(!ComUtil.isEmpty(phone)){
					expressions.add(cb.like(root.<String>get("phone"), phone +"%")); 
				}
				if(!ComUtil.isEmpty(name)){
					expressions.add(cb.like(root.<String>get("name"), "%"+phone +"%")); 
				}
				return predicate;
			}
		});
		return question;
	}

}
