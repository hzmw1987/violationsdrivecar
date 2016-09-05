package com.test.violationsdrivecarCommon.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 订单表和违章详情表的关系类
* @ClassName: OrderAndInfo 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2014-11-10 下午3:33:03 
*
 */
@Entity
@Table(name = "cro_order_and_info")
public class OrderAndInfo
{

    private Integer relationId;// int4 DEFAULT nextval('seq_cro_order_and_info'::regclass) NOT NULL,

    private String chaOrderNo;// varchar(32),--渠道订单号
    private String violationsId;// varchar(10),--违章订单明细ID

    private String merchantNo;// varchar(10),--商户号
    private String channelNo;// varchar(32),--渠道号

    private Date createdAt;// timestamp(32) NOT NULL,--创建时间
    private Date updatedAt;// timestamp(32) NOT NULL,--更新时间
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relation_id", unique = true, nullable = false)
    public Integer getRelationId()
    {
        return relationId;
    }
    public void setRelationId(Integer relationId)
    {
        this.relationId = relationId;
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
    @Column(name = "violations_id",length = 32)
    public String getViolationsId()
    {
        return violationsId;
    }
    public void setViolationsId(String violationsId)
    {
        this.violationsId = violationsId;
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
