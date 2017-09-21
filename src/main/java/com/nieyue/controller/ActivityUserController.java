package com.nieyue.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.nieyue.bean.ActivityUser;
import com.nieyue.rabbitmq.confirmcallback.Sender;
import com.nieyue.service.ActivityUserService;
import com.nieyue.util.ResultUtil;
import com.nieyue.util.StateResult;
import com.nieyue.util.StateResultList;


/**
 * 活动用户控制类
 * @author yy
 *
 */
@RestController
@RequestMapping("/activityUser")
public class ActivityUserController {
	@Resource
	private ActivityUserService activityUserService;
	@Resource
	private Sender sender;
	
	/**
	 * 活动用户分页浏览
	 * @param orderName 活动用户排序数据库字段
	 * @param orderWay 活动用户排序方法 asc升序 desc降序
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList browsePagingActivityUser(
			@RequestParam(value="acountId",required=false)Integer acountId,
			@RequestParam(value="activityId",required=false)Integer activityId,
			@RequestParam(value="createDate",required=false)Date createDate,
			@RequestParam(value="updateDate",required=false)Date updateDate,
			@RequestParam(value="pageNum",defaultValue="1",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize,
			@RequestParam(value="orderName",required=false,defaultValue="activity_user_id") String orderName,
			@RequestParam(value="orderWay",required=false,defaultValue="desc") String orderWay) throws Exception  {
			List<ActivityUser> list = new ArrayList<ActivityUser>();
			list= activityUserService.browsePagingActivityUser(acountId,activityId,createDate,updateDate,pageNum, pageSize, orderName, orderWay);
			if(list.size()>0){
				return ResultUtil.getSlefSRSuccessList(list);
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
	/**
	 * 活动用户修改
	 * @return
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult updateActivityUser(@ModelAttribute ActivityUser activityUser,HttpSession session)  {
		boolean um = activityUserService.updateActivityUser(activityUser);
		return ResultUtil.getSR(um);
	}
	/**
	 * 活动用户增加
	 * @return 
	 */
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult addActivityUser(@ModelAttribute ActivityUser activityUser, HttpSession session) {
		boolean am = activityUserService.addActivityUser(activityUser);
		//sender.sendActivityUser(activityUser);
		return ResultUtil.getSR(am);
	}
	/**
	 * 活动用户删除
	 * @return
	 */
	@RequestMapping(value = "/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delActivityUser(@RequestParam("activityUserId") Integer activityUserId,HttpSession session)  {
		boolean dm = activityUserService.delActivityUser(activityUserId);
		return ResultUtil.getSR(dm);
	}
	/**
	 * 活动用户浏览数量
	 * @return
	 */
	@RequestMapping(value = "/count", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody int countAll(
			@RequestParam(value="acountId",required=false)Integer acountId,
			@RequestParam(value="activityId",required=false)Integer activityId,
			@RequestParam(value="createDate",required=false)Date createDate,
			@RequestParam(value="updateDate",required=false)Date updateDate,
			HttpSession session)  {
		int count = activityUserService.countAll(acountId,activityId,createDate,updateDate);
		return count;
	}
	/**
	 * 活动用户单个加载
	 * @return
	 */
	@RequestMapping(value = "/{activityUserId}", method = {RequestMethod.GET,RequestMethod.POST})
	public  StateResultList loadActivityUser(@PathVariable("activityUserId") Integer activityUserId,HttpSession session)  {
		List<ActivityUser> list = new ArrayList<ActivityUser>();
		ActivityUser activityUser = activityUserService.loadActivityUser(activityUserId);
			if(activityUser!=null &&!activityUser.equals("")){
				list.add(activityUser);
				return ResultUtil.getSlefSRSuccessList(list);
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
	
}
