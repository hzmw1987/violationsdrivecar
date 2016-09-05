package com.test.violationsdrivecarCommon.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 城市列表
* @ClassName: ViolationsCity 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2014-11-20 上午9:32:42 
*
 */
@Entity
@Table(name = "cro_violations_city")
public class ViolationsCity
{
    private Integer cityId;//主键
    private String funguideCityId;//--新空气城市ID
    private String cityName;//--新空气城市名称
    private String channelId;//渠道号
    private String channelCityId;//--渠道城市ID
    private String channelCityName;//--渠道城市名称
    private String cityShortTitle;//--渠道城市简称(即车牌大写字母)
    private boolean isNeedEngine;
    private int engineNoLength;//--所需发动机长度
    private boolean isNeedCarNo;
    private int carNoLength;//--所需车身架号长度
    private boolean isNeedCarOwnerNo;
    private int carOwnerNoLength;//--所需车辆所有人信息长度
    private boolean isStop;//--是否停用
    private String cityCodeName;//--城市编码名称
    private String cityFistName;//--城市首字母
    private boolean isHostyCity;//--是否热门城市
    private String fullPY;//--城市全拼
    private String shortPY;//--城市简称拼音
    private String cityFullName;//--城市全称
    private String provinceId;//--省ID
    private String provinceName;//--省名称
    private String provinceShortTitle;//--省简称
    private String message;//--提示信息
    private Date createdAt;
    private Date updatedAt;
    private Integer state;
    private String canQuery;
    private int modifyPrice;//在原来价格修改的价格

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", unique = true, nullable = false)
    public Integer getCityId()
    {
        return cityId;
    }

    public void setCityId(Integer cityId)
    {
        this.cityId = cityId;
    }
    @Column(name = "funguide_city_id",length = 32)
    public String getFunguideCityId()
    {
        return funguideCityId;
    }

    public void setFunguideCityId(String funguideCityId)
    {
        this.funguideCityId = funguideCityId;
    }
    @Column(name = "city_name",length = 32)
    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }
    @Column(name = "channel_id",length = 32)
    public String getChannelId()
    {
        return channelId;
    }

    public void setChannelId(String channelId)
    {
        this.channelId = channelId;
    }
    @Column(name = "channel_city_id",length = 32)
    public String getChannelCityId()
    {
        return channelCityId;
    }

    public void setChannelCityId(String channelCityId)
    {
        this.channelCityId = channelCityId;
    }
    @Column(name = "channel_city_name",length = 32)
    public String getChannelCityName()
    {
        return channelCityName;
    }

    public void setChannelCityName(String channelCityName)
    {
        this.channelCityName = channelCityName;
    }
    @Column(name = "city_short_title",length = 32)
    public String getCityShortTitle()
    {
        return cityShortTitle;
    }

    public void setCityShortTitle(String cityShortTitle)
    {
        this.cityShortTitle = cityShortTitle;
    }
    @Column(name = "is_need_engine",length = 32)
    public boolean isNeedEngine()
    {
        return isNeedEngine;
    }

    public void setNeedEngine(boolean isNeedEngine)
    {
        this.isNeedEngine = isNeedEngine;
    }
    @Column(name = "engine_no_length",length = 6)
    public int getEngineNoLength()
    {
        return engineNoLength;
    }

    public void setEngineNoLength(int engineNoLength)
    {
        this.engineNoLength = engineNoLength;
    }
    @Column(name = "is_need_car_no",length = 32)
    public boolean isNeedCarNo()
    {
        return isNeedCarNo;
    }

    public void setNeedCarNo(boolean isNeedCarNo)
    {
        this.isNeedCarNo = isNeedCarNo;
    }
    @Column(name = "car_no_length",length = 6)
    public int getCarNoLength()
    {
        return carNoLength;
    }

    public void setCarNoLength(int carNoLength)
    {
        this.carNoLength = carNoLength;
    }
    @Column(name = "is_need_car_wner_no",length = 32)
    public boolean isNeedCarOwnerNo()
    {
        return isNeedCarOwnerNo;
    }

    public void setNeedCarOwnerNo(boolean isNeedCarOwnerNo)
    {
        this.isNeedCarOwnerNo = isNeedCarOwnerNo;
    }
    @Column(name = "car_owner_no_length",length = 6)
    public int getCarOwnerNoLength()
    {
        return carOwnerNoLength;
    }

    public void setCarOwnerNoLength(int carOwnerNoLength)
    {
        this.carOwnerNoLength = carOwnerNoLength;
    }
    @Column(name = "is_stop",length = 32)
    public boolean isStop()
    {
        return isStop;
    }

    public void setStop(boolean isStop)
    {
        this.isStop = isStop;
    }
    @Column(name = "city_code_name",length = 32)
    public String getCityCodeName()
    {
        return cityCodeName;
    }

    public void setCityCodeName(String cityCodeName)
    {
        this.cityCodeName = cityCodeName;
    }
    @Column(name = "city_fist_name",length = 32)
    public String getCityFistName()
    {
        return cityFistName;
    }

    public void setCityFistName(String cityFistName)
    {
        this.cityFistName = cityFistName;
    }
    @Column(name = "is_hosty_city",length = 32)
    public boolean isHostyCity()
    {
        return isHostyCity;
    }

    public void setHostyCity(boolean isHostyCity)
    {
        this.isHostyCity = isHostyCity;
    }
    @Column(name = "full_py",length = 32)
    public String getFullPY()
    {
        return fullPY;
    }

    public void setFullPY(String fullPY)
    {
        this.fullPY = fullPY;
    }
    @Column(name = "short_py",length = 32)
    public String getShortPY()
    {
        return shortPY;
    }

    public void setShortPY(String shortPY)
    {
        this.shortPY = shortPY;
    }
    @Column(name = "city_full_name",length = 32)
    public String getCityFullName()
    {
        return cityFullName;
    }

    public void setCityFullName(String cityFullName)
    {
        this.cityFullName = cityFullName;
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
    @Column(name = "province_name",length = 32)
    public String getProvinceName()
    {
        return provinceName;
    }

    public void setProvinceName(String provinceName)
    {
        this.provinceName = provinceName;
    }
    @Column(name = "province_short_title",length = 32)
    public String getProvinceShortTitle()
    {
        return provinceShortTitle;
    }

    public void setProvinceShortTitle(String provinceShortTitle)
    {
        this.provinceShortTitle = provinceShortTitle;
    }
    @Column(name = "message",length = 200)
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
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
    @Column(name = "state",length = 4)
    public Integer getState()
    {
        return state;
    }

    public void setState(Integer state)
    {
        this.state = state;
    }
    @Column(name = "can_query",length = 5)
    public String getCanQuery()
    {
        return canQuery;
    }

    public void setCanQuery(String canQuery)
    {
        this.canQuery = canQuery;
    }
    @Column(name = "modify_price")
	public int getModifyPrice() {
		return modifyPrice;
	}

	public void setModifyPrice(int modifyPrice) {
		this.modifyPrice = modifyPrice;
	}
    
    

}
