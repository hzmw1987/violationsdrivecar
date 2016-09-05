package com.test.violationsdrivecarCommon.model;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商户的订单表
 * @author hhm
 *
 */
@Entity
@Table(name = "violations_order")
public class MerViolationsOrder
{
    //主键
    private int orderId;
    //订单号
    private String orderNo;
    //支付订单号
    private String payId;
    //
    private float amount;
    //渠道用户ID
    private String customerId;
    //招行id
    private String accountId;
    //状态
    private int state;
    //错误描述
    private String errorMsg;
    //下单时间
    private Date createtime;
    //更新时间
    private Date updatetime;
    /**
     * 描述
     */
    private String mark;
    private String postalCode;
    private String invoiceTitle;
    private String linkMan; 
    private String phone; 
    private String cityName; 
    private int paySource; 
    private String mobile;
    private String clientInfo;
    private Integer payType; 
    private String userName;
    private String clientAppid; 
    private String userMobile;
    private String chrCode;
    private String merOrderId;
    //订单金额
    private String totalMoney;
    private String isNeedsVerifyCode;
    private String returnId;
    private String random;
    private String description;
    private String ext;
    private String streetAddress;
    private String channelId;
    private String codeNo;
    private String codeValue;
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false)
    public int getOrderId()
    {
        return orderId;
    }
    public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
    @Column(name = "order_no",length = 32)
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	@Column(name = "pay_id",length = 128)
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	@Column(name = "amount",length = 53)
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Column(name = "customer_id",length = 32)
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Column(name = "account_id",length = 128)
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	@Column(name = "state",length = 32)
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Column(name = "error_msg",length = 64)
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	@Column(name = "createtime",length = 6)
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Column(name = "updatetime",length = 6)
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	@Column(name = "mark")
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@Column(name = "postal_code")
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	@Column(name = "invoice_title")
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	@Column(name = "link_man")
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	@Column(name = "tele_phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name = "city_name")
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Column(name = "pay_source")
	public int getPaySource() {
		return paySource;
	}
	public void setPaySource(int paySource) {
		this.paySource = paySource;
	}
	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Column(name = "client_info")
	public String getClientInfo() {
		return clientInfo;
	}
	public void setClientInfo(String clientInfo) {
		this.clientInfo = clientInfo;
	}
	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}
	@Column(name = "pay_type")
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name = "client_appid")
	public String getClientAppid() {
		return clientAppid;
	}
	public void setClientAppid(String clientAppid) {
		this.clientAppid = clientAppid;
	}
	@Column(name = "user_mobile")
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	@Column(name = "chr_code")
	public String getChrCode() {
		return chrCode;
	}
	public void setChrCode(String chrCode) {
		this.chrCode = chrCode;
	}
	@Column(name = "mer_order_id")
	public String getMerOrderId() {
		return merOrderId;
	}
	public void setMerOrderId(String merOrderId) {
		this.merOrderId = merOrderId;
	}
	@Column(name = "total_money")
	public String getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}
	@Column(name = "is_needs_verify_code")
	public String getIsNeedsVerifyCode() {
		return isNeedsVerifyCode;
	}
	public void setIsNeedsVerifyCode(String isNeedsVerifyCode) {
		this.isNeedsVerifyCode = isNeedsVerifyCode;
	}
	@Column(name = "return_id")
	public String getReturnId() {
		return returnId;
	}
	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}
	@Column(name = "random")
	public String getRandom() {
		return random;
	}
	public void setRandom(String random) {
		this.random = random;
	}
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "ext")
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	@Column(name = "street_address")
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	@Column(name = "channel_id")
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	@Column(name = "code_no")
	public String getCodeNo() {
		return codeNo;
	}
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}
	@Column(name = "code_value")
	public String getCodeValue() {
		return codeValue;
	}
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
    
    
    
}
