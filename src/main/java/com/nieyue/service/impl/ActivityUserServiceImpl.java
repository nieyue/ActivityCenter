package com.nieyue.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nieyue.bean.ActivityUser;
import com.nieyue.dao.ActivityUserDao;
import com.nieyue.service.ActivityUserService;
@Service
public class ActivityUserServiceImpl implements ActivityUserService{
	@Resource
	ActivityUserDao activityUserDao;
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean addActivityUser(ActivityUser activityUser) {
		activityUser.setCreateDate(new Date());
		activityUser.setUpdateDate(new Date());
		boolean b = activityUserDao.addActivityUser(activityUser);
		return b;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean delActivityUser(Integer activityUserId) {
		boolean b = activityUserDao.delActivityUser(activityUserId);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean updateActivityUser(ActivityUser activityUser) {
		activityUser.setUpdateDate(new Date());
		boolean b = activityUserDao.updateActivityUser(activityUser);
		return b;
	}

	@Override
	public ActivityUser loadActivityUser(Integer activityUserId) {
		ActivityUser ActivityUser = activityUserDao.loadActivityUser(activityUserId);
		return ActivityUser;
	}

	@Override
	public int countAll(
			Integer acountId,
			Integer activityId,
			Date createDate,
			Date updateDate) {
		int c = activityUserDao.countAll(
				acountId,
				activityId,
				createDate,
				updateDate);
		return c;
	}

	@Override
	public List<ActivityUser> browsePagingActivityUser(
			Integer acountId,
			Integer activityId,
			Date createDate,
			Date updateDate,
			int pageNum, int pageSize,
			String orderName, String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<ActivityUser> l = activityUserDao.browsePagingActivityUser(
				acountId,
				activityId,
				createDate,
				updateDate,
				pageNum-1, pageSize, orderName, orderWay);
		return l;
	}

	
}
