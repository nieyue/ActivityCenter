package com.nieyue.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nieyue.bean.Activity;
import com.nieyue.bean.ActivityCate;
import com.nieyue.dao.ActivityDao;
import com.nieyue.service.ActivityCateService;
import com.nieyue.service.ActivityService;
@Service
public class ActivityServiceImpl implements ActivityService{
	@Resource
	ActivityDao activityDao;
	@Resource
	ActivityCateService activityCateService;
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean addActivity(Activity activity) {
		activity.setCreateDate(new Date());
		activity.setUpdateDate(new Date());
		activity.setPvs(0);
		activity.setUvs(0);
		activity.setIps(0);
		activity.setReadingNumber(0);
		if(activity.getStatus()==null||activity.getStatus().equals("")){
			activity.setStatus(1);//默认上架
		}
		boolean b = activityDao.addActivity(activity);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean delActivity(Integer activityId) {
		boolean b = activityDao.delActivity(activityId);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean updateActivity(Activity activity) {
		activity.setUpdateDate(new Date());
		boolean b = activityDao.updateActivity(activity);
		return b;
	}

	@Override
	public Activity loadActivity(Integer activityId) {
		Activity activity = activityDao.loadActivity(activityId);
		ActivityCate activityCate = activityCateService.loadActivityCate(activity.getActivityCateId());
		activity.setActivityCate(activityCate);
		return activity;
	}

	@Override
	public int countAll(
			Integer readingNumber,
			Integer activityCateId,
			Date startDate,
			Date endDate,
			Date createDate,
			Date updateDate,
			Integer status) {
		int c = activityDao.countAll(
				 readingNumber,
				 activityCateId,
				 startDate,
				 endDate,
				 createDate,
				 updateDate,
				 status);
		return c;
	}

	@Override
	public List<Activity> browsePagingActivity(
			Integer readingNumber,
			Integer activityCateId,
			Date startDate,
			Date endDate,
			Date createDate,
			Date updateDate,
			Integer status,
			int pageNum, int pageSize,
			String orderName, String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<Activity> l = activityDao.browsePagingActivity(
				 readingNumber,
				 activityCateId,
				 startDate,
				 endDate,
				 createDate,
				 updateDate,
				 status,
				pageNum-1, pageSize, orderName, orderWay);
		
		for (Activity activity : l) {
			ActivityCate activityCate = activityCateService.loadActivityCate(activity.getActivityCateId());
			activity.setActivityCate(activityCate);
		}
		return l;
	}
	@Override
	public Activity loadSmallActivity(Integer activityId) {
		Activity activity = activityDao.loadSmallActivity(activityId);
		return activity;
	}

	
}
