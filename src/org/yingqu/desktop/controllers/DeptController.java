package org.yingqu.desktop.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.desktop.model.Department;
import org.yingqu.framework.constant.NodeType;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.model.BaseEntity;
import org.yingqu.framework.model.TreeBaseEntity;
import org.yingqu.framework.utils.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 部门Action
* @author 作者 yingqu: 
* @version 创建时间：2014年6月21日 下午11:49:45 
* version 1.0
 */
@Controller("deptAction")
@RequestMapping("/rbacDept")
@Scope("prototype")
public class DeptController extends SimpleBaseController<Department> {
	protected DeptController() {
		super(Department.class);
		// TODO Auto-generated constructor stub
	}

	private static Logger logger=Logger.getLogger(DeptController.class);
	private Department department=new Department();

	@Override
	public void load(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		super.load(request, response);
	}

	public void doSave(Department mdoel,HttpServletRequest request,HttpServletResponse response){
		Department entity=this.getModel(request, mdoel);
		try{
			if(entity instanceof BaseEntity){
				buildModelCreateInfo((BaseEntity)entity,request,response);
			}else{
				logger.error("实体信息获取错误");
				
				toWrite(response,jsonBuilder.returnFailureJson("'传入的实体信息错误'"));
				return;
			}
			//构建创建信息
			
			//保存实体
			entity=(Department) ebi.save(entity);
			Department dept=(Department) entity;
			Department parent=(Department) ebi.findById(Department.class, dept.getParent().getDeptId());
			if(!parent.getDeptId().equals(NodeType.ROOT)){
				parent.setNodeType(NodeType.GENERAL.getType());
				ebi.update(parent);
			}
			toWrite(response,jsonBuilder.returnSuccessJson(jsonBuilder.toJson(entity)));
		}catch(Exception e){
			e.printStackTrace();
			logger.error("保存方法出错，错误信息"+e.getMessage());
			toWrite(response,jsonBuilder.returnFailureJson("'保存方法出错，错误信息"+e.getMessage()+"'"));
		}
	}

	@Override
	public Department getModel(HttpServletRequest request, Department model) {
		String parentId=request.getParameter("parentId");
		if(StringUtil.isEmpty(parentId)){
			parentId=NodeType.ROOT.getType();
		}
		Department parent=new Department();
		parent.setDeptId(parentId);
		department.setParent(parent);
		return department;
	}

	@Override
	protected TreeBaseEntity getTreeModel() {
		// TODO Auto-generated method stub
		return super.getTreeModel();
	}
	
}
