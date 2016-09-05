package com.test.violationsdrivecarCommon.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 黑名单
 * @author hhm
 *
 */
@Entity
@Table(name = "violations_blacklist")
public class BlackList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int blackId;
	/**
	 * 商户号
	 */
	private String merchantNo;
	/**
	 * 用户ID
	 */
	private String accountId;
	/**
	 * 用户手机号
	 */
	private String userPhone;
	/**
	 * 状态（1-正常，2-暂停，3-删除）
	 */
	private int status;
	private Date createTime;
	private Date updateTime;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "black_id", unique = true, nullable = false)
	public int getBlackId() {
		return blackId;
	}
	public void setBlackId(int blackId) {
		this.blackId = blackId;
	}
	@Column(name = "merchant_no")
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	@Column(name = "status")
	public int getStatus() {
		return status;
	}
	@Column(name = "account_id")
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	@Column(name = "user_phone")
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "update_time")
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	

}
