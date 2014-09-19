package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.Feedback;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.core.utils.AppUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/fbd")
@Controller
public class FeedbackController extends SimpleBaseController<Feedback> {

	protected FeedbackController() {
		super(Feedback.class);
	}

	@Override
	public Feedback getModel(HttpServletRequest request, Feedback model) {
		return model;
	}

	@Override
	public void doSave(Feedback model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		model.setFbid(AppUtils.getCurrentTime());
		super.doSave(model, request, response);
	}

}
