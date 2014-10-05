package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.DeptImageUrl;
import org.yingqu.desktop.model.Department;
import org.yingqu.desktop.utils.ProcessFieldsUploadUtil;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/bl/deptimg")
@Controller
public class DeptImageUrlController extends SimpleBaseController<DeptImageUrl> {

	protected DeptImageUrlController() {
		super(DeptImageUrl.class);
	}

	@Override
	public DeptImageUrl getModel(HttpServletRequest request, DeptImageUrl model) {
		return model;
		
	}
	@RequestMapping("/uploadField")
	public void uploadField( @Validated DeptImageUrl model,BindingResult br,@RequestParam("url") MultipartFile url,
			@RequestParam(value="foreignKey",required=false,defaultValue="") String foreignKey,
			HttpServletRequest request,
			HttpServletResponse response) {
	/*	if(StringUtil.isNotEmpty(foreignKey)){
         Department dept=new Department();
         dept.setDeptId(foreignKey);
         model.setDept(dept);
		}*/
		ProcessFieldsUploadUtil.upload(model, url,"url","baoli.upload.path"); 
		super.doSave(model, request, response);
	}

}
