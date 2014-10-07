package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.desktop.model.Department;
import org.yingqu.desktop.model.EndUser;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.core.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/sysuser")
@Controller
public class EndUserController extends SimpleBaseController<EndUser> {

	protected EndUserController() {
		super(EndUser.class);
	}

	@Override
	public EndUser getModel(HttpServletRequest request, EndUser model) {
		Department department=new  Department();
		department.setDeptId("ROOT");
		//model.setPassword("123456");
		model.setDepartment(department);
		return model;
	}

	@Override
	public void doSave(EndUser model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
	    model.setSex("0");
		super.doSave(model, request, response);
	}

	@Override
	public void doUpdate(EndUser model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		model.setPassword(MD5Util.md5(model.getPassword()));
		super.doUpdate(model, request, response);
	}
	

}
