package org.yingqu.baoli.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.set.CompositeSet.SetMutator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.yingqu.baoli.ebi.GoodsEbi;
import org.yingqu.baoli.ebo.GoodsEbo;
import org.yingqu.baoli.model.AppClassify;
import org.yingqu.baoli.model.AppClassifyItem;
import org.yingqu.baoli.model.AppUser;
import org.yingqu.baoli.model.GoodImage;
import org.yingqu.baoli.model.Goods;
import org.yingqu.baoli.model.OrderContent;
import org.yingqu.baoli.model.OrderItem;
import org.yingqu.baoli.model.UserAdress;
import org.yingqu.baoli.model.po.GoodsPo;
import org.yingqu.baoli.model.po.OderPro;
import org.yingqu.baoli.model.po.RoundPo;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.controllers.AppBaseController;
import org.yingqu.framework.controllers.AppBaseController.PrepareResult;
import org.yingqu.framework.log.LogerManager;
import org.yingqu.framework.model.Model;
import org.yingqu.framework.model.vo.PModel;
import org.yingqu.framework.model.vo.ResultModel;
import org.yingqu.framework.utils.StringUtil;

import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;

/**
 * APP接口请求处理类
 * 
 * @author HouLynn
 * @date 2014年9月22日
 * @version 1.0
 */
@RequestMapping("/app")
@Controller
public class AppRequestCntroller extends AppBaseController implements LogerManager {

	@Autowired
	private GoodsEbi gdebi;
	

	public GoodsEbi getGdebi() {
		return gdebi;
	}

	public void setGdebi(GoodsEbi gdebi) {
		this.gdebi = gdebi;
	}

	/**
	 * 18.返回周边类型 无效参数 001 本地服务
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/001")
	public void appRequest001(HttpServletRequest request,
			HttpServletResponse response) {
		final String hql = " from AppClassify where typeCode='001'";
		ResultModel resultModel = this.initResultModel();
		try {
			List<AppClassify> cls = (List<AppClassify>) ebi.queryByHql(hql);
			List<RoundPo> list = new ArrayList<RoundPo>();
			RoundPo rp = null;
			for (AppClassify ac : cls) {
				rp = new RoundPo();
				rp.setImg(ac.getImgurl());
				rp.setName(ac.getClassify());
				Set<RoundPo> child = new HashSet<RoundPo>();
				Set<AppClassifyItem> items = ac.getItems();
				RoundPo rpchild = null;
				for (AppClassifyItem aitm : items) {
					rpchild = new RoundPo();
					rpchild.setName(aitm.getItemName());// 类别名称
					rpchild.setImg(aitm.getImgurl());// 图片路径
					child.add(rpchild);
				}
				rp.setChild(child);
				list.add(rp);
				;
				rp = null;
			}
			resultModel.setObj(list);
		} catch (Exception e) {
			setServerErrCode(resultModel, "服务器错误！返回数据失败");

		}
		toWritePhone(response, resultModel);
	}

	/**
	 * 19.返回周边类型 无需参数 002生活家政
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/002")
	public void appRequest002(HttpServletRequest request,
			HttpServletResponse response) {
		final String hql = " from AppClassify where typeCode='002'";
		ResultModel resultModel = this.initResultModel();
		try {
			List<AppClassify> cls = (List<AppClassify>) ebi.queryByHql(hql);
			List<RoundPo> list = new ArrayList<RoundPo>();
			RoundPo rp = null;
			for (AppClassify ac : cls) {
				rp = new RoundPo();
				rp.setImg(ac.getImgurl());
				rp.setName(ac.getClassify());
				Set<RoundPo> child = new HashSet<RoundPo>();
				Set<AppClassifyItem> items = ac.getItems();
				RoundPo rpchild = null;
				for (AppClassifyItem aitm : items) {
					rpchild = new RoundPo();
					rpchild.setName(aitm.getItemName());
					rpchild.setImg(aitm.getImgurl());
					child.add(rpchild);
				}
				rp.setChild(child);
				list.add(rp);
				;
				rp = null;
			}
			resultModel.setObj(list);
		} catch (Exception e) {
			setServerErrCode(resultModel, "服务器错误！返回数据失败");
			error(resultModel, e);

		}
		toWritePhone(response, resultModel);

	}

	/**
	 * 20 商品顶置接口 无效参数 跟据更新时间取前3个
	 */
	@RequestMapping("/003")
	public void appRequest003(HttpServletRequest request,
			HttpServletResponse response) {
		final String hql = " from Goods  where hot='1'  order by modifyTime desc ";
		ResultModel resultModel = initResultModel();
		try {
			List<Goods> goods = (List<Goods>) ebi.queryByHql(hql, 0, 3);
			debug("获取推荐到商品: "+goods.size());
			List<GoodsPo> goddspro = fillGoodsPo(goods);
			resultModel.setObj(goddspro);
		} catch (Exception e) {
			e.printStackTrace();
			setServerErrCode(resultModel, "服务端错误,返回数据失败!");
		}
		toWritePhone(response, resultModel);
	}
private List<GoodsPo> fillGoodsPo(List<Goods> goods) {
	List<GoodsPo> goddspro = new ArrayList<GoodsPo>();
				GoodsPo gdp = null;
				for (Goods gd : goods) {
					gdp = new GoodsPo();
					Set<GoodImage> imgs = gd.getImgs();
					gdp.setName(gd.getName());// 商品名称
					gdp.setPrice(gd.getPrice());// 单价
					gdp.setSaleCount(gd.getSaleCount());// 销售数量
					List<String> listImage = new ArrayList<String>();// 图片集合
					if (imgs != null && imgs.size() > 0) {
						for (GoodImage gimg : imgs) {
							listImage.add(gimg.getUrl());
						}
					}
					gdp.setImgs(listImage);
					listImage = null;
					goddspro.add(gdp);
					gdp = null;
				}
	return goddspro;
}

	/**
	 *  21 004 获取更多商品 可分页   不传页码显示全部
	 * @param whereSql 查询条件
	 * @param parentSql 准备sql
	 * @param querySql  
	 * @param orderSql 排序SQL
	 * @param start 从第几条取
	 * @param limit 页码
	 * @param response 
	 */
	@RequestMapping("/004")
	public void appRequest004(
			@RequestParam(value = "whereSql", required = false, defaultValue = "") String whereSql,
			@RequestParam(value = "parentSql", required = false, defaultValue = "") String parentSql,
			@RequestParam(value = "querySql", required = false, defaultValue = "") String querySql,
			@RequestParam(value = "orderSql", required = false, defaultValue = "") String orderSql,
			@RequestParam(value = "start", required = false, defaultValue = "0") String start,
			@RequestParam(value = "limit", required = false, defaultValue = "0") String limit,
			HttpServletResponse response) {
		super.load(whereSql, parentSql, querySql, orderSql, start, limit, response, Goods.class, (list,resultModel)->{
		        List<GoodsPo> listPro=new ArrayList<GoodsPo>();
		    	List<GoodsPo> goddspro = fillGoodsPo(list);
		    	resultModel.setObj(goddspro);
		});
	}
	/**
	 * 22  005商品详细
	 * 商品主键  必须的
	 */
	@RequestMapping("/005")
	public void appRequest005(@RequestParam(value = "gid", required = false, defaultValue = "") String gid,
			HttpServletRequest request,
			HttpServletResponse response ) {
		ResultModel resultModel=this.initResultModel();
		try{
			if(StringUtil.isEmpty(gid)){
				setEmptyCode(resultModel, "传入商品标示不能为空!");
			}else{
				Goods goods=ebi.findByOId(Goods.class, gid);
				if(goods==null){
					setNoFecCode(resultModel, "传入的商品标示无效!");
				}else{
					resultModel.setObj(goods);
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			setServerErrCode(resultModel, "服务器错误，无法返回商品详细信息！");
		}
		toWritePhone(response, resultModel);
	}

	/**
	 * 23 006订单接口
	 * @param userid 用户标示
	 * @param orderDetail 参考实体中属性
	 * @param udid 地址标示必填
	 * @param request
	 * @param response
	 */
	@RequestMapping("/006")
	public void appRequest006(@RequestParam(value = "userid", required = false, defaultValue = "") String userid,OderPro  orderDetail,
			@RequestParam(value = "udid", required = false, defaultValue = "") String udid,
			HttpServletRequest request,
			HttpServletResponse response ){
		   ResultModel resultModel=initResultModel();
		   try{
			   boolean flag=true;
			   if(StringUtil.isEmpty(userid)){
				   flag=false;
				   setEmptyCode(resultModel, "传入的用户标示不能为空!");
				   
			   }else { 
				   AppUser user=ebi.findByOId(AppUser.class, userid);
				   if(user==null){
					   flag=false;
					   setNoFecCode(resultModel, "传入的用户标示无效!");
				   }
			   }
			   if(StringUtil.isEmpty(udid)){
				   flag=false;
				   setEmptyCode(resultModel, "传入的送货地址标示不能为空!");
			   }else{
				   debug(" udid:"+udid);
				    UserAdress useraddress=ebi.findByOId(UserAdress.class,udid);
				    if(useraddress==null){
				    	 flag=false;
				    	setNoFecCode(resultModel, "传入的送货地址标示无效!");
				    }
			   }
			   if(flag){
				   OrderContent content=new OrderContent();
				   content.setUserid(userid);
				   content.setAdressid(udid);
				   content.setOrdertime(orderDetail.getOrdertime());
				   content.setRemarks(orderDetail.getRemark());
				   content.setAcount(orderDetail.getAoucnt());
				   String oderStr=orderDetail.getOderStr();
				   if(StringUtil.isEmpty(oderStr)){
					   setEmptyCode(resultModel, "订单json字符串不能为空!"); 
				   }else{
					   List<Map> detail=jsonBuilder.fromJsonArray(oderStr);
					   if(detail==null||detail.size()==0){
						   setNoFecCode(resultModel, "无效的定单信息！");
					   }else{
						   Set<OrderItem> orderitem=new HashSet<OrderItem>();
						   OrderItem or=null;
						   for(Map obj : detail){
							   or=new OrderItem();
							   Objects.requireNonNull(obj.get("gid"));
							   Objects.requireNonNull(obj.get("count"));
							   String gid=(String) obj.get("gid");
							   int count=(int) obj.get("count");
							   Goods goods=ebi.findByOId(Goods.class, gid);
							   if(goods==null){
								   setNoFecCode(resultModel, "传入的gid无效");
							   }else{
								   or.setGid(gid);
									or.setPrice(goods.getPrice());
									or.setCount(count);
									or.setAcount(goods.getPrice()*goods.getPrice());
									orderitem.add(or);
							   }
						   }
						   content.setItems(orderitem);
						   content.setIspay("0");
						   OrderContent oc= (OrderContent) gdebi.save(content);
						   String oderid=oc.getOrdid();
						   if(StringUtil.isEmpty(oderid)){
							   throw new Exception();
						   }
					   }
					 
				   }
				   
			   }
		   }catch (NullPointerException e) {
			   setNoFecCode(resultModel,"无法获取gid 或count值 ");
			   error(resultModel, e);
			// TODO: handle exception
		}
		   catch(Exception e){
			   e.printStackTrace();
			   setServerErrCode(resultModel);
			   error(resultModel,e);
		   }
		   toWritePhone(response, resultModel);
	}
}
