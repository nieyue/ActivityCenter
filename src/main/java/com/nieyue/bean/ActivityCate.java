package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动类型
 * @author yy
 *
 */
public class ActivityCate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 活动类型id
	 */
	private Integer activityCateId;
	
	/**
	 * 活动类型名
	 */
	private String name;
	/**
	 * 更新时间
	 */
	private Date updateDate;

	public ActivityCate(Integer activityCateId, String name, String duty, Date updateDate) {
		super();
		this.activityCateId = activityCateId;
		this.name = name;
		this.updateDate = updateDate;
	}
	public ActivityCate() {
		super();
	}
	public Integer getActivityCateId() {
		return activityCateId;
	}
	public void setActivityCateId(Integer activityCateId) {
		this.activityCateId = activityCateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
