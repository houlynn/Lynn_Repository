package org.yingqu.baoli.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;








import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.yingqu.baoli.ebi.GoodsEbi;
import org.yingqu.baoli.ebi.InteractEbi;
import org.yingqu.baoli.model.AppClassify;
import org.yingqu.baoli.model.AppClassifyItem;
import org.yingqu.baoli.model.AppNews;
import org.yingqu.baoli.model.AppUser;
import org.yingqu.baoli.model.GoodImage;
import org.yingqu.baoli.model.Goods;
import org.yingqu.baoli.model.Interact;
import org.yingqu.baoli.model.Massage;
import org.yingqu.baoli.model.Merchant;
import org.yingqu.baoli.model.OfficialIteract;
import org.yingqu.baoli.model.OfficialPhotograph;
import org.yingqu.baoli.model.OrderContent;
import org.yingqu.baoli.model.OrderItem;
import org.yingqu.baoli.model.Photograph;
import org.yingqu.baoli.model.Rental;
import org.yingqu.baoli.model.SellOfer;
import org.yingqu.baoli.model.UserAdress;
import org.yingqu.baoli.model.VirtualIcon;
import org.yingqu.baoli.model.po.AppNewPo;
import org.yingqu.baoli.model.po.AppNewProd;
import org.yingqu.baoli.model.po.GoodsDetail;
import org.yingqu.baoli.model.po.GoodsPo;
import org.yingqu.baoli.model.po.InteractListPo;
import org.yingqu.baoli.model.po.InteractPo;
import org.yingqu.baoli.model.po.MerchantPo;
import org.yingqu.baoli.model.po.MessagePo;
import org.yingqu.baoli.model.po.OderPro;
import org.yingqu.baoli.model.po.OrderProAdrees;
import org.yingqu.baoli.model.po.RentalPo;
import org.yingqu.baoli.model.po.RoundPo;
import org.yingqu.baoli.model.po.SellOferPo;
import org.yingqu.baoli.model.po.VirtualIconPo;
import org.yingqu.desktop.utils.ProcessFieldsUploadUtil;
import org.yingqu.framework.controllers.AppBaseController;
import org.yingqu.framework.core.utils.AppUtils;
import org.yingqu.framework.log.LogerManager;
import org.yingqu.framework.model.vo.ResultModel;
import org.yingqu.framework.utils.StringUtil;
/**
 * APP接口请求处理类
 * 
 * @author HouLynn
 * @date 2014年9月22日
 * @version 1.0
 */
@RequestMapping("/app")
@Controller
public class AppRequestCntroller extends AppBaseController {

	@Autowired
	private GoodsEbi gdebi;
	

	public GoodsEbi getGdebi() {
		return gdebi;
	}

	public void setGdebi(GoodsEbi gdebi) {
		this.gdebi = gdebi;
	}
	@Autowired
	private InteractEbi iebi;
	public InteractEbi getIebi() {
		return iebi;
	}
	public void setIebi(InteractEbi iebi) {
		this.iebi = iebi;
	}

	/**
	 * 18. 001返回周边类型 无效参数 001 本地服务
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
				rp.setCode(ac.getCid());
				Set<RoundPo> child = new HashSet<RoundPo>();
				Set<AppClassifyItem> items = ac.getItems();
				RoundPo rpchild = null;
				for (AppClassifyItem aitm : items) {
					rpchild = new RoundPo();
					rpchild.setCode(aitm.getItemid());
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
	 * 19.002返回周边类型 无需参数 002生活家政
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
	 * 20 003 商品顶置接口 无效参数 跟据更新时间取前3个
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
					gdp.setTrip(gd.getTrip());
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
	 *  21 004  获取更多商品 可分页   不传页码显示全部
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
		    	List<GoodsPo> goddspro = fillGoodsPo(list);
		    	resultModel.setObj(goddspro);
		});
	}
	/**
	 * 22 005 商品详细
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
					GoodsDetail gDetail= new GoodsDetail();
					 BeanUtils.copyProperties(gDetail, goods);
					 List<String> imgsList=new ArrayList<String>();
					 if(goods.getImgs()!=null&&goods.getImgs().size()>0){
						 for(GoodImage gdimg : goods.getImgs()){
							 imgsList.add(gdimg.getUrl());
						 }
						 String imgJsonStr=jsonBuilder.toJson(imgsList);
						 gDetail.setImg(imgJsonStr); 
					 }
					resultModel.setObj(gDetail);
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
                           content.setOrdertime(AppUtils.getCurrentTime());						   
						   content.setIspay("0");
						   OrderContent oc= (OrderContent) gdebi.saveOrder(content);
						   String oderid=oc.getOrdid();
						   if(StringUtil.isEmpty(oderid)){
							   throw new Exception();
						   }else{
							   resultModel.setObj(oderid);
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
	
	
	/**
	 * 24 007订单更新
	 * @param userid 用户标示
	 * @param orderDetail 参考实体中属性
	 * @param udid 地址标示必填
	 * @param request
	 * @param response
	 */
	@RequestMapping("/007")
	public void appRequest007(@RequestParam(value = "userid", required = false, defaultValue = "") String userid,
			@RequestParam(value = "udid", required = false, defaultValue = "") String udid,
			@RequestParam(value = "orderid", required = false, defaultValue = "") String orderid,
			OderPro  orderDetail,
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
			   OrderContent content =null;
			   List<String> itemids=new ArrayList<>();
				if (StringUtil.isEmpty(orderid)) {
					setEmptyCode(resultModel, "传入订单标示不能为空!");
					flag = false;
				}else{
					content = ebi.findByOId(OrderContent.class, orderid);
					if (content == null) {
						setNoFecCode(resultModel, "传入订单标示无效");
						flag = false;
					}else{
						Set<OrderItem> items=content.getItems();
						if(items!=null&&items.size()>0){
							itemids= items.parallelStream().map(item-> item.getOitmid()).collect(Collectors.toList());
						}
						
					}
				}
			   if(flag){
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
                           content.setOrdertime(AppUtils.getCurrentTime());						   
						   content.setIspay("0");
						   OrderContent oc= (OrderContent) gdebi.updateOrder(content,itemids);
						   String oderid=oc.getOrdid();
						   if(StringUtil.isEmpty(oderid)){
							   throw new Exception();
						   }else{
							   resultModel.setObj(oderid);
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
	
	
	/**
	 * 25  008更新订单支付状态接口
	 *userid 用户标示 
	 * orderid订单标示
	 * payType  001  银行卡支付   002 支付宝支付
	 * 支付成功 返回 OrderProAdrees 详细见属性
	 * 	订单状态 1待付款000  2支付成功 001  3 交易 成功 002   4交易关闭003
	 */
	@RequestMapping("/008")
	public void appRequest008(@RequestParam(value = "userid", required = false, defaultValue = "") String userid,
			@RequestParam(value = "orderid", required = false, defaultValue = "") String orderid,
			@RequestParam(value = "payType", required = false, defaultValue = "") String payType,
			HttpServletRequest request,
			HttpServletResponse response ){
		   ResultModel resultModel=initResultModel();
		    try {
				boolean flag = true;
				AppUser user = null;
				OrderContent order=null;
				if (StringUtil.isEmpty(userid)) {
					setEmptyCode(resultModel, "传入的用户标示不能为空!");
					flag = false;
				}else{
					user=ebi.findByOId(AppUser.class, userid);
					if (user == null) {
						setNoFecCode(resultModel, "传入用户标示无效");
						flag = false;
					}
				}
				if (StringUtil.isEmpty(orderid)) {
					setEmptyCode(resultModel, "传入订单标示不能为空!");
					flag = false;
				}else{
					order = ebi.findByOId(OrderContent.class, orderid);
					if (order == null) {
						setNoFecCode(resultModel, "传入订单标示无效");
						flag = false;
					}
				}
				if (StringUtil.isEmpty(payType)) {
					setEmptyCode(resultModel, "传入订支付类型不能为空!");
					flag = false;
				}
				
				if (flag) {
					order.setIspay("1");
					order.setPayType(payType);
					order= ebi.update(order);
					OrderProAdrees view=new OrderProAdrees();
					view.setIspay(order.getIspay());
					view.setOrdertime(order.getOrdertime());
					view.setItems(order.getItems());
					view.setAdress(ebi.findByOId(UserAdress.class, order.getAdressid()));
					resultModel.setObj(view);
				}
			} catch (Exception e) {
				// TODO: handle exception
				setServerErrCode(resultModel);
				error(resultModel,e);
			}
		    toWritePhone(response, resultModel);
		
	}
	/**
	 * 26  009删除订单
	 * @param userid
	 * @param orderid
	 * @param request
	 * @param response
	 */
	@RequestMapping("/009")
	public void appRequest009(@RequestParam(value = "userid", required = false, defaultValue = "") String userid,
			@RequestParam(value = "orderid", required = false, defaultValue = "") String orderid,
			HttpServletRequest request,
			HttpServletResponse response ){
		ResultModel resultModel=initResultModel();
		try{
			checkAppUser(userid, resultModel);
			if (StringUtil.isEmpty(orderid)) {
				setEmptyCode(resultModel, "传入订单标示不能为空!");
			}else{
				OrderContent content = ebi.findByOId(OrderContent.class, orderid);
				if (content == null) {
					setNoFecCode(resultModel, "传入订单标示无效");
				}else{
					ebi.removeById(orderid, OrderContent.class);
				}
			}
			
		}catch(Exception e){
			setServerErrCode(resultModel);
			error(resultModel, e);
		}
		   toWritePhone(response, resultModel);
	}
	
	
	
	/**
	 *27 010申请商户  请求类型为 multipart/form-data 
	 * 传递参考 我要开店页面  找到对应的属性 
	 *是否 上门 参考数 0,1
	 *btype  RoundPo 服务类型代码 
	 *其中 地址  可能包括 经度 纬度 详细地址 
	 *
	 */
	@RequestMapping("/010")
	public void appRequest0010( @Validated Merchant model,BindingResult br,@RequestParam("icon") MultipartFile icon,
			HttpServletRequest request,
			HttpServletResponse response) {
		ProcessFieldsUploadUtil.upload(model, icon,"icon","baoli.upload.merchant"); 
		String  useri=model.getUserid();
		ResultModel resultModel= this.initResultModel();
		try{
			checkAppUser(useri, resultModel);
			model.setApplytime(AppUtils.getCurrentTime());
			ebi.save(model);
		}catch(Exception e){
			e.printStackTrace();
			setServerErrCode(resultModel);
			error(resultModel,e);
		}
		  toWritePhone(response, resultModel);
	}

	/**
	 * 28 011 根据服务类型代码 加载商户
	 * @param dtype 类型code bixu
	 * @param request
	 * @param response
	 */
	@RequestMapping("/011")
	public void appRequest0011( 
			@RequestParam(value = "dtype", required = false, defaultValue = "") String dtype,
			HttpServletRequest request,
			HttpServletResponse response) {
	         ResultModel resultModel= this.initResultModel();
	         try{
	        	 if(StringUtil.isEmpty(dtype)){
	        		 setEmptyCode(resultModel, "传入服务类型代码不空!");
	        	 }else{
	        		 final String  hql="from Merchant where btype='"+dtype+"'";
	        		 List<Merchant> merList=(List<Merchant>) ebi.queryByHql(hql);
	        		List<MerchantPo> merListPO= merList.parallelStream().map(item->{
	        			 MerchantPo po=new MerchantPo();
	        			 try {
							BeanUtils.copyProperties(po, item);
						} catch (Exception e) {
							error("拷贝属性失败!",e);
						}
	        			return po; 
	        		 }).collect(Collectors.toList());
	        		resultModel.setObj(merListPO);
	        	 }
	        	 
	         }catch(Exception e){
	        		e.printStackTrace();
	    			setServerErrCode(resultModel);
	    			error(resultModel,e);
	         }
	         toWritePhone(response, resultModel);

	}
	/**
	 * 29 012  获取社区首页今日头条
	 */
	@RequestMapping("/012")
	public void appRequest0012( 
			HttpServletRequest request,
			HttpServletResponse response){
		super.requestMeth(response, (resultModel)->{
	    String today=AppUtils.getCurDate();
		 String hql=" from AppNews where 1=1 and addate between '"+today+"' and '"+today+"' order  by adtime desc" ;
		 List<AppNews> listnews=  (List<AppNews>) ebi.queryByHql(hql, 0, 1);
		 AppNews appNews=null;
		  if(listnews!=null&listnews.size()>0){
			  appNews=listnews.get(0);
		  }else{
			  hql=" from AppNews where 1=1  order  by addtime desc" ;
			  listnews=  (List<AppNews>) ebi.queryByHql(hql, 0, 1);
			  if(listnews==null||listnews.size()==0){
				  resultModel.setMsg("系统没有发布任何新闻");
			  }else{
				  appNews=listnews.get(0);
			  }
		  }
		  resultModel.setObj(appNews);
		});
	}
	/**
	 * 30 013 根据日期加载 APP新闻
	 * @param whereSql 查询条件  可选
	 * @param parentSql  可选
	 * @param querySql  可选
	 * @param orderSql 排序段  order by +字段名称 可选
	 * @param start 从几条取  可选
	 * @param limit 每页多少条  可选
	 * @param startdate 开始日期
	 * @param enddate 结束日期
	 */
	@RequestMapping("/013")
	public void appRequest0013( 
	@RequestParam(value = "whereSql", required = false, defaultValue = "") String whereSql,
	@RequestParam(value = "parentSql", required = false, defaultValue = "") String parentSql,
	@RequestParam(value = "querySql", required = false, defaultValue = "") String querySql,
	@RequestParam(value = "orderSql", required = false, defaultValue = "") String orderSql,
	@RequestParam(value = "start", required = false, defaultValue = "0") String start,
	@RequestParam(value = "limit", required = false, defaultValue = "0") String limit,
	@RequestParam(value = "startdate", required = false, defaultValue ="" ) String startdate,
	@RequestParam(value = "enddate", required = false, defaultValue = "") String enddate,
	HttpServletResponse response) {
		SimpleDateFormat formatter=new  SimpleDateFormat("yyyy-MM-dd");
		Date startd=null;
		Date endd=null;
		try {
		if(StringUtil.isEmpty(startdate)){
			startd=formatter.parse(AppUtils.getCurDate());
			startdate=formatter.format(startd);
		}else{
			startd = formatter.parse(startdate);
		}
		if(StringUtil.isEmpty(enddate)){
			endd=formatter.parse(AppUtils.getCurDate());
			enddate=formatter.format(endd);
		}else{
			endd = formatter.parse(enddate);
		}
		if(startd==null||endd==null){
			error("日期转换失败!");
			
		}else{
			List<String> dates=AppUtils.findDates(startd, endd);
			whereSql+=" and addate between  '"+startdate+"' and '"+enddate+"' ";
			orderSql+=" order  by adtime desc";
			super.load(whereSql, parentSql, querySql, orderSql, start, limit, response, AppNews.class,(list,resultModel)->{
				  List<AppNews>  listnews=list;
				  debug("获取到SIZE： "+list.size());
				  /**
				   * 按日期 作为 map key 
				   * 返回   list 新闻 列表
				   */
				  List <Map<String ,List<AppNewPo>>>listNews=new   ArrayList<Map<String ,List<AppNewPo>>>();
				
				  if(list!=null){
					  for(String d :dates ){
						  List<AppNewPo> views=  listnews.parallelStream().filter(item-> d.equals(item.getAddate()))
								  .map(item-> new AppNewPo(item.getTitle(),item.getShrinkimg()))
								  .collect(Collectors.toList());
						 Map<String ,List<AppNewPo>> mapnews=new HashMap<String,List<AppNewPo>>();
						 mapnews.put(d, views);
						 listNews.add(mapnews);
					  }
				  }
				  resultModel.setObj(listNews);
			} );
		}
		} catch (ParseException e) {
			error("日期转换失败!");
		}

	}
	/**
	 * 
	 * 31 014  根据 新闻 标示加载 一条新闻
	 * @param newid 必须滴
	 */
	@RequestMapping("/014")
	public void appRequest0014(
			String  newid,
			HttpServletRequest request,
			HttpServletResponse response
			){
		
		super.requestMeth(response, resultModel->{
			AppNews	appNews= super.checkNoFec(newid, "新闻标示不能为空!", "新闻标示无效!", resultModel, AppNews.class);
			AppNewProd  appNewProd=new AppNewProd();
			appNewProd.setTitle(appNews.getTitle());
			appNewProd.setAddate(appNews.getAddate());
			appNewProd.setImg(appNews.getShrinkimg());
			appNewProd.setSource(appNews.getSource());
			resultModel.setObj(appNewProd);
		});
	}
	
	/** 
	 * 32 加载虚拟小区 015 无需参数
	 */
	@RequestMapping("/015")
	public void appRequest0014(
			@RequestParam(value = "whereSql", required = false, defaultValue = "") String whereSql,
			@RequestParam(value = "parentSql", required = false, defaultValue = "") String parentSql,
			@RequestParam(value = "querySql", required = false, defaultValue = "") String querySql,
			@RequestParam(value = "orderSql", required = false, defaultValue = "") String orderSql,
			@RequestParam(value = "start", required = false, defaultValue = "0") String start,
			@RequestParam(value = "limit", required = false, defaultValue = "0") String limit,
			HttpServletRequest request,
			HttpServletResponse response
			){
		     super.load(whereSql, parentSql, querySql, orderSql, start, limit, response, VirtualIcon.class, (list,resultModel)->{
		    	  List<VirtualIconPo> views=new ArrayList<VirtualIconPo>();
		    	  views=list.parallelStream().map(item->{
		    		   VirtualIconPo view=  new VirtualIconPo();
		    		   view.setInconUrl(item.getInconUrl());
		    		   view.setName(item.getName());
		    		   view.setLinkUrl(item.getLinkUrl());
		    		   return view;
		    	  }). collect(Collectors.toList());
		    	 resultModel.setObj(views);
		     });
	}
/**
 * 33 016 用户发帖  提交 方式 enctype="multipart/form-data"
 * @param userid 用户标示 必须
 * @param type 帖子类型 必须   相关项参考    数字字典    用户论坛分类 条目
 * @param model  参考用户 发帖界面  注意活动类型帖子传入的参数, 发帖地址
 * @param imge 图片文件u 用户上传图片的文件集合 file类型
 * @param request
 * @param response
 */
	@RequestMapping(value= "/016",method=RequestMethod.POST)
	public void appRequest016(
			@Validated Interact model, BindingResult result, @RequestParam("imge") MultipartFile[] imges, 
			HttpServletRequest request,
			HttpServletResponse response
			){
		String  userid=model.getUserid();
		String type=model.getType();
		     super.requestMeth(response, resultModel->{
                AppUser appUser=  checkAppUser(userid, resultModel);
                if(appUser!=null){
                  if(StringUtil.isEmpty(type)){
                	  setEmptyCode(resultModel, "贴子类型不能为空!");
                  }else{
                   Set<Photograph> imgeItems=new HashSet<>();
                 Photograph imgeItem=null;
                	for(MultipartFile img :imges ){
                		if(img!=null){
                			imgeItem=new   Photograph();
                	  		String path= ProcessFieldsUploadUtil.processFieldsUpload(img,"baoli.upload.interact");
                    		if(path==null){
                    			 setServerErrCode(resultModel);
                    		}
                    		imgeItem.setImgurl(path);
                    		imgeItems.add(imgeItem);
                    		imgeItem=null;
                		}
                	}
                	model.setPhotourl(imgeItems);
                	model.setUid(appUser);
                	iebi.saveInteract(model);
                  }
                }
		     });
	}
	/**
	 * 34 017评论帖子
	 * @param msg 用户标示 ，贴子ID，评论内容必须的  用户定位信息
	 * @param request
	 * @param response
	 */
	@RequestMapping(value= "/017",method=RequestMethod.POST)
	public void appRequest017(Massage msg,
			HttpServletRequest request,
			HttpServletResponse response
			){
		super.requestMeth(response, (resultModel->{
			String userid=msg.getUserid();
			String inid=msg.getInid();
			String cpntext=msg.getContext();
			boolean flag=true;
		    AppUser appUser= checkNoFec(userid, "用户标示不能为空!","传入用户标示无效!", resultModel,AppUser.class );
		    Interact   interact=checkNoFec(inid, "贴子标示不能为空", "传入贴子无效", resultModel,Interact.class);
		    if(appUser==null){
		    	flag=false;
		    }else if(interact==null){
		    	flag=false;
		    }else if(StringUtil.isEmpty(cpntext)){
		    	flag=false;
		    	setEmptyCode(resultModel, "评论内容不能为空");
		    }
			if(flag){
				ebi.save(msg);
				resultModel.setObj(ebi);
			}
		}));
	}
	
	/**
	 * 35 018加载用户贴列表 可分页
	 * @param msg
	 * @param request
	 * @param response
	 */
	@RequestMapping(value= "/018")
	public void appRequest018(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "whereSql", required = false, defaultValue = "") String whereSql,
			@RequestParam(value = "parentSql", required = false, defaultValue = "") String parentSql,
			@RequestParam(value = "querySql", required = false, defaultValue = "") String querySql,
			@RequestParam(value = "orderSql", required = false, defaultValue = "") String orderSql,
			@RequestParam(value = "start", required = false, defaultValue = "0") String start,
			@RequestParam(value = "limit", required = false, defaultValue = "0") String limit
			){
		   super.load(whereSql, parentSql, querySql, orderSql, start, limit, response, Interact.class, (list,resultModel)->{
			   List<InteractListPo> views=new ArrayList<>();
			   views= list.parallelStream().map(item->{
				   InteractListPo viewItem=new InteractListPo();
				   viewItem.setPostTime(item.getPtime());
				   viewItem.setInid(item.getInterid());
				   viewItem.setPostAddress(item.getPostAddress());
				   viewItem.setTypeCode(item.getType());
				   viewItem.setContext(item.getContent());
				   Set<Photograph> imgs=item.getPhotourl();
				   if(imgs!=null&&imgs.size()>0){
					   for(Photograph img : imgs){
						   viewItem.getImgList().add(img.getImgurl());
					   }
				   }
				    AppUser appUser=item.getUid();
				    viewItem.setTopUrl(appUser.getTopUrl());
				    viewItem.setUserName(appUser.getUsername());
				    viewItem.setSefTick(appUser.getSefTick());
				   return viewItem;
			   }).collect(Collectors.toList());
			   resultModel.setObj(views);
		   });

	}
	
	/**
	 * 36 加载评论    interid 必须
	 * @param request
	 * @param response
	 * @param model
	 * @param whereSql
	 * @param parentSql
	 * @param querySql
	 * @param orderSql
	 * @param start
	 * @param limit
	 */
	@RequestMapping(value= "/019")
	public void appRequest019(
			HttpServletRequest request,
			HttpServletResponse response,
			String  interid,
			@RequestParam(value = "whereSql", required = false, defaultValue = "") String whereSql,
			@RequestParam(value = "parentSql", required = false, defaultValue = "") String parentSql,
			@RequestParam(value = "querySql", required = false, defaultValue = "") String querySql,
			@RequestParam(value = "orderSql", required = false, defaultValue = "") String orderSql,
			@RequestParam(value = "start", required = false, defaultValue = "0") String start,
			@RequestParam(value = "limit", required = false, defaultValue = "0") String limit
			){
		    super.requestMeth(response, (resultModel)->{
		    	if(StringUtil.isEmpty(interid)){
		    		setEmptyCode(resultModel, "帖子标识不能为空!");
		    	}
		    });
		     whereSql+=" and  inid='"+interid+"'";
			  orderSql+=" order  by backtime desc";
			  super.load(whereSql, parentSql, querySql, orderSql, start, limit, response, Massage.class, (list,resultModel)->{
				   List<MessagePo> views=new ArrayList<>();
				   views= list.parallelStream().map(item->{
 					  MessagePo view=new MessagePo();
					   view.setCity(item.getCity());
					   view.setProvince(item.getProvince());
					   view.setMesg(item.getContext());
					   view.setUserName(item.getUsername());
					   view.setPsTime(item.getBacktime());
					  return view;
				  }).collect(Collectors.toList());
                   resultModel.setObj(views); 				  
			  });
	}
	
	/**
	 *37 加载出租信息
	 * @param request
	 * @param response
	 * @param whereSql
	 * @param parentSql
	 * @param querySql
	 * @param orderSql
	 * @param start
	 * @param limit
	 */
	@RequestMapping(value= "/020")
	public void appRequest020(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "whereSql", required = false, defaultValue = " and state='1' ") String whereSql,
			@RequestParam(value = "parentSql", required = false, defaultValue = "") String parentSql,
			@RequestParam(value = "querySql", required = false, defaultValue = "") String querySql,
			@RequestParam(value = "orderSql", required = false, defaultValue = " order  by ptime desc ") String orderSql,
			@RequestParam(value = "start", required = false, defaultValue = "0") String start,
			@RequestParam(value = "limit", required = false, defaultValue = "0") String limit
			){
		      super.load(whereSql, parentSql, querySql, orderSql, start, limit, response, Rental.class, (list,resultModel)->{
		    	   List<RentalPo> views=new ArrayList<>();
		    	   views=  list.parallelStream().map(item->{
		    		  RentalPo  view=new RentalPo();
		    		  try {
						BeanUtils.copyProperties(view, item);
						view.setPrice(view.getPrice()+"元/m2/天");
					} catch (Exception e) {
						e.printStackTrace();
					}
		    		  return view;}).collect(Collectors.toList());
		    	  resultModel.setObj(views);
		      });
	}
	
	/**
	 *38 加载出租信息
	 * @param request
	 * @param response
	 * @param whereSql
	 * @param parentSql
	 * @param querySql
	 * @param orderSql
	 * @param start
	 * @param limit
	 */
	@RequestMapping(value= "/021")
	public void appRequest021(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "whereSql", required = false, defaultValue = " and state='1' ") String whereSql,
			@RequestParam(value = "parentSql", required = false, defaultValue = "") String parentSql,
			@RequestParam(value = "querySql", required = false, defaultValue = "") String querySql,
			@RequestParam(value = "orderSql", required = false, defaultValue = " order  by ptime desc ") String orderSql,
			@RequestParam(value = "start", required = false, defaultValue = "0") String start,
			@RequestParam(value = "limit", required = false, defaultValue = "0") String limit
			){
		      super.load(whereSql, parentSql, querySql, orderSql, start, limit, response, SellOfer.class, (list,resultModel)->{
		    	   List<RentalPo> views=new ArrayList<>();
		    	   views= list.parallelStream().map(item->{
		    		  RentalPo  view=new RentalPo();
		    		  try {
						BeanUtils.copyProperties(view, item);
						if("0".equals(view.getPrice())){
							view.setPrice("面议");
						}else{
							view.setPrice(view.getPrice()+"万");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		    		  return view;}).collect(Collectors.toList());
		    	  resultModel.setObj(views);
		      });
	}
	
	/**
	 * 39 22加载官方  帖子详细 信息    
	 * @param   tid  帖子ID
	 * @param request
	 * @param response
	 */
	@RequestMapping(value= "/022")
	public void appRequest022(
			HttpServletRequest request,
			HttpServletResponse response,
			String tid
			){
		   super.requestMeth(response,resultModel->{
			   OfficialIteract iteract=   checkNoFec(tid, "帖子标识不能为空!", "帖子标识无效!", resultModel, OfficialIteract.class);
			   if(iteract!=null){
				   InteractPo interactPo=new InteractPo(); 
				   interactPo.setPostTime(iteract.getPtime());
				   interactPo.setInid(iteract.getOinerid());
				   interactPo.setTypeCode(iteract.getType());
				   interactPo.setContext(iteract.getContent());
				   Set<OfficialPhotograph> imgs=iteract.getPhotourl();
				   if(imgs!=null&&imgs.size()>0){
					   for(OfficialPhotograph img : imgs){
						   interactPo.getImgList().add(img.getImgurl());
					   }
				   }
				   resultModel.setObj(interactPo);
			   }
		   } );
	}
	/**
	 * 40详细 出租信息
	 * @param request
	 * @param response
	 * @param tid
	 */
	@RequestMapping(value= "/023")
	public void appRequest023(
			HttpServletRequest request,
			HttpServletResponse response,
			String rid
			){
		super.requestMeth(response, (resultModel)->{
			Rental rental=  checkNoFec(rid, "出租识示能为空", "出租标识无效", resultModel, Rental.class);
			if(rental!=null){
				RentalPo view=new RentalPo();
				BeanUtils.copyProperties(view, rental);
				resultModel.setObj(view);
			}
		});
		
		
	}
	
	
	/**
	 * 41 详细 出售信息
	 * @param request
	 * @param response
	 * @param tid
	 */
	@RequestMapping(value= "/024")
	public void appRequest024(
			HttpServletRequest request,
			HttpServletResponse response,
			String rid
			){
		super.requestMeth(response, (resultModel)->{
			SellOfer sellOfer=  checkNoFec(rid, "出租标识能为空", "出租标示无效", resultModel, SellOfer.class);
			if(sellOfer!=null){
				SellOferPo view=new SellOferPo();
				BeanUtils.copyProperties(view, sellOfer);
				resultModel.setObj(view);
			}
		});
	}
		
		
	
	
	private AppUser checkAppUser(String useri, ResultModel resultModel)
			throws Exception {
		AppUser appUser=null;
		if(StringUtil.isEmpty(useri)){
			setEmptyCode(resultModel, "传入的用户标示不能为空！");
		}else{
			appUser=ebi.findByOId(AppUser.class, useri);
			if(appUser==null){
				setNoFecCode(resultModel, "传入的用户标示无效!");
			}
		}
		return appUser;
	}
	
}
