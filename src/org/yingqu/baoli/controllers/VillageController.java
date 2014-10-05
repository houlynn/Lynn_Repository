package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.Village;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/vil")
@Controller
public class VillageController extends SimpleBaseController<Village> {

	protected VillageController() {
		super(Village.class);
	}

	@Override
	public Village getModel(HttpServletRequest request, Village model) {
		return model;
	}

}
