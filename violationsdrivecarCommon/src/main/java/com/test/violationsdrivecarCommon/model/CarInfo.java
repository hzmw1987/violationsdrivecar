package com.test.violationsdrivecarCommon.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 保存车辆信息
 * @author houzhangbo
 *
 */
@Entity
@Table(name = "cro_car_info")
public class CarInfo {

	private Integer carId;
	private String shopsign;
	private String engineNo;
	private String voitureNo;
	private String carType;
	private String city;
	private String mobile;
	private String userId;
	private String status;
	private String registerDate;
	private String cityName;
	private String carTypeName;
	private Date createdAt;
	private Date updatedAt;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", unique = true, nullable = false)
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	@Column(name = "shopsign",length = 32)
	public String getShopsign() {
		return shopsign;
	}
	public void setShopsign(String shopsign) {
		this.shopsign = shopsign;
	}
	@Column(name = "engine_no",length = 32)
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	@Column(name = "voiture_no",length = 32)
	public String getVoitureNo() {
		return voitureNo;
	}
	public void setVoitureNo(String voitureNo) {
		this.voitureNo = voitureNo;
	}
	@Column(name = "car_type",length = 10)
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	@Column(name = "city",length = 10)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "mobile",length = 11)
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Column(name = "user_id",length = 50)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	//车辆状态 0为不可用 1为可用
	@Column(name = "status",length = 5)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "register_date",length = 15)
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	@Column(name = "created_at",length = 6)
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Column(name = "updated_at",length = 6)
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Column(name = "city_name",length = 15)
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Column(name = "car_type_name",length = 15)
	public String getCarTypeName() {
		return carTypeName;
	}
	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}
	
}
