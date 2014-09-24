package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.AppNews;
import org.yingqu.desktop.utils.ProcessFieldsUploadUtil;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.core.utils.AppUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/bl/news")
@Controller
public class AppNewsController extends SimpleBaseController<AppNews> {

	protected AppNewsController() {
		super(AppNews.class);
	}

	@Override
	public AppNews getModel(HttpServletRequest request, AppNews model) {
		return model;
	}
	
	@RequestMapping(value="/doSave",method=RequestMethod.POST)
	public void doSave(@Validated  AppNews model,BindingResult br,@RequestParam("shrinkimg") MultipartFile shrinkimg,  HttpServletRequest request,
			HttpServletResponse response) {
		ProcessFieldsUploadUtil.upload(model, shrinkimg,"shrinkimg","baoli.upload.news"); 
		super.doSave(model, request, response);
		
	}
	
	@RequestMapping(value="/doUpdate",method=RequestMethod.POST)
	public void doUpdates(@Validated AppNews model,BindingResult br,@RequestParam("shrinkimg") MultipartFile shrinkimg,  HttpServletRequest request,
			HttpServletResponse response) {
		ProcessFieldsUploadUtil.upload(model, shrinkimg,"shrinkimg","baoli.upload.news"); 
		super.doUpdate(model, request, response);
		
	}
	@RequestMapping(value="/postnews",method=RequestMethod.POST)
	public void postNews(HttpServletRequest request,HttpServletResponse response,String newid){
		try{
			AppNews appNews=(AppNews) ebi.findById(clazz, newid);
			appNews.setAdddate(AppUtils.getCurDate());
			appNews.setAddtime(AppUtils.getCurrentTime());
			appNews.setState("1");
			toWrite(response, jsonBuilder.returnSuccessJson("''发布成功!'"));
		}catch(Exception e){
			error("发布失败!",e);
			toWrite(response, jsonBuilder.returnFailureJson("'发布失败!'"));
		}
		
	}
	

}
