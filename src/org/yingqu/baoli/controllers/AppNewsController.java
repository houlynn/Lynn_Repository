package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;

import org.yingqu.baoli.model.AppNews;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/news")
@Controller
public class AppNewsController extends SimpleBaseController<AppNews> {

	protected AppNewsController() {
		super(AppNews.class);
	}

	@Override
	public AppNews getModel(HttpServletRequest request, AppNews model) {
		return model;
	}

}
