package com.test.violationsdrivecarCommon.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 车辆类型表
* @ClassName: CarType 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2014-11-21 上午9:23:00 
*
 */
@Entity
@Table(name = "cro_car_type")
public class CarType
{

    private Integer carId;
    private String funguideTypeId;
    private String funguideTypeName;
    private String channelId;
    private String channelTypeId;
    private String channelTypeName;
    private String message;
    private Date createdAt;
    private Date updatedAt;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", unique = true, nullable = false)
    public Integer getCarId()
    {
        return carId;
    }
    public void setCarId(Integer carId)
    {
        this.carId = carId;
    }
    @Column(name = "funguide_type_id",length = 32)
    public String getFunguideTypeId()
    {
        return funguideTypeId;
    }
    public void setFunguideTypeId(String funguideTypeId)
    {
        this.funguideTypeId = funguideTypeId;
    }
    @Column(name = "funguide_type_name",length = 32)
    public String getFunguideTypeName()
    {
        return funguideTypeName;
    }
    public void setFunguideTypeName(String funguideTypeName)
    {
        this.funguideTypeName = funguideTypeName;
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
    @Column(name = "channel_type_id",length = 32)
    public String getChannelTypeId()
    {
        return channelTypeId;
    }
    public void setChannelTypeId(String channelTypeId)
    {
        this.channelTypeId = channelTypeId;
    }
    @Column(name = "channel_type_name",length = 32)
    public String getChannelTypeName()
    {
        return channelTypeName;
    }
    public void setChannelTypeName(String channelTypeName)
    {
        this.channelTypeName = channelTypeName;
    }
    @Column(name = "message",length = 32)
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
    
}
