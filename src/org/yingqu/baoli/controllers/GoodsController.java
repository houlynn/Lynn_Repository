package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.yingqu.baoli.model.Goods;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.core.utils.AppUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RequestMapping("/bl/gd")
@Controller
public class GoodsController extends SimpleBaseController<Goods> {

	protected GoodsController() {
		super(Goods.class);
	}

	@Override
	public Goods getModel(HttpServletRequest request, Goods model) {
		return model;
	}

	@RequestMapping(value="/post",method=RequestMethod.POST)
	public void postNews(HttpServletRequest request,HttpServletResponse response,String gid ){
		try{
			Goods goods=(Goods) ebi.findById(clazz, gid);
			goods.setReleases("1");
			goods.setReleasetime(AppUtils.getCurrentTime());
			ebi.update(goods);
			toWrite(response, jsonBuilder.returnSuccessJson("'发布成功!'"));
		}catch(Exception e){
			error("发布失败!",e);
			toWrite(response, jsonBuilder.returnFailureJson("'发布失败!'"));
		}
		
	}
}
