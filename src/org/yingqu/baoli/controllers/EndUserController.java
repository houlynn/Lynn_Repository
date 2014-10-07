package org.yingqu.baoli.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.desktop.model.Department;
import org.yingqu.desktop.model.EndUser;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.core.utils.MD5Util;
import org.yingqu.framework.model.BaseEntity;
import org.yingqu.framework.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/sysuser")
@Controller
public class EndUserController extends SimpleBaseController<EndUser> {

	protected EndUserController() {
		super(EndUser.class);
	}

	@Override
	public EndUser getModel(HttpServletRequest request, EndUser model) {
		Department department=new  Department();
		department.setDeptId("ROOT");
		//model.setPassword("123456");
		model.setDepartment(department);
		return model;
	}

	@Override
	public void doSave(EndUser model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		getModel(request, model);
		model.setPassword(MD5Util.md5(model.getPassword()));
	try {
	      String hql="from EndUser where userCode='"+model.getUserCode()+"'";
	      EndUser endUser=  (EndUser) ebi.getEntityByHql(hql);
	      if(endUser==null){
	    		model = (EndUser) ebi.save(model);
	    		toWrite(response,
						jsonBuilder.returnSuccessJson(jsonBuilder.toJson(model)));
	      }else{
	    		toWrite(response,
						jsonBuilder.returnFailureJson("'登陆账号已存在,添加失败!'"));
	      }
		} catch (Exception e) {
			e.printStackTrace();
			error("保存方法出错，错误信息" + e.getMessage());
			toWrite(response,
					jsonBuilder.returnFailureJson("'保存方法出错，错误信息"
							+ e.getMessage() + "'"));
		}
	}

	@Override
	public void doUpdate(EndUser model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		super.doUpdate(model, request, response);
	}
	

}
