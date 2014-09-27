package org.yingqu.framework.controllers;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yingqu.desktop.model.Department;
import org.yingqu.desktop.model.EndUser;
import org.yingqu.desktop.security.SecurityUserHolder;
import org.yingqu.framework.constant.StringVeriable;
import org.yingqu.framework.constant.TreeVeriable;
import org.yingqu.framework.core.utils.AppUtils;
import org.yingqu.framework.ebi.SimpleEbi;
import org.yingqu.framework.log.LogerManager;
import org.yingqu.framework.model.BaseEntity;
import org.yingqu.framework.model.TreeBaseEntity;
import org.yingqu.framework.model.vo.JSONTreeNode;
import org.yingqu.framework.model.vo.PModel;
import org.yingqu.framework.model.vo.PageResult;
import org.yingqu.framework.model.vo.ResultModel;
import org.yingqu.framework.utils.DateUtil;
import org.yingqu.framework.utils.JsonBuilder;
import org.yingqu.framework.utils.ModelUtil;
import org.yingqu.framework.utils.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @author HouLynn
*创建时间：2014年6月20日 下午7:51:15 version 1.0
 */
public abstract class SimpleBaseController<M extends BaseEntity> implements LogerManager {
	/** 项目部署的WebRoot路径 */
	public static String webrootAbsPath;
	/** 项目部署的class路径 */
	public static String absClassPath;
	/** Json工具类 */
	protected static JsonBuilder jsonBuilder;
	/** 应用名称 */
	public static String appName;
	@Autowired
	protected SimpleEbi<M> ebi;
	

	public SimpleEbi<M> getEbi() {
		return ebi;
	}

	public void setEbi(SimpleEbi<M> ebi) {
		this.ebi = ebi;
	}

	protected final Class<? extends M> clazz;

	static {
		jsonBuilder = JsonBuilder.getInstance();
	}

	protected SimpleBaseController(Class<? extends M> clazz) {
		this.clazz = clazz;
	}

	/** ------------开始封装通用方法------------------ */
	/**
	 * 默认的读取方法
	 */
	@RequestMapping("/load")
	public void load(HttpServletRequest request, HttpServletResponse response) {
		try {
			StringBuffer hql = new StringBuffer("from " + clazz.getSimpleName()
					+ " where 1=1");
			StringBuffer countHql = new StringBuffer("select count(*) from "
					+ clazz.getSimpleName() + " where 1=1");
			String whereSql = request.getParameter("whereSql");
			whereSql = whereSql == null ? "" : whereSql;
			hql.append(whereSql);
			String parentSql = request.getParameter("parentSql");
			parentSql = parentSql == null ? "" : parentSql;
			hql.append(parentSql);
			String querySql = request.getParameter("querySql");
			querySql = querySql == null ? "" : querySql;
			hql.append(querySql);
			String orderSql = request.getParameter("orderSql");
			orderSql = orderSql == null ? "" : orderSql;
			int start = 0;
			int limit = 30;
			String startStr = request.getParameter("start");
			start = startStr == null ? 0 : Integer.valueOf(startStr);
			String limitStr = request.getParameter("limit");
			countHql.append(whereSql);
			countHql.append(querySql);
			countHql.append(parentSql);
			Integer count = ebi.getCount(countHql.toString());
			limit = limitStr == null ? limit : Integer.valueOf(limitStr);
			hql.append(orderSql);
			List<?> lists = ebi.queryByHql(hql.toString(), start, limit);
			String strData = jsonBuilder.buildObjListToJson(new Long(count),
					lists, true);
			toWrite(response, strData);
		} catch (Exception e) {
			e.printStackTrace();
			error("加载数据失败！", e);
		}
	}

	/**
	 * 默认的保存方法
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/doSave")
	public void doSave(M model, HttpServletRequest request,
			HttpServletResponse response) {
		
		this.getModel(request, model);
		try {
			
			if (model instanceof BaseEntity) {
				buildModelCreateInfo((BaseEntity) model, request, response);
			} else {
				error("实体信息获取错误");
				toWrite(response, jsonBuilder.returnFailureJson("'传入的实体信息错误'"));
				return;
			}
			// 构建创建信息
			// 保存实体
			
			model = (M) ebi.save(model);
		toWrite(response,
					jsonBuilder.returnSuccessJson(jsonBuilder.toJson(model)));
		} catch (Exception e) {
			e.printStackTrace();
			error("保存方法出错，错误信息" + e.getMessage());
			toWrite(response,
					jsonBuilder.returnFailureJson("'保存方法出错，错误信息"
							+ e.getMessage() + "'"));
		}
	}

	/**
	 * 默认的更新
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/doUpdate")
	public void doUpdate(M model, HttpServletRequest request,
			HttpServletResponse response) {
		this.getModel(request, model);
		try {
			if (model instanceof BaseEntity) {
				buildModelModifyInfo(request, response, (BaseEntity) model);
			} else {
				error("实体信息获取错误");
				toWrite(response, jsonBuilder.returnFailureJson("'传入的实体信息错误'"));
				return;
			}
			model = (M) ebi.formUpdate(model);

			toWrite(response,
					jsonBuilder.returnSuccessJson(jsonBuilder.toJson(model)));
		} catch (Exception e) {
			e.printStackTrace();
			error("更新方法出错，错误信息" + e.getMessage());
			toWrite(response,
					jsonBuilder.returnFailureJson("'更新方法出错，错误信息"
							+ e.getMessage() + "'"));

		}
	}

	/**
	 * 默认的删除方法
	 */
	@RequestMapping("/doRemove")
	public void doRemove(M model, HttpServletRequest request,
			HttpServletResponse response) {
		String ids = request.getParameter("ids");
		this.getModel(request, model);
		try {
			if (StringUtil.isNotEmpty(ids)) {
				String[] idArray = ids.split(StringVeriable.STR_SPLIT);
				String idsStr = StringUtil.fromArrayToStr(idArray);
				String pkName = request.getParameter("pkName");
				pkName = pkName == null ? "" : pkName;
				if (StringUtil.isEmpty(pkName)) {
					pkName = ModelUtil.getClassPkName(model.getClass());
				}
				if (StringUtil.isEmpty(pkName)) {
					toWrite(response,
							jsonBuilder.returnFailureJson("'得到类主键名失败'"));
					return;
				}
				ebi.deleteBatchById(model.getClass(), pkName, idsStr);
				toWrite(response,
						jsonBuilder.returnSuccessJson("'" + idArray.length
								+ "条记录被删除'"));
			} else {
				toWrite(response, jsonBuilder.returnFailureJson("'传入ids为空'"));
			}
		} catch (Exception e) {
			e.printStackTrace();

			Arrays.asList(e.getStackTrace()).forEach(
					item -> System.out.println(item));
			error("删除失败，失败信息:" + e.getMessage());
			toWrite(response,
					jsonBuilder.returnFailureJson("'删除失败，失败信息:"
							+ e.getMessage() + "'"));
		}
	}

	/**
	 * 默认的表格的更新方法
	 */
	@RequestMapping("/doUpdateList")
	public void doUpdateList(
			@RequestParam(value="strData",required=false,defaultValue="") String strData,
			@RequestParam(value="ids",required=false) String[] ids,
			HttpServletRequest request,
			HttpServletResponse response) {
		// [{sql:"update EndUser set name='zsp'"},{}]

		try {
			String[] updateSqls = jsonBuilder.jsonSqlToString(strData);
			ebi.executeBatchHql(updateSqls);
			toWrite(response,
					jsonBuilder.returnSuccessJson("'" + updateSqls.length
							+ "条记录被更新'"));
		} catch (Exception e) {
			e.printStackTrace();
			error("批量更新失败，错误信息:" + e.getMessage());
			toWrite(response,
					jsonBuilder.returnFailureJson("'批量更新失败，错误信息："
							+ e.getMessage() + "'"));
		}
	}

	/**
	 * 根据实体主键值获取实体信息
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getInfoById")
	public void getInfoById(HttpServletRequest request,
			HttpServletResponse response) {
		String pkValue = request.getParameter("pkValue");
		pkValue = pkValue == null ? "" : pkValue;
		try {
			if (StringUtil.isEmpty(pkValue)) {
				toWrite(response, jsonBuilder.returnFailureJson("'得到类主键值失败'"));
				return;
			}

			M entity = (M) ebi.findById(clazz, pkValue);
			toWrite(response,
					jsonBuilder.returnSuccessJson(jsonBuilder.toJson(entity)));
		} catch (Exception e) {
			e.printStackTrace();
			error("获取实体信息失败，错误信息" + e.getMessage());
			toWrite(response,
					jsonBuilder.returnFailureJson("'获取实体信息失败，错误信息"
							+ e.getMessage() + "'"));
		}
	}

	/**
	 * 默认的读取树形方法
	 */
	@RequestMapping("/getTree")
	public void getTree(HttpServletRequest request, HttpServletResponse response) {
		String node = request.getParameter("node");
		node = node == null ? "" : node;
		String nodeId = request.getParameter("nodeId");
		nodeId = nodeId == null ? "" : nodeId;

		String whereSql = request.getParameter("whereSql");
		whereSql = whereSql == null ? "" : whereSql;

		String expanded = request.getParameter("expanded");
		Boolean expand = expanded == null ? false : Boolean
				.parseBoolean(expanded);

		String excludes = request.getParameter("excludes");
		excludes = excludes == null ? "" : excludes;

		TreeBaseEntity model = this.getTreeModel();
		if (model != null && model instanceof TreeBaseEntity) {
			Class<?> c = model.getClass();
			// 得到根节点ID
			if (!(StringUtil.isNotEmpty(node) && node
					.equalsIgnoreCase(TreeVeriable.ROOT))) {
				node = TreeVeriable.ROOT;
			}
			if (StringUtil.isNotEmpty(nodeId)) {
				node = nodeId;
			}
			// 得到表名
			String entityName = c.getSimpleName();
			// 得到模版类
			JSONTreeNode template = ModelUtil.getJSONTreeNodeTemplate(c);
			try {
				// 递归查询出集合
				List<JSONTreeNode> lists = ebi.getTreeList(node, entityName,
						whereSql, template, expand);
				// 构建成树形节点对象
				JSONTreeNode root = ebi.buildJSONTreeNode(lists, node);
				String strData = "";
				if (node.equalsIgnoreCase(TreeVeriable.ROOT)) {
					strData = jsonBuilder.buildList(root.getChildren(),
							excludes);
				} else {
					List<JSONTreeNode> alist = new ArrayList<JSONTreeNode>();
					alist.add(root);
					strData = jsonBuilder.buildList(root.getChildren(),
							excludes);
				}
				toWrite(response, strData);
			} catch (Exception e) {
				e.getStackTrace();
				e.printStackTrace();
			}

		}

	}

	protected TreeBaseEntity getTreeModel() {
		return new Department();
	}

	protected void toWrite(HttpServletResponse response, String contents) {
		if (ModelUtil.isNotNull(response)) {
			response.setContentType("text/html;charset=UTF-8;");
			Writer writer = null;
			try {
				response.setCharacterEncoding("UTF-8");
				writer = response.getWriter();
				writer.write(contents);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					writer.flush();
					writer.close();
					response.flushBuffer();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 构建创建的实体信息
	 * 
	 * @param model
	 * @throws Exception 
	 */

	protected void buildModelCreateInfo(BaseEntity entity,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 登录人信息获取 ,从安全上下文中获取当前用户信息
		EndUser currentUser = SecurityUserHolder.getCurrentUser();
		if (StringUtil.isEmpty(currentUser.getUserCode())) {
			response.sendRedirect("/login.jsp");
		}

		// ///////////////////////////////////////////////////
	    Date now = new Date();
		String dateStr = DateUtil.formatDateTime(now);
		entity.setCreateUser(currentUser.getUserCode());
		entity.setCreateDept(currentUser.getDeptCode());
		entity.setCreateTime(dateStr);
		//ebi.getOrderIndex(entity);

	}
	/**
	 * 构建修改的实体信息
	 * 
	 * @param model
	 * @throws Exception 
	 */
	protected void buildModelModifyInfo(HttpServletRequest request,
			HttpServletResponse response, BaseEntity entity) throws Exception {
		EndUser currentUser = SecurityUserHolder.getCurrentUser();
		if ("GUEST".equals(currentUser.getUserCode())) {
			response.sendRedirect("/login.jsp");
		}
		Department currentDept = currentUser.getDepartment();
		Date now = new Date();
		String dateStr = DateUtil.formatDateTime(now);
		entity.setModifyUser(currentUser.getUserCode());
		entity.setModifyDept(currentDept.getDeptCode());
		entity.setUpdateTime(entity.getModifyTime());
		entity.setModifyTime(dateStr);
		//ebi.getOrderIndex(entity);
	}

	public abstract M getModel(HttpServletRequest request, M model);
	
	
	/**
	 * APP添加方法
	 * @param request
	 * @param response
	 * @param model
	 */
	public  <T extends BaseEntity> void phoneSave(HttpServletRequest request,
			HttpServletResponse response,  T  model
		) {
		info(AppUtils.getCurrentTime()+": 调用了phoneSave 方法");
		ResultModel resultModel=this.initResultModel();
		try {
			M m =(M) ebi.save(model);
			resultModel.setObj(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			setServerErrCode(resultModel, "插入失败!");
			error("APP调用插入失败！", e);
			e.printStackTrace();
		}
		toWritePhone(response,resultModel);
	}
	
	
/**
 * APP更新操作
 * @param request
 * @param response
 * @param model
 */
	public  <T extends PModel> void  phoneUpdate(HttpServletRequest request,
			HttpServletResponse response, T  model
		) {
		info(AppUtils.getCurrentTime()+": 调用了phoneUpdate 方法");
		ResultModel resultModel=this.initResultModel();
		try {
			model.setClazz(clazz);
			M m =(M) ebi.updateByPhone(model);
			resultModel.setObj(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			setServerErrCode(resultModel, "更新失败!");
			error("APP请求更改方法失败！", e);
			e.printStackTrace();
		}
		toWritePhone(response,resultModel);
	}
	
	
	/**
	 * APP更新操作
	 * @param request
	 * @param response
	 * @param model
	 */
		public  <T extends PModel> void  phoneUpdate(HttpServletRequest request,
				HttpServletResponse response, T  model,Class clazz
			) {
			info(AppUtils.getCurrentTime()+": 调用了phoneUpdate 方法");
			ResultModel resultModel=this.initResultModel();
			try {
				model.setClazz(clazz);
				M m =(M) ebi.updateByPhone(model);
				resultModel.setObj(m);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				 setServerErrCode(resultModel, "更新失败!");
				error("APP请求更改方法失败！", e);
				e.printStackTrace();
			}
			toWritePhone(response,resultModel);
		}
	
	/***
	 * app端的删除操作
	 * @param request
	 * @param response
	 * @param model
	 */

	public  <T extends BaseEntity> void phoneRemove(HttpServletRequest request,
			HttpServletResponse response,  T  model
		) {
		info(AppUtils.getCurrentTime()+": 调用了phoneRemove 方法");
		ResultModel resultModel=initResultModel();
		try {
		     ebi.delete(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			setServerErrCode(resultModel, "删除失败!");
			e.printStackTrace();
			error("APP请求删除方法失败！", e);
		}
		toWritePhone(response,resultModel);
	}
	
	/**
	 * APP加载数据默认方法
	 * @param whereSql
	 * @param parentSql
	 * @param querySql
	 * @param orderSql
	 * @param startStr
	 * @param limitStr
	 * @param response
	 */
	public void phoneList(
			@RequestParam(value="whereSql",required=false,defaultValue="") String whereSql,
	    	@RequestParam(value="parentSql",required=false,defaultValue="") String parentSql,
	    	@RequestParam(value="querySql",required=false,defaultValue="") String querySql,
	    	@RequestParam(value="orderSql",required=false,defaultValue="") String orderSql,
	    	@RequestParam(value="start",required=false,defaultValue="0") String startStr,
	    	@RequestParam(value="limit",required=false,defaultValue="25") String limitStr,
	    	HttpServletResponse response){
		info(AppUtils.getCurrentTime()+": 调用了phoneList 方法");
		PageResult resultModel=new PageResult();
		    try {
				StringBuffer hql = new StringBuffer("from " + clazz.getSimpleName()
						+ " where 1=1");
				StringBuffer countHql = new StringBuffer("select count(*) from "
						+ clazz.getSimpleName() + " where 1=1");
				hql.append(whereSql);
				parentSql = parentSql == null ? "" : parentSql;
				hql.append(parentSql);
				querySql = querySql == null ? "" : querySql;
				hql.append(querySql);
				orderSql = orderSql == null ? "" : orderSql;
				int start= Integer.valueOf(startStr);
				countHql.append(whereSql);
				countHql.append(querySql);
				countHql.append(parentSql);
				Integer count = ebi.getCount(countHql.toString());
				resultModel.setTotalCount(count);
				 Integer limit  = Integer.valueOf(limitStr);
				hql.append(orderSql);
				List<?> lists = ebi.queryByHql(hql.toString(), start, limit);
				resultModel.setObj(lists);
			} catch (Exception e) {
				e.printStackTrace();
			    setServerErrCode(resultModel,"加载数据失败!");
				error("默认读取方法出错，错误信息：" + e.getMessage());
			}
		    toWritePhone(response,resultModel);
	}
	
	protected ResultModel initResultModel() {
		ResultModel resModel = new ResultModel();
		resModel.setCode(000);
		resModel.setMsg("ok");
		return resModel;
	}
	
	/**
	 * 向手机端返回请求数据
	 * @param response
	 * @param resModel
	 */
	protected void toWritePhone(HttpServletResponse response, ResultModel resModel){
		String jsonSql=jsonBuilder.toJson(resModel);
		toWrite(response, jsonSql);
	}
	
	
	
	/**
	 * 设置1001 参数不许为空
	 * @param resultModel
	 * @param param
	 */
	public void setEmptyCode(ResultModel resultModel,String msg){
		resultModel.setCode(1001);
		resultModel.setMsg(msg);
	}
	
	/**
	 * 1002
	 * @param resultModel
	 * @param param
	 */
	public void setNoFecCode(ResultModel resultModel,String msg){
		resultModel.setCode(1002);
		resultModel.setMsg(msg);
	}
	
	
	/**
	 * 1003
	 * @param resultModel
	 * @param param
	 */
	public void setServerFecCode(ResultModel resultModel,String msg){
		resultModel.setCode(1003);
		resultModel.setMsg(msg);
	}
	
	/**
	 * 1100
	 * @param resultModel
	 * @param param
	 */
	public void setServerErrCode(ResultModel resultModel,String msg){
		resultModel.setCode(1100);
		resultModel.setMsg(msg);
	}
	
	
	
	
	
	

}
