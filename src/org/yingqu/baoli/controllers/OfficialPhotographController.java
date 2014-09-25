package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.OfficialPhotograph;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/inc")
@Controller
public class OfficialPhotographController extends SimpleBaseController<OfficialPhotograph> {

	protected OfficialPhotographController() {
		super(OfficialPhotograph.class);
	}

	@Override
	public OfficialPhotograph getModel(HttpServletRequest request, OfficialPhotograph model) {
		return model;
	}

}
