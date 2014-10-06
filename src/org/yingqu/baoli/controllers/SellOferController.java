package org.yingqu.baoli.controllers;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.model.Rental;
import org.yingqu.baoli.model.SellOfer;
import org.yingqu.desktop.security.SecurityUserHolder;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.core.utils.AppUtils;
import org.yingqu.framework.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@RequestMapping("/bl/sell")
@Controller
public class SellOferController extends SimpleBaseController<SellOfer> {

	protected SellOferController() {
		super(SellOfer.class);
	}

	@Override
	public SellOfer getModel(HttpServletRequest request, SellOfer model) {
		return model;
	}

	@RequestMapping(value="/push",method=RequestMethod.POST)
	public void postNews(HttpServletRequest request,HttpServletResponse response,String rid){
		try{
			SellOfer sellOfer=(SellOfer) ebi.findById(clazz, rid);
			sellOfer.setPtime(AppUtils.getCurrentTime());
			sellOfer.setState("1");
			sellOfer.setUsername(SecurityUserHolder.getCurrentUser().getUsername());
			ebi.save(sellOfer);
			toWrite(response, jsonBuilder.returnSuccessJson("'发布成功!'"));
		}catch(Exception e){
			error("发布失败!",e);
			toWrite(response, jsonBuilder.returnFailureJson("'发布失败!'"));
		}
	}

	@Override
	public void doUpdate(SellOfer model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		  if(StringUtil.isEmpty(model.getPrice())){
				 model.setPrice("0");
			  }
			  double dprice =Double.parseDouble(model.getPrice());
		       BigDecimal bg = new BigDecimal(dprice/10000);
		        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        model.setPrice(f1+"");
		        model.setSource("001");
		super.doUpdate(model, request, response);
	}

	@RequestMapping(value="/doUpdateContent",method=RequestMethod.POST)
	public void doUpdateContent(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="id",required=false) String id
			) {
		try{
		StringBuilder builder=new StringBuilder(request.getParameter("content"));
		SellOfer sellOfer=(SellOfer) ebi.findById(clazz, id);
		sellOfer.setSellContent(builder.toString());
		ebi.update(sellOfer);
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
	public void doSave(SellOfer model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		  if(StringUtil.isEmpty(model.getPrice())){
			 model.setPrice("0");
		  }
		  double dprice =Double.parseDouble(model.getPrice());
	       BigDecimal bg = new BigDecimal(dprice/10000);
	        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	        model.setPrice(f1+"");
	        model.setSource("001");
		
		super.doSave(model, request, response);
	}
	
	
}
