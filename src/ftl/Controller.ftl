package org.HouLynn.desktop.controllers;

import javax.servlet.http.HttpServletRequest;

import org.HouLynn.desktop.model.${className};
import org.HouLynn.framework.controllers.BaseController;
import org.HouLynn.framework.controllers.BaseController;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("${className}Action")
@Scope("prototype")
public class ${className}Controller extends BaseController<${className}> {
	protected ${className}Controller() {
		super(${className}.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ${className} getModel(HttpServletRequest request, ${className} model) {
		// TODO Auto-generated method stub
		return model;
	}

}
