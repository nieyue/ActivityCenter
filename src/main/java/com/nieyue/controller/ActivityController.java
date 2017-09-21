package com.nieyue.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nieyue.bean.Activity;
import com.nieyue.bean.DataRabbitmqDTO;
import com.nieyue.comments.IPCountUtil;
import com.nieyue.rabbitmq.confirmcallback.Sender;
import com.nieyue.service.ActivityService;
import com.nieyue.util.ResultUtil;
import com.nieyue.util.StateResult;
import com.nieyue.util.StateResultList;


/**
 * 活动控制类
 * @author yy
 *
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
	@Resource
	private ActivityService activityService;
	@Resource
	private Sender sender;
	
	/**
	 * web阅读文章获取 根据ActivityId、acountId、uv来统计数据
	 * @return
	 */
	@RequestMapping(value = "/webRead", method = {RequestMethod.GET,RequestMethod.POST})
	public StateResult webReadActivity(
			@RequestParam(value="activityId") Integer activityId,
			@RequestParam(value="acountId") Integer acountId,
			@RequestParam(value="uv",defaultValue="0",required=false) Integer uv,
			HttpSession session,HttpServletRequest request)  {
		if(uv!=0 &&uv!=1){
			return ResultUtil.getFail();
		}
		DataRabbitmqDTO drd=new DataRabbitmqDTO();
		drd.setAcountId(acountId);//转发    10积分（获得3个有效阅读）
		drd.setActivityId(activityId);
		drd.setUv(uv);
		drd.setIp(IPCountUtil.getIpAddr(request));//请求的ip地址
		sender.sendActivityWebRead(drd);
		return ResultUtil.getSuccess();
	}
	
	/**
	 * 活动分页浏览
	 * @param orderName 活动排序数据库字段
	 * @param orderWay 活动排序方法 asc升序 desc降序
	 * @return
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList browsePagingActivity(
			@RequestParam(value="readingNumber",required=false)Integer readingNumber,
			@RequestParam(value="activityCateId",required=false)Integer activityCateId,
			@RequestParam(value="startDate",required=false)Date startDate,
			@RequestParam(value="endDate",required=false)Date endDate,
			@RequestParam(value="createDate",required=false)Date createDate,
			@RequestParam(value="updateDate",required=false)Date updateDate,
			@RequestParam(value="status",required=false)Integer status,
			@RequestParam(value="pageNum",defaultValue="1",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize,
			@RequestParam(value="orderName",required=false,defaultValue="activity_id") String orderName,
			@RequestParam(value="orderWay",required=false,defaultValue="desc") String orderWay)  {
			List<Activity> list = new ArrayList<Activity>();
			list= activityService.browsePagingActivity(readingNumber,activityCateId,startDate,endDate,createDate,updateDate,status,pageNum, pageSize, orderName, orderWay);
			if(list.size()>0){
				return ResultUtil.getSlefSRSuccessList(list);
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
	/**
	 * 活动修改
	 * @return
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult updateActivity(@RequestBody Activity activity,HttpSession session)  {
		boolean um = activityService.updateActivity(activity);
		return ResultUtil.getSR(um);
	}
	/**
	 * 活动增加
	 * @return 
	 */
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult addActivity(@RequestBody Activity activity, HttpSession session) {
		boolean am = activityService.addActivity(activity);
		return ResultUtil.getSR(am);
	}
	/**
	 * 活动删除
	 * @return
	 */
	@RequestMapping(value = "/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delActivity(@RequestParam("activityId") Integer activityId,HttpSession session)  {
		boolean dm = activityService.delActivity(activityId);
		return ResultUtil.getSR(dm);
	}
	/**
	 * 活动浏览数量
	 * @return
	 */
	@RequestMapping(value = "/count", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody int countAll(
			@RequestParam(value="readingNumber",required=false)Integer readingNumber,
			@RequestParam(value="activityCateId",required=false)Integer activityCateId,
			@RequestParam(value="startDate",required=false)Date startDate,
			@RequestParam(value="endDate",required=false)Date endDate,
			@RequestParam(value="createDate",required=false)Date createDate,
			@RequestParam(value="updateDate",required=false)Date updateDate,
			@RequestParam(value="status",required=false)Integer status,
			HttpSession session)  {
		int count = activityService.countAll(readingNumber,activityCateId,startDate,endDate,createDate,updateDate,status);
		return count;
	}
	/**
	 * 活动单个加载
	 * @return
	 */
	@RequestMapping(value = "/{activityId}", method = {RequestMethod.GET,RequestMethod.POST})
	public  StateResultList loadActivity(@PathVariable("activityId") Integer activityId,HttpSession session)  {
		List<Activity> list = new ArrayList<Activity>();
		Activity activity = activityService.loadActivity(activityId);
			if(activity!=null &&!activity.equals("")){
				list.add(activity);
				return ResultUtil.getSlefSRSuccessList(list);
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
	/**
	 * 活动单个加载
	 * @return
	 */
	@RequestMapping(value = "/loadSmall/{activityId}", method = {RequestMethod.GET,RequestMethod.POST})
	public  StateResultList loadSmallActivity(@PathVariable("activityId") Integer activityId,HttpSession session)  {
		List<Activity> list = new ArrayList<Activity>();
		Activity activity = activityService.loadSmallActivity(activityId);
		if(activity!=null &&!activity.equals("")){
			list.add(activity);
			return ResultUtil.getSlefSRSuccessList(list);
		}else{
			return ResultUtil.getSlefSRFailList(list);
		}
	}
	
}
