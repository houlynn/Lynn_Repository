package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.RentalImg;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/renimg")
@Controller
public class RentalImgController extends SimpleBaseController<RentalImg> {

	protected RentalImgController() {
		super(RentalImg.class);
	}

	@Override
	public RentalImg getModel(HttpServletRequest request, RentalImg model) {
		return model;
	}

}
