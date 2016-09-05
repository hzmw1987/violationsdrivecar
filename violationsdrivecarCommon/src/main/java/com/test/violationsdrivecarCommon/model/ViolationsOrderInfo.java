package com.test.violationsdrivecarCommon.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 违章详情
* @ClassName: ViolationsOrderInfo 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2014-11-10 下午3:32:23 
*
 */
@Entity
@Table(name = "cro_violations_order_info")
public class ViolationsOrderInfo
{

    private Integer infoId;

    private String merchantNo;//商户号
    private String channelNo;//渠道号

    private String violationsId;//违章详情明细ID
    private String thirdPoint;//第三方标识，为了可查询至尊返回的违章详情明细ID
    
    private String logId;// varchar(32),--违章ID(唯一)
    private String voitureId;// varchar(10),--车辆ID
    private String shopSign;// varchar(32),--车牌号
    private double lateFee;// float8,--滞纳金
    private double agencyFees;// float8,--代办费
    private String provinceId;// varchar(32),--省ID
    private String cityId;// varchar(32),--城市ID
    private String areaId;// varchar(32),--区域ID
    private String peccancyPlace;// varchar(32),--违章地点
    private Date peccancyTime;// timestamp(32),--违章时间
    private String regulationId;// varchar(32),--违章条例ID
    private String peccancyRuleCode;// varchar(32),--违章条例代码
    private String peccancyRuleName;// varchar(32),--违章条例名称
    private double fineAmount;// float8,--罚金
    private String peccancyPoint;// int4,--违章扣分
    private boolean isLocaleBill;// boolean,
    private double totalAmount;// float8,--总金额
    
    private Integer refundStatusId;// int4, --退款状态码
    private String refundStatusName;// varchar(32),--退款状态说明
    private double refundAmount;// float8,--退款金额
    private Integer statusId;// int4, --违章详情明细状态码
    private String statusName;// varchar(32),--章详情明细状态说明

    private Date createdAt;// timestamp(32) NOT NULL,--创建时间
    private Date updatedAt;// timestamp(32) NOT NULL,--更新时间
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_id", unique = true, nullable = false)
    public Integer getInfoId()
    {
        return infoId;
    }
    public void setInfoId(Integer infoId)
    {
        this.infoId = infoId;
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
    @Column(name = "channel_no",length = 32)
    public String getChannelNo()
    {
        return channelNo;
    }
    public void setChannelNo(String channelNo)
    {
        this.channelNo = channelNo;
    }
    @Column(name = "violations_id",length = 32)
    public String getViolationsId()
    {
        return violationsId;
    }
    public void setViolationsId(String violationsId)
    {
        this.violationsId = violationsId;
    }
    @Column(name = "third_point",length = 32)
    public String getThirdPoint()
    {
        return thirdPoint;
    }
    public void setThirdPoint(String thirdPoint)
    {
        this.thirdPoint = thirdPoint;
    }
    @Column(name = "log_id",length = 32)
    public String getLogId()
    {
        return logId;
    }
    public void setLogId(String logId)
    {
        this.logId = logId;
    }
    @Column(name = "voiture_id",length = 32)
    public String getVoitureId()
    {
        return voitureId;
    }
    public void setVoitureId(String voitureId)
    {
        this.voitureId = voitureId;
    }
    @Column(name = "shop_sign",length = 32)
    public String getShopSign()
    {
        return shopSign;
    }
    public void setShopSign(String shopSign)
    {
        this.shopSign = shopSign;
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
    @Column(name = "agency_fees",length = 8)
    public double getAgencyFees()
    {
        return agencyFees;
    }
    public void setAgencyFees(double agencyFees)
    {
        this.agencyFees = agencyFees;
    }
    @Column(name = "province_id",length = 32)
    public String getProvinceId()
    {
        return provinceId;
    }
    public void setProvinceId(String provinceId)
    {
        this.provinceId = provinceId;
    }
    @Column(name = "city_id",length = 32)
    public String getCityId()
    {
        return cityId;
    }
    public void setCityId(String cityId)
    {
        this.cityId = cityId;
    }
    @Column(name = "area_id",length = 32)
    public String getAreaId()
    {
        return areaId;
    }
    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }
    @Column(name = "peccancy_place",length = 500)
    public String getPeccancyPlace()
    {
        return peccancyPlace;
    }
    public void setPeccancyPlace(String peccancyPlace)
    {
        this.peccancyPlace = peccancyPlace;
    }
    @Column(name = "peccancy_time",length = 32)
    public Date getPeccancyTime()
    {
        return peccancyTime;
    }
    public void setPeccancyTime(Date peccancyTime)
    {
        this.peccancyTime = peccancyTime;
    }
    @Column(name = "regulation_id",length = 32)
    public String getRegulationId()
    {
        return regulationId;
    }
    public void setRegulationId(String regulationId)
    {
        this.regulationId = regulationId;
    }
    @Column(name = "peccancy_rule_code",length = 32)
    public String getPeccancyRuleCode()
    {
        return peccancyRuleCode;
    }
    public void setPeccancyRuleCode(String peccancyRuleCode)
    {
        this.peccancyRuleCode = peccancyRuleCode;
    }
    @Column(name = "peccancy_rule_name",length = 300)
    public String getPeccancyRuleName()
    {
        return peccancyRuleName;
    }
    public void setPeccancyRuleName(String peccancyRuleName)
    {
        this.peccancyRuleName = peccancyRuleName;
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
    @Column(name = "peccancy_point",length = 4)
    public String getPeccancyPoint()
    {
        return peccancyPoint;
    }
    public void setPeccancyPoint(String peccancyPoint)
    {
        this.peccancyPoint = peccancyPoint;
    }
    @Column(name = "is_locale_bill",length = 4)
    public boolean isLocaleBill()
    {
        return isLocaleBill;
    }
    public void setLocaleBill(boolean isLocaleBill)
    {
        this.isLocaleBill = isLocaleBill;
    }
    @Column(name = "refund_status_id",length = 4)
    public Integer getRefundStatusId()
    {
        return refundStatusId;
    }
    public void setRefundStatusId(Integer refundStatusId)
    {
        this.refundStatusId = refundStatusId;
    }
    @Column(name = "refund_status_name",length = 32)
    public String getRefundStatusName()
    {
        return refundStatusName;
    }
    public void setRefundStatusName(String refundStatusName)
    {
        this.refundStatusName = refundStatusName;
    }
    @Column(name = "refund_amount",length = 8)
    public double getRefundAmount()
    {
        return refundAmount;
    }
    public void setRefundAmount(double refundAmount)
    {
        this.refundAmount = refundAmount;
    }
    @Column(name = "status_id",length = 4)
    public Integer getStatusId()
    {
        return statusId;
    }
    public void setStatusId(Integer statusId)
    {
        this.statusId = statusId;
    }
    @Column(name = "status_name",length = 32)
    public String getStatusName()
    {
        return statusName;
    }
    public void setStatusName(String statusName)
    {
        this.statusName = statusName;
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
    
    public static void main(String[] args)
    {
        
        
    }
    
}
