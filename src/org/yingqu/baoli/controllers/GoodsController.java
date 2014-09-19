package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.Goods;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/gd")
@Controller
public class GoodsController extends SimpleBaseController<Goods> {

	protected GoodsController() {
		super(Goods.class);
	}

	@Override
	public Goods getModel(HttpServletRequest request, Goods model) {
		return model;
	}

}
