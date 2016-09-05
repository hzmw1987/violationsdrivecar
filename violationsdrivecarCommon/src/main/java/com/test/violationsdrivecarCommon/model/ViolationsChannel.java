package com.test.violationsdrivecarCommon.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cro_violations_channel")
public class ViolationsChannel
{

    private Integer channelId;
    private String channelNo;//渠道号
    private String channelName;//渠道名字
    private String channelStatus;//渠道的状态
    private String channelStatusName;//渠道状态说明   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "channel_id", unique = true, nullable = false)
    public Integer getChannelId()
    {
        return channelId;
    }
    public void setChannelId(Integer channelId)
    {
        this.channelId = channelId;
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
    @Column(name = "channel_name",length = 32)
    public String getChannelName()
    {
        return channelName;
    }
    public void setChannelName(String channelName)
    {
        this.channelName = channelName;
    }
    @Column(name = "channel_status",length = 32)
    public String getChannelStatus()
    {
        return channelStatus;
    }
    public void setChannelStatus(String channelStatus)
    {
        this.channelStatus = channelStatus;
    }
    @Column(name = "channel_status_name",length = 32)
    public String getChannelStatusName()
    {
        return channelStatusName;
    }
    public void setChannelStatusName(String channelStatusName)
    {
        this.channelStatusName = channelStatusName;
    }
    
}
