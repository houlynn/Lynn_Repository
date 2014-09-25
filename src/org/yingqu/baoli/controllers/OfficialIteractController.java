package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.OfficialIteract;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/inc")
@Controller
public class OfficialIteractController extends SimpleBaseController<OfficialIteract> {

	protected OfficialIteractController() {
		super(OfficialIteract.class);
	}

	@Override
	public OfficialIteract getModel(HttpServletRequest request, OfficialIteract model) {
		return model;
	}

}
