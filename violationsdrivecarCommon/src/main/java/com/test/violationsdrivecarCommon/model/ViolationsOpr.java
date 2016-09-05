package com.test.violationsdrivecarCommon.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  订单历史表
* @ClassName: ViolationsOpr 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2014-10-24 下午5:03:41 
*
 */
@Entity
@Table(name = "cro_history_order")
public class ViolationsOpr
{
    private Integer historyId;
    private String merOrderNo;//商户订单号
    private String merStatus;//商户订单状态
    private String merRemark;//商户订单状态说明
    private String orderNo;//核心订单号
    private String status;//核心订单状态
    private String remark;//核心订单状态说明
    private String chaOrderNo;//渠道订单号
    private String chaStatus;//渠道订单状态
    private String chaRemark;//渠道订单状态说明
    private String action;//动作码
    private String actionRemark;//动作说明
    private String reqUrl;//请求的url
    private String reqParam;//请求的参数
    private String response;//请求的响应
    private double totalAmount;//总金额
    private double payAmount;//支付金额
    private Date createdAt;//创建时间
    private Date updatedAt;//更新时间
    private String merchantNo;//商户号
    private String funguideChannelId;//渠道号
    private String reason = "成功";//动作的结果，默认是成功
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id", unique = true, nullable = false)
    public Integer getHistoryId()
    {
        return historyId;
    }
    public void setHistoryId(Integer historyId)
    {
        this.historyId = historyId;
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
    @Column(name = "mer_status",length = 5)
    public String getMerStatus()
    {
        return merStatus;
    }
    public void setMerStatus(String merStatus)
    {
        this.merStatus = merStatus;
    }
    @Column(name = "mer_remark",length = 32)
    public String getMerRemark()
    {
        return merRemark;
    }
    public void setMerRemark(String merRemark)
    {
        this.merRemark = merRemark;
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
    @Column(name = "status",length = 5)
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    @Column(name = "remark",length = 32)
    public String getRemark()
    {
        return remark;
    }
    public void setRemark(String remark)
    {
        this.remark = remark;
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
    @Column(name = "cha_status",length = 5)
    public String getChaStatus()
    {
        return chaStatus;
    }
    public void setChaStatus(String chaStatus)
    {
        this.chaStatus = chaStatus;
    }
    @Column(name = "cha_remark",length = 32)
    public String getChaRemark()
    {
        return chaRemark;
    }
    public void setChaRemark(String chaRemark)
    {
        this.chaRemark = chaRemark;
    }
    @Column(name = "action",length = 32)
    public String getAction()
    {
        return action;
    }
    public void setAction(String action)
    {
        this.action = action;
    }
    @Column(name = "action_remark",length = 32)
    public String getActionRemark()
    {
        return actionRemark;
    }
    public void setActionRemark(String actionRemark)
    {
        this.actionRemark = actionRemark;
    }
    @Column(name = "req_url",length = 300)
    public String getReqUrl()
    {
        return reqUrl;
    }
    public void setReqUrl(String reqUrl)
    {
        this.reqUrl = reqUrl;
    }
    @Column(name = "req_param",length = 300)
    public String getReqParam()
    {
        return reqParam;
    }
    public void setReqParam(String reqParam)
    {
        this.reqParam = reqParam;
    }
    @Column(name = "response",length = 300)
    public String getResponse()
    {
        return response;
    }
    public void setResponse(String response)
    {
        this.response = response;
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
    @Column(name = "created_at",length = 32)
    public Date getCreatedAt()
    {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }
    @Column(name = "updated_at",length = 32)
    public Date getUpdatedAt()
    {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }
    @Column(name = "merchant_no",length = 32)
    public String getMerchantNo()
    {
        return merchantNo;
    }
    public void setMerchantNo(String merchantNo)
    {
        this.merchantNo = merchantNo;
    }
    @Column(name = "channel_no",length = 32)
    public String getFunguideChannelId()
    {
        return funguideChannelId;
    }
    public void setFunguideChannelId(String funguideChannelId)
    {
        this.funguideChannelId = funguideChannelId;
    }
    @Column(name = "reason",length = 300)
    public String getReason()
    {
        return reason;
    }
    public void setReason(String reason)
    {
        this.reason = reason;
    }
	@Override
	public String toString() {
		return "ViolationsOpr [historyId=" + historyId + ", merOrderNo="
				+ merOrderNo + ", merStatus=" + merStatus + ", merRemark="
				+ merRemark + ", orderNo=" + orderNo + ", status=" + status
				+ ", remark=" + remark + ", chaOrderNo=" + chaOrderNo
				+ ", chaStatus=" + chaStatus + ", chaRemark=" + chaRemark
				+ ", action=" + action + ", actionRemark=" + actionRemark
				+ ", reqUrl=" + reqUrl + ", reqParam=" + reqParam
				+ ", response=" + response + ", totalAmount=" + totalAmount
				+ ", payAmount=" + payAmount + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", merchantNo=" + merchantNo
				+ ", funguideChannelId=" + funguideChannelId + ", reason="
				+ reason + ", getHistoryId()=" + getHistoryId()
				+ ", getMerOrderNo()=" + getMerOrderNo() + ", getMerStatus()="
				+ getMerStatus() + ", getMerRemark()=" + getMerRemark()
				+ ", getOrderNo()=" + getOrderNo() + ", getStatus()="
				+ getStatus() + ", getRemark()=" + getRemark()
				+ ", getChaOrderNo()=" + getChaOrderNo() + ", getChaStatus()="
				+ getChaStatus() + ", getChaRemark()=" + getChaRemark()
				+ ", getAction()=" + getAction() + ", getActionRemark()="
				+ getActionRemark() + ", getReqUrl()=" + getReqUrl()
				+ ", getReqParam()=" + getReqParam() + ", getResponse()="
				+ getResponse() + ", getTotalAmount()=" + getTotalAmount()
				+ ", getPayAmount()=" + getPayAmount() + ", getCreatedAt()="
				+ getCreatedAt() + ", getUpdatedAt()=" + getUpdatedAt()
				+ ", getMerchantNo()=" + getMerchantNo()
				+ ", getFunguideChannelId()=" + getFunguideChannelId()
				+ ", getReason()=" + getReason() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
    
}
