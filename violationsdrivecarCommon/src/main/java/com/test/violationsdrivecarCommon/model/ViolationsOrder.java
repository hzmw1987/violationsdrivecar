package com.test.violationsdrivecarCommon.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 保存订单的数据库表
* @ClassName: ViolationsOrder 
* @Description: 
* @author A18ccms a18ccms_gmail_com 
* @date 2014-9-30 下午5:43:19 
*
 */
@Entity
@Table(name = "cro_violations_order")
public class ViolationsOrder
{
    //主键
    private Integer orderId;
    //商户号
    private String merchantNo;
    //商户订单号
    private String merOrderNo;
    //商户流水
    @JsonIgnore
    private String merTempNo;
    //商户订单状态
    @JsonIgnore
    private String merStatus;
    //商户订单状态说明
    @JsonIgnore
    private String merRemark;
    //用户姓名
    private String userName;
    //用户性别
    private String userSex;
    //用户手机号
    private String phone;
    //用户车牌
    private String shopSign;
    //车辆类型
    private String voitureType; 
    //发动机号
    private String engineNo; 
    //车身架号
    private String voitureNo; 
    //查询城市
    private String city; 
    //车辆注册日期
    @JsonIgnore
    private String registerdate;
    //收件人信息
    private String receiveDetail;
    //支付手机号
    @JsonIgnore
    private String payPhone; 
    //支付uid
    @JsonIgnore
    private String payUid;
    
    
    //核心系统订单号
    @JsonIgnore
    private String orderNo; 
    //核心流水
    @JsonIgnore
    private String orderTempNo;
    //状态
    @JsonIgnore
    private String status;
    //备注说明
    @JsonIgnore
    private String remark;
    //优惠码
    private String codeNo;
    //优惠金额
    private double codeValue;
    
    
    //渠道的订单号
    private String chaOrderNo;
    //渠道流水
    @JsonIgnore
    private String chaTempNo;
    //渠道订单状态
    private String chaStatus;
    //渠道订单状态说明
    private String chaRemark;
    //罚金
    private double fineAmount; 
    //代办费
    private double agencyFees; 
    //滞纳金
    private double lateFee; 
    //订单金额
    private double totalAmount;
    //支付金额
    private double payAmount;
    //本地总金额
    private double localAmount;
    //新空气渠道号
    private String funguideChannelId;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //商户支付订单号
    private String payId;
    //支付完成时间
    private Date payTime;
    //通知渠道完成时间
    private Date callTime;
    //客户端请求商户IP
    private String termip;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false)
    public Integer getOrderId()
    {
        return orderId;
    }
    public void setOrderId(Integer orderId)
    {
        this.orderId = orderId;
    }
    @Column(name = "merchant_no",length = 10)
    public String getMerchantNo()
    {
        return merchantNo;
    }
    public void setMerchantNo(String merchantNo)
    {
        this.merchantNo = merchantNo;
    }
    @Column(name = "mer_order_no",length = 32)
    public String getMerOrderNo()
    {
        return merOrderNo;
    }
    public void setMerOrderNo(String merOrderNo)
    {
        this.merOrderNo = merOrderNo;
    }
    @Column(name = "mer_temp_no",length = 32)
    public String getMerTempNo()
    {
        return merTempNo;
    }
    public void setMerTempNo(String merTempNo)
    {
        this.merTempNo = merTempNo;
    }
    @Column(name = "mer_status",length = 5)
    public String getMerStatus()
    {
        return merStatus;
    }
    public void setMerStatus(String merStatus)
    {
        this.merStatus = merStatus;
    }
    @Column(name = "mer_remark",length = 64)
    public String getMerRemark()
    {
        return merRemark;
    }
    public void setMerRemark(String merRemark)
    {
        this.merRemark = merRemark;
    }
    @Column(name = "phone",length = 32)
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    @Column(name = "shopsign",length = 32)
    public String getShopSign()
    {
        return shopSign;
    }
    public void setShopSign(String shopSign)
    {
        this.shopSign = shopSign;
    }
    @Column(name = "voiture_type",length = 32)
    public String getVoitureType()
    {
        return voitureType;
    }
    public void setVoitureType(String voitureType)
    {
        this.voitureType = voitureType;
    }
    @Column(name = "engine_no",length = 32)
    public String getEngineNo()
    {
        return engineNo;
    }
    public void setEngineNo(String engineNo)
    {
        this.engineNo = engineNo;
    }
    @Column(name = "voiture_no",length = 32)
    public String getVoitureNo()
    {
        return voitureNo;
    }
    public void setVoitureNo(String voitureNo)
    {
        this.voitureNo = voitureNo;
    }
    @Column(name = "city",length = 32)
    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    @Column(name = "register_date",length = 32)
    public String getRegisterdate()
    {
        return registerdate;
    }
    public void setRegisterdate(String registerdate)
    {
        this.registerdate = registerdate;
    }
    @Column(name = "receive_detail",length = 300)
    public String getReceiveDetail()
    {
        return receiveDetail;
    }
    public void setReceiveDetail(String receiveDetail)
    {
        this.receiveDetail = receiveDetail;
    }
    @Column(name = "pay_phone",length = 32)
    public String getPayPhone()
    {
        return payPhone;
    }
    public void setPayPhone(String payPhone)
    {
        this.payPhone = payPhone;
    }
    @Column(name = "pay_uid",length = 32)
    public String getPayUid()
    {
        return payUid;
    }
    public void setPayUid(String payUid)
    {
        this.payUid = payUid;
    }
    @Column(name = "order_no",length = 32)
    public String getOrderNo()
    {
        return orderNo;
    }
    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }
    @Column(name = "order_temp_no",length = 32)
    public String getOrderTempNo()
    {
        return orderTempNo;
    }
    public void setOrderTempNo(String orderTempNo)
    {
        this.orderTempNo = orderTempNo;
    }
    @Column(name = "status",length = 5)
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    @Column(name = "remark",length = 64)
    public String getRemark()
    {
        return remark;
    }
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    @Column(name = "pay_code",length = 32)
    public String getCodeNo()
    {
        return codeNo;
    }
    public void setCodeNo(String codeNo)
    {
        this.codeNo = codeNo;
    }
    @Column(name = "code_value",length = 32)
    public double getCodeValue()
    {
        return codeValue;
    }
    public void setCodeValue(double codeValue)
    {
        this.codeValue = codeValue;
    }
    @Column(name = "cha_order_no",length = 32)
    public String getChaOrderNo()
    {
        return chaOrderNo;
    }
    public void setChaOrderNo(String chaOrderNo)
    {
        this.chaOrderNo = chaOrderNo;
    }
    @Column(name = "cha_temp_no",length = 32)
    public String getChaTempNo()
    {
        return chaTempNo;
    }
    public void setChaTempNo(String chaTempNo)
    {
        this.chaTempNo = chaTempNo;
    }
    @Column(name = "cha_status",length = 5)
    public String getChaStatus()
    {
        return chaStatus;
    }
    public void setChaStatus(String chaStatus)
    {
        this.chaStatus = chaStatus;
    }
    @Column(name = "cha_remark",length = 64)
    public String getChaRemark()
    {
        return chaRemark;
    }
    public void setChaRemark(String chaRemark)
    {
        this.chaRemark = chaRemark;
    }
    @Column(name = "fine_amount",length = 8)
    public double getFineAmount()
    {
        return fineAmount;
    }
    public void setFineAmount(double fineAmount)
    {
        this.fineAmount = fineAmount;
    }
    @Column(name = "agency_fees",length = 8)
    public double getAgencyFees()
    {
        return agencyFees;
    }
    public void setAgencyFees(double agencyFees)
    {
        this.agencyFees = agencyFees;
    }
    @Column(name = "late_fee",length = 8)
    public double getLateFee()
    {
        return lateFee;
    }
    public void setLateFee(double lateFee)
    {
        this.lateFee = lateFee;
    }
    @Column(name = "total_amount",length = 8)
    public double getTotalAmount()
    {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount)
    {
        this.totalAmount = totalAmount;
    }
    @Column(name = "pay_amount",length = 8)
    public double getPayAmount()
    {
        return payAmount;
    }
    public void setPayAmount(double payAmount)
    {
        this.payAmount = payAmount;
    }
    @Column(name = "local_amount",length = 8)
    public double getLocalAmount()
    {
        return localAmount;
    }
    public void setLocalAmount(double localAmount)
    {
        this.localAmount = localAmount;
    }
    @Column(name = "created_at",length = 32)
    public Date getCreateTime()
    {
        return createTime;
    }
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    @Column(name = "updated_at",length = 32)
    public Date getUpdateTime()
    {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }
    @Column(name = "channel_no",length = 10)
    public String getFunguideChannelId()
    {
        return funguideChannelId;
    }
    public void setFunguideChannelId(String funguideChannelId)
    {
        this.funguideChannelId = funguideChannelId;
    }
    @Column(name = "user_name",length = 32)
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    @Column(name = "user_sex",length = 32)
    public String getUserSex()
    {
        return userSex;
    }
    public void setUserSex(String userSex)
    {
        this.userSex = userSex;
    }
    @Column(name = "pay_id",length = 128)
    public String getPayId() {
  		return payId;
  	}
  	public void setPayId(String payId) {
  		this.payId = payId;
  	}
  	@Column(name = "pay_time",length = 32)
  	public Date getPayTime() {
  		return payTime;
  	}
  	public void setPayTime(Date payTime) {
  		this.payTime = payTime;
  	}
  	@Column(name = "call_time",length = 32)
	public Date getCallTime() {
		return callTime;
	}
	public void setCallTime(Date callTime) {
		this.callTime = callTime;
	}
	@Column(name = "termip",length = 20)
	public String getTermip() {
		return termip;
	}
	public void setTermip(String termip) {
		this.termip = termip;
	}
    
    
}
