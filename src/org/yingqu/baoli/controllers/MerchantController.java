package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.AppUser;
import org.yingqu.baoli.model.Merchant;
import org.yingqu.baoli.model.po.MerchantPo;
import org.yingqu.desktop.utils.ProcessFieldsUploadUtil;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.model.vo.PModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/bl/mc")
@Controller
public class MerchantController extends SimpleBaseController<Merchant> {

	protected MerchantController() {
		super(Merchant.class);
	}

	@Override
	public Merchant getModel(HttpServletRequest request, Merchant model) {
		return model;
	}

	@RequestMapping("/phoneUpdate")
	public void phoneUpdate(HttpServletRequest request,
			HttpServletResponse response, MerchantPo model) {
		// TODO Auto-generated method stub
		super.phoneUpdate(request, response, model);
	}
	


	

}
