package com.nieyue.service;

import java.util.Date;
import java.util.List;

import com.nieyue.bean.Activity;

/**
 * 活动逻辑层接口
 * @author yy
 *
 */
public interface ActivityService {
	/** 新增活动 */	
	public boolean addActivity(Activity activity) ;	
	/** 删除活动 */	
	public boolean delActivity(Integer activityId) ;
	/** 更新活动*/	
	public boolean updateActivity(Activity activity);
	/** 装载活动 */	
	public Activity loadActivity(Integer activityId);	
	/** 装载small活动 */	
	public Activity loadSmallActivity(Integer activityId);	
	/** 活动总共数目 */	
	public int countAll(
			Integer readingNumber,
			Integer activityCateId,
			Date startDate,
			Date endDate,
			Date createDate,
			Date updateDate,
			Integer status);
	/** 分页活动信息 */
	public List<Activity> browsePagingActivity(
			Integer readingNumber,
			Integer activityCateId,
			Date startDate,
			Date endDate,
			Date createDate,
			Date updateDate,
			Integer status,
			int pageNum,
			int pageSize,
			String orderName,
			String orderWay) ;
}
