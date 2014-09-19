package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.AppClassify;
import org.yingqu.desktop.utils.ProcessFieldsUploadUtil;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/bl/ac")
@Controller
public class AppClassifyController extends SimpleBaseController<AppClassify> {

	protected AppClassifyController() {
		super(AppClassify.class);
	}

	@Override
	public AppClassify getModel(HttpServletRequest request, AppClassify model) {
		return model;
	}
	
	@RequestMapping("/uploadField")
	public void uploadField( @Validated AppClassify model,BindingResult br,@RequestParam("imgurl") MultipartFile imgurl,
			HttpServletRequest request,
			HttpServletResponse response
			){
		ProcessFieldsUploadUtil.upload(model, imgurl,"imgurl","baoli.upload.path"); 
		super.doSave(model, request, response);
	}

}
