package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.OrderContent;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/order")
@Controller
public class OrderContentController extends SimpleBaseController<OrderContent> {

	protected OrderContentController() {
		super(OrderContent.class);
	}

	@Override
	public OrderContent getModel(HttpServletRequest request, OrderContent model) {
		
		
		
		
		
		return model;
	}

}
