package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.UserCollection;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.model.vo.ResultModel;
import org.yingqu.framework.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/uc")
@Controller
public class UserCollectionController extends SimpleBaseController<UserCollection> {

	protected UserCollectionController() {
		super(UserCollection.class);
	}

	@Override
	public UserCollection getModel(HttpServletRequest request, UserCollection model) {
		return model;
	}
	
	
	
	/**
	 * 用户收藏接口
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("/collect")
	public void collect(HttpServletRequest request,HttpServletResponse response,UserCollection model){
		ResultModel resultModel=this.initResultModel();
		String userid=model.getUid();
		String cid=model.getCid();
		String ctype=model.getCtype();
		try{
		if(StringUtil.isEmpty(userid)){
			resultModel.setOk(0);
			resultModel.setMsg("传入用户标示不能为空!");
		}else if(StringUtil.isEmpty(cid)){
			resultModel.setOk(0);
			resultModel.setMsg("传入收藏ID不能为空!");
			
		}else if(StringUtil.isEmpty(ctype)){
			resultModel.setOk(0);
			resultModel.setMsg("传入出入收藏类型不能为空!");
		}else {
			ebi.save(model);
		}}catch(Exception e){
			e.printStackTrace();
			resultModel.setCode(500);
			resultModel.setMsg("收藏失败！");
			resultModel.setOk(0);
			error(resultModel.getMsg(), e);
		}
		  toWritePhone(response,resultModel);
	}
	
	/**
	 * 删除收藏
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("/phoneRemove")
	public void phoneRemovee(HttpServletRequest request,
			HttpServletResponse response,  UserCollection  model
		) {
		ResultModel resultModel=this.initResultModel();
		String cid=model.getCid();
	 if(StringUtil.isEmpty(cid)){
			resultModel.setOk(0);
			resultModel.setMsg("传入收藏ID不能为空!");
		}else {
			super.phoneRemove(request, response, model);
		}
	}
	

}
