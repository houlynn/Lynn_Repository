package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.AppVersion;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/av")
@Controller
public class AppVersionController extends SimpleBaseController<AppVersion> {

	protected AppVersionController() {
		super(AppVersion.class);
	}

	@Override
	public AppVersion getModel(HttpServletRequest request, AppVersion model) {
		return model;
	}

}
