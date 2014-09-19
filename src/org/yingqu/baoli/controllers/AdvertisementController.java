package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.Advertisement;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/adt")
@Controller
public class AdvertisementController extends SimpleBaseController<Advertisement> {

	
	protected AdvertisementController() {
		super(Advertisement.class);
	}

	@Override
	public Advertisement getModel(HttpServletRequest request, Advertisement model) {
		return model;
	}

}
