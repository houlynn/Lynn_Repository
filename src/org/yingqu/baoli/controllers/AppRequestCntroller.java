package org.yingqu.baoli.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import org.apache.jasper.tagplugins.jstl.core.Url;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.yingqu.baoli.ebi.AppUserEbi;
import org.yingqu.baoli.ebi.GoodsEbi;
import org.yingqu.baoli.ebi.InteractEbi;
import org.yingqu.baoli.model.AppClassify;
import org.yingqu.baoli.model.AppClassifyItem;
import org.yingqu.baoli.model.AppNews;
import org.yingqu.baoli.model.AppUser;
import org.yingqu.baoli.model.AppVersion;
import org.yingqu.baoli.model.Feedback;
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
import org.yingqu.baoli.model.RentalImg;
import org.yingqu.baoli.model.SellOfer;
import org.yingqu.baoli.model.SellOferImg;
import org.yingqu.baoli.model.UserAdress;
import org.yingqu.baoli.model.UserCollection;
import org.yingqu.baoli.model.Village;
import org.yingqu.baoli.model.VirtualIcon;
import org.yingqu.baoli.model.po.AppNewPo;
import org.yingqu.baoli.model.po.AppNewProd;
import org.yingqu.baoli.model.po.AppUserPo;
import org.yingqu.baoli.model.po.ColleckMercharPro;
import org.yingqu.baoli.model.po.CollectBase;
import org.yingqu.baoli.model.po.CollectPo;
import org.yingqu.baoli.model.po.GoodsDetail;
import org.yingqu.baoli.model.po.GoodsPo;
import org.yingqu.baoli.model.po.InteractListPo;
import org.yingqu.baoli.model.po.OfferInteractPo;
import org.yingqu.baoli.model.po.MerchantPo;
import org.yingqu.baoli.model.po.MessagePo;
import org.yingqu.baoli.model.po.OderPro;
import org.yingqu.baoli.model.po.OrderContenPro;
import org.yingqu.baoli.model.po.OrderDetail;
import org.yingqu.baoli.model.po.OrderItemPro;
import org.yingqu.baoli.model.po.OrderPro;
import org.yingqu.baoli.model.po.OrderProAdrees;
import org.yingqu.baoli.model.po.RentalPo;
import org.yingqu.baoli.model.po.RentalPoDetail;
import org.yingqu.baoli.model.po.RoundPo;
import org.yingqu.baoli.model.po.SellOferPoDetail;
import org.yingqu.baoli.model.po.UserAdressPo;
import org.yingqu.baoli.model.po.ViewPange;
import org.yingqu.baoli.model.po.VirtualIconPo;
import org.yingqu.desktop.utils.ProcessFieldsUploadUtil;
import org.yingqu.framework.controllers.AppBaseController;
import org.yingqu.framework.core.utils.AppUtils;
import org.yingqu.framework.model.BaseEntity;
import org.yingqu.framework.model.vo.ResultModel;
import org.yingqu.framework.utils.StringUtil;





import com.sun.accessibility.internal.resources.accessibility;

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
	
	@Autowired
	private AppUserEbi userebi;

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

	public AppUserEbi getUserebi() {
		return userebi;
	}

	public void setUserebi(AppUserEbi userebi) {
		this.userebi = userebi;
	}

	// ////////////////////////////////////////////////我的模块接口////////////////////////////////////////////////////////////////////////////
	/**
	 * + 验证码发送接口
	 * 
	 * @param request
	 */
	@RequestMapping("A000")
	public void appRequestA000(HttpServletRequest request,
			HttpServletResponse response, String loginCode) {
		debug(AppUtils.getCurrentTime() + ":APP调用 获取验证码---A000");
		super.requestMeth(response, resultModel -> {
			if (StringUtil.isEmpty(loginCode)) {
				super.setEmptyCode(resultModel, "传入手机号码不能为空");
			} else {

				String code = "001";
				// /发送短信业务 未实现

				resultModel.setObj(code);// 返回验证码
			}

		});
	}
	
	@RequestMapping("A00_B")
	public void appRequestA00_B(HttpServletRequest request,
			HttpServletResponse response,
			String pid
			) {
		
		debug(AppUtils.getCurrentTime() + ":APP调用 获取验证码---A000");
		super.requestMeth(response, resultModel -> {
			List<Map<String,String>> data=new ArrayList<>();
			if(StringUtil.isEmpty(pid)){
		/*		for(int i=0;i<10;i++){
					Map<String,String> view=new HashMap<String,String>();
					view.put("itemCode",i+"");
					view.put("itemName", "我是省"+i);
					data.add(view);
					view=null;*/
					
				  String sql="select * from province";
				  Work work=conn->{
					  PreparedStatement ps=  conn.prepareStatement(sql);
					  ResultSet rset=  ps.executeQuery();
					  while(rset.next()){
						  Map<String,String> viewItem=new HashMap<String, String>();
						  viewItem.put("itemCode", rset.getString("ProSort"));
						  viewItem.put("itemName",rset.getString("ProName"));
						  viewItem.put("autonomy", rset.getString("autonomy"));
						  data.add(viewItem);
						  viewItem=null;
					  }
					  rset.close();
					//  conn.close();
					  
				  };
				   ebi.doWork(sql, work, data);
				   
					
				//}
			}else{
				String sql="select * from city where ProID='"+pid+"'";
				  Work work=conn->{
					  PreparedStatement ps=  conn.prepareStatement(sql);
					  ResultSet rset=  ps.executeQuery();
					  while(rset.next()){
						  Map<String,String> viewItem=new HashMap<String, String>();
						  viewItem.put("itemCode", rset.getString("CitySort"));
						  viewItem.put("itemName",rset.getString("CityName"));
						  viewItem.put("autonomy", "false");
						  data.add(viewItem);
						  viewItem=null;
					  }
					  rset.close();
					 // conn.close();
					  
				  };
				  ebi.doWork(sql, work, data);
				  
					}
			resultModel.setObj(data);

		});
	}

	/**
	 * 1 添加一个注册接口 参数值参考 注册界面 /register
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("A001")
	public void register(HttpServletRequest request,
			HttpServletResponse response, @Validated AppUser model) {
		debug(AppUtils.getCurrentTime() + ":APP调用 注册方法---A001");
		ResultModel resultModel = this.initResultModel();
		boolean flag=true;
		try {
			if(StringUtil.isEmpty(model.getLoginCode())){
				flag=false;
				setEmptyCode(resultModel, "用户账号不能为空！");
			}
			if (StringUtil.isNotEmpty(model.getLoginCode())) {
				String hql = " from AppUser where loginCode='"
						+ model.getLoginCode().trim() + "'";
				AppUser appuser = (AppUser) ebi.getEntityByHql(AppUser.class,
						hql);
				if (appuser!=null) {
					flag=false;
					setNoFecCode(resultModel, "用户账号已存在!");
				} 
			  
			if (StringUtil.isEmpty(model.getPwd())) {
				setEmptyCode(resultModel, "密码不能为空!");
				flag=false;
			}
			if(flag){
				model.setOwner("0");
				model.setSex("0");
				model.setUsername("匿名用户");
				ebi.save(model);
			}
		} }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setServerErrCode(resultModel, "注册失败!");
			error(resultModel.getMsg(), e);
		}
		toWriterResult(response, resultModel);

	}

	/***
	 * +2登录接口 传入用户 loginCode pwd必须的 /login 添加了 返回参数 省份 市 预约 小区ID 默认地址改为
	 * defaultAddressid
	 * 
	 * @param appUser
	 * @param response
	 */
	@RequestMapping("A002")
	public void login(AppUser appUser, HttpServletResponse response,
	 HttpServletRequest request)
	{
		this.initResultModel();
		debug(AppUtils.getCurrentTime() + ":APP调用 登陆方法---A002");
		ResultModel resModel = initResultModel();
		try {
			String pwd = appUser.getPwd();
			String loginCode = appUser.getLoginCode();
			if (StringUtil.isEmpty(loginCode)) {
				setEmptyCode(resModel, "登陆账号不能为空!");
			}else if(StringUtils.isEmpty(pwd)){
				setEmptyCode(resModel, "密码不能为空!");
			}else {
				String hql = " from AppUser o where loginCode='" + loginCode
						+ "' and pwd='" + pwd + "'";
				List<AppUser> users = (List<AppUser>) ebi.queryByHql(hql);
				if (users != null && users.size() == 1) {
					AppUserPo appUserPo = new AppUserPo();
					String userid = users.get(0).getUserid();// 用户标识
					BeanUtils.copyProperties(appUserPo, users.get(0));
					String horder = " select count(o) from OrderContent o where o.userid='"
							+ userid + "'";
					Integer count = ebi.getCount(horder);
					appUserPo.setOrderCount(count);// 订单数目
					String hcoll = " select count(o) from UserCollection o where o.uid='"
							+ userid + "'";
					count = ebi.getCount(hcoll);// 收藏数目
					String addHql = "from UserAdress where appUser='" + userid
							+ "' and defaulted='1'";
					UserAdress addAdress = (UserAdress) ebi.getEntityByHql(
							UserAdress.class, addHql);
					if (addAdress != null) {
						appUserPo.setDefaultAddressid(addAdress.getUdid());// 默认地址ID
						addAdress.setUserid(userid);
						appUserPo.setDefaultAdress(addAdress);
					}else{
						 List<UserAdress> useradds= (List<UserAdress>) ebi.queryByHql("from UserAdress where appUser='"+userid+"'", 0, 1);
						 if(useradds!=null&& useradds.size()>0){
							    UserAdress defaultadd=useradds.get(0);
							    defaultadd.setDefaulted("1");
								userebi.executeSql(userid, defaultadd.getUdid());
								appUserPo.setDefaultAddressid(defaultadd.getUdid());// 默认地址ID
								appUserPo.setDefaultAdress(defaultadd);
						 }
							
					}
					appUserPo.setCollecCount(count);
					resModel.setObj(appUserPo);

				} else {
					setNoFecCode(resModel, "用户名或密码错误！");
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
	 * +获取小区列表 可分页 返回 属性 vid 小区标示 name小区名称
	 */
	@RequestMapping("A003")
	public void appRequestA003(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "whereSql", required = false, defaultValue = "") String whereSql,
			@RequestParam(value = "parentSql", required = false, defaultValue = "") String parentSql,
			@RequestParam(value = "querySql", required = false, defaultValue = "") String querySql,
			@RequestParam(value = "orderSql", required = false, defaultValue = " order  by createTime desc ") String orderSql,
			@RequestParam(value = "start", required = false, defaultValue = "0") String start,
			@RequestParam(value = "limit", required = false, defaultValue = "0") String limit) {
		debug(AppUtils.getCurrentTime() + ":APPd调用获取小区类表---A003");
		super.load(
				whereSql,
				parentSql,
				querySql,
				orderSql,
				start,
				limit,
				response,
				Village.class,
				(list, resultModel,totalCount) -> {
					ViewPange viewPange=new ViewPange();
					viewPange.setTotalCount(totalCount);
					List<Map<String, String>> views = new ArrayList<>();
					views = list
							.parallelStream()
							.map(item -> {
								Map<String, String> view = new HashMap<String, String>();
								view.put("vid", item.getViid());
								view.put("name", item.getName());
								return view;
							}).collect(Collectors.toList());
					viewPange.setItems(views);
					resultModel.setObj(viewPange);
				});
	}

	/**
	 * 3根据用户ID 获取用户个人信息接口 传入 userid loadAppUser
	 * 
	 * @param uid
	 */
	@RequestMapping("/A004")
	public void loadAppUser(String userid, HttpServletResponse response) {
		ResultModel resModel = initResultModel();
		debug(AppUtils.getCurrentTime() + ":APP调用 加载用户个人信息 loadAppUser---A004");
		try {
			if (StringUtil.isEmpty(userid)) {
			} else {
				AppUser appUser = (AppUser) ebi
						.findByOId(AppUser.class, userid);
				if (appUser == null) {
					setServerFecCode(resModel, "传入的用户标示无效无法获取用户信息!");
				} else {
					AppUserPo appUserPo = new AppUserPo();
					BeanUtils.copyProperties(appUserPo, appUser);
					String horder = " select count(o) from OrderContent o where o.userid='"
							+ userid + "'";// 加载我的订单
					Integer count = ebi.getCount(horder);
					appUserPo.setOrderCount(count);
					String hcoll = " select count(o) from UserCollection o where o.uid='"
							+ userid + "'";// 加载我的收藏
					count = ebi.getCount(hcoll);
					appUserPo.setCollecCount(count);
					String addHql = "from UserAdress where userid='" + userid
							+ "' and defaulted='1'";// 加载用户默认地址
					UserAdress addAdress = (UserAdress) ebi.getEntityByHql(
							UserAdress.class, addHql);
					if (addAdress != null) {
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
	 * +4 用户更新接口 
	 * 请求类型为 multipart/form-data defaultAddressid 用户默认地址ID 如果不为空 则不会更新
	 * 
	 * @param appUser
	 * @param response
	 *            默认地址
	 */
	@RequestMapping("/A005")
	public void updateAppUser(String  userid, HttpServletResponse response,
			HttpServletRequest request,
			String code,
			String value
	) {
		debug(AppUtils.getCurrentTime() + ":APP调用 updateAppUser");
		super.requestMeth(response, resultModel->{
			boolean flag=true;
			if(StringUtil.isEmpty(code)){
				flag=false;
				super.setEmptyCode(resultModel, "更新代码不能为空");
			}
			if(StringUtil.isEmpty(value)){
				super.setEmptyCode(resultModel, "对更新条目并未赋值");
				flag=false;
			}
			AppUser appUser= super.checkNoFec(userid, "用户标示不能为空!", "用户标示无效!", resultModel, AppUser.class);
			if(appUser==null){
				flag=false;
			}
			if(flag){
				switch(code){
				case "001":{
					   if(StringUtil.isEmpty(value)){
		        	    	super.setEmptyCode(resultModel, "用户亲昵不能为空");
		        	    }else{
		        	      	appUser.setUsername(value);
		        	      	ebi.update(appUser);
		        	      	 resultModel.setObj(appUser.getUsername());
		        	    }
					break;
				}
              case "002":{
            	   if(StringUtil.isEmpty(value)){
	        	    	super.setEmptyCode(resultModel, "职业不能为空");
	        	    }else{
	        	    	appUser.setOccupation(value);
	        	    	ebi.update(appUser);
	        	    	 resultModel.setObj(appUser.getOccupation());
	        	    }
					break;
				}
          	case "003":{
          	   if(StringUtil.isEmpty(value)){
       	    	super.setEmptyCode(resultModel, "星座不能为空");
       	    }else{
       	 	appUser.setConstellation(value);
	    	ebi.update(appUser);
	    	   resultModel.setObj(appUser.getConstellation());
       	    }
				break;
			}
          case "004":{
        	   if(StringUtil.isEmpty(value)){
       	    	super.setEmptyCode(resultModel, "家乡不能为空");
       	    }else{
       	 	    appUser.setHome(value);
	    	    ebi.update(appUser);
	    	    resultModel.setObj(appUser.getHome());
       	    }
          }
          case "005":{
        	   if(StringUtil.isEmpty(value)){
       	    	super.setEmptyCode(resultModel, "个性签名不能为空");
       	    }else{
       	  	appUser.setSefTick(value);
	    	ebi.update(appUser);
	    	resultModel.setObj(appUser.getSefTick());
       	    }
				break;
			}
          case "006":{
       	   if(StringUtil.isEmpty(value)){
      	    	super.setEmptyCode(resultModel, "情感状态不能为空");
      	    }else{
      	    	appUser.setFeelings(value);
    	    	ebi.update(appUser);
    	    	resultModel.setObj(appUser.getFeelings());
      	    }
				break;
			}
          case "007":{
          	   if(StringUtil.isEmpty(value)){
         	    	super.setEmptyCode(resultModel, "兴趣爱好不能为空");
         	    }else{
         	   	appUser.setHoby(value);
    	    	ebi.update(appUser);
    	    	resultModel.setObj(appUser.getHoby());
         	    }
   				break;
   			}
          default :{
        	  super.setNoFecCode(resultModel, "非法更新类型");
        	  
          }
		}
	}
} );
		 
		


	}

/**
 * +  上传头像	图片字符 必须的
 *           图片格式  默认为 png
 *           用户标示
 * @param response
 * @param request
 * @param imageStr
 * @param postfix
 */
	@RequestMapping(value="/A005_1",method=RequestMethod.POST)
	public void appRequestA005_1(HttpServletResponse response,HttpServletRequest request,
		     @RequestParam(value = "postfix", required = false, defaultValue = "png") String postfix,
		     String userid
			) {
		 
		        super.requestMeth(response, resultModel->{
		        	   boolean flag=true;
		        	   StringBuffer buffer=new StringBuffer();
		        	   buffer.append(request.getParameter("imageStr"));
		        	   System.out.println(buffer);
		        	  if(StringUtil.isEmpty(buffer.toString())){
		        		super.setEmptyCode(resultModel, "图片字符不能为空");
		        		flag=false;
		        	  }
		        	   AppUser appUser=  super.checkNoFec(userid, "用户标示不能为空", "用户标示无效", resultModel, AppUser.class);
		        	    if(appUser==null){
		        	    	flag=false;
		        	    }
		        	    flag= ProcessFieldsUploadUtil.uploadByBase64("baoli.upload.top",buffer,postfix,appUser,"topUrl");
		        	    if(flag){
		        	    	   ebi.update(appUser);
				        	    resultModel.setObj(appUser.getTopUrl());	
		        	    }else{
		        	    	throw  new Exception();	
		        	    }
		        	 
		        });
	}
	/**
	 * 亲昵
	 * @param response
	 * @param request
	 * @param username
	 * @param userid
	 */
	@RequestMapping(value="/A005_2")
	public void appRequestA005_2(HttpServletResponse response,HttpServletRequest request,
		     @RequestParam(value = "username", required = false, defaultValue = "") String username,
		     String userid
			){
		    super.requestMeth(response, resultModel->{
		    	   boolean flag=true;
		    	   AppUser appUser=  super.checkNoFec(userid, "用户标示不能为空", "用户标示无效", resultModel, AppUser.class);
	        	    if(appUser==null){
	        	    	flag=false;
	        	    }
	        	    if(StringUtil.isEmpty(username)){
	        	    	super.setEmptyCode(resultModel, "用户亲昵不能为空");
	        	    }
	        	    if(flag){
	        	    	appUser.setUsername(username);
	        	    	ebi.update(appUser);
	        	    }
	        	    resultModel.setObj(appUser.getUsername());
		    });
	}
	/**
	 * 职业
	 * @param response
	 * @param request
	 * @param occupation
	 * @param userid
	 */
	@RequestMapping(value="/A005_3")
	public void appRequestA005_3(HttpServletResponse response,HttpServletRequest request,
		     @RequestParam(value = "occupation", required = false, defaultValue = "") String occupation,
		     String userid
			){
		    super.requestMeth(response, resultModel->{
		    	   boolean flag=true;
		    	   AppUser appUser=  super.checkNoFec(userid, "用户标示不能为空", "用户标示无效", resultModel, AppUser.class);
	        	    if(appUser==null){
	        	    	flag=false;
	        	    }
	        	    if(StringUtil.isEmpty(occupation)){
	        	    	super.setEmptyCode(resultModel, "职业不能为空");
	        	    }
	        	    if(flag){
	        	    	appUser.setOccupation(occupation);
	        	    	ebi.update(appUser);
	        	    }
	        	    resultModel.setObj(appUser.getOccupation());
		    });
	}
	
	/**
	 * 星座
	 * @param response
	 * @param request
	 * @param constellation
	 * @param userid
	 */
	@RequestMapping(value="/A005_4")
	public void appRequestA005_4(HttpServletResponse response,HttpServletRequest request,
		     @RequestParam(value = "constellation", required = false, defaultValue = "") String constellation,
		     String userid
			){
		    super.requestMeth(response, resultModel->{
		    	   boolean flag=true;
		    	   AppUser appUser=  super.checkNoFec(userid, "用户标示不能为空", "用户标示无效", resultModel, AppUser.class);
	        	    if(appUser==null){
	        	    	flag=false;
	        	    }
	        	    if(StringUtil.isEmpty(constellation)){
	        	    	super.setEmptyCode(resultModel, "星座不能为空");
	        	    }
	        	    if(flag){
	        	    	appUser.setConstellation(constellation);
	        	    	ebi.update(appUser);
	        	    }
	        	    resultModel.setObj(appUser.getConstellation());
		    });
	}
	
	/**
	 * 家乡
	 * @param response
	 * @param request
	 * @param constellation
	 * @param userid
	 */
	@RequestMapping(value="/A005_5")
	public void appRequestA005_5(HttpServletResponse response,HttpServletRequest request,
		     @RequestParam(value = "home", required = false, defaultValue = "") String home,
		     String userid
			){
		    super.requestMeth(response, resultModel->{
		    	   boolean flag=true;
		    	   AppUser appUser=  super.checkNoFec(userid, "用户标示不能为空", "用户标示无效", resultModel, AppUser.class);
	        	    if(appUser==null){
	        	    	flag=false;
	        	    }
	        	    if(StringUtil.isEmpty(home)){
	        	    	super.setEmptyCode(resultModel, "家乡不能为空");
	        	    }
	        	    if(flag){
	        	    	appUser.setHome(home);
	        	    	ebi.update(appUser);
	        	    }
	        	    resultModel.setObj(appUser.getHome());
		    });
	}

	/**
	 * 个性签名
	 * @param response
	 * @param request
	 * @param constellation
	 * @param userid
	 */
	@RequestMapping(value="/A005_6")
	public void appRequestA005_6(HttpServletResponse response,HttpServletRequest request,
		     @RequestParam(value = "sefTick", required = false, defaultValue = "") String sefTick,
		     String userid
			){
		    super.requestMeth(response, resultModel->{
		    	   boolean flag=true;
		    	   AppUser appUser=  super.checkNoFec(userid, "用户标示不能为空", "用户标示无效", resultModel, AppUser.class);
	        	    if(appUser==null){
	        	    	flag=false;
	        	    }
	        	    if(StringUtil.isEmpty(sefTick)){
	        	    	super.setEmptyCode(resultModel, "个性签名不能为空");
	        	    }
	        	    if(flag){
	        	    	appUser.setSefTick(sefTick);
	        	    	ebi.update(appUser);
	        	    }
	        	    resultModel.setObj(appUser.getSefTick());
		    });
	}
	
	
	/**
	 * 情感状态  001 002 003 004
	 * @param response
	 * @param request
	 * @param constellation
	 * @param userid
	 */
	@RequestMapping(value="/A005_7")
	public void appRequestA005_7(HttpServletResponse response,HttpServletRequest request,
		     @RequestParam(value = "feelings", required = false, defaultValue = "") String feelings,
		     String userid
			){
		    super.requestMeth(response, resultModel->{
		    	   boolean flag=true;
		    	   AppUser appUser=  super.checkNoFec(userid, "用户标示不能为空", "用户标示无效", resultModel, AppUser.class);
	        	    if(appUser==null){
	        	    	flag=false;
	        	    }
	        	    if(StringUtil.isEmpty(feelings)){
	        	    	super.setEmptyCode(resultModel, "情感状态不能为空");
	        	    }
	        	    if(flag){
	        	    	appUser.setFeelings(feelings);
	        	    	ebi.update(appUser);
	        	    }
	        	    resultModel.setObj(appUser.getFeelings());
		    });
	}
	
	/**
	 * 兴趣爱好
	 * @param response
	 * @param request
	 * @param hoby
	 * @param userid
	 */
	@RequestMapping(value="/A005_8")
	public void appRequestA005_8(HttpServletResponse response,HttpServletRequest request,
		     @RequestParam(value = "hoby", required = false, defaultValue = "") String hoby,
		     String userid
			){
		    super.requestMeth(response, resultModel->{
		    	   boolean flag=true;
		    	   AppUser appUser=  super.checkNoFec(userid, "用户标示不能为空", "用户标示无效", resultModel, AppUser.class);
	        	    if(appUser==null){
	        	    	flag=false;
	        	    }
	        	    if(StringUtil.isEmpty(hoby)){
	        	    	super.setEmptyCode(resultModel, "兴趣爱好不能为空");
	        	    }
	        	    if(flag){
	        	    	appUser.setHoby(hoby);
	        	    	ebi.update(appUser);
	        	    }
	        	    resultModel.setObj(appUser.getHoby());
		    });
	}
	/**
	 * 5设置送货地址 需要传入 userid必须的
	 * 
	 * @param adress
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "A006")
	public void addAdress(UserAdress adress, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			System.out.println("获取到URL "+AppUtils.getCurrentTimestamp());
			System.out.println(request.getQueryString());
			System.out.println(URLDecoder.decode(request.getQueryString(), "UTF-8"));
			System.out.println("------------------------------------------");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		debug(AppUtils.getCurrentTime() + ":APP调用  设置addAdress---A006");
		System.out.println("============================");
		System.out.println(adress.getUname()+adress.getAddress());
		super.requestMeth(
				response,
				resultModel -> {
					AppUser appUser = super.checkNoFec(adress.getUserid(),
							"用户标示不能为空", "用户标示无效", resultModel, AppUser.class);
					if (appUser != null) {
						adress.setAppUser(appUser);
						ebi.save(adress);
						if ("1".equals((adress.getDefaulted()))) {
							userebi.executeSql(adress.getUserid(), adress.getUdid());
						} 
						resultModel.setObj(adress);
					}

				});
	}

	/**
	 * +6更新送货地址 defaulted 0 或1 1表示默认地址
	 * 
	 * @param adress
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "A007")
	public void updateAdress(UserAdressPo adress, HttpServletRequest request,
			HttpServletResponse response) {
		debug(AppUtils.getCurrentTime() + ":APP调用更新用户地址 updateAdress---A007");
		super.requestMeth(
				response,
				resultModel -> {
					boolean flag = true;
					AppUser appUser = super.checkNoFec(adress.getUserid(),
							"用户标示不能为空", "用户标示无效", resultModel, AppUser.class);
					flag = appUser == null ? false : true;
					UserAdress address = super.checkNoFec(adress.getUdid(),
							"地址标示不能为空", "地址标示无效", resultModel, UserAdress.class);
					flag = address == null ? false : true;
					if (flag) {
						address.setUserid(adress.getUserid());// 设置用户ID
						address.setAddress(adress.getAddress());// 设置地址
						if ("1".equals((adress.getDefaulted()))) {
							defaultAddress(address, request, response);
						} else {
							address.setDefaulted("0");// 是否默认
						}
						address.setUname(adress.getUname());
						address.setAppUser(appUser);
						ebi.update(address);
						resultModel.setObj(address);
					}
				});

	}

	/**
	 * 7删除送货地址
	 * 
	 * @param adress
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "A008")
	public void removeAdress(UserAdress adress, HttpServletRequest request,
			HttpServletResponse response) {
		debug(AppUtils.getCurrentTime() + ":APP调用 删除用户地址removeAdress---A008");
		super.requestMeth(
				response,
				resultModel -> {
					UserAdress useraddress = super.checkNoFec(adress.getUdid(),
							"地址标示不能为空", "地址标示无效", resultModel, UserAdress.class);
					if (useraddress != null) {
						ebi.removeById(useraddress.getUdid(), UserAdress.class);
					}
				});
	}

	/**
	 * 8获取所用送货地址
	 * 
	 * @param mode
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "A009")
	public void loadAddress(AppUser mode, HttpServletRequest request,
			HttpServletResponse response) {
		debug(AppUtils.getCurrentTime() + ":APP调用获取用户所有地址 loadAddress--A009");
		ResultModel resultModel = initResultModel();
		try {
			if (StringUtil.isEmpty(mode.getUserid())) {
				setEmptyCode(resultModel, "用户标示不能为空!");
				error(resultModel.getMsg());
			} else {
				AppUser user = (AppUser) ebi.findByOId(AppUser.class,
						mode.getUserid());
				if (user == null) {
					setNoFecCode(resultModel, "传入用户标示无效!");
					error(resultModel.getMsg());
				} else {
					List<UserAdress> list = (List<UserAdress>) ebi
							.queryByHql(" from  UserAdress where appUser='"
									+ mode.getUserid() + "'");
					list.parallelStream().map(item->{
						item.setUserid(item.getAppUser().getUserid());
					     return item;	
					}).collect(Collectors.toList());
					
					resultModel.setObj(list);
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setServerErrCode(resultModel, "加载地址失败!");
			error(resultModel.getMsg(), e);
		}
		toWriterResult(response, resultModel);

	}

	/**
	 * +9设置默认地址 默认人地址标示 udid
	 * 
	 * @param adress
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "A010")
	public void defaultAddress(UserAdress adress, HttpServletRequest request,
			HttpServletResponse response) {
		debug(AppUtils.getCurrentTime() + ":APP调用获取用户所有地址 defaultAddress--A010");
		ResultModel resultModel = this.initResultModel();
		String userid = adress.getUserid();
		String uaddid = adress.getUdid();
		boolean flag = true;
		try {
			if(StringUtil.isEmpty(userid)){
				flag = false;
				setEmptyCode(resultModel, "传入用户标示不能为空!");
			}
			if(StringUtil.isEmpty(uaddid)){
				flag = false;
				setEmptyCode(resultModel, "传入地址标示不能为空!");
			}
			
			if(flag) {
				AppUser user = (AppUser) ebi.findByOId(AppUser.class,
						adress.getUserid());
				if (user == null) {
					setNoFecCode(resultModel, "传入的用户标示无效!");
					error(resultModel.getMsg());
					flag = false;
				} else {
					UserAdress address = super.checkNoFec(uaddid, "地址标示不能为空",
							"地址标示无效", resultModel, UserAdress.class);
					if (address == null) {
						flag = false;
					}
					if (flag) {
						userebi.executeSql(userid, uaddid);
						resultModel.setMsg("设置成功!");
					}
				}
			}
		} catch (Exception e) {
			setServerErrCode(resultModel, "服务端错误!设置地址失败");
			e.printStackTrace();
		}
		toWriterResult(response, resultModel);
	}

	/**
	 * + (更改 ：这里传入参数改一下) 10 修改密码 1 userid 必须 2 旧密码 oldpwd 必须 3 新密码 newpwd 必须
	 */
	@RequestMapping(value = "A011")
	public void updatePwd(String userid, String oldpwd, String newpwd,
			HttpServletRequest request, HttpServletResponse response) {
		debug(AppUtils.getCurrentTime() + ":APP调用获取用户所有地址 updatePwd--A011");
		ResultModel resultModel = this.initResultModel();
		try {
			boolean flag = true;
			if (StringUtil.isEmpty(oldpwd)) {
				flag = false;
				setEmptyCode(resultModel, "旧密码不能为空!");
			}
			if (StringUtil.isEmpty(newpwd)) {
				flag = false;
				setEmptyCode(resultModel, "新密码不能为空!");
			}
			AppUser appUser = super.checkNoFec(userid, "用户标示不能为空", "用户标示无效",
					resultModel, AppUser.class);
			if (appUser == null) {
				flag = false;
			}
			if (flag) {
				if (oldpwd.equals(appUser.getPwd())) {
					appUser.setPwd(newpwd);
					ebi.update(appUser);
					resultModel.setMsg("更新成功!");
				} else {
					setNoFecCode(resultModel, "旧密码不正确!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			setServerErrCode(resultModel, "更新密码错误!");
		}
		toWriterResult(response, resultModel);
	}

	/**
	 * 11 检查用户名是否重复
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "A012")
	public void checkUser(AppUser user, HttpServletRequest request,
			HttpServletResponse response) {
		debug(AppUtils.getCurrentTime() + ":APP调用获取用户所有地址 checkUser--A012");
		ResultModel resultModel = initResultModel();
		String loginCode = user.getLoginCode();
		try {
			if (StringUtil.isEmpty(loginCode)) {
				setEmptyCode(resultModel, "用户名不能为空!");
			} else {
				String hql = " from AppUser where loginCode='"
						+ loginCode.trim() + "'";
				AppUser appuser = (AppUser) ebi.getEntityByHql(AppUser.class,
						hql);
				if (null == appuser) {
					resultModel.setMsg("用户名有效!");
				} else {
					setNoFecCode(resultModel, "用户名已存在!");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			setServerErrCode(resultModel, "服务端错误！无法进行更新");
		}
		toWriterResult(response, resultModel);
	}

	/**
	 * 12获取用户订单 传入userid 订单信息
	 * 
	 */
	@RequestMapping("/A013")
	public void loadorders(HttpServletRequest request,
			HttpServletResponse response, String userid) {
		ResultModel resultModel = this.initResultModel();
		debug(AppUtils.getCurrentTime() + ":APP调用获取用户所有地址 loadorders--A013");
		try {
			if (StringUtil.isEmpty(userid)) {
				resultModel.setMsg("传入的用户标示不能为空！");
			} else {
				String hsql = " from OrderContent o where o.userid='" + userid
						+ "'";
				List<OrderContent> orders = (List<OrderContent>) ebi
						.queryByHql(hsql);
				List<OrderPro> orderpro = new ArrayList<OrderPro>();
				OrderPro op = null;
				for (OrderContent oc : orders) {
					op = new OrderPro();
					op.setOrdid(oc.getOrdid());
					op.setIspay(oc.getIspay());
					op.setOrdertime(oc.getOrdertime());
					Set<OrderItem> items=oc.getItems();
					if(items!=null&&items.size()>0){
						OrderItem oritem=items.iterator().next();
						op.setAcount(oritem.getAcount());
						 Goods goods=  ebi.findByOId(Goods.class, oritem.getGid());
						 if(goods==null){
							 ebi.removeById(oc.getOrdid(), OrderContent.class);
							 continue;
						 }
						OrderDetail orderDetail=new OrderDetail();
						orderDetail.setName(goods.getName());
						orderDetail.setRemarks(goods.getRemarks());
						orderDetail.setPrice(goods.getPrice());
						op.setItemCount(oritem.getCount());
						List<String> imgeList=new ArrayList<String>();
						Set<GoodImage> setImages=goods.getImgs();
						if(setImages!=null&&setImages.size()>0){
							for(GoodImage gi :setImages ){
								imgeList.add(gi.getUrl());
							}
						}
					    orderDetail.setImgs(imgeList);
					    op.setGoodInfo(orderDetail);
					    op.setAcount(oc.getAcount());
					    
						 
						//GoodImage
						//orderDetail.setName(name);
						//orderDetail.setImgs(imgs);
					}
					
					orderpro.add(op);
					op = null;
				}
				resultModel.setObj(orderpro);
			}

		} catch (Exception e) {
			setServerErrCode(resultModel, "服务端错误!无法获取用户订单");
			error(resultModel.getMsg(), e);
		}
		toWriterResult(response, resultModel);
	}

	/**
	 * +13 重新测试 加载用户收藏接口
	 * 
	 * @param userid
	 *            传入用户标示
	 * @param response
	 */
	@RequestMapping("/A014")
	public void loadeCollect(String userid, HttpServletResponse response) {
		ResultModel resultModel = this.initResultModel();
		debug(AppUtils.getCurrentTime() + ":APP调用获取用户所有地址 loadeCollect--A014");
		try {
			if (StringUtil.isEmpty(userid)) {
				resultModel.setMsg("传入的用户标示不能为空！");
			} else {
				String zhql = "from UserCollection where ctype='001'";// 周边
				String ghql = "from UserCollection where ctype='002'";// 商品
				String thql = "from UserCollection where ctype='003' or  ctype='004' or  ctype='005' or  ctype='006'";// 帖子
				List<UserCollection> ucMerchars = (List<UserCollection>) ebi
						.queryByHql(zhql);
				List<UserCollection> ucGoods = (List<UserCollection>) ebi
						.queryByHql(ghql);

				List<UserCollection> ucThs = (List<UserCollection>) ebi
						.queryByHql(thql);
				List<CollectPo> listCollect = new ArrayList<CollectPo>();
				CollectPo cpz = new CollectPo();
				cpz.setType("001");
				ColleckMercharPro cmp = null;
				List<ColleckMercharPro> cprs = new ArrayList<ColleckMercharPro>();
				for (UserCollection uc : ucMerchars) {
					Merchant m = ebi.findByOId(Merchant.class, uc.getCid());
					if (m == null) {
						continue;
					}
					cmp = new ColleckMercharPro();
					cmp.setId(m.getMerid());
					cmp.setIcon(m.getIcon());// 图标
					cmp.setPhone(m.getPhone());// 联系电话
					cmp.setTitle(m.getName());// 标题
					cmp.setRemark(m.getRemarks());// 描述信息
					cmp.setXponit(m.getXponit());// 经度
					cmp.setYponit(m.getYponit());// 纬度
					cmp.setType(uc.getCtype());
					cprs.add(cmp);
					cmp = null;
				}
				cpz.setItem(cprs);// 添加周边收藏

				CollectPo cpg = new CollectPo();
				cpg.setType("002");
				CollectBase cb = null;
				List<CollectBase> cpgs = new ArrayList<CollectBase>();
				for (UserCollection uc : ucGoods) {
					Goods gds = ebi.findByOId(Goods.class, uc.getCid());
					if (gds == null) {
						continue;
					}
					cb = new CollectBase();
					Set<GoodImage> imgs = gds.getImgs();
					if (imgs != null && imgs.size() > 0) {
						GoodImage gimg = imgs.iterator().next();
						cb.setIcon(gimg.getUrl());
					} else {
						gds.setImg("");// 没有图片
					}
					cb.setRemark(gds.getRemarks());
					cb.setTitle(gds.getName());
					cb.setType(uc.getCtype());
					cpgs.add(cb);
					cb = null;
				}
				cpg.setItem(cpgs);// 添加上商品收藏
				listCollect.add(cpz);
				listCollect.add(cpg);
				// ///////////////////////////////////

				List<CollectBase> cths = new ArrayList<CollectBase>();
				CollectPo cth = new CollectPo();
				;
				cth.setType("003");
				for (UserCollection uc : ucThs) {
					cb = new CollectBase();
					BaseEntity baseEntity = ebi.findByOId(BaseEntity.class,
							uc.getCid());
					if (baseEntity == null) {
						continue;
					}
					String ctype = uc.getCtype();
					switch (ctype) {
					case "003":// 用户论坛
						Interact interact = (Interact) baseEntity;
						cb.setTitle(interact.getInteractContent());
						Set<Photograph> icons = interact.getPhotourl();
						if (interact != null && icons.size() > 0) {
							String url = icons.iterator().next().getImgurl();
							cb.setIcon(url);
						}
						cb.setType(uc.getCtype());
						break;
					case "004":// 官方贴
						OfficialIteract officialIteract = (OfficialIteract) baseEntity;
						Set<OfficialPhotograph> imges = officialIteract
								.getPhotourl();
						cb.setTitle(officialIteract.getTitle());
						if (imges != null & imges.size() > 0) {
							String url = imges.iterator().next().getImgurl();
							cb.setIcon(url);
						}
						cb.setType(uc.getCtype());
						break;
					case "005":// 出租
						Rental rental = (Rental) baseEntity;
						cb.setTitle(rental.getTitle());
						Set<RentalImg> rimgs = rental.getImgs();
						if (rimgs != null & rimgs.size() > 0) {
							String url = rimgs.iterator().next().getUrl();
							cb.setIcon(url);
						}
						cb.setType(uc.getCtype());
						break;
					case "006":// 出售
						SellOfer sellOfer = (SellOfer) baseEntity;
						cb.setTitle(sellOfer.getTitle());
						Set<SellOferImg> oimgs = sellOfer.getImgs();
						if (oimgs != null & oimgs.size() > 0) {
							String url = oimgs.iterator().next().getUrl();
							cb.setIcon(url);
						}
						cb.setType(uc.getCtype());
						break;
					}

					cths.add(cb);
					cth = null;
				}
				cth.setItem(cths);
				listCollect.add(cth);
				resultModel.setObj(listCollect);
			}

		} catch (Exception e) {
			this.setServerErrCode(resultModel, "加载用户收藏类表失败!");
			error(resultModel.getMsg(), e);
		}
		toWriterResult(response, resultModel);

	}

	/**
	 * + (重新测试)收藏类型添加3个 14 用户收藏接口 ctype参数有以下几种类型 
	 * 001 周边类型 002 商品类型 003 用户贴
	 * 004官方贴 005出租 006出售
	 * 
	 * cid 来源以下主键 Merchant 主键 Goods 主键 帖子 的主键
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("/A015")
	public void collect(HttpServletRequest request,
			HttpServletResponse response, UserCollection model) {
		debug(AppUtils.getCurrentTime() + ":APP调用获取用户所有地址 collect--A015");
		ResultModel resultModel = this.initResultModel();
		String userid = model.getUid();
		String cid = model.getCid();
		String ctype = model.getCtype();
		try {
			boolean flag = true;
			AppUser AppUser = super.checkNoFec(userid, "用户标示不能为空", "用户标示无效",
					resultModel, AppUser.class);
			if (AppUser == null) {
				flag = false;
			}

			if (StringUtil.isEmpty(cid)) {
				setEmptyCode(resultModel, "传入收藏ID不能为空!");
				flag = false;
			} else if (StringUtil.isEmpty(ctype)) {
				setEmptyCode(resultModel, "收藏类型不能为空!");
				flag = false;
			} else {
				switch (ctype) {
				case "001":// 周边
					Merchant merchant = super.checkNoFec(cid, "周边商铺标示不能为空",
							"周边商铺标示无效", resultModel, Merchant.class);
					flag = merchant == null ? false : true;
					break;
				case "002":// 商品
					Goods goods = super.checkNoFec(cid, "商品标示不能为空", "商品标示无效",
							resultModel, Goods.class);
					flag = goods == null ? false : true;
					break;
				case "003":// 用户论坛
					Interact interact = super.checkNoFec(cid, "用户论坛标示不能为空",
							"用户论坛标示无效", resultModel, Interact.class);
					flag = interact == null ? false : true;
					break;
				case "004":// 官方贴
					OfficialIteract officialIteract = super.checkNoFec(cid,
							"官方论坛标示不能为空", "官方论坛示无效", resultModel,
							OfficialIteract.class);
					flag = officialIteract == null ? false : true;
					break;
				case "005":// 出租
					Rental rental = super.checkNoFec(cid, "出租标示不能为空", "出租标示无效",
							resultModel, Rental.class);
					flag = rental == null ? false : true;
					break;
				case "006":// 出售
					SellOfer sellOfer = super.checkNoFec(cid, "出售标示不能为空",
							"出售标示无效", resultModel, SellOfer.class);
					flag = sellOfer == null ? false : true;
					break;

				default:
					setNoFecCode(resultModel, "非法收藏类型");
					flag = false;
					break;
				}
				if (flag) {
					ebi.save(model);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			setServerErrCode(resultModel, "服务端错误！收藏室失败!");
			error(resultModel.getMsg(), e);
		}
		toWritePhone(response, resultModel);
	}

	/**
	 * +（添加一个接） 收藏明细 输入参数 1 收藏标示 2收藏类型 001 002 003 004 005 006 周边 商品。。。。。。
	 * id 为收藏条目的ID
	 */
	@RequestMapping("/A016")
	public void appRequestA016(HttpServletRequest request,
			HttpServletResponse response, String id, String type) {
		debug(AppUtils.getCurrentTime() + ":APP调用获取用户所有地址 appRequestA016--A016");
		super.requestMeth(
				response,
				resultModel -> {
					boolean flag = true;
					if(StringUtil.isEmpty(type)){
						super.setEmptyCode(resultModel, "收藏类型不能为空!");
						 flag =false;
					}else{
					switch (type) {
					case "001":// 周边
						Merchant merchant = super.checkNoFec(id, "周边商铺标示不能为空",
								"周边商铺标示无效", resultModel, Merchant.class);
						flag = merchant == null ? false : true;
						if (flag) {
							MerchantPo view = new MerchantPo();
							BeanUtils.copyProperties(view, merchant);
							resultModel.setObj(view);
						}

						break;
					case "002":// 商品
						Goods goods = super.checkNoFec(id, "商品标示不能为空",
								"商品标示无效", resultModel, Goods.class);
						flag = goods == null ? false : true;
						if (flag) {
							GoodsPo view = new GoodsPo();
							view.setName(goods.getName());
							view.setPrice(goods.getPrice());
							view.setSaleCount(goods.getSaleCount());
							view.setTrip(goods.getTrip());
							view.setYprice(goods.getYprice());
							List<String> imgsList = new ArrayList<String>();
							if (goods.getImgs() != null
									&& goods.getImgs().size() > 0) {
								for (GoodImage gdimg : goods.getImgs()) {
									imgsList.add(gdimg.getUrl());
								}
								view.setImgs(imgsList);
							}
							resultModel.setObj(view);
						}
						break;
					case "003":// 用户论坛
						Interact interact = super.checkNoFec(id, "用户论坛标示不能为空",
								"用户论坛标示无效", resultModel, Interact.class);
						flag = interact == null ? false : true;
						if (flag) {
							InteractListPo viewItem = new InteractListPo();
							viewItem.setPostTime(interact.getPtime());
							viewItem.setInid(interact.getInterid());
							viewItem.setPostAddress(interact.getPostAddress());
							viewItem.setTypeCode(interact.getType());
							viewItem.setInteractContent(interact
									.getInteractContent());
							Set<Photograph> imgs = interact.getPhotourl();
							if (imgs != null && imgs.size() > 0) {
								List<String> listImage = new ArrayList<>();
								for (Photograph img : imgs) {
									listImage.add(img.getImgurl());
								}
								viewItem.setImgList(listImage);
							}
							AppUser appUser = interact.getUid();
							viewItem.setTopUrl(appUser.getTopUrl());
							viewItem.setUserName(appUser.getUsername());
							viewItem.setSefTick(appUser.getSefTick());
							resultModel.setObj(viewItem);
						}
						break;
					case "004":// 官方贴
						OfficialIteract iteract = super.checkNoFec(id,
								"官方论坛标示不能为空", "官方论坛示无效", resultModel,
								OfficialIteract.class);
						flag = iteract == null ? false : true;
						if (flag) {
							OfferInteractPo interactPo = new OfferInteractPo();
							interactPo.setPostTime(iteract.getPtime());
							interactPo.setInid(iteract.getOinerid());
							interactPo.setTypeCode(iteract.getType());
							interactPo.setOfficialContent(iteract
									.getOfficialContent());
							Set<OfficialPhotograph> imgs = iteract
									.getPhotourl();
							if (imgs != null && imgs.size() > 0) {
								List<String> imgList = new ArrayList<>();
								for (OfficialPhotograph img : imgs) {
									imgList.add(img.getImgurl());
								}
								interactPo.setImgList(imgList);
							}
							resultModel.setObj(interactPo);
						}
						break;
					case "005":// 出租
						Rental rental = super.checkNoFec(id, "出租标示不能为空",
								"出租标示无效", resultModel, Rental.class);
						flag = rental == null ? false : true;
						if (flag) {
							RentalPoDetail view = new RentalPoDetail();
							view.setRid(rental.getRid());
							view.setTitle(rental.getTitle());
							view.setPrice(rental.getPrice());
							view.setPtime(rental.getPtime());
							view.setSource(rental.getSource());
							view.setRentalContent(rental.getRentalContent());
							Set<RentalImg> imgs = rental.getImgs();
							if (imgs != null && imgs.size() > 0) {
								List<String> imgList = new ArrayList<>();
								for (RentalImg img : imgs) {
									imgList.add(img.getUrl());
								}
								view.setImgs(imgList);
							}
							view.setArea(rental.getArea());
							resultModel.setObj(view);
						}
						break;
					case "006":// 出售
						SellOfer sellOfer = super.checkNoFec(id, "出售标示不能为空",
								"出售标示无效", resultModel, SellOfer.class);
						flag = sellOfer == null ? false : true;
						if (flag) {
							SellOferPoDetail view = new SellOferPoDetail();
							view.setRid(sellOfer.getRid());
							view.setTitle(sellOfer.getTitle());
							view.setPrice(sellOfer.getPrice());
							view.setPtime(sellOfer.getPtime());
							view.setSource(sellOfer.getSource());
							view.setSellContent(sellOfer.getSellContent());
							Set<SellOferImg> imgs = sellOfer.getImgs();
							if (imgs != null && imgs.size() > 0) {
								List<String> imgList = new ArrayList<>();
								for (SellOferImg img : imgs) {
									imgList.add(img.getUrl());
								}
								view.setImgs(imgList);
							}
							view.setArea(sellOfer.getArea());
							resultModel.setObj(view);

						}
						break;

					default:
						setNoFecCode(resultModel, "非法收藏类型");
						flag = false;
						break;
					}
					}
				});
	}

	/**
	 * 15删除收藏 传入cid
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("/A017")
	public void phoneRemovee(HttpServletRequest request,
			HttpServletResponse response, UserCollection model) {
		debug(AppUtils.getCurrentTime() + ":APP调用获取用户所有地址 phoneRemovee--A017");
		super.requestMeth(
				response,
				resultModel -> {
					String cid = model.getCid();
					UserCollection ucs = super.checkNoFec(cid, "收藏标示不能为空",
							"收藏标示无效", resultModel, UserCollection.class);
					if (ucs != null) {
						ebi.removeById(cid, UserCollection.class);
					}
				});
	}

	/***
	 * 16 版本更新 接口 start 从那一条开始取出 limit 每页显示多少条 默认 pangeSize 25 whereSql 可选
	 * parentSql 可选 orderSql 默认 按 发布时间降序
	 * 
	 */
	@RequestMapping("/A018")
	public void phoneList(
			@RequestParam(value = "whereSql", required = false, defaultValue = "") String whereSql,
			@RequestParam(value = "parentSql", required = false, defaultValue = "") String parentSql,
			@RequestParam(value = "querySql", required = false, defaultValue = "") String querySql,
			@RequestParam(value = "orderSql", required = false, defaultValue = " order by uptime DESC") String orderSql,
			@RequestParam(value = "start", required = false, defaultValue = "0") String startStr,
			@RequestParam(value = "limit", required = false, defaultValue = "25") String limitStr,
			HttpServletResponse response) {
		debug(AppUtils.getCurrentTime() + ":APP调用获取用户所有地址 phoneList--A018");
		super.load(whereSql, parentSql, querySql, orderSql, startStr, limitStr,
				response, AppVersion.class, (list, resultModel,totalCount) -> {
					ViewPange viewPange=new ViewPange();
					viewPange.setTotalCount(totalCount);
					viewPange.setItems(list);
					resultModel.setObj(list);
				});
	}

	/**
	 * 17 评价接口 （ 意见反馈）
	 * 
	 */
	@RequestMapping("/A019")
	public void userFeedb(Feedback model, HttpServletRequest request,
			HttpServletResponse response) {
		debug(AppUtils.getCurrentTime() + ":APP调用获取用户所有地址 userFeedb--A019");
		ResultModel resultModel = this.initResultModel();
		try {
			String userid = model.getUserid();
			if (StringUtil.isEmpty(userid)) {
				setEmptyCode(resultModel, "传入的用户标示不能为空!");
			} else {
				AppUser appUser = (AppUser) ebi
						.findByOId(AppUser.class, userid);
				if (appUser == null) {
					setNoFecCode(resultModel, "传入的用户标示无效");
				} else {
					if (StringUtil.isEmpty(model.getMsg())) {
						setEmptyCode(resultModel, "评论内容不能为空!");
					} else {
						model.setFbtime(AppUtils.getCurDate());
						ebi.save(model);
					}

				}

			}

		} catch (Exception e) {
			setServerErrCode(resultModel, "服务端错误反馈失败!");
			error(resultModel.getMsg(), e);
		}
		toWritePhone(response, resultModel);
	}

	// ////////////////////////////////////////周边模块////////////////////////////////////////////////////////////////////////////////////////////
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
			debug("获取推荐到商品: " + goods.size());
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
			gdp.setGid(gd.getGid());//商品ID
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
	 * 21 004 获取更多商品 可分页 不传页码显示全部
	 * 
	 * @param whereSql
	 *            查询条件
	 * @param parentSql
	 *            准备sql
	 * @param querySql
	 * @param orderSql
	 *            排序SQL
	 * @param start
	 *            从第几条取
	 * @param limit
	 *            页码
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
		super.load(whereSql, parentSql, querySql, orderSql, start, limit,
				response, Goods.class, (list, resultModel,totalCount) -> {
					ViewPange viewPange=new ViewPange();
					viewPange.setItems(list);
					viewPange.setTotalCount(totalCount);
					List<GoodsPo> goddspro = fillGoodsPo(list);
					resultModel.setObj(goddspro);
				});
	}

	/**参数 userid
	 * + 添加了 gid marking这两个值段
	 * 22 005 商品详细 商品主键 必须的
	 */
	@RequestMapping("/005")
	public void appRequest005(
			@RequestParam(value = "gid", required = false, defaultValue = "") String gid,
			HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "userid", required = false, defaultValue = "") String userid
			) {
		ResultModel resultModel = this.initResultModel();
		try {
			if (StringUtil.isEmpty(gid)) {
				setEmptyCode(resultModel, "传入商品标示不能为空!");
			} else {
				Goods goods = ebi.findByOId(Goods.class, gid);
				if (goods == null) {
					setNoFecCode(resultModel, "传入的商品标示无效!");
				} else {
					GoodsDetail gDetail = new GoodsDetail();
					gDetail.setGid(gid);
					gDetail.setName(goods.getName());
					gDetail.setPrice(goods.getPrice());
					gDetail.setYprice(goods.getYprice());
					gDetail.setRemarks(goods.getRemarks());
					gDetail.setFree(goods.getFree());
					gDetail.setSaleCount(goods.getSaleCount());
					gDetail.setStock(goods.getStock());
					gDetail.setMoveprice(goods.getMoveprice());
					gDetail.setShelfdate(goods.getShelfdate());
					gDetail.setOrigin(goods.getOrigin());
					gDetail.setSpecification(goods.getSpecification());
					gDetail.setShipfrom(goods.getShipfrom());
					gDetail.setIngredient(goods.getIngredient());
					String hql=" SELECT count(o) from  UserCollection o where o.uid='"+userid+"' and o.cid='"+gid+"'";
					Integer count= ebi.getCount(hql);
					if(count!=null&&count!=0){
						gDetail.setMarking(true);//这个户有收藏这个商品app收藏按钮是闪亮的
					}
					List<String> imgsList = new ArrayList<String>();
					if (goods.getImgs() != null && goods.getImgs().size() > 0) {
						for (GoodImage gdimg : goods.getImgs()) {
							imgsList.add(gdimg.getUrl());
						}
						gDetail.setImg(imgsList);
					}
					resultModel.setObj(gDetail);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			setServerErrCode(resultModel, "服务器错误，无法返回商品详细信息！");
		}
		toWritePhone(response, resultModel);
	}

	/**
	 * 23 006订单接口
	 *  [{"gid":"402881e4485d2a6601485d2bafd70000","count":100}]
	 * @param userid
	 *            用户标示
	 * @param orderDetail
	 *            参考实体中属性
	 * @param udid
	 *            地址标示必填
	 * @param request
	 * @param response
	 */
	@RequestMapping("/006")
	public void appRequest006(
			@RequestParam(value = "userid", required = false, defaultValue = "") String userid,
			OderPro orderDetail,
			@RequestParam(value = "udid", required = false, defaultValue = "") String udid,
			HttpServletRequest request, HttpServletResponse response) {
		ResultModel resultModel = initResultModel();
		try {
			String loginCode="";
			String gdName="";
			boolean flag = true;
			if (StringUtil.isEmpty(userid)) {
				flag = false;
				setEmptyCode(resultModel, "传入的用户标示不能为空!");

			} else {
				AppUser user = ebi.findByOId(AppUser.class, userid);
				if (user == null) {
					flag = false;
					setNoFecCode(resultModel, "传入的用户标示无效!");
				}else{
					loginCode=user.getLoginCode();
				}
			}
			if (StringUtil.isEmpty(udid)) {
				flag = false;
				setEmptyCode(resultModel, "传入的送货地址标示不能为空!");
			} else {
				debug(" udid:" + udid);
				UserAdress useraddress = ebi.findByOId(UserAdress.class, udid);
				if (useraddress == null) {
					flag = false;
					setNoFecCode(resultModel, "传入的送货地址标示无效!");
				}
			}
			if (flag) {
				OrderContent content = new OrderContent();
				content.setIspay("000");
				content.setUserid(userid);
				content.setAdressid(udid);
				content.setOrdertime(orderDetail.getOrdertime());
				content.setRemarks(orderDetail.getRemark());
				String oderStr = orderDetail.getOderStr();
				if (StringUtil.isEmpty(oderStr)) {
					setEmptyCode(resultModel, "订单json字符串不能为空!");
				} else {
					List<Map> detail = jsonBuilder.fromJsonArray(oderStr);
					if (detail == null || detail.size() == 0) {
						setNoFecCode(resultModel, "无效的定单信息！");
					} else {
						Set<OrderItem> orderitem = new HashSet<OrderItem>();
						OrderItem or = null;
						for (Map obj : detail) {
							or = new OrderItem();
							Objects.requireNonNull(obj.get("gid"));
							Objects.requireNonNull(obj.get("count"));
							String gid = (String) obj.get("gid");
							int count = (int) obj.get("count");
							Goods goods = ebi.findByOId(Goods.class, gid);
							if (goods == null) {
								setNoFecCode(resultModel, "商品ID无效!");
								toWritePhone(response, resultModel);
							} else {
								or.setGid(gid);
								or.setPrice(goods.getPrice());
								or.setCount(count);
								or.setAcount(goods.getPrice()*count);
								orderitem.add(or);
							}
						}
						if(orderitem.size()>0){
							OrderItem order=  orderitem.iterator().next();
							content.setAcount(order.getAcount());
							Goods goods = ebi.findByOId(Goods.class, order.getGid());
							content.setGdName(goods.getName());
						}
						content.setItems(orderitem);
						content.setLoginCode(loginCode);
						content.setOrdertime(AppUtils.getCurrentTime());
						OrderContent oc = (OrderContent) gdebi
								.saveOrder(content);
						String oderid = oc.getOrdid();
						if (StringUtil.isEmpty(oderid)) {
							throw new Exception();
						}/* else {
							OrderContenPro  contenPro=new OrderContenPro();
							contenPro.setAcount(content.getAcount());
							contenPro.setAdressid(content.getAdressid());
							contenPro.setIspay(content.getIspay());
							contenPro.setOrdertime(content.getOrdertime());
							contenPro.setOrdid(content.getOrdid());
							contenPro.setPayType(contenPro.getPayType());
							contenPro.setUserid(contenPro.getUserid());
							contenPro.setWeekendto(content.getWeekendto());
							contenPro.setUserid(content.getUserid());
							Set<OrderItem> items=content.getItems();
							 Set<OrderItemPro> listItem=new HashSet<>();
							 contenPro.setItems(listItem);
							 if(items!=null&&items.size()>0){
								 Set<OrderItemPro> orderItems=new HashSet<OrderItemPro>();
								 for(OrderItem ori:items ){
									 OrderItemPro viewItem=new OrderItemPro();
									 Goods goods=ebi.findByOId( Goods.class, ori.getGid());
									 if(goods!=null){
										 viewItem.setGid(ori.getGid());
										 viewItem.setName(goods.getName());
										 viewItem.setPrice(goods.getPrice());
										 viewItem.setYprice(goods.getYprice());
										 List<String> imgesList=new ArrayList<String>();
										 Set<GoodImage> goodsImags=goods.getImgs();
										 if(goodsImags!=null&&goodsImags.size()>0){
											 for(GoodImage gimg : goodsImags){
												 imgesList.add(gimg.getUrl());
											 }
										 }
										 viewItem.setImgs(imgesList);
									 }
									 orderItems.add(viewItem);
								 }
								 contenPro.setItems(orderItems);
							 }*/
							
							resultModel.setObj(oderid);
						}
					}


			}
		} catch (NullPointerException e) {
			setNoFecCode(resultModel, "无法获取gid 或count值 ");
			error(resultModel, e);
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
			setServerErrCode(resultModel);
			error(resultModel, e);
		}
		toWritePhone(response, resultModel);
	}

	/**
	 * 24 007订单更新
	 * 
	 * @param userid
	 *            用户标示
	 * @param orderDetail
	 *            参考实体中属性
	 * @param udid
	 *            地址标示必填
	 * @param request
	 * @param response
	 */
	@RequestMapping("/007")
	public void appRequest007(
			@RequestParam(value = "userid", required = false, defaultValue = "") String userid,
			@RequestParam(value = "udid", required = false, defaultValue = "") String udid,
			@RequestParam(value = "orderid", required = false, defaultValue = "") String orderid,
			OderPro orderDetail, HttpServletRequest request,
			HttpServletResponse response) {
		ResultModel resultModel = initResultModel();
		try {
			boolean flag = true;
			if (StringUtil.isEmpty(userid)) {
				flag = false;
				setEmptyCode(resultModel, "传入的用户标示不能为空!");

			} else {
				AppUser user = ebi.findByOId(AppUser.class, userid);
				if (user == null) {
					flag = false;
					setNoFecCode(resultModel, "传入的用户标示无效!");
				}
			}
			if (StringUtil.isEmpty(udid)) {
				flag = false;
				setEmptyCode(resultModel, "传入的送货地址标示不能为空!");
			} else {
				debug(" udid:" + udid);
				UserAdress useraddress = ebi.findByOId(UserAdress.class, udid);
				if (useraddress == null) {
					flag = false;
					setNoFecCode(resultModel, "传入的送货地址标示无效!");
				}
			}
			OrderContent content = null;
			List<String> itemids = new ArrayList<>();
			if (StringUtil.isEmpty(orderid)) {
				setEmptyCode(resultModel, "传入订单标示不能为空!");
				flag = false;
			} else {
				content = ebi.findByOId(OrderContent.class, orderid);
				if (content == null) {
					setNoFecCode(resultModel, "传入订单标示无效");
					flag = false;
				} else {
					Set<OrderItem> items = content.getItems();
					if (items != null && items.size() > 0) {
						itemids = items.parallelStream()
								.map(item -> item.getOitmid())
								.collect(Collectors.toList());
					}

				}
			}
			if (flag) {
				content.setUserid(userid);
				content.setAdressid(udid);
				content.setOrdertime(orderDetail.getOrdertime());
				content.setRemarks(orderDetail.getRemark());
				content.setAcount(orderDetail.getAoucnt());
				String oderStr = orderDetail.getOderStr();
				if (StringUtil.isEmpty(oderStr)) {
					setEmptyCode(resultModel, "订单json字符串不能为空!");
				} else {
					List<Map> detail = jsonBuilder.fromJsonArray(oderStr);
					if (detail == null || detail.size() == 0) {
						setNoFecCode(resultModel, "无效的定单信息！");
					} else {
						Set<OrderItem> orderitem = new HashSet<OrderItem>();
						OrderItem or = null;
						for (Map obj : detail) {
							or = new OrderItem();
							Objects.requireNonNull(obj.get("gid"));
							Objects.requireNonNull(obj.get("count"));
							String gid = (String) obj.get("gid");
							int count = (int) obj.get("count");
							Goods goods = ebi.findByOId(Goods.class, gid);
							if (goods == null) {
								setNoFecCode(resultModel, "传入的gid无效");
							} else {
								or.setGid(gid);
								or.setPrice(goods.getPrice());
								or.setCount(count);
								or.setAcount(goods.getPrice()
										* goods.getPrice());
								orderitem.add(or);
							}
						}
						content.setItems(orderitem);
						content.setOrdertime(AppUtils.getCurrentTime());
						content.setIspay("0");
						OrderContent oc = (OrderContent) gdebi.updateOrder(
								content, itemids);
						String oderid = oc.getOrdid();
						if (StringUtil.isEmpty(oderid)) {
							throw new Exception();
						} else {
							resultModel.setObj(oderid);
						}
					}

				}

			}
		} catch (NullPointerException e) {
			setNoFecCode(resultModel, "无法获取gid 或count值 ");
			error(resultModel, e);
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
			setServerErrCode(resultModel);
			error(resultModel, e);
		}
		toWritePhone(response, resultModel);
	}

	/**
	 * 25 008更新订单支付状态接口 userid 用户标示 orderid订单标示 payType 001 银行卡支付 002 支付宝支付 支付成功
	 * 返回 OrderProAdrees 详细见属性 订单状态 1待付款000 2支付成功 001 3 交易 成功 002 4交易关闭003
	 */
	@RequestMapping("/008")
	public void appRequest008(
			@RequestParam(value = "userid", required = false, defaultValue = "") String userid,
			@RequestParam(value = "orderid", required = false, defaultValue = "") String orderid,
			@RequestParam(value = "state", required = false, defaultValue = "") String payType,
			HttpServletRequest request, HttpServletResponse response) {
		ResultModel resultModel = initResultModel();
		try {
			boolean flag = true;
			AppUser user = null;
			OrderContent order = null;
			if (StringUtil.isEmpty(userid)) {
				setEmptyCode(resultModel, "传入的用户标示不能为空!");
				flag = false;
			} else {
				user = ebi.findByOId(AppUser.class, userid);
				if (user == null) {
					setNoFecCode(resultModel, "传入用户标示无效");
					flag = false;
				}
			}
			if (StringUtil.isEmpty(orderid)) {
				setEmptyCode(resultModel, "传入订单标示不能为空!");
				flag = false;
			} else {
				order = ebi.findByOId(OrderContent.class, orderid);
				if (order == null) {
					setNoFecCode(resultModel, "传入订单标示无效");
					flag = false;
				}
			}
			if (StringUtil.isEmpty(payType)) {
				setEmptyCode(resultModel, "订单状态不能为空!");
				flag = false;
			}else{
				switch (payType) {
				case "000":
					break;
		       case "001":
					
					break;
		       case "002":
			
			break;
		      case "003":
			
			break;

				default:
					flag = false;
					setNoFecCode(resultModel,"非法状态");
					break;
				}

			if (flag) {
				order.setIspay(payType);
				OrderContent oreder=ebi.findByOId(OrderContent.class, orderid);
				ebi.update(oreder);
				resultModel.setObj(payType);
	/*			order.setIspay("1");
				order.setPayType(payType);
				order = ebi.update(order);
				OrderProAdrees view = new OrderProAdrees();
				view.setIspay(order.getIspay());
				view.setOrdertime(order.getOrdertime());
				view.setItems(order.getItems());
				view.setAdress(ebi.findByOId(UserAdress.class,
						order.getAdressid()));
				resultModel.setObj(view);*/
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			setServerErrCode(resultModel);
			error(resultModel, e);
		}
		toWritePhone(response, resultModel);

	}

	/**
	 * 26 009删除订单
	 * 
	 * @param userid
	 * @param orderid
	 * @param request
	 * @param response
	 */
	@RequestMapping("/009")
	public void appRequest009(
			@RequestParam(value = "userid", required = false, defaultValue = "") String userid,
			@RequestParam(value = "orderid", required = false, defaultValue = "") String orderid,
			HttpServletRequest request, HttpServletResponse response) {
		ResultModel resultModel = initResultModel();
		try {
			checkAppUser(userid, resultModel);
			if (StringUtil.isEmpty(orderid)) {
				setEmptyCode(resultModel, "传入订单标示不能为空!");
			} else {
				OrderContent content = ebi.findByOId(OrderContent.class,
						orderid);
				if (content == null) {
					setNoFecCode(resultModel, "传入订单标示无效");
				} else {
					ebi.removeById(orderid, OrderContent.class);
				}
			}

		} catch (Exception e) {
			setServerErrCode(resultModel);
			error(resultModel, e);
		}
		toWritePhone(response, resultModel);
	}

	/**
	 * 27 010申请商户 请求类型为 multipart/form-data 传递参考 我要开店页面 找到对应的属性 是否 上门 参考数 0,1
	 * btype RoundPo 服务类型代码 其中 地址 可能包括 经度 纬度 详细地址
	 *
	 */
	@RequestMapping("/010")
	public void appRequest0010(@Validated Merchant model,
			HttpServletRequest request, HttpServletResponse response) {
	/*	ProcessFieldsUploadUtil.upload(model, icon, "icon",
				"baoli.upload.merchant");*/
		String useri = model.getUserid();
		ResultModel resultModel = this.initResultModel();
		try {
			boolean flag=true;
			 AppUser appUser= checkAppUser(useri, resultModel);
			 if(appUser==null)
			 if(StringUtil.isEmpty(model.getName())){
				 flag=false;
				 setEmptyCode(resultModel, "商铺名称不能为空！");
			 }
			 if(StringUtil.isEmpty(model.getAdress())){
				 flag=false;
				 setEmptyCode(resultModel, "商铺地址不能为空！");
			 }
			 if(StringUtil.isEmpty(model.getBtype())){
				 flag=false;
				 setEmptyCode(resultModel, "服务类型不能为空！");
			 }
			 
			 if(flag){
					model.setApplytime(AppUtils.getCurrentTime());
					model.setAudit("0");
					model.setUsername(appUser.getLoginCode());
					ebi.save(model);
					resultModel.setObj(model.getMerid());
			 }
	
		} catch (Exception e) {
			e.printStackTrace();
			setServerErrCode(resultModel);
			error(resultModel, e);
		}
		toWritePhone(response, resultModel);
	}

	/**
	 * 上传商户图标
	 * @param response
	 * @param request
	 * @param postfix
	 * @param merid
	 */
	@RequestMapping(value="/010_A",method=RequestMethod.POST)
	public void appRequest010_A(HttpServletResponse response,HttpServletRequest request,
		     @RequestParam(value = "postfix", required = false, defaultValue = "png") String postfix,
		     @RequestParam(value = "merid", required = false, defaultValue = "")  String merid  
			) {
		        super.requestMeth(response, resultModel->{
		        	   boolean flag=true;
		        	   StringBuffer buffer=new StringBuffer();
		        	   buffer.append(request.getParameter("imageStr"));
		        	  if(StringUtil.isEmpty(buffer.toString())){
		        		super.setEmptyCode(resultModel, "图片字符不能为空");
		        		flag=false;
		        	  }
		        	  Merchant merchant=  super.checkNoFec(merid, "商户标示不能为空", "传入商户无效", resultModel, Merchant.class);
		        	    if(merchant==null){
		        	    	flag=false;
		        	    }
		        	    flag= ProcessFieldsUploadUtil.uploadByBase64("baoli.upload.merchant",buffer,postfix,merchant,"icon");
		        	    if(flag){
		        	    	   ebi.update(merchant);
				        	    resultModel.setObj(merchant.getIcon());	
		        	    }else{
		        	    	throw  new Exception();	
		        	    }
		        	 
		        });
	}
	
	
	
	/**
	 * 28 011 根据服务类型代码 加载商户
	 * 
	 * @param dtype
	 *            类型code bixu
	 * @param request
	 * @param response
	 */
	@RequestMapping("/011")
	public void appRequest0011(
			@RequestParam(value = "dtype", required = false, defaultValue = "") String dtype,
			HttpServletRequest request, HttpServletResponse response) {
		ResultModel resultModel = this.initResultModel();
		try {
			if (StringUtil.isEmpty(dtype)) {
				setEmptyCode(resultModel, "传入服务类型代码不空!");
			} else {
				final String hql = "from Merchant where btype='" + dtype + "'";
				List<Merchant> merList = (List<Merchant>) ebi.queryByHql(hql);
				List<MerchantPo> merListPO = merList.parallelStream()
						.map(item -> {
							MerchantPo po = new MerchantPo();
							try {
								BeanUtils.copyProperties(po, item);
							} catch (Exception e) {
								error("拷贝属性失败!", e);
							}
							return po;
						}).collect(Collectors.toList());
				resultModel.setObj(merListPO);
			}

		} catch (Exception e) {
			e.printStackTrace();
			setServerErrCode(resultModel);
			error(resultModel, e);
		}
		toWritePhone(response, resultModel);

	}

	// //////////////////////////////////////////////社区模块////////////////////////////////////////////////////////////////////////
	/**
	 * 29 012 获取社区首页今日头条 返回头条的标题 缩略图
	 */
	@RequestMapping("/012")
	public void appRequest0012(HttpServletRequest request,
			HttpServletResponse response) {
		super.requestMeth(response, (resultModel) -> {
			String today = AppUtils.getCurDate();
			String hql = " from AppNews where 1=1 and addate between '" + today
					+ "' and '" + today + "'  and state='1' order  by adtime desc";
			List<AppNews> listnews = (List<AppNews>) ebi.queryByHql(hql, 0, 1);
			AppNews appNews = null;
			if (listnews != null&& listnews.size() > 0) {
				appNews = listnews.get(0);
				hql=" select count(o) from Massage o where inid='"+appNews.getNewid()+"'";
				Integer onCount= ebi.getCount(hql);
				AppNewPo newPo = new AppNewPo();
				newPo.setImg(appNews.getShrinkimg());
				newPo.setTitle(appNews.getTitle());
				newPo.setOnCount(onCount==null?0:onCount);
				resultModel.setObj(newPo);
			} else {
				hql = " from AppNews where 1=1  and state='1' order  by adtime desc";
				listnews = (List<AppNews>) ebi.queryByHql(hql, 0, 1);
				if (listnews == null || listnews.size() == 0) {
					resultModel.setMsg("系统没有发布任何新闻");
				} else {
					appNews = listnews.get(0);
					hql=" select count(o) from Massage o where inid='"+appNews.getNewid()+"'";
					Integer onCount= ebi.getCount(hql);
					AppNewPo newPo = new AppNewPo();
					newPo.setImg(appNews.getShrinkimg());
					newPo.setTitle(appNews.getTitle());
					newPo.setOnCount(onCount==null?0:onCount);
					resultModel.setObj(newPo);
				}
			}

		});
	}

	/**
	 * 30 013 根据日期加载 APP新闻
	 * 
	 * @param whereSql
	 *            查询条件 可选
	 * @param parentSql
	 *            可选
	 * @param querySql
	 *            可选
	 * @param orderSql
	 *            排序段 order by +字段名称 可选
	 * @param start
	 *            从几条取 可选
	 * @param limit
	 *            每页多少条 可选
	 * @param startdate
	 *            开始日期
	 * @param enddate
	 *            结束日期
	 */
	@RequestMapping("/013")
	public void appRequest0013(
			@RequestParam(value = "whereSql", required = false, defaultValue = "") String whereSql,
			@RequestParam(value = "parentSql", required = false, defaultValue = "") String parentSql,
			@RequestParam(value = "querySql", required = false, defaultValue = "") String querySql,
			@RequestParam(value = "orderSql", required = false, defaultValue = "") String orderSql,
			@RequestParam(value = "start", required = false, defaultValue = "0") String start,
			@RequestParam(value = "limit", required = false, defaultValue = "0") String limit,
			@RequestParam(value = "startdate", required = false, defaultValue = "") String startdate,
			@RequestParam(value = "enddate", required = false, defaultValue = "") String enddate,
			HttpServletResponse response) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date startd = null;
		Date endd = null;
		try {
			if (StringUtil.isEmpty(startdate)) {
				startd = formatter.parse(AppUtils.getCurDate());
				startdate = formatter.format(startd);
			} else {
				startd = formatter.parse(startdate);
			}
			if (StringUtil.isEmpty(enddate)) {
				endd = formatter.parse(AppUtils.getCurDate());
				enddate = formatter.format(endd);
			} else {
				endd = formatter.parse(enddate);
			}
			if (startd == null || endd == null) {
				error("日期转换失败!");

			} else {
				List<String> dates = AppUtils.findDates(startd, endd);
				whereSql += " and addate between  '" + startdate + "' and '"
						+ enddate + "' ";
				orderSql += " order  by adtime desc";
				super.load(
						whereSql,
						parentSql,
						querySql,
						orderSql,
						start,
						limit,
						response,
						AppNews.class,
						(list, resultModel,totalCount) -> {
							ViewPange viewPange=new ViewPange();
							viewPange.setTotalCount(totalCount);
							List<AppNews> listnews = list;
							debug("获取到SIZE： " + list.size());
							/**
							 * 按日期 作为 map key 返回 list 新闻 列表
							 */
							List<Map<String, List<AppNewPo>>> listNews = new ArrayList<Map<String, List<AppNewPo>>>();

							if (list != null) {
								for (String d : dates) {
									List<AppNewPo> views = listnews
											.parallelStream()
											.filter(item -> d.equals(item
													.getAddate()))
											.map(item -> new AppNewPo(item
													.getTitle(), item
													.getShrinkimg()))
											.collect(Collectors.toList());
									Map<String, List<AppNewPo>> mapnews = new HashMap<String, List<AppNewPo>>();
									mapnews.put(d, views);
									listNews.add(mapnews);
								}
							}
							viewPange.setItems(listNews);
							resultModel.setObj(viewPange);
						});
			}
		} catch (ParseException e) {
			error("日期转换失败!");
		}

	}

	/**
	 * 
	 * 31 014 根据 新闻 标示 加载 一条新闻
	 * 
	 * @param newid
	 *            必须滴
	 */
	@RequestMapping("/014")
	public void appRequest0014(String newid, HttpServletRequest request,
			HttpServletResponse response) {
		super.requestMeth(
				response,
				resultModel -> {
					AppNews appNews = super.checkNoFec(newid, "新闻标示不能为空!",
							"新闻标示无效!", resultModel, AppNews.class);
					if (appNews != null) {
						AppNewProd appNewProd = new AppNewProd();
						appNewProd.setTitle(appNews.getTitle());
						appNewProd.setAddate(appNews.getAddate());
						appNewProd.setImg(appNews.getShrinkimg());
						appNewProd.setSource(appNews.getSource());
						appNewProd.setNewContent(appNews.getNewContent());
						resultModel.setObj(appNewProd);
					}
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
			HttpServletRequest request, HttpServletResponse response) {
		super.load(whereSql, parentSql, querySql, orderSql, start, limit,
				response, VirtualIcon.class, (list, resultModel,totalCount) -> {
					ViewPange viewPange=new ViewPange();
					viewPange.setTotalCount(totalCount);
					List<VirtualIconPo> views = new ArrayList<VirtualIconPo>();
					views = list.parallelStream().map(item -> {
						VirtualIconPo view = new VirtualIconPo();
						view.setInconUrl(item.getInconUrl());
						view.setName(item.getName());
						view.setLinkUrl(item.getLinkUrl());
						return view;
					}).collect(Collectors.toList());
					viewPange.setItems(views);
					resultModel.setObj(viewPange);
				});
	}

	/**
	 * 33 016 用户发帖 提交 方式 
	 * 
	 * @param userid
	 *            用户标示 必须
	 * @param type
	 *            帖子类型 必须 相关项参考 数字字典 用户论坛分类 条目
	 * @param model
	 *            参考用户 发帖界面 注意活动类型帖子传入的参数, 发帖地址
	 * @param imgesStr 示例数据  [{"imgStr":"qqwqw","postfix":"jpg"},{"imgStr":"qqwqw","postfix":"jpg"}]
	 *           
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/016", method = RequestMethod.POST)
	public void appRequest016( Interact model,
			HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "imgsStr", required = false, defaultValue = "") String imgsStr
			) {
		String userid = model.getUserid();
		String type = model.getType();
		super.requestMeth(
				response,
				resultModel -> {
					boolean flag=true;
					if(StringUtil.isEmpty(model.getInteractContent())){
						super.setEmptyCode(resultModel, "发表内容不能为空");
						flag=false;
					}else{
					AppUser appUser = checkAppUser(userid, resultModel);
					if (appUser != null) {
						if (StringUtil.isEmpty(type)) {
							setEmptyCode(resultModel, "贴子类型不能为空!");
							flag=false;
						} else {
							Set<Photograph> imgeItems = new HashSet<>();
							Photograph imgeItem = null;
						    if(flag){
						    	 if(StringUtil.isNotEmpty(imgsStr)){
						    		   List<Map> imges = jsonBuilder.fromJsonArray(imgsStr);
						    		   debug("用户将上传： "+imges.size()+" 张图片");
						    			for (Map img : imges) {
						    				   debug("=================================");
												imgeItem = new Photograph();
												StringBuffer imageStr=new StringBuffer(img.get("imgStr")+"");
												String postfix=img.get("postfix")==null?"png":img.get("postfix")+"";
											    flag= ProcessFieldsUploadUtil.uploadByBase64("baoli.upload.interact",imageStr,postfix,imgeItem,"imgurl");
												if (!flag) {
													throw new Exception("保存图片是失败!");
												}else{
													imgeItems.add(imgeItem);
												
												}
												debug("用户上传图片："+imgeItem.getImgurl()+"成功!");
												imgeItem = null;
											}
										}
						    }
							model.setPhotourl(imgeItems);
							model.setUid(appUser);
						    model.setUsername(appUser.getUsername());
							model.setPtime(AppUtils.getCurrentTime());
							model.setPostAddress(appUser.getProvince()+appUser.getCity());
							iebi.saveInteract(model);
							resultModel.setObj(model.getInterid());
						}
					}
					}
				});
	}

	/**
	 * 34 017 论坛评论
	 * 
	 * @param msg
	 *            用户标示 ，贴子ID，评论内容必须的   用户定位信息  评论类型 001用户论坛 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/017")
	public void appRequest017(Massage msg, HttpServletRequest request,
			HttpServletResponse response) {
		super.requestMeth(
				response,
				(resultModel -> {
					String userid = msg.getUserid();
					String inid = msg.getInid();
					String cpntext = msg.getMsgContext();
				    msg.setBacktime(AppUtils.getCurrentTime());
					boolean flag = true;
					AppUser appUser = checkNoFec(userid, "用户标示不能为空!",
							"传入用户标示无效!", resultModel, AppUser.class);
					if (appUser == null) {
						flag = false;
					} else if (StringUtil.isEmpty(inid)) {
						flag = false;
					} else if (StringUtil.isEmpty(cpntext)) {
						flag = false;
						setEmptyCode(resultModel, "评论内容不能为空");
					}
					if (flag) {
						msg.setUsername(appUser.getLoginCode());
						msg.setProvince(appUser.getProvince());
						msg.setCity(appUser.getCity());
						ebi.save(msg);
						resultModel.setObj(msg);
					}
				}));
	}

	/**
	 * 35 018加载用户贴列表 可分页
	 * 
	 * @param msg
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/018")
	public void appRequest018(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "whereSql", required = false, defaultValue = "") String whereSql,
			@RequestParam(value = "parentSql", required = false, defaultValue = "") String parentSql,
			@RequestParam(value = "querySql", required = false, defaultValue = "") String querySql,
			@RequestParam(value = "orderSql", required = false, defaultValue = "") String orderSql,
			@RequestParam(value = "start", required = false, defaultValue = "0") String start,
			@RequestParam(value = "limit", required = false, defaultValue = "0") String limit) {
		super.load(whereSql, parentSql, querySql, orderSql, start, limit,
				response, Interact.class, (list, resultModel,totalCount) -> {
					ViewPange viewPange=new ViewPange();
					List<InteractListPo> views = new ArrayList<>();
					views = list.parallelStream().map(item -> {
						InteractListPo viewItem = new InteractListPo();
						viewItem.setPostTime(item.getPtime());
						viewItem.setInid(item.getInterid());
						viewItem.setPostAddress(item.getPostAddress());
						viewItem.setTypeCode(item.getType());
						viewItem.setInteractContent(item.getInteractContent());
						Set<Photograph> imgs = item.getPhotourl();
						if (imgs != null && imgs.size() > 0) {
							List<String> listImage = new ArrayList<>();
							for (Photograph img : imgs) {
								listImage.add(img.getImgurl());
							}
							viewItem.setImgList(listImage);
						}
						AppUser appUser = item.getUid();
						viewItem.setTopUrl(appUser.getTopUrl());
						viewItem.setUserName(appUser.getUsername());
						viewItem.setSefTick(appUser.getSefTick());
						return viewItem;
					}).collect(Collectors.toList());
					viewPange.setItems(views);
					viewPange.setTotalCount(totalCount);
					resultModel.setObj(viewPange);
				});

	}

	/**
	 * 36 加载评论 interid 必须
	 * 
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
	@RequestMapping(value = "/019")
	public void appRequest019(
			HttpServletRequest request,
			HttpServletResponse response,
			String interid,
			@RequestParam(value = "whereSql", required = false, defaultValue = "") String whereSql,
			@RequestParam(value = "parentSql", required = false, defaultValue = "") String parentSql,
			@RequestParam(value = "querySql", required = false, defaultValue = "") String querySql,
			@RequestParam(value = "orderSql", required = false, defaultValue = "") String orderSql,
			@RequestParam(value = "start", required = false, defaultValue = "0") String start,
			@RequestParam(value = "limit", required = false, defaultValue = "0") String limit) {
		
		 ResultModel resultModel= initResultModel();
		whereSql += " and  inid='" + interid + "'";
		orderSql += " order  by backtime desc";
		if (StringUtil.isEmpty(interid)) {
			setEmptyCode(resultModel, "帖子标识不能为空!");
		}else{
		try{
	StringBuffer hql = new StringBuffer(" from Massage where 1=1 ");
	StringBuffer countHql = new StringBuffer("select count(*) from Massage   where 1=1");
	hql.append(whereSql);
	hql.append(parentSql);
	hql.append(querySql);
	countHql.append(whereSql);
	countHql.append(querySql);
	countHql.append(parentSql);
	Integer count = ebi.getCount(countHql.toString()).intValue();
	hql.append(orderSql);
	String  limitStr=limit.equals("0") ? String.valueOf(count) : limit;
	List<Massage> list = (List<Massage>) ebi.queryByHql(hql.toString(),
			Integer.valueOf(start), Integer.valueOf(limit));
				List<MessagePo> views = new ArrayList<>();
				views = list.parallelStream().map(item -> {
					MessagePo view = new MessagePo();
					view.setCity(item.getCity());
					view.setProvince(item.getProvince());
					view.setMesg(item.getMsgContext());
					view.setUserName(item.getUsername());
					view.setPsTime(item.getBacktime());
					return view;
				}).collect(Collectors.toList());
				resultModel.setObj(views);
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		super.toWritePhone(response, resultModel);
	}

	/**
	 * 37 加载出租信息
	 * 
	 * @param request
	 * @param response
	 * @param whereSql
	 * @param parentSql
	 * @param querySql
	 * @param orderSql
	 * @param start
	 * @param limit
	 */
	@RequestMapping(value = "/020")
	public void appRequest020(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "whereSql", required = false, defaultValue = " and state='1' ") String whereSql,
			@RequestParam(value = "parentSql", required = false, defaultValue = "") String parentSql,
			@RequestParam(value = "querySql", required = false, defaultValue = "") String querySql,
			@RequestParam(value = "orderSql", required = false, defaultValue = " order  by ptime desc ") String orderSql,
			@RequestParam(value = "start", required = false, defaultValue = "0") String start,
			@RequestParam(value = "limit", required = false, defaultValue = "0") String limit) {
		super.load(whereSql, parentSql, querySql, orderSql, start, limit,
				response, Rental.class, (list, resultModel,totalCount) -> {
					ViewPange viewPange=new ViewPange();
					viewPange.setTotalCount(totalCount);
					List<RentalPo> views = new ArrayList<>();
					views = list.parallelStream().map(item -> {
						RentalPo view = new RentalPo();
						try {
							view.setArea(item.getArea());
							view.setRid(item.getRid());
							view.setSource(item.getSource());
							view.setTitle(item.getTitle());
							view.setPtime(item.getPtime());
							view.setPrice(item.getPrice() + "元/m2/天");
							Set<RentalImg> imgSet=item.getImgs();
							//List<String> imgList=new ArrayList<>();
							if(imgSet!=null&&imgSet.size()>0){
					/*			for(RentalImg img :imgSet ){
									imgList.add(img.getUrl());
								}*/
								view.setImge(imgSet.iterator().next().getUrl());
							}
							//view.setImge(imgList);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
						return view;
					}).collect(Collectors.toList());
					viewPange.setItems(views);
					resultModel.setObj(viewPange);
				});
	}

	/**
	 * 38 加载出售信息
	 * 
	 * @param request
	 * @param response
	 * @param whereSql
	 * @param parentSql
	 * @param querySql
	 * @param orderSql
	 * @param start
	 * @param limit
	 */
	@RequestMapping(value = "/021")
	public void appRequest021(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "whereSql", required = false, defaultValue = " and state='1' ") String whereSql,
			@RequestParam(value = "parentSql", required = false, defaultValue = "") String parentSql,
			@RequestParam(value = "querySql", required = false, defaultValue = "") String querySql,
			@RequestParam(value = "orderSql", required = false, defaultValue = " order  by ptime desc ") String orderSql,
			@RequestParam(value = "start", required = false, defaultValue = "0") String start,
			@RequestParam(value = "limit", required = false, defaultValue = "0") String limit) {
		super.load(whereSql, parentSql, querySql, orderSql, start, limit,
				response, SellOfer.class, (list, resultModel,totaleCount) -> {
					ViewPange viewPange=new ViewPange();
					viewPange.setTotalCount(totaleCount);
					List<RentalPo> views = new ArrayList<>();
					views = list.parallelStream().map(item -> {
						RentalPo view = new RentalPo();
						try {
							view.setArea(item.getArea());
							view.setPrice(item.getPrice());
							view.setRid(item.getRid());
							view.setSource(item.getSource());
							view.setTitle(item.getTitle());
							view.setPtime(item.getPtime());
							if ("0".equals(view.getPrice())) {
								view.setPrice("面议");
							} else {
								view.setPrice(view.getPrice() + "万");
							}
							Set<SellOferImg> imgeSet=item.getImgs();
						//	List<String> imges=new ArrayList<>();
							if(imgeSet!=null&&imgeSet.size()>0){
							/*	for(SellOferImg img :imgeSet){
									imges.add(img.getUrl());
								}*/
								view.setImge(imgeSet.iterator().next().getUrl());
							}
						
							
						} catch (Exception e) {
							e.printStackTrace();
						}
						return view;
					}).collect(Collectors.toList());
					viewPange.setItems(views);
					resultModel.setObj(viewPange);
				});
	}

	/**
	 * 39 22加载官方 帖子详细 信息
	 * 
	 * @param tid
	 *            帖子ID
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/022")
	public void appRequest022(HttpServletRequest request,
			HttpServletResponse response, String tid) {
		super.requestMeth(
				response,
				resultModel -> {
					OfficialIteract iteract = checkNoFec(tid, "帖子标识不能为空!",
							"帖子标识无效!", resultModel, OfficialIteract.class);
					if (iteract != null) {
						OfferInteractPo interactPo = new OfferInteractPo();
						interactPo.setPostTime(iteract.getPtime());
						interactPo.setInid(iteract.getOinerid());
						interactPo.setTypeCode(iteract.getType());
						interactPo.setOfficialContent(iteract
								.getOfficialContent());
						Set<OfficialPhotograph> imgs = iteract.getPhotourl();
						if (imgs != null && imgs.size() > 0) {
							List<String> imgList = new ArrayList<>();
							for (OfficialPhotograph img : imgs) {
								imgList.add(img.getImgurl());
							}
							interactPo.setImgList(imgList);
						}
						resultModel.setObj(interactPo);
					}
				});
	}

	/**
	 * 40详细 出租信息
	 * 
	 * @param request
	 * @param response
	 * @param tid
	 */
	@RequestMapping(value = "/023")
	public void appRequest023(HttpServletRequest request,
			HttpServletResponse response, String rid) {
		super.requestMeth(
				response,
				(resultModel) -> {
					Rental rental = checkNoFec(rid, "出租识示能为空", "出租标识无效",
							resultModel, Rental.class);
					if (rental != null) {
						RentalPoDetail view = new RentalPoDetail();
						view.setRid(rental.getRid());
						view.setTitle(rental.getTitle());
						view.setPrice(rental.getPrice());
						view.setPtime(rental.getPtime());
						view.setSource(rental.getSource());
						view.setRentalContent(rental.getRentalContent());
						Set<RentalImg> imgs = rental.getImgs();
						if (imgs != null && imgs.size() > 0) {
							List<String> imgList = new ArrayList<>();
							for (RentalImg img : imgs) {
								imgList.add(img.getUrl());
							}
							view.setImgs(imgList);
						}
						view.setArea(rental.getArea());
						resultModel.setObj(view);
					}
				});

	}

	/**
	 * 41 详细 出售信息
	 * 
	 * @param request
	 * @param response
	 * @param tid
	 */
	@RequestMapping(value = "/024")
	public void appRequest024(HttpServletRequest request,
			HttpServletResponse response, String rid) {
		super.requestMeth(
				response,
				(resultModel) -> {
					SellOfer sellOfer = checkNoFec(rid, "出售标识能为空", "出售标示无效",
							resultModel, SellOfer.class);
					if (sellOfer != null) {
						SellOferPoDetail view = new SellOferPoDetail();
						view.setRid(sellOfer.getRid());
						view.setTitle(sellOfer.getTitle());
						view.setPrice(sellOfer.getPrice());
						view.setPtime(sellOfer.getPtime());
						view.setSource(sellOfer.getSource());
						view.setSellContent(sellOfer.getSellContent());
						Set<SellOferImg> imgs = sellOfer.getImgs();
						if (imgs != null && imgs.size() > 0) {
							List<String> imgList = new ArrayList<>();
							for (SellOferImg img : imgs) {
								imgList.add(img.getUrl());
							}
							view.setImgs(imgList);
						}
						view.setArea(sellOfer.getArea());
						resultModel.setObj(view);
					}
				});
	}

	private AppUser checkAppUser(String useri, ResultModel resultModel)
			throws Exception {
		AppUser appUser = null;
		if (StringUtil.isEmpty(useri)) {
			setEmptyCode(resultModel, "传入的用户标示不能为空！");
		} else {
			appUser = ebi.findByOId(AppUser.class, useri);
			if (appUser == null) {
				setNoFecCode(resultModel, "传入的用户标示无效!");
			}
		}
		return appUser;
	}

	private void toWriterResult(HttpServletResponse response,
			ResultModel resModel) {
		String josString = jsonBuilder.toJson(resModel);
		this.toWrite(response, josString);
	}

}
