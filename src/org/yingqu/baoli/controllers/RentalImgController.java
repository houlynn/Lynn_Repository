package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.OfficialIteract;
import org.yingqu.baoli.model.OfficialPhotograph;
import org.yingqu.baoli.model.Rental;
import org.yingqu.baoli.model.RentalImg;
import org.yingqu.desktop.utils.ProcessFieldsUploadUtil;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/bl/renimg")
@Controller
public class RentalImgController extends SimpleBaseController<RentalImg> {

	protected RentalImgController() {
		super(RentalImg.class);
	}

	@Override
	public RentalImg getModel(HttpServletRequest request, RentalImg model) {
		return model;
	}

	@RequestMapping("/uploadField")
	public void uploadField( @Validated RentalImg model,BindingResult br,@RequestParam("imgurl") MultipartFile url,
			@RequestParam(value="foreignKey",required=false,defaultValue="") String foreignKey,
			HttpServletRequest request,
			HttpServletResponse response) {
		if(StringUtil.isNotEmpty(foreignKey)){
			Rental rental=new Rental();
			rental.setRid(foreignKey);
			model.setRental(rental);
          ProcessFieldsUploadUtil.upload(model, url,"url","baoli.upload.forum"); 
  		  super.doSave(model, request, response);
		}else{
			toWrite(response,
					jsonBuilder.returnFailureJson("'出租信息并未保存，请先保存再进行图片上传.'"));
		}
		
	}
}
