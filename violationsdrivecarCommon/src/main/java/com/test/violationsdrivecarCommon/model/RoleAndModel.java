package com.test.violationsdrivecarCommon.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 *  角色模块关系
 * @author hhm
 *
 */
@Entity
@Table(name = "cm_role_and_model")
public class RoleAndModel implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer roleAndModelId;
    private Integer roleId;
    private Integer modelId;
    private Date updatedAt;
    private Date createdAt;
    
    @Column(name = "update_at")
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Column(name = "created_at")
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Column(name = "model_id")
	public Integer getModelId() {
		return modelId;
	}
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_and_model_id", unique = true, nullable = false)
	public Integer getRoleAndModelId() {
		return roleAndModelId;
	}
	public void setRoleAndModelId(Integer roleAndModelId) {
		this.roleAndModelId = roleAndModelId;
	}
	@Column(name = "role_id")
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
    
   
    
}
