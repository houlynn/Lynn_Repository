package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.Photograph;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/inc")
@Controller
public class PhotographController extends SimpleBaseController<Photograph> {

	protected PhotographController() {
		super(Photograph.class);
	}

	@Override
	public Photograph getModel(HttpServletRequest request, Photograph model) {
		return model;
	}

}
