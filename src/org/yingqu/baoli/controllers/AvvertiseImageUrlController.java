package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.Advertisement;
import org.yingqu.baoli.model.AvvertiseImageUrl;
import org.yingqu.desktop.utils.ProcessFieldsUploadUtil;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/bl/adtimge")
@Controller
public class AvvertiseImageUrlController extends SimpleBaseController<AvvertiseImageUrl> {

	protected AvvertiseImageUrlController() {
		super(AvvertiseImageUrl.class);
	}

	@Override
	public AvvertiseImageUrl getModel(HttpServletRequest request, AvvertiseImageUrl model) {
		return model;
	}
	
	@RequestMapping("/uploadField")
	public void uploadField( @Validated AvvertiseImageUrl model,BindingResult br,@RequestParam("url") MultipartFile url,
			@RequestParam(value="foreignKey",required=false,defaultValue="") String foreignKey,
			HttpServletRequest request,
			HttpServletResponse response) {
		if(StringUtil.isNotEmpty(foreignKey)){
			Advertisement adt= new Advertisement();
			adt.setAdverid(foreignKey);
			model.setAdt(adt);
		}
		ProcessFieldsUploadUtil.upload(model, url,"url","baoli.upload.adt"); 
		super.doSave(model, request, response);
	}

}
