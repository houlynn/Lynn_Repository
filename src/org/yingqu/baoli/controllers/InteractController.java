package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.Interact;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/inc")
@Controller
public class InteractController extends SimpleBaseController<Interact> {

	protected InteractController() {
		super(Interact.class);
	}

	@Override
	public Interact getModel(HttpServletRequest request, Interact model) {
		return model;
	}

}
