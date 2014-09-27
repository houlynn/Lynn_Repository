package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.AppUser;
import org.yingqu.baoli.model.Interact;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/inc")
@Controller
public class InteractController extends SimpleBaseController<Interact> {

	protected InteractController() {
		super(Interact.class);
	}

	@Override
	public Interact getModel(HttpServletRequest request, Interact model) {
		return model;
	}

	@Override
	public void doSave(Interact model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		AppUser appUser=new AppUser();
		appUser.setUserid("402881ed482625490148262ea7a70000");
		model.setUid(appUser);
		super.doSave(model, request, response);
	}
	
	

}
