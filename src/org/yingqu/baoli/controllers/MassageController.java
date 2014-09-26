package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.Massage;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/mesg")
@Controller
public class MassageController extends SimpleBaseController<Massage> {

	protected MassageController() {
		super(Massage.class);
	}

	@Override
	public Massage getModel(HttpServletRequest request, Massage model) {
		return model;
	}

}
