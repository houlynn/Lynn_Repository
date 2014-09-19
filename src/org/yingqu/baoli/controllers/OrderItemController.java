package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.OrderContent;
import org.yingqu.baoli.model.OrderItem;
import org.yingqu.desktop.model.Dictionary;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/orderitem")
@Controller
public class OrderItemController extends SimpleBaseController<OrderItem> {

	protected OrderItemController() {
		super(OrderItem.class);
	}

	@Override
	public OrderItem getModel(HttpServletRequest request, OrderItem model) {
		
		String foreignKey=request.getParameter("foreignKey");
		foreignKey=foreignKey==null?"":foreignKey;
		if(StringUtil.isNotEmpty(foreignKey)){
			OrderContent order=new OrderContent();
			order.setOrdid(foreignKey);
			model.setOrderContent(order);
		}
		return model;
	}

}
