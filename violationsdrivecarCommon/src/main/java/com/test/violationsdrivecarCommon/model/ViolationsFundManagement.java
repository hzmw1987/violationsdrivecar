package com.test.violationsdrivecarCommon.model;


import java.io.Serializable;
import java.util.Date;

/**
 * 第三方商户预存款记录
 * @author hhm
 *
 */
public class ViolationsFundManagement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 商户号
	 */
	private String merchantNo;
	/**
	 * 动作 1-充值，2-扣款
	 */
	private int action;
	/**
	 * 充值或扣款金额
	 */
	private long amount;
	/**
	 * 操作时间
	 */
	private Date actionTime;
	
	
	
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public Date getActionTime() {
		return actionTime;
	}
	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}
	
	
	

}
