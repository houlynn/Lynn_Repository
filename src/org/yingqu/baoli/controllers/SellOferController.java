package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.SellOfer;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/sell")
@Controller
public class SellOferController extends SimpleBaseController<SellOfer> {

	protected SellOferController() {
		super(SellOfer.class);
	}

	@Override
	public SellOfer getModel(HttpServletRequest request, SellOfer model) {
		return model;
	}

}
