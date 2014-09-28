package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.Rental;
import org.yingqu.baoli.model.RentalImg;
import org.yingqu.baoli.model.SellOfer;
import org.yingqu.baoli.model.SellOferImg;
import org.yingqu.desktop.utils.ProcessFieldsUploadUtil;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/bl/sellimg")
@Controller
public class SellOferImgController extends SimpleBaseController<SellOferImg> {

	protected SellOferImgController() {
		super(SellOferImg.class);
	}

	@Override
	public SellOferImg getModel(HttpServletRequest request, SellOferImg model) {
		return model;
	}
	@RequestMapping("/uploadField")
	public void uploadField( @Validated SellOferImg model,BindingResult br,@RequestParam("imgurl") MultipartFile url,
			@RequestParam(value="foreignKey",required=false,defaultValue="") String foreignKey,
			HttpServletRequest request,
			HttpServletResponse response) {
		if(StringUtil.isNotEmpty(foreignKey)){
			SellOfer sell=new SellOfer();
			sell.setRid(foreignKey);
			model.setSell(sell);
          ProcessFieldsUploadUtil.upload(model, url,"url","baoli.upload.forum"); 
  		  super.doSave(model, request, response);
		}else{
			toWrite(response,
					jsonBuilder.returnFailureJson("'出售信息并未保存，请先保存再进行图片上传.'"));
		}
		
	}
}
