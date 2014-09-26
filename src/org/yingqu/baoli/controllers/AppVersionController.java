package org.yingqu.baoli.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.yingqu.baoli.model.AppVersion;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RequestMapping("/bl/av")
@Controller
public class AppVersionController extends SimpleBaseController<AppVersion> {

	protected AppVersionController() {
		super(AppVersion.class);
	}

	@Override
	public AppVersion getModel(HttpServletRequest request, AppVersion model) {
		return model;
		
	}

//////////////////////////////////////////APP方法/////////////////////////////////////////////////
	
	/***
	 *16 版本更新 接口
	 *start 从那一条开始取出   
	 *limit 每页显示多少条
	 *默认 pangeSize 25
	 * whereSql 可选
	 * parentSql 可选
	 * orderSql 默认 按 发布时间降序
	 * 
	 */
	@RequestMapping("/loadVs")
	public void phoneList(
			@RequestParam(value="whereSql",required=false,defaultValue="") String whereSql,
	    	@RequestParam(value="parentSql",required=false,defaultValue="") String parentSql,
	    	@RequestParam(value="querySql",required=false,defaultValue="") String querySql,
	    	@RequestParam(value="orderSql",required=false,defaultValue=" order by uptime DESC") String orderSql,
	    	@RequestParam(value="start",required=false,defaultValue="0") String startStr,
	    	@RequestParam(value="limit",required=false,defaultValue="25") String limitStr,
	    	HttpServletResponse response){
		super.phoneList(whereSql, parentSql, querySql, orderSql, startStr, limitStr, response);
		
	}
	
	
}
