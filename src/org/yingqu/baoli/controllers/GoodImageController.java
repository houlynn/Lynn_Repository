package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.DeptImageUrl;
import org.yingqu.baoli.model.GoodImage;
import org.yingqu.baoli.model.Goods;
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
@RequestMapping("/bl/gdimg")
@Controller
public class GoodImageController extends SimpleBaseController<GoodImage> {

	protected GoodImageController() {
		super(GoodImage.class);
	}

	@Override
	public GoodImage getModel(HttpServletRequest request, GoodImage model) {
		return model;
	}
	@RequestMapping("/uploadField")
	public void uploadField( @Validated GoodImage model,BindingResult br,@RequestParam("url") MultipartFile url,
			@RequestParam(value="foreignKey",required=false,defaultValue="") String foreignKey,
			HttpServletRequest request,
			HttpServletResponse response) {
		if(StringUtil.isNotEmpty(foreignKey)){
         Goods good=new Goods();
         good.setGid(foreignKey);
         model.setGood(good);
		}
		ProcessFieldsUploadUtil.upload(model, url,"url","baoli.upload.good"); 
		super.doSave(model, request, response);
	}
}
