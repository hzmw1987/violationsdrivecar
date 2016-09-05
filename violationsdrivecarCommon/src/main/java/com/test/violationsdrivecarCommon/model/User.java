package com.test.violationsdrivecarCommon.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 用户表
 * @author hhm
 *
 */
@Entity
@Table(name = "cro_user")
public class User implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer userId;
    private String userName;
    @JsonIgnore
    private String userPsd;
    @JsonIgnore
    private String requestIp;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date updatedAt;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createdAt;
    @JsonIgnore
    private int roleId;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name = "user_psd")
	public String getUserPsd() {
		return userPsd;
	}
	public void setUserPsd(String userPsd) {
		this.userPsd = userPsd;
	}
	@Column(name = "request_ip")
	public String getRequestIp() {
		return requestIp;
	}
    @Column(name = "created_at")
    public Date getCreatedAt()
    {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }
    @Column(name = "updated_at")
    public Date getUpdatedAt()
    {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }
	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}
	@Column(name = "role_id")
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
    
}
