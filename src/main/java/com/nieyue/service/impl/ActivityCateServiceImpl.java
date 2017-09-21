package com.nieyue.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nieyue.bean.ActivityCate;
import com.nieyue.dao.ActivityCateDao;
import com.nieyue.service.ActivityCateService;
@Service
public class ActivityCateServiceImpl implements ActivityCateService{
	@Resource
	ActivityCateDao activityCateDao;
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean addActivityCate(ActivityCate activityCate) {
		activityCate.setUpdateDate(new Date());
		boolean b = activityCateDao.addActivityCate(activityCate);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean delActivityCate(Integer activityCateId) {
		boolean b = activityCateDao.delActivityCate(activityCateId);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean updateActivityCate(ActivityCate activityCate) {
		activityCate.setUpdateDate(new Date());
		boolean b = activityCateDao.updateActivityCate(activityCate);
		return b;
	}

	@Override
	public ActivityCate loadActivityCate(Integer activityCateId) {
		ActivityCate r = activityCateDao.loadActivityCate(activityCateId);
		return r;
	}

	@Override
	public int countAll() {
		int c = activityCateDao.countAll();
		return c;
	}

	@Override
	public List<ActivityCate> browsePagingActivityCate(int pageNum, int pageSize,
			String orderName, String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<ActivityCate> l = activityCateDao.browsePagingActivityCate(pageNum-1, pageSize, orderName, orderWay);
		return l;
	}

	
}
