package com.test.violationsdrivecarCommon.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 交罚商户
* @ClassName: ViolationsMerchant 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2015-1-13 上午10:16:06 
*
 */
@Entity
@Table(name = "cro_violations_merchant")
public class ViolationsMerchant
{
    private Integer merchantId;
    private String merchantNo;
    private String token;
    private String merchantName;
    private String merchantStatus;
    private String merchantStatusName;
    private String payStyle;
    private String merchantCity;
    private Date createdAt;
    private Date updatedAt;
    private int modifyType;//修改价格的类型 0是指定的价格，1是在原来的价格上修改
    private int modifyPrice;//在原来的价格上修改的价格，单位为分
    private int specifyPrice;//在指定的价格，单位为分
    private String stopTip;
    private String stopStartTime;
    private String stopEndTime;
    /**
     * 商户一天内查询总次数
     */
    private int queryTotal;
    /**
     * 商户城市15分钟内查询总次数
     */
    private int cityQueryTotal;
    /**
     * 商户城市查询限制时间
     */
    private int queryCityTime;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "merchant_id", unique = true, nullable = false)
    public Integer getMerchantId()
    {
        return merchantId;
    }
    public void setMerchantId(Integer merchantId)
    {
        this.merchantId = merchantId;
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
    @Column(name = "token",length = 32)
    public String getToken()
    {
        return token;
    }
    public void setToken(String token)
    {
        this.token = token;
    }
    @Column(name = "merchant_name",length = 32)
    public String getMerchantName()
    {
        return merchantName;
    }
    public void setMerchantName(String merchantName)
    {
        this.merchantName = merchantName;
    }
    @Column(name = "merchant_status",length = 32)
    public String getMerchantStatus()
    {
        return merchantStatus;
    }
    public void setMerchantStatus(String merchantStatus)
    {
        this.merchantStatus = merchantStatus;
    }
    @Column(name = "merchant_status_name",length = 32)
    public String getMerchantStatusName()
    {
        return merchantStatusName;
    }
    public void setMerchantStatusName(String merchantStatusName)
    {
        this.merchantStatusName = merchantStatusName;
    }
    @Column(name = "pay_style",length = 32)
    public String getPayStyle()
    {
        return payStyle;
    }
    public void setPayStyle(String payStyle)
    {
        this.payStyle = payStyle;
    }
    @Column(name = "merchant_city",length = 500)
    public String getMerchantCity()
    {
        return merchantCity;
    }
    public void setMerchantCity(String merchantCity)
    {
        this.merchantCity = merchantCity;
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
    @Column(name = "modify_type")
	public int getModifyType() {
		return modifyType;
	}
	public void setModifyType(int modifyType) {
		this.modifyType = modifyType;
	}
	 @Column(name = "modify_price")
	public int getModifyPrice() {
		return modifyPrice;
	}
	public void setModifyPrice(int modifyPrice) {
		this.modifyPrice = modifyPrice;
	}
	@Column(name = "specify_price")
	public int getSpecifyPrice() {
		return specifyPrice;
	}
	public void setSpecifyPrice(int specifyPrice) {
		this.specifyPrice = specifyPrice;
	}
	@Column(name = "stop_start_time",length = 32)
	public String getStopStartTime() {
		return stopStartTime;
	}
	public void setStopStartTime(String stopStartTime) {
		this.stopStartTime = stopStartTime;
	}
	@Column(name = "stop_end_time",length = 32)
	public String getStopEndTime() {
		return stopEndTime;
	}
	public void setStopEndTime(String stopEndTime) {
		this.stopEndTime = stopEndTime;
	}
	@Column(name = "stop_tip",length = 200)
	public String getStopTip() {
		return stopTip;
	}
	public void setStopTip(String stopTip) {
		this.stopTip = stopTip;
	}
	@Column(name = "query_total")
	public int getQueryTotal() {
		return queryTotal;
	}
	public void setQueryTotal(int queryTotal) {
		this.queryTotal = queryTotal;
	}
	@Column(name = "city_query_total")
	public int getCityQueryTotal() {
		return cityQueryTotal;
	}
	public void setCityQueryTotal(int cityQueryTotal) {
		this.cityQueryTotal = cityQueryTotal;
	}
	@Column(name = "query_city_time")
	public int getQueryCityTime() {
		return queryCityTime;
	}
	public void setQueryCityTime(int queryCityTime) {
		this.queryCityTime = queryCityTime;
	}
    
    
}
