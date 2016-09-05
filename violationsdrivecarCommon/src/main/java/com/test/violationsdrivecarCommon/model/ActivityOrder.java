package com.test.violationsdrivecarCommon.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "violations_order_and_activity")
public class ActivityOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int activityOrderId;
	private String orderNo;
	private String activityNo;
	private String merchantNo;
	private String cardNo;
	private String posId;
	private String payCardNo;
	private String payName;
	private int orderAmount;
	private int payAmount;
	private int couponValue;
	private Integer checkAmount;
	private Integer area;
	private int couponStatus;
	private String shopsign;
    private Date payTime;
    private Date createTime;
    private Date updateTime;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_and_activity_id", unique = true, nullable = false)
	public int getActivityOrderId() {
		return activityOrderId;
	}
	public void setActivityOrderId(int activityOrderId) {
		this.activityOrderId = activityOrderId;
	}
	@Column(name = "order_no")
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	@Column(name = "activity_no")
	public String getActivityNo() {
		return activityNo;
	}
	public void setActivityNo(String activityNo) {
		this.activityNo = activityNo;
	}
	@Column(name = "merchant_no")
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	@Column(name = "card_no")
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	@Column(name = "pos_id")
	public String getPosId() {
		return posId;
	}
	public void setPosId(String posId) {
		this.posId = posId;
	}
	@Column(name = "pay_card_no")
	public String getPayCardNo() {
		return payCardNo;
	}
	public void setPayCardNo(String payCardNo) {
		this.payCardNo = payCardNo;
	}
	@Column(name = "pay_name")
	public String getPayName() {
		return payName;
	}
	public void setPayName(String payName) {
		this.payName = payName;
	}
	@Column(name = "order_amount")
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	@Column(name = "pay_amount")
	public int getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}
	@Column(name = "coupon_value")
	public int getCouponValue() {
		return couponValue;
	}
	
	public void setCouponValue(int couponValue) {
		this.couponValue = couponValue;
	}
	
	@Column(name = "coupon_status")
	public int getCouponStatus() {
		return couponStatus;
	}
	@Column(name = "check_amount")
	public Integer getCheckAmount() {
		return checkAmount;
	}
	public void setCheckAmount(Integer checkAmount) {
		this.checkAmount = checkAmount;
	}
	public void setCouponStatus(int couponStatus) {
		this.couponStatus = couponStatus;
	}
	@Column(name = "shopsign")
	public String getShopsign() {
		return shopsign;
	}
	public void setShopsign(String shopsign) {
		this.shopsign = shopsign;
	}
	@Column(name = "pay_time")
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	@Column(name = "createtime")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "updatetime")
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Column(name = "area")
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
    
}
