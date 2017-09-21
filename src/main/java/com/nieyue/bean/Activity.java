package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动
 * @author yy
 *
 */
public class Activity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 活动id
	 */
	private Integer activityId;
	/**
	 * 活动名称
	 */
	private String title;
	/**
	 * 简介
	 */
	private String summary;
	/**
	 * 活动对象
	 */
	private String target;
	/**
	 *封面
	 */
	private String imgAddress;
	/**
	 *内容
	 */
	private String content;
	/**
	 *pv
	 */
	private Integer pvs;
	/**
	 *uv
	 */
	private Integer uvs;
	/**
	 *ip
	 */
	private Integer ips;
	/**
	 *阅读数
	 */
	private Integer readingNumber;
	/**
	 *下架0,上架1
	 */
	private Integer status;
	/**
	 *活动类型id,外键
	 */
	private Integer activityCateId;
	/**
	 * 活动开始时间
	 */
	private Date startDate;
	/**
	 * 活动结束时间
	 */
	private Date endDate;
	/**
	 * 活动创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 活动类型
	 */
	private ActivityCate activityCate;

	public Activity() {
		super();
	}

	public Activity(Integer activityId, String title, String summary, String target, String imgAddress, String content,
			Integer pvs, Integer uvs, Integer ips, Integer readingNumber, Integer status, Integer activityCateId,
			Date startDate, Date endDate, Date createDate, Date updateDate, ActivityCate activityCate) {
		super();
		this.activityId = activityId;
		this.title = title;
		this.summary = summary;
		this.target = target;
		this.imgAddress = imgAddress;
		this.content = content;
		this.pvs = pvs;
		this.uvs = uvs;
		this.ips = ips;
		this.readingNumber = readingNumber;
		this.status = status;
		this.activityCateId = activityCateId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.activityCate = activityCate;
	}

	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", title=" + title + ", summary=" + summary + ", target=" + target
				+ ", imgAddress=" + imgAddress + ", content=" + content + ", pvs=" + pvs + ", uvs=" + uvs + ", ips="
				+ ips + ", readingNumber=" + readingNumber + ", status=" + status + ", activityCateId=" + activityCateId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", activityCate=" + activityCate + "]";
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getImgAddress() {
		return imgAddress;
	}

	public void setImgAddress(String imgAddress) {
		this.imgAddress = imgAddress;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPvs() {
		return pvs;
	}

	public void setPvs(Integer pvs) {
		this.pvs = pvs;
	}

	public Integer getUvs() {
		return uvs;
	}

	public void setUvs(Integer uvs) {
		this.uvs = uvs;
	}

	public Integer getIps() {
		return ips;
	}

	public void setIps(Integer ips) {
		this.ips = ips;
	}

	public Integer getReadingNumber() {
		return readingNumber;
	}

	public void setReadingNumber(Integer readingNumber) {
		this.readingNumber = readingNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getActivityCateId() {
		return activityCateId;
	}

	public void setActivityCateId(Integer activityCateId) {
		this.activityCateId = activityCateId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public ActivityCate getActivityCate() {
		return activityCate;
	}

	public void setActivityCate(ActivityCate activityCate) {
		this.activityCate = activityCate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
