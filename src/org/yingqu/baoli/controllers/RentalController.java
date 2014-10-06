package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.AppNews;
import org.yingqu.baoli.model.OfficialIteract;
import org.yingqu.baoli.model.Rental;
import org.yingqu.desktop.security.SecurityUserHolder;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.core.utils.AppUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value="/doUpdateContent",method=RequestMethod.POST)
	public void doUpdateContent(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="id",required=false) String id
			) {
		try{
		StringBuilder builder=new StringBuilder(request.getParameter("content"));
		Rental rental=(Rental) ebi.findById(clazz, id);
		rental.setRentalContent(builder.toString());
		ebi.update(rental);
		toWrite(response,
				jsonBuilder.returnSuccessJson("''"));
		}catch(Exception e){
			error("app新闻更新失败!", e);
			toWrite(response,
					jsonBuilder.returnFailureJson("'保存方法出错，错误信息"
							+ e.getMessage() + "'"));
		}
	}
	@RequestMapping(value="/push",method=RequestMethod.POST)
	public void postNews(HttpServletRequest request,HttpServletResponse response,String rid){
		try{
			Rental rental=(Rental) ebi.findById(clazz, rid);
			rental.setPtime(AppUtils.getCurrentTime());
			rental.setState("1");//官方
			rental.setUsername(SecurityUserHolder.getCurrentUser().getUsername());
			ebi.save(rental);
			toWrite(response, jsonBuilder.returnSuccessJson("'发布成功!'"));
		}catch(Exception e){
			error("发布失败!",e);
			toWrite(response, jsonBuilder.returnFailureJson("'发布失败!'"));
		}
	}
	
	
	
	@Override
	public void doUpdate(Rental model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		model.setRentalContent("");
		super.doUpdate(model, request, response);
	}

	@Override
	public void doSave(Rental model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		model.setSource("001");
		model.setState("0");
		super.doSave(model, request, response);
	}
	
	
}
