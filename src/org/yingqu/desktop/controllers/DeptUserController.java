package org.yingqu.desktop.controllers;

import javax.servlet.http.HttpServletRequest;

import org.yingqu.desktop.model.view.VDeptUser;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.model.TreeBaseEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
* @author 作者 yingqu: 
* @version 创建时间：2014年6月24日 上午9:58:37 
* version 1.0
 */
@Component("deptUserAction")
@Scope("prototype")
@RequestMapping("/rbacDeptUser")
public class DeptUserController extends SimpleBaseController<VDeptUser> {
	protected DeptUserController() {
		super(VDeptUser.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public VDeptUser getModel(HttpServletRequest request, VDeptUser model) {
		// TODO Auto-generated method stub
		return model;
	}

	@Override
	protected TreeBaseEntity getTreeModel() {
		// TODO Auto-generated method stub
		return new VDeptUser();
	}

}
