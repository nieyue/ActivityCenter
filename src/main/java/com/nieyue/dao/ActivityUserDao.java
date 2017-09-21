package com.nieyue.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.ActivityUser;

/**
 * 活动用户数据库接口
 * @author yy
 *
 */
@Mapper
public interface ActivityUserDao {
	/** 新增活动用户*/	
	public boolean addActivityUser(ActivityUser activityUser) ;	
	/** 删除活动用户 */	
	public boolean delActivityUser(Integer activityUserId) ;
	/** 更新活动用户*/	
	public boolean updateActivityUser(ActivityUser activityUser);
	/** 装载活动用户 */	
	public ActivityUser loadActivityUser(Integer activityUserId);	
	/** 活动用户总共数目 */	
	public int countAll(
			@Param("acountId")Integer acountId,
			@Param("activityId")Integer activityId,
			@Param("createDate")Date createDate,
			@Param("updateDate")Date updateDate
			);	
	/** 分页活动用户信息 */
	public List<ActivityUser> browsePagingActivityUser(
			@Param("acountId")Integer acountId,
			@Param("activityId")Integer activityId,
			@Param("createDate")Date createDate,
			@Param("updateDate")Date updateDate,
			@Param("pageNum")int pageNum,
			@Param("pageSize")int pageSize,
			@Param("orderName")String orderName,
			@Param("orderWay")String orderWay) ;		
}
