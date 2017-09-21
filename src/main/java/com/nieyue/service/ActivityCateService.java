package com.nieyue.service;

import java.util.List;

import com.nieyue.bean.ActivityCate;

/**
 * 活动类型逻辑层接口
 * @author yy
 *
 */
public interface ActivityCateService {
	/** 新增活动类型 */	
	public boolean addActivityCate(ActivityCate activityCate) ;	
	/** 删除活动类型 */	
	public boolean delActivityCate(Integer activityCateId) ;
	/** 更新活动类型*/	
	public boolean updateActivityCate(ActivityCate activityCate);
	/** 装载活动类型 */	
	public ActivityCate loadActivityCate(Integer activityCateId);	
	/** 活动类型总共数目 */	
	public int countAll();
	/** 分页活动类型信息 */
	public List<ActivityCate> browsePagingActivityCate(int pageNum,int pageSize,String orderName,String orderWay) ;
}
