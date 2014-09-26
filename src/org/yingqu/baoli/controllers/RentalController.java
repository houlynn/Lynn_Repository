package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.Rental;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/ren")
@Controller
public class RentalController extends SimpleBaseController<Rental> {

	protected RentalController() {
		super(Rental.class);
	}

	@Override
	public Rental getModel(HttpServletRequest request, Rental model) {
		return model;
	}

}
