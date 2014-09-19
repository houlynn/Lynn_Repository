package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.PayKey;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/paykey")
@Controller
public class PayKeyController extends SimpleBaseController<PayKey> {

	protected PayKeyController() {
		super(PayKey.class);
	}

	@Override
	public PayKey getModel(HttpServletRequest request, PayKey model) {
		return model;
	}

}
