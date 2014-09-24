package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.AppUser;
import org.yingqu.baoli.model.Feedback;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.core.utils.AppUtils;
import org.yingqu.framework.model.vo.ResultModel;
import org.yingqu.framework.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/fbd")
@Controller
public class FeedbackController extends SimpleBaseController<Feedback> {

	protected FeedbackController() {
		super(Feedback.class);
	}

	@Override
	public Feedback getModel(HttpServletRequest request, Feedback model) {
		return model;
	}

	@Override
	public void doSave(Feedback model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		model.setFbid(AppUtils.getCurrentTime());
		super.doSave(model, request, response);
	}

	////////////////////////////////////////////////APP方法/////////////////////////////////////
	
	/**
	 * 17 评价接口  （ 意见反馈）
	 * 
	 */
	@RequestMapping("/userFeedb")
	public void userFeedb(Feedback model, HttpServletRequest request,
			HttpServletResponse response) {
		    ResultModel resultModel= this.initResultModel();
		    try{
		         String userid= model.getUserid();
		         if(StringUtil.isEmpty(userid)){
		        	 setEmptyCode(resultModel, "传入的用户标示不能为空!");
		         }else{
		        	   AppUser appUser=(AppUser) ebi.findById(AppUser.class, userid);
		        	   if(appUser==null){
		        		   setNoFecCode(resultModel, "传入的用户标示无效");
		        	   }else{
		        		     if(StringUtil.isEmpty(model.getMsg())){
		        		    	  setEmptyCode(resultModel, "评论内容不能为空!");
		        		     }else{
		        		    	    model.setFbtime(AppUtils.getCurDate());
							    	ebi.save(model);   
		        		     }
		        		  
		        	   }
				    	
		         }
		  
		    }catch(Exception e){
		    	setServerErrCode(resultModel, "服务端错误反馈失败!");
		    	error(resultModel.getMsg(),e);
		    }
		    toWritePhone(response, resultModel);
	}
	
}
