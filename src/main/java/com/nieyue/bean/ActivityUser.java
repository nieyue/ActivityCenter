package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动用户
 * @author yy
 *
 */
public class ActivityUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 活动用户id
	 */
	private Integer activityUserId;
	
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 账户id,外键
	 */
	private Integer acountId;
	/**
	 * 活动id,外键
	 */
	private Integer activityId;

	
	public ActivityUser() {
		super();
	}



	public ActivityUser(Integer activityUserId, String name, String phone, String address, Date createDate,
			Date updateDate, Integer acountId, Integer activityId) {
		super();
		this.activityUserId = activityUserId;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.acountId = acountId;
		this.activityId = activityId;
	}



	public Integer getActivityUserId() {
		return activityUserId;
	}


	public void setActivityUserId(Integer activityUserId) {
		this.activityUserId = activityUserId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	public Integer getAcountId() {
		return acountId;
	}


	public void setAcountId(Integer acountId) {
		this.acountId = acountId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Integer getActivityId() {
		return activityId;
	}


	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}



	@Override
	public String toString() {
		return "ActivityUser [activityUserId=" + activityUserId + ", name=" + name + ", phone=" + phone + ", address="
				+ address + ", createDate=" + createDate + ", updateDate=" + updateDate + ", acountId=" + acountId
				+ ", activityId=" + activityId + "]";
	}
	
	
}
