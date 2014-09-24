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
	
	
/////////////////////////////////////////////////////////////APP方法//////////////////////////////////////////////////////////
	/**
	 * 14 用户收藏接口
	 * ctype参数有以下几种类型
	 *  001 周边类型
	 *  002 商品类型
	 *  003 帖子类型
	 *  cid 来源以下主键
	 *  Merchant 主键
	 *  Goods 主键
	 *  帖子 的主键
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
			setEmptyCode(resultModel, "传入用户标示不能为空!");
		}else if(StringUtil.isEmpty(cid)){
			setEmptyCode(resultModel, "传入收藏ID不能为空!");
			
		}else if(StringUtil.isEmpty(ctype)){
			setEmptyCode(resultModel, "传入出入收藏类型不能为空!");
		}else {
	/*		UserCollection uc=(UserCollection) ebi.findById(UserCollection.class, cid);
			if(uc==null){
				setNoFecCode(resultModel, "传入收藏ID无效!");
			}*/
			ebi.save(model);
		}}catch(Exception e){
			e.printStackTrace();
			setServerErrCode(resultModel, "服务端错误！收藏室失败!");
			error(resultModel.getMsg(), e);
		}
		  toWritePhone(response,resultModel);
	}
	
	/**
	 * 15删除收藏 传入cid
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("/removeCollec")
	public void phoneRemovee(HttpServletRequest request,
			HttpServletResponse response,  UserCollection  model
		) {
		ResultModel resultModel=this.initResultModel();
		String cid=model.getCid();
	 if(StringUtil.isEmpty(cid)){
		   setEmptyCode(resultModel, "传入收藏ID不能为空!");
		}else {
			super.phoneRemove(request, response, model);
		}
	 toWritePhone(response,resultModel);
	}
	

}
