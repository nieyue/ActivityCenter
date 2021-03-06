package com.nieyue.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nieyue.bean.ActivityCate;
import com.nieyue.service.ActivityCateService;
import com.nieyue.util.ResultUtil;
import com.nieyue.util.StateResult;
import com.nieyue.util.StateResultList;


/**
 * 活动类型控制类
 * @author yy
 *
 */
@RestController
@RequestMapping("/activityCate")
public class ActivityCateController {
	@Resource
	private ActivityCateService activityCateService;
	
	/**
	 * 活动类型分页浏览
	 * @param orderName 活动排序数据库字段
	 * @param orderWay 活动排序方法 asc升序 desc降序
	 * @return
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList browsePagingActivityCate(
			@RequestParam(value="pageNum",defaultValue="1",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize,
			@RequestParam(value="orderName",required=false,defaultValue="activity_cate_id") String orderName,
			@RequestParam(value="orderWay",required=false,defaultValue="desc") String orderWay)  {
			List<ActivityCate> list = new ArrayList<ActivityCate>();
			list= activityCateService.browsePagingActivityCate(pageNum, pageSize, orderName, orderWay);
			if(list.size()>0){
				return ResultUtil.getSlefSRSuccessList(list);
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
	/**
	 * 活动类型修改
	 * @return
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult updateActivityCate(@ModelAttribute ActivityCate activityCate,HttpSession session)  {
		boolean um = activityCateService.updateActivityCate(activityCate);
		return ResultUtil.getSR(um);
	}
	/**
	 * 活动类型增加
	 * @return 
	 */
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult addActivityCate(@ModelAttribute ActivityCate activityCate, HttpSession session) {
		boolean am = activityCateService.addActivityCate(activityCate);
		return ResultUtil.getSR(am);
	}
	/**
	 * 活动类型删除
	 * @return
	 */
	@RequestMapping(value = "/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delActivityCate(@RequestParam("activityCateId") Integer activityCateId,HttpSession session)  {
		boolean dm = activityCateService.delActivityCate(activityCateId);
		return ResultUtil.getSR(dm);
	}
	/**
	 * 活动类型浏览数量
	 * @return
	 */
	@RequestMapping(value = "/count", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody int countAll(HttpSession session)  {
		int count = activityCateService.countAll();
		return count;
	}
	/**
	 * 活动类型单个加载
	 * @return
	 */
	@RequestMapping(value = "/{activityCateId}", method = {RequestMethod.GET,RequestMethod.POST})
	public  StateResultList loadActivityCate(@PathVariable("activityCateId") Integer activityCateId,HttpSession session)  {
		List<ActivityCate> list = new ArrayList<ActivityCate>();
		ActivityCate activityCate = activityCateService.loadActivityCate(activityCateId);
			if(activityCate!=null &&!activityCate.equals("")){
				list.add(activityCate);
				return ResultUtil.getSlefSRSuccessList(list);
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
	
}
