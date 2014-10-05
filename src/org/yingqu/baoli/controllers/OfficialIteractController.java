package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.AppNews;
import org.yingqu.baoli.model.OfficialIteract;
import org.yingqu.desktop.security.SecurityUserHolder;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.core.utils.AppUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@RequestMapping("/bl/offinc")
@Controller
public class OfficialIteractController extends SimpleBaseController<OfficialIteract> {

	protected OfficialIteractController() {
		super(OfficialIteract.class);
	}

	@Override
	public void doSave(OfficialIteract model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		model.setState("0");
		model.setOfficialContent("");
		super.doSave(model, request, response);
	}

	@RequestMapping(value="/doUpdateContent",method=RequestMethod.POST)
	public void doUpdateContent(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="id",required=false) String id
			) {
		try{
		StringBuilder builder=new StringBuilder(request.getParameter("content"));
		OfficialIteract iteract=(OfficialIteract) ebi.findById(clazz, id);
		 iteract.setOfficialContent(builder.toString());
		ebi.update( iteract);
		toWrite(response,
				jsonBuilder.returnSuccessJson("''"));
		}catch(Exception e){
			error("app新闻更新失败!", e);
			toWrite(response,
					jsonBuilder.returnFailureJson("'保存方法出错，错误信息"
							+ e.getMessage() + "'"));
		}
	}
	
	
	
	@Override
	public OfficialIteract getModel(HttpServletRequest request, OfficialIteract model) {
		return model;
	}
	@RequestMapping(value="/push",method=RequestMethod.POST)
	public void postNews(HttpServletRequest request,HttpServletResponse response,String oinerid){
		try{
			OfficialIteract iteract=(OfficialIteract) ebi.findById(clazz, oinerid);
			iteract.setPtime(AppUtils.getCurrentTime());
			iteract.setState("1");
			iteract.setUsername(SecurityUserHolder.getCurrentUser().getUsername());
			ebi.save(iteract);
			toWrite(response, jsonBuilder.returnSuccessJson("'发布成功!'"));
		}catch(Exception e){
			error("发布失败!",e);
			toWrite(response, jsonBuilder.returnFailureJson("'发布失败!'"));
		}
		
	}

}
