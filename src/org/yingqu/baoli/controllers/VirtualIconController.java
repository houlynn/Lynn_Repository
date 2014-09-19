package org.yingqu.baoli.controllers;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.VirtualIcon;
import org.yingqu.desktop.model.Menu;
import org.yingqu.desktop.model.SysIcon;
import org.yingqu.desktop.utils.ProcessFieldsUploadUtil;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/bl/vi")
@Controller
public class VirtualIconController extends SimpleBaseController<VirtualIcon> {

	protected VirtualIconController() {
		super(VirtualIcon.class);
	}

	@Override
	public VirtualIcon getModel(HttpServletRequest request, VirtualIcon model) {
		return model;
	}

	@RequestMapping(value="/doSave",method=RequestMethod.POST)
	public void doSave(@Validated VirtualIcon model,BindingResult br,@RequestParam("inconUrl") MultipartFile icon,  HttpServletRequest request,
			HttpServletResponse response) {
		
		
		ProcessFieldsUploadUtil.upload(model, icon,"inconUrl","baoli.upload.ac"); 
		super.doSave(model, request, response);
		
		
	}

	
}
