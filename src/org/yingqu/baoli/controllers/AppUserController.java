package org.yingqu.baoli.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.baoli.ebi.AppUserEbi;
import org.yingqu.baoli.model.AppUser;
import org.yingqu.baoli.model.OrderContent;
import org.yingqu.baoli.model.UserAdress;
import org.yingqu.baoli.model.po.AppUserPo;
import org.yingqu.baoli.model.po.OrderPro;
import org.yingqu.baoli.model.po.UserAdressPo;
import org.yingqu.desktop.model.Department;
import org.yingqu.desktop.model.EndUser;
import org.yingqu.desktop.security.SecurityUserHolder;
import org.yingqu.desktop.utils.ProcessFieldsUploadUtil;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.core.utils.AppUtils;
import org.yingqu.framework.model.vo.ResultModel;
import org.yingqu.framework.utils.StringUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.codehaus.jackson.map.util.BeanUtil;
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
			EndUser currentUser = SecurityUserHolder.getCurrentUser();
			if (currentUser != null) {
				model.setDeptid(currentUser.getDeptId());
				model.setDeptname(currentUser.getDeptName());
				Department dept = currentUser.getDepartment();
				if (dept != null) {
					model.setCity(dept.getCity());
				}
			}

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
	 *11 添加一个注册接口
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
			          	 resultModel.setOk(1);
			 			 ebi.save(model);
						 resultModel.setOk(1);
						 resultModel.setMsg("注册成功!");
			            }else{
			          	  resultModel.setOk(0);
			          	  resultModel.setMsg("用户名已存在!");
			            }
		    	 }else{
		    		 resultModel.setOk(0);
		    		 resultModel.setMsg("用户账户不能为空!");
		    	 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultModel.setCode(500);
				resultModel.setMsg("注册失败!");
				resultModel.setOk(0);
				error(resultModel.getMsg(), e);
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
					   op.setItems(oc.getItems());
					   orderpro.add(op);
					   op=null;
				   }
				   resultModel.setObj(orderpro);
				   resultModel.setOk(1);
			  }
			  
		  }catch(Exception e){
			  resultModel.setCode(500);
			  resultModel.setMsg("加载订单失败!");
			  resultModel.setOk(0);
			  error(resultModel.getMsg(),e);
		  }
		   toWriterResult(response, resultModel);
	 }
	
/**
 * 13加载用户收藏接口
 * @param userid 传入用户主键
 * @param response
 */
	public void loadeCollect(
			String userid, HttpServletResponse response
			){
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
					   op.setItems(oc.getItems());
					   orderpro.add(op);
					   op=null;
				   }
				   resultModel.setObj(orderpro);
				   resultModel.setOk(1);
			  }
			  
		  }catch(Exception e){
			  resultModel.setCode(500);
			  resultModel.setMsg("加载订单失败!");
			  resultModel.setOk(0);
			  error(resultModel.getMsg(),e);
		  }
		   toWriterResult(response, resultModel);
		
		
		
	}
	
	/**
	 * 1获取用户个人信息接口 传入 userid
	 * 
	 * @param uid
	 */
	@RequestMapping("/loadAppUser")
	public void loadAppUser(String userid, HttpServletResponse response) {
		ResultModel resModel = initResultModel();
		debug(AppUtils.getCurrentTime()+":APP调用 加载用户个人信息 loadAppUser");
		try {
			AppUser appUser = (AppUser) ebi.findById(AppUser.class, userid);
			 AppUserPo appUserPo=new AppUserPo();
			  BeanUtils.copyProperties(appUserPo, appUser);
			  String horder=" select count(o) from OrderContent o where o.userid='"+userid+"'";
			  Integer count= ebi.getCount(horder);
			  appUserPo.setOrderCount(count);
			  String hcoll=" select count(o) from UserCollection o where o.uid='"+userid+"'";
			  count=ebi.getCount(hcoll);
			  appUserPo.setCollecCount(count);		 
			  String addHql="from UserAdress where userid='"+userid+"' and defaulted='1'";
			  UserAdress addAdress=(UserAdress) ebi.getEntityByHql(addHql);
			  if(addAdress!=null){
				  appUserPo.setDefaultAdrs(addAdress.getAddress());
			  }
			  resModel.setObj(appUserPo);
			if (null == appUser) {
				resModel.setOk(0);
				resModel.setMsg("传入用户标示无效");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resModel.setMsg("无法加载用户信息!");
			resModel.setOk(0);
			resModel.setCode(500);
			error("无法加载用户信息!", e);
		}
		toWriterResult(response, resModel);
	}

	private void toWriterResult(HttpServletResponse response,
			ResultModel resModel) {
		String josString = jsonBuilder.toJson(resModel);
		this.toWrite(response, josString);
	}

	
	/**
	 * 2用户更新接口 连同文件上传 topUrl
	 * 请求类型为 multipart/form-data
	 * @param appUser
	 * @param response
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
			resModel.setOk(0);
		} else {
			AppUser user;
			try {
				user = (AppUser) ebi.findById(AppUser.class, userId);
				if (user == null) {
					resModel.setOk(0);
					resModel.setMsg("传入用户标示无效");
					error("传入无效的用户标示!");
				} else {
					if(StringUtil.isNotEmpty( topUrl.getOriginalFilename())){
						ProcessFieldsUploadUtil.upload(appUser, topUrl, "topUrl",
								"baoli.upload.top");
					}
					user.setUsername(appUser.getUsername());//用户亲昵
					if(StringUtil.isNotEmpty( appUser.getDefaultadi())){
						 UserAdress uddres=new UserAdress();
						 uddres.setUdid(appUser.getDefaultadi());
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
					resModel.setCode(200);
					resModel.setOk(1);
					resModel.setMsg("更新成功!");
			
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resModel.setOk(0);
				resModel.setCode(500);
				resModel.setObj("更新用户失败!");
				error(resModel.getMsg(), e);
			}
			toWriterResult(response, resModel);

		}

	}

	/**
	 * 3登录接口 传入用户 loginCode pwd必须的
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
				resModel.setOk(0);
				resModel.setMsg("用户名不能为空！");
			} else {
				String hql = " from AppUser o where loginCode='" + loginCode
						+ "' and pwd='" + pwd + "'";
				List<AppUser> users = (List<AppUser>) ebi.queryByHql(hql);
				if (users != null && users.size() == 1) {
					resModel.setOk(1);
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
						  appUserPo.setDefaultAdrs(addAdress.getAddress());
					  }
					  appUserPo.setCollecCount(count);
					resModel.setObj(appUserPo);
					resModel.setMsg("登陆成功！");
					
				}else{
					resModel.setOk(0);
					resModel.setMsg("用户名或密码错误！");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			resModel.setOk(0);
			resModel.setCode(500);
			resModel.setMsg("服务器错误!");
			error(resModel.getMsg(), e);
		}
		toWriterResult(response, resModel);

	}
	
	
	/**
	 * 4设置送货地址 需要传入 userid必须的
	 * @param adress
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="addAdress")
	public void addAdress(UserAdress adress,HttpServletRequest request, HttpServletResponse response){
		ResultModel resultModel= initResultModel();
		debug(AppUtils.getCurrentTime()+":APP调用 addAdress");
		      try {
				AppUser appUser=(AppUser) ebi.findById(AppUser.class, adress.getUserid());
				if(appUser==null){
					resultModel.setMsg("传入的用户标示无效!");
					error(resultModel.getMsg());
					resultModel.setOk(0);
				}else{
					 adress.setAppUser(appUser);
					 super.phoneSave(request, response,adress);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				resultModel.setOk(0);
				resultModel.setCode(500);
				resultModel.setMsg("设置地址失败!");
				e.printStackTrace();
				error(resultModel.getMsg(), e);
				
			}
		  	toWriterResult(response, resultModel);  
		     
	}
	
	/** 5更新送货地址
	 * @param adress
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="updateAdress")
	public void updateAdress(UserAdressPo adress,HttpServletRequest request,HttpServletResponse response){
		debug(AppUtils.getCurrentTime()+":APP调用 updateAdress");
		ResultModel resultModel=initResultModel();
		String userid=adress.getUserid();
		if(StringUtil.isEmpty(userid)){
			resultModel.setMsg("传入的用户标示无效,无法进行更新！");
			resultModel.setOk(0);
			error(resultModel.getMsg());
		}else{
			AppUser appUser=new AppUser();
			appUser.setUserid(userid);
			
		}
		super.phoneUpdate(request, response, adress, UserAdress.class);
		
	}
	
/**
 * 6删除送货地址
 * @param adress
 * @param request
 * @param response
 */
	@RequestMapping(value="removeAdress")
	public void removeAdress(UserAdress adress,HttpServletRequest request,HttpServletResponse response){
		debug(AppUtils.getCurrentTime()+":APP调用 removeAdress");
		super.phoneRemove(request, response, adress);
	}
	/**
	 * 7获取所用送货地址
	 * @param mode
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="loadAddress")
	public void loadAddress(AppUser mode, HttpServletRequest request,HttpServletResponse response){
		debug(AppUtils.getCurrentTime()+":APP调用 loadAddress");
		ResultModel resultModel=initResultModel();
		try {
	    if(StringUtil.isEmpty(mode.getUserid())){
	    	resultModel.setOk(0);
	    	resultModel.setMsg("出入用户标示无效!");
	    	error(resultModel.getMsg());
	    }else{
				AppUser  user=(AppUser) ebi.findById(AppUser.class, mode.getUserid());
				if(user==null){
					resultModel.setOk(0);
			    	resultModel.setMsg("出入用户标示无效!");
			    	error(resultModel.getMsg());
				}else{
					List<UserAdress> list=(List<UserAdress>) ebi.queryByHql(" from  UserAdress where appUser='"+mode.getUserid()+"'");
					resultModel.setObj(list);
				}
			
			} }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultModel.setCode(500);
				resultModel.setMsg("加载地址失败!");
				resultModel.setOk(0);
				error(resultModel.getMsg(), e);
			}
		toWriterResult(response, resultModel);
		
	    }
	/**
	 * 8设置默认地址
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
				resultModel.setOk(0);
		    	resultModel.setMsg("传入用户标示无效!");
		    	error(resultModel.getMsg());
		  }else{
				AppUser  user=(AppUser) ebi.findById(AppUser.class, adress.getUserid());
				if(user==null){
					resultModel.setOk(0);
			    	resultModel.setMsg("传入用户标示无效!");
			    	error(resultModel.getMsg());
				}else{
					AppUserEbi uebi=(AppUserEbi)ebi;
					uebi.executeSql(userid, uaddid);
					resultModel.setOk(1);
					resultModel.setMsg("设置成功!");
					
				}
		  }
		  }catch(Exception e){
			  e.printStackTrace();
			  resultModel.setOk(0);
			  resultModel.setMsg("设置失败!");
			  resultModel.setCode(500);
		  }
		  toWriterResult(response, resultModel);
	}
		
	/**
	 *9 修改密码
	 */
	@RequestMapping(value="updateUserPwd")
	public void updatePwd(AppUser user,HttpServletRequest request,HttpServletResponse response){
		 ResultModel resultModel= this.initResultModel();
		 String userid=user.getUserid();
		 String pw=user.getPwd();
		 try{
		 if(StringUtil.isEmpty(userid)){
			 resultModel.setOk(0);
		    	resultModel.setMsg("传入用户标示无效!");
		    	error(resultModel.getMsg());
		 }else{
			 if(StringUtil.isEmpty(pw)){
				 resultModel.setObj(0);
				 resultModel.setMsg("密码不能为空!");
			 }else{
				 AppUser appUser=(AppUser) ebi.findById(AppUser.class, userid);
				 if(appUser==null){
					 resultModel.setMsg("传入用户标示无效!");
					 resultModel.setOk(0);
				    	error(resultModel.getMsg());
				 }else{
					 appUser.setPwd(pw);
					 ebi.update(appUser);
					 resultModel.setOk(1);
					 resultModel.setMsg("更新成功!");
					 resultModel.setCode(200);
				 }
			 }
			 
		 }
		 }catch(Exception e){
			 e.printStackTrace();
			  resultModel.setOk(0);
			  resultModel.setMsg("更新密码错误!");
			  resultModel.setCode(500);
		 }
	}
		
	/**
	 *10 检查用户名是否重复
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
	    	resultModel.setOk(0);
	    	resultModel.setMsg("用户名不能为空");
	    }else{
          String hql=" from AppUser where loginCode='"+loginCode.trim()+"'";
          AppUser appuser= (AppUser) ebi.getEntityByHql(hql);
          if(null==appuser){
        	  resultModel.setOk(1);
        	  resultModel.setMsg("用户名有效!");
          }else{
        	  resultModel.setOk(0);
        	  resultModel.setMsg("用户名已存在!");
          }
	    	
	    }
	    }catch(Exception e){
	    	e.printStackTrace(); 
	    	resultModel.setOk(0);
	    	resultModel.setMsg("服务器错误！");
	    	resultModel.setCode(500);
	    }
	    toWriterResult(response, resultModel);
	}

}
