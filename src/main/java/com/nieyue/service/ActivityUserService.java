package com.nieyue.service;

import java.util.Date;
import java.util.List;

import com.nieyue.bean.ActivityUser;

/**
 * 活动用户逻辑层接口
 * @author yy
 *
 */
public interface ActivityUserService {
	/** 新增活动用户 */	
	public boolean addActivityUser(ActivityUser activityUser) ;	
	/** 删除活动用户 */	
	public boolean delActivityUser(Integer activityUserId) ;
	/** 更新活动用户*/	
	public boolean updateActivityUser(ActivityUser activityUser);
	/** 装载活动用户*/	
	public ActivityUser loadActivityUser(Integer activityUserId);	
	/** 活动总共数目 */	
	public int countAll(
			Integer acountId,
			Integer activityId,
			Date createDate,
			Date updateDate);
	/** 分页活动用户信息 */
	public List<ActivityUser> browsePagingActivityUser(
			Integer acountId,
			Integer activityId,
			Date createDate,
			Date updateDate,
			int pageNum,
			int pageSize,
			String orderName,
			String orderWay) ;
}
