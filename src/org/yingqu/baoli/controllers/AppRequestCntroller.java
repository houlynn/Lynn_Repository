package org.yingqu.baoli.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yingqu.baoli.model.AppClassify;
import org.yingqu.baoli.model.AppClassifyItem;
import org.yingqu.baoli.model.GoodImage;
import org.yingqu.baoli.model.Goods;
import org.yingqu.baoli.model.po.GoodsPo;
import org.yingqu.baoli.model.po.RoundPo;
import org.yingqu.framework.controllers.AppBaseController;
import org.yingqu.framework.model.vo.ResultModel;

/**
 * APP接口请求处理类
* @author HouLynn
* @date 2014年9月22日
  @version 1.0
 */
@RequestMapping("/app")
@Controller
public class AppRequestCntroller extends AppBaseController {
	
	
	/**
	 * 18.返回周边类型   无效参数
	 * 001 本地服务
	 * 002生活家政
	 * @param request
	 * @param response
	 */
	@RequestMapping("/001")
	public void appRequest001(HttpServletRequest request,HttpServletResponse response){
		final String hql=" from AppClassify where typeCode='001'";
		ResultModel resultModel=  this.initResultModel();
		try{
			  List<AppClassify> cls= (List<AppClassify>) ebi.queryByHql(hql);
			  List<RoundPo> list=new ArrayList<RoundPo>();
			  RoundPo rp=null;
			  for(AppClassify ac : cls){
				  rp=new RoundPo();
				  rp.setImg(ac.getImgurl());
				  rp.setName(ac.getClassify());
				  Set<RoundPo> child=new HashSet<RoundPo>();
				  Set<AppClassifyItem> items=ac.getItems();
				  RoundPo  rpchild=null;
				  for(AppClassifyItem aitm : items){
					  rpchild=new RoundPo();
					  rpchild.setName(aitm.getItemName());
					  rpchild.setImg(aitm.getImgurl());
					  child.add(rpchild);
				  }
				  rp.setChild(child);
				  list.add(rp);
;				  rp=null;
			  }
			  resultModel.setObj(list);
		}catch(Exception e){
            setServerErrCode(resultModel, "服务器错误！返回数据失败");			
			
		}
		toWritePhone(response, resultModel);
	}
	
	/**
	 * 19.返回周边类型   无需参数
	 * 002生活家政
	 * @param request
	 * @param response
	 */
	@RequestMapping("/002")
	public void appRequest002(HttpServletRequest request,HttpServletResponse response){
		final String hql=" from AppClassify where typeCode='002'";
		ResultModel resultModel=  this.initResultModel();
		try{
			  List<AppClassify> cls= (List<AppClassify>) ebi.queryByHql(hql);
			  List<RoundPo> list=new ArrayList<RoundPo>();
			  RoundPo rp=null;
			  for(AppClassify ac : cls){
				  rp=new RoundPo();
				  rp.setImg(ac.getImgurl());
				  rp.setName(ac.getClassify());
				  Set<RoundPo> child=new HashSet<RoundPo>();
				  Set<AppClassifyItem> items=ac.getItems();
				  RoundPo  rpchild=null;
				  for(AppClassifyItem aitm : items){
					  rpchild=new RoundPo();
					  rpchild.setName(aitm.getItemName());
					  rpchild.setImg(aitm.getImgurl());
					  child.add(rpchild);
				  }
				  rp.setChild(child);
				  list.add(rp);
;				  rp=null;
			  }
			  resultModel.setObj(list);
		}catch(Exception e){
            setServerErrCode(resultModel, "服务器错误！返回数据失败");			
			
		}
		toWritePhone(response, resultModel);
		
	}
	
	/**
	 *20 商品顶置接口  无效参数
	 */
	@RequestMapping("/003")
	public void appRequest003(HttpServletRequest request,HttpServletResponse response){
		final String hql=" from Goods  where hot='1'  order by modifyTime desc ";
		ResultModel resultModel=initResultModel();
		try{
			List<Goods> goods=	(List<Goods>) ebi.queryByHql(hql, 0, 3);
			List<GoodsPo> goddspro=new ArrayList<GoodsPo>();
			GoodsPo gdp=null;
			for(Goods gd : goods){
				gdp=new GoodsPo();
				Set<GoodImage> imgs=gd.getImgs();
				BeanUtils.copyProperties(gdp, gd);
				List<String> listImage=new ArrayList<String>();
				if(imgs!=null&&imgs.size()>0){
					for(GoodImage gimg :imgs ){
						listImage.add(gimg.getUrl());
					}
				}
				gdp.setImgs(listImage);
				listImage=null;
				goddspro.add(gdp);
				gdp=null;
			}
			resultModel.setObj(goddspro);
		}catch(Exception e){
			e.printStackTrace();
			setServerErrCode(resultModel, "服务端错误返回数据失败!");
		}
		toWritePhone(response, resultModel);
	}
	
	
	
	

}
