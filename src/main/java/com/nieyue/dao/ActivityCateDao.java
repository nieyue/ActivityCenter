package com.nieyue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.ActivityCate;

/**
 * 活动类型数据库接口
 * @author yy
 *
 */
@Mapper
public interface ActivityCateDao {
	/** 新增活动类型*/	
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
	public List<ActivityCate> browsePagingActivityCate(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize,@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;		
}
