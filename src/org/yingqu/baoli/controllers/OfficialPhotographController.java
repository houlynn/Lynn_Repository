package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.GoodImage;
import org.yingqu.baoli.model.Goods;
import org.yingqu.baoli.model.OfficialIteract;
import org.yingqu.baoli.model.OfficialPhotograph;
import org.yingqu.desktop.utils.ProcessFieldsUploadUtil;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/bl/offincimg")
@Controller
public class OfficialPhotographController extends SimpleBaseController<OfficialPhotograph> {

	protected OfficialPhotographController() {
		super(OfficialPhotograph.class);
	}

	@Override
	public OfficialPhotograph getModel(HttpServletRequest request, OfficialPhotograph model) {
		return model;
	}
	@RequestMapping("/uploadField")
	public void uploadField( @Validated OfficialPhotograph model,BindingResult br,@RequestParam("imgurl") MultipartFile url,
			@RequestParam(value="foreignKey",required=false,defaultValue="") String foreignKey,
			HttpServletRequest request,
			HttpServletResponse response) {
		if(StringUtil.isNotEmpty(foreignKey)){
			System.out.println(foreignKey);
          OfficialIteract iteract=new OfficialIteract();
          iteract.setOinerid(foreignKey);
          model.setIt(iteract);
		}
		ProcessFieldsUploadUtil.upload(model, url,"imgurl","baoli.upload.forum"); 
		super.doSave(model, request, response);
	}

}
