package com.nieyue.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.Activity;

/**
 * 活动数据库接口
 * @author yy
 *
 */
@Mapper
public interface ActivityDao {
	/** 新增活动*/	
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
			@Param("readingNumber")Integer readingNumber,
			@Param("activityCateId")Integer activityCateId,
			@Param("startDate")Date startDate,
			@Param("endDate")Date endDate,
			@Param("createDate")Date createDate,
			@Param("updateDate")Date updateDate,
			@Param("status")Integer status
			);	
	/** 分页活动信息 */
	public List<Activity> browsePagingActivity(
			@Param("readingNumber")Integer readingNumber,
			@Param("activityCateId")Integer activityCateId,
			@Param("startDate")Date startDate,
			@Param("endDate")Date endDate,
			@Param("createDate")Date createDate,
			@Param("updateDate")Date updateDate,
			@Param("status")Integer status,
			@Param("pageNum")int pageNum,
			@Param("pageSize")int pageSize,
			@Param("orderName")String orderName,
			@Param("orderWay")String orderWay) ;		
}
