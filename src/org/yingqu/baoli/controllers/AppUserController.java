package org.yingqu.baoli.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.ebi.AppUserEbi;
import org.yingqu.baoli.model.AppUser;
import org.yingqu.baoli.model.GoodImage;
import org.yingqu.baoli.model.Goods;
import org.yingqu.baoli.model.Merchant;
import org.yingqu.baoli.model.OrderContent;
import org.yingqu.baoli.model.UserAdress;
import org.yingqu.baoli.model.po.AppUserPo;
import org.yingqu.baoli.model.po.ColleckMercharPro;
import org.yingqu.baoli.model.po.CollectBase;
import org.yingqu.baoli.model.po.CollectPo;
import org.yingqu.baoli.model.po.OrderPro;
import org.yingqu.baoli.model.po.UserAdressPo;
import org.yingqu.desktop.utils.ProcessFieldsUploadUtil;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.core.utils.AppUtils;
import org.yingqu.framework.model.vo.ResultModel;
import org.yingqu.framework.utils.StringUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/bl/appu")
@Controller
public class AppUserController extends SimpleBaseController<AppUser> {

	protected AppUserController() {
		super(AppUser.class);
	}
	
	

	@Override
	public AppUser getModel(HttpServletRequest request, AppUser model) {
		return model;
	}

	@Override
	public void doSave(AppUser model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		setDefualtValue(model);
		super.doSave(model, request, response);
	}

	private void setDefualtValue(AppUser model) {
		try {
			Random random = new Random();
			int nuber = random.nextInt(100000);
			AppUser user = (AppUser) ebi
					.getEntityByHql("from AppUser where loginCode='" + nuber
							+ "'");
			while (user != null) {
				nuber = random.nextInt(100000);
				user = (AppUser) ebi
						.getEntityByHql("from AppUser where loginCode='"
								+ nuber + "'");
			}
			model.setLoginCode(nuber + "");
			model.setSex("001");
			model.setOwner("000");
			model.setPwd("000");
		/*	EndUser currentUser = SecurityUserHolder.getCurrentUser();
			if (currentUser != null) {
				model.setDeptid(currentUser.getDeptId());
				model.setDeptname(currentUser.getDeptName());
				Department dept = currentUser.getDepartment();
				if (dept != null) {
					model.setCity(dept.getCity());
				}
			}*/

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public void doUpdateList(String strData, String[] ids,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		super.doUpdateList(strData, ids, request, response);
	}

	@RequestMapping("/doUpdateUser")
	public void doUpdateUser(HttpServletRequest request,
			HttpServletResponse response, @Validated AppUser model,
			BindingResult br, @RequestParam("topUrl") MultipartFile topUrl) {
		
		if(StringUtil.isNotEmpty(topUrl.getOriginalFilename())){
			ProcessFieldsUploadUtil.upload(model, topUrl, "topUrl",
					"baoli.upload.top");
		}
		// TODO Auto-generated method stub
		super.doUpdate(model, request, response);
	}

	@RequestMapping("/doSaveUser")
	public void doSaveUser(HttpServletRequest request,
			HttpServletResponse response, @Validated AppUser model,
			BindingResult br, @RequestParam("topUrl") MultipartFile topUrl) {
		// TODO Auto-generated method stub
		ProcessFieldsUploadUtil.upload(model, topUrl, "topUrl",
				"baoli.upload.top");
		setDefualtValue(model);
		super.doSave(model, request, response);
	}
	
	
//////////////////////////////////////////////////APP方法////////////////////////////////////////////////////////////////////////////
	
	/**
	 *1   添加一个注册接口  参数值参考 注册界面
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("/register")
	public void register(HttpServletRequest request,
			HttpServletResponse response, @Validated AppUser model){
		     ResultModel resultModel= this.initResultModel();
		     try {
		    	 if(StringUtil.isNotEmpty(model.getLoginCode())){
		    		   String hql=" from AppUser where loginCode='"+model.getLoginCode().trim()+"'";
			            AppUser appuser= (AppUser) ebi.getEntityByHql(hql);
			            if(null==appuser){
			 			 ebi.save(model);
			            }else{
			            	setNoFecCode(resultModel,"用户账号已存在!");
			            }
		    	 }else{
		    		 setEmptyCode(resultModel,"用户账号不能为空！");
		    	 }
		    	 if(StringUtil.isEmpty(model.getPwd())){
		    		 setEmptyCode(resultModel, "密码不能为空!");
		    	 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				setServerErrCode(resultModel,"注册失败!");
				error(resultModel.getMsg(), e);
			}
		     toWriterResult(response, resultModel);
		
	}
	
	/***
	 * 2登录接口 传入用户 loginCode pwd必须的
	 * @param appUser
	 * @param response
	 */
	@RequestMapping("/login")
	public void login(AppUser appUser, HttpServletResponse response) {
		this.initResultModel();
		ResultModel resModel = initResultModel();
		debug(AppUtils.getCurrentTime()+":APP调用 login");
		try {
			String pwd = appUser.getPwd();
			String loginCode = appUser.getLoginCode();
			if( StringUtil.isEmpty(loginCode)){
				setEmptyCode(resModel, "loginCode");
			} else {
				String hql = " from AppUser o where loginCode='" + loginCode
						+ "' and pwd='" + pwd + "'";
				List<AppUser> users = (List<AppUser>) ebi.queryByHql(hql);
				if (users != null && users.size() == 1) {
					 AppUserPo appUserPo=new AppUserPo();
					 String userid=users.get(0).getUserid();
					 BeanUtils.copyProperties(appUserPo, users.get(0));
					  String horder=" select count(o) from OrderContent o where o.userid='"+userid+"'";
					  Integer count= ebi.getCount(horder);
					  appUserPo.setOrderCount(count);
					  String hcoll=" select count(o) from UserCollection o where o.uid='"+userid+"'";
					  count=ebi.getCount(hcoll);
					  String addHql="from UserAdress where userid='"+userid+"' and defaulted='1'";
					  UserAdress addAdress=(UserAdress) ebi.getEntityByHql(addHql);
					  if(addAdress!=null){
						  appUserPo.setDefaultAddressid(addAdress.getUdid());
					  }
					  appUserPo.setCollecCount(count);
					resModel.setObj(appUserPo);
					
				}else{
					setNoFecCode(resModel,"用户名或密码错误！");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			setServerErrCode(resModel, "服务器错误!登陆失败!");
			error(resModel.getMsg(), e);
		}
		toWriterResult(response, resModel);

	}
	/**
	 * 3根据用户ID 获取用户个人信息接口 传入    userid 
	 * 
	 * @param uid
	 */
	@RequestMapping("/loadAppUser")
	public void loadAppUser(String userid, HttpServletResponse response) {
		ResultModel resModel = initResultModel();
		debug(AppUtils.getCurrentTime()+":APP调用 加载用户个人信息 loadAppUser");
		try {
			if(StringUtil.isEmpty(userid)){
			}else{
				AppUser appUser = (AppUser) ebi.findById(AppUser.class, userid);
				if(appUser==null){
					setServerFecCode(resModel, "传入的用户标示无效无法获取用户信息!");
				}else{
					      AppUserPo appUserPo=new AppUserPo();
						  BeanUtils.copyProperties(appUserPo, appUser);
						  String horder=" select count(o) from OrderContent o where o.userid='"+userid+"'";//加载我的订单
						  Integer count= ebi.getCount(horder);
						  appUserPo.setOrderCount(count);
						  String hcoll=" select count(o) from UserCollection o where o.uid='"+userid+"'";//加载我的收藏
						  count=ebi.getCount(hcoll);
						  appUserPo.setCollecCount(count);		 
						  String addHql="from UserAdress where userid='"+userid+"' and defaulted='1'";//加载用户默认地址
						  UserAdress addAdress=(UserAdress) ebi.getEntityByHql(addHql);
						  if(addAdress!=null){
							  appUserPo.setDefaultAddressid(addAdress.getUdid());
						  }
						  resModel.setObj(appUserPo);
				}
			}
	
		} catch (Exception e) {
			e.printStackTrace();
			setServerErrCode(resModel, "服务器错误！无法获取用户信息");
			error("无法加载用户信息!", e);
		}
		toWriterResult(response, resModel);
	}

	/**
	 * 4    用户更新接口 
	 * 请求类型为 multipart/form-data
	 * @param appUser
	 * @param response
	 * 默认地址
	 */
	@RequestMapping("/updateAppUser")
	public void updateAppUser(AppUser appUser,HttpServletResponse response, 
			HttpServletRequest request,
			BindingResult br, @RequestParam("topUrl") MultipartFile topUrl
			) {
		debug(AppUtils.getCurrentTime()+":APP调用 updateAppUser");
		ResultModel resModel = initResultModel();
		String userId = appUser.getUserid();
		if (StringUtil.isEmpty(userId)) {
			setEmptyCode(resModel, "传入用户标示不能为空!");
		} else {
			AppUser user;
			try {
				user = (AppUser) ebi.findById(AppUser.class, userId);
				if (user == null) {
					setNoFecCode(resModel, "传入用户标示无效");
					error("传入无效的用户标示!");
				} else {
					if(StringUtil.isNotEmpty( topUrl.getOriginalFilename())){
						ProcessFieldsUploadUtil.upload(appUser, topUrl, "topUrl",
								"baoli.upload.top");
					}
					user.setUsername(appUser.getUsername());//用户亲昵
					if(StringUtil.isNotEmpty( appUser.getDefaultAddressid())){
						 UserAdress uddres=new UserAdress();
						 uddres.setUdid(appUser.getDefaultAddressid());
						 defaultAddress(uddres, request, response);
						 debug("更新用户地址！:");
						 
					}
					user.setOccupation(appUser.getOccupation());//职业
					user.setConstellation(appUser.getConstellation());//星座
					user.setHome(appUser.getHome());//家乡
					user.setSefTick(appUser.getSefTick());//个性签名
					user.setFeelings(user.getFeelings());//情感状态
					user.setTopUrl(appUser.getTopUrl());//用户头像
				    debug("用户头像地址:"+appUser.getTopUrl());
				    ebi.update(user);
					resModel.setMsg("更新成功!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				setServerErrCode(resModel, "服务器错误！更新用户失败!");
				error(resModel.getMsg(), e);
			}
			toWriterResult(response, resModel);

		}

	}
	/**
	 * 5设置送货地址 需要传入 userid必须的
	 * @param adress
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="addAdress")
	public void addAdress(UserAdress adress,HttpServletRequest request, HttpServletResponse response){
		ResultModel resultModel= initResultModel();
		debug(AppUtils.getCurrentTime()+":APP调用  设置addAdress");
		      try {
				AppUser appUser=(AppUser) ebi.findById(AppUser.class, adress.getUserid());
				if(appUser==null){
					setNoFecCode(resultModel, "传入的用户标示无效,无进行添加操作!");
					error(resultModel.getMsg());
				}else{
					 adress.setAppUser(appUser);
					 super.phoneSave(request, response,adress);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				setServerErrCode(resultModel, "服务端错误， 设置地址失败!");
				e.printStackTrace();
				error(resultModel.getMsg(), e);
			}
		  	toWriterResult(response, resultModel);  
	}
	
	/** 6更新送货地址
	 * @param adress
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="updateAdress")
	public void updateAdress(UserAdressPo adress,HttpServletRequest request,HttpServletResponse response){
		debug(AppUtils.getCurrentTime()+":APP调用更新用户地址 updateAdress");
		ResultModel resultModel=initResultModel();
		String userid=adress.getUserid();
		if(StringUtil.isEmpty(userid)){
			setEmptyCode(resultModel, "传入的用户标示不能为空!");
			error(resultModel.getMsg());
		}else{
			AppUser appUser=new AppUser();
			appUser.setUserid(userid);
		}
		super.phoneUpdate(request, response, adress, UserAdress.class);
		
	}
	
/**
 * 7删除送货地址
 * @param adress
 * @param request
 * @param response
 */
	@RequestMapping(value="removeAdress")
	public void removeAdress(UserAdress adress,HttpServletRequest request,HttpServletResponse response){
		debug(AppUtils.getCurrentTime()+":APP调用 删除用户地址removeAdress");
		super.phoneRemove(request, response, adress);
	}
	
	/**
	 * 8获取所用送货地址
	 * @param mode
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="loadAddress")
	public void loadAddress(AppUser mode, HttpServletRequest request,HttpServletResponse response){
		debug(AppUtils.getCurrentTime()+":APP调用获取用户所有地址 loadAddress");
		ResultModel resultModel=initResultModel();
		try {
	    if(StringUtil.isEmpty(mode.getUserid())){
	    	setEmptyCode(resultModel, "传入的用户地址簿能为空!");
	    	error(resultModel.getMsg());
	    }else{
				AppUser  user=(AppUser) ebi.findById(AppUser.class, mode.getUserid());
				if(user==null){
					setNoFecCode(resultModel, "传入用户标示无效!");
			    	error(resultModel.getMsg());
				}else{
					List<UserAdress> list=(List<UserAdress>) ebi.queryByHql(" from  UserAdress where appUser='"+mode.getUserid()+"'");
					resultModel.setObj(list);
				}
			
			} }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				setServerErrCode(resultModel, "加载地址失败!");
				error(resultModel.getMsg(), e);
			}
		toWriterResult(response, resultModel);
		
	    }
	/**
	 * 9设置默认地址
	 * @param adress
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="defaultAddress")
	public void  defaultAddress(UserAdress adress,HttpServletRequest request,HttpServletResponse response){
		 ResultModel resultModel= this.initResultModel();
		  String userid=adress.getUserid();
		  String uaddid=adress.getUdid();
		  try{
		  if(StringUtil.isEmpty(userid)||StringUtil.isEmpty(uaddid)){
			  setEmptyCode(resultModel, "传入用户标示不能为空!");
		    	error(resultModel.getMsg());
		  }else{
				AppUser  user=(AppUser) ebi.findById(AppUser.class, adress.getUserid());
				if(user==null){
					setNoFecCode(resultModel, "传入的用户标示无效!");
			    	error(resultModel.getMsg());
				}else{
					AppUserEbi uebi=(AppUserEbi)ebi;
					uebi.executeSql(userid, uaddid);
					resultModel.setMsg("设置成功!");
					
				}
		  }
		  }catch(Exception e){
			  setServerErrCode(resultModel, "服务端错误!设置地址失败");
			  e.printStackTrace();
		  }
		  toWriterResult(response, resultModel);
	}
/**
 *10 修改密码
 */
@RequestMapping(value="updateUserPwd")
public void updatePwd(AppUser user,HttpServletRequest request,HttpServletResponse response){
	 ResultModel resultModel= this.initResultModel();
	 String userid=user.getUserid();
	 String pw=user.getPwd();
	 try{
	 if(StringUtil.isEmpty(userid)){
		 setEmptyCode(resultModel, "传入的用户标示不能为空!");
	     error(resultModel.getMsg());
	 }else{
		 if(StringUtil.isEmpty(pw)){
			 setEmptyCode(resultModel, "密码不能为空!");
		 }else{
			 AppUser appUser=(AppUser) ebi.findById(AppUser.class, userid);
			 if(appUser==null){
				 setNoFecCode(resultModel, "传入用户标示无效!");
				 resultModel.setMsg("传入用户标示无效!");
			     error(resultModel.getMsg());
			 }else{
				 appUser.setPwd(pw);
				 ebi.update(appUser);
				 resultModel.setMsg("更新成功!");
			 }
		 }
		 
	 }
	 }catch(Exception e){
		 e.printStackTrace();
		 setServerErrCode(resultModel, "更新密码错误!");
	 }
	  toWriterResult(response, resultModel);
}

/**
 *11 检查用户名是否重复
 * @param user
 * @param request
 * @param response
 * @throws Exception 
 */
@RequestMapping(value="checkUser")
public void checkUser(AppUser user,HttpServletRequest request, HttpServletResponse response) {
	ResultModel resultModel= initResultModel();
    String loginCode=user.getLoginCode();
    try{
    if(StringUtil.isEmpty(loginCode)){
    	setEmptyCode(resultModel, "用户名不能为空!");
    }else{
      String hql=" from AppUser where loginCode='"+loginCode.trim()+"'";
      AppUser appuser= (AppUser) ebi.getEntityByHql(hql);
      if(null==appuser){
    	  resultModel.setMsg("用户名有效!");
      }else{
    	  setNoFecCode(resultModel, "用户名已存在!");
      }
    	
    }
    }catch(Exception e){
    	e.printStackTrace(); 
    	setServerErrCode(resultModel, "服务端错误！无法进行更新");
    }
    toWriterResult(response, resultModel);
}
	
	/**
	 * 12获取用户订单 传入userid 订单信息
	 * 
	 */
	@RequestMapping("/loadorders")
	 public void loadorders(HttpServletRequest request,
				HttpServletResponse response, String userid){
		  ResultModel resultModel= this.initResultModel();
		  try{
			  if(StringUtil.isEmpty(userid)){
				  resultModel.setMsg("传入的用户标示不能为空！");
			  }else{
				  String hsql=" from OrderContent o where o.userid='"+userid+"'";
				  List<OrderContent> orders=(List<OrderContent>) ebi.queryByHql(hsql);
				   List<OrderPro> orderpro=new ArrayList<OrderPro>();
				   OrderPro op=null;
				   for(OrderContent oc : orders){
					   op=new OrderPro();
					   op.setOrdid(oc.getOrdid());
					   op.setIspay(oc.getIspay());
					   op.setOrdertime(oc.getOrdertime());
					  // op.setItems(oc.getItems());
					   orderpro.add(op);
					   op=null;
				   }
				   resultModel.setObj(orderpro);
			  }
			  
		  }catch(Exception e){
			  setServerErrCode(resultModel, "服务端错误!无法获取用户订单");
			  error(resultModel.getMsg(),e);
		  }
		   toWriterResult(response, resultModel);
	 }
	
/**
 * 13加载用户收藏接口
 * @param userid 传入用户标示
 * @param response
 */
	@RequestMapping("/loadeCollect")
	public void loadeCollect(
			String userid, HttpServletResponse response
			){
		  ResultModel resultModel= this.initResultModel();
		  try{
			  if(StringUtil.isEmpty(userid)){
				  resultModel.setMsg("传入的用户标示不能为空！");
			  }else{
				  String zhql="from UserCollection where ctype='001'";//周边
				  String ghql="from UserCollection where ctype='002'";//商品
				  String thql="from UserCollection where ctype='003'";//发帖
				  List<Merchant> istMerchnt= (List<Merchant>) ebi.queryByHql(zhql);
				  List<Goods> listGoods=(List<Goods>) ebi.queryByHql(ghql);
				  ///
				  List<CollectPo> listCollect=new ArrayList<CollectPo>(); 
				  
				  
				  CollectPo cpz=new CollectPo();
				  cpz.setType("001");
				  ColleckMercharPro cmp=null;
				  List<ColleckMercharPro> cprs=new ArrayList<ColleckMercharPro>();
				  for(Merchant m :istMerchnt ){
					  cmp=new ColleckMercharPro();
					  cmp.setIcon(m.getIcon());//图标
					  cmp.setPhone(m.getPhone());//联系电话
					  cmp.setTitle(m.getName());//标题
					  cmp.setRemark(m.getRemarks());//描述信息
					  cmp.setXponit(m.getXponit());//经度
					  cmp.setYponit(m.getYponit());//纬度
					  cprs.add(cmp);
					  cmp=null;
					
				  }
				  cpz.setItem(cprs);//添加周边收藏
				  
				  
				  CollectPo cpg=new CollectPo();
				  cpg.setType("002");
				  CollectBase cb=null;
				  List<CollectBase> cpgs=new ArrayList<CollectBase>();
				  for(Goods gds : listGoods){
					  cb=new CollectBase();
					    Set<GoodImage> imgs=gds.getImgs();
					    if(imgs!=null&&imgs.size()>0){
					    	GoodImage gimg=  imgs.iterator().next();
					    	cb.setIcon(gimg.getUrl());
					    }else{
					    	gds.setImg("默认图片地址");
					    }
					    cb.setRemark(gds.getRemarks());
					    cb.setTitle(gds.getName());
					    cpgs.add(cb);
					    cb=null;
				  }
				  cpg.setItem(cpgs);//添加上商品收藏
				  listCollect.add(cpz);
				  listCollect.add(cpg);
				  /////////////////////////////////////
					// TODO Auto-generated catch block 收藏帖子站未实现
				  
				  resultModel.setObj(listCollect);
			  }
			  
		  }catch(Exception e){
			  this.setServerErrCode(resultModel, "加载用户收藏类表失败!");
			  error(resultModel.getMsg(),e);
		  }
		   toWriterResult(response, resultModel);
		
		
		
	}

	private void toWriterResult(HttpServletResponse response,
			ResultModel resModel) {
		String josString = jsonBuilder.toJson(resModel);
		this.toWrite(response, josString);
	}

	

	
	





		


}
