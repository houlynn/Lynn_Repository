package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.OfficialIteract;
import org.yingqu.baoli.model.Rental;
import org.yingqu.desktop.security.SecurityUserHolder;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.core.utils.AppUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value="/push",method=RequestMethod.POST)
	public void postNews(HttpServletRequest request,HttpServletResponse response,String rid){
		try{
			Rental rental=(Rental) ebi.findById(clazz, rid);
			rental.setPtime(AppUtils.getCurrentTime());
			rental.setState("1");
			rental.setUsername(SecurityUserHolder.getCurrentUser().getUsername());
			ebi.save(rental);
			toWrite(response, jsonBuilder.returnSuccessJson("'发布成功!'"));
		}catch(Exception e){
			error("发布失败!",e);
			toWrite(response, jsonBuilder.returnFailureJson("'发布失败!'"));
		}
		
	}
}
