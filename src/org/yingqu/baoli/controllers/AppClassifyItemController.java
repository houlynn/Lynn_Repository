package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.AppClassify;
import org.yingqu.baoli.model.AppClassifyItem;
import org.yingqu.desktop.utils.ProcessFieldsUploadUtil;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/bl/acitem")
@Controller
public class AppClassifyItemController extends SimpleBaseController<AppClassifyItem> {

	protected AppClassifyItemController() {
		super(AppClassifyItem.class);
	}

	@Override
	public AppClassifyItem getModel(HttpServletRequest request, AppClassifyItem model) {
	
		return model;
		
	}

	@RequestMapping("/uploadField")
	public void uploadField( @Validated AppClassifyItem model,BindingResult br,@RequestParam("imgurl") MultipartFile imgurl,
			HttpServletRequest request,
			HttpServletResponse response
			){
		
		String foreignKey=request.getParameter("foreignKey");
		foreignKey=foreignKey==null?"":foreignKey;
		if(StringUtil.isNotEmpty(foreignKey)){
			AppClassify ac=new AppClassify();
			ac.setCid(foreignKey);
			model.setAc(ac);
		}
		ProcessFieldsUploadUtil.upload(model, imgurl,"imgurl","baoli.upload.path"); 
		super.doSave(model, request, response);
	}

}
