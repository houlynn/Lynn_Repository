package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.SellOferImg;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
