package org.yingqu.framework.controllers;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.persistence.Inheritance;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.yingqu.baoli.model.AppUser;
import org.yingqu.baoli.model.Goods;
import org.yingqu.framework.ebi.CommonEbi;
import org.yingqu.framework.log.LogerManager;
import org.yingqu.framework.model.Model;
import org.yingqu.framework.model.vo.PModel;
import org.yingqu.framework.model.vo.ResultModel;
import org.yingqu.framework.utils.JsonBuilder;
import org.yingqu.framework.utils.ModelUtil;
import org.yingqu.framework.utils.StringUtil;

/**
 * APP接口基础操作类
 * 
 * @author HouLynn
 * @date 2014年9月22日
 * @version 1.0
 */
public class AppBaseController   implements LogerManager{

	protected static JsonBuilder jsonBuilder;
	static {
		jsonBuilder = JsonBuilder.getInstance();
	}

	@Autowired
	protected CommonEbi ebi;

	public CommonEbi getEbi() {
		return ebi;
	}

	public void setEbi(CommonEbi ebi) {
		this.ebi = ebi;
	}

	public interface PrepareResult<T extends Model> {

		public  void prepare(List<T> list,
				ResultModel resultModel);
	}

	/**
	 * 按条件取一笔数据
	 * 
	 * @param whereSql
	 * @param parentSql
	 * @param querySql
	 * @param orderSql
	 * @param start
	 * @param limit
	 * @param response
	 * @param clazz
	 * @param prepareResult
	 * @throws Exception
	 */
	public <T extends Model, R extends PModel> void load(
			@RequestParam(value = "whereSql", required = false, defaultValue = "") String whereSql,
			@RequestParam(value = "parentSql", required = false, defaultValue = "") String parentSql,
			@RequestParam(value = "querySql", required = false, defaultValue = "") String querySql,
			@RequestParam(value = "orderSql", required = false, defaultValue = "") String orderSql,
			@RequestParam(value = "start", required = false, defaultValue = "0") String start,
			@RequestParam(value = "limit", required = false, defaultValue = "0") String limit,
			HttpServletResponse response, Class<T> clazz,
			PrepareResult<T> prepareResult) {
		ResultModel resultModel = initResultModel();
		try {
			StringBuffer hql = new StringBuffer(" from "
					+ clazz.getSimpleName() + " where 1=1 ");
			StringBuffer countHql = new StringBuffer("select count(*) from "
					+ clazz.getSimpleName() + " where 1=1");
			hql.append(whereSql);
			hql.append(parentSql);
			hql.append(querySql);
			countHql.append(whereSql);
			countHql.append(querySql);
			countHql.append(parentSql);
			Integer count = ebi.getCount(countHql.toString()).intValue();
			hql.append(orderSql);
			limit = limit.equals("0") ? String.valueOf(count) : limit;
			List<T> list = (List<T>) ebi.queryByHql(hql.toString(),
					Integer.valueOf(start), Integer.valueOf(limit));
			prepareResult.prepare(list, resultModel);
		} catch (Exception e) {
              e.printStackTrace();
              setServerErrCode(resultModel, "服务端错误,无法加载数据!");
		}
		toWritePhone(response, resultModel);
	}

	/**
	 * 添加操作
	 * 
	 * @param model
	 * @throws Exception
	 */
	public <T extends Model> void save(T model) throws Exception {
		ebi.save(model);

	}

	/**
	 * 删除操作
	 * 
	 * @param model
	 * @throws Exception
	 */
	public <T extends Model> void remove(Class<T> clazz, String id)
			throws Exception {
		ebi.removeById(id, clazz);

	}

	/**
	 * 更加ID查找
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T extends Model> T findByOId(Class<T> clazz, String id)
			throws Exception {
		return ebi.findByOId(clazz, id);
	}

	/**
	 * 查询所有
	 * 
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public <T extends Model> List<T> findAll(Class<T> clazz) throws Exception {
		return ebi.findAll(clazz);
	}

	/**
	 * 获取一笔数
	 * 
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	public List<?> queryByHql(String hql) throws Exception {
		return ebi.queryByHql(hql);
	}

	/**
	 * 获取一个唯一的
	 * 
	 * @param clazz
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	public <T extends Model> T getEntityByHql(Class<T> clazz, String hql)
			throws Exception {
		return ebi.getEntityByHql(clazz, hql);

	}

	/**
	 * 更新一个实体
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public <T extends Model> T update(T entity) throws Exception {
		return ebi.update(entity);
	}

	/***
	 * 加载一笔数据
	 * 
	 * @param hql
	 * @param start
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public List<?> queryByHql(String hql, Integer start, Integer limit)
			throws Exception {
		return ebi.queryByHql(hql, start, limit);
	}

	/**
	 * 初始化返回数据模型
	 * 
	 * @return
	 */
	protected ResultModel initResultModel() {
		ResultModel resModel = new ResultModel();
		resModel.setCode(000);
		resModel.setMsg("ok");
		return resModel;
	}

	/**
	 * 向手机端返回请求数据
	 * 
	 * @param response
	 * @param resModel
	 */
	protected void toWritePhone(HttpServletResponse response,
			ResultModel resultModel) {
		String jsonSql = jsonBuilder.toJson(resultModel);
		toWrite(response, jsonSql);
	}

	/**
	 * 设置1001 参数不许为空
	 * 
	 * @param resultModel
	 * @param param
	 */
	public void setEmptyCode(ResultModel resultModel, String msg) {
		resultModel.setCode(1001);
		resultModel.setMsg(msg);
	}

	/**
	 * 1002 无效参数值
	 * 
	 * @param resultModel
	 * @param param
	 */
	public void setNoFecCode(ResultModel resultModel, String msg) {
		resultModel.setCode(1002);
		resultModel.setMsg(msg);
	}

	/**
	 * 1003 服务器返回数据无效
	 * 
	 * @param resultModel
	 * @param param
	 */
	public void setServerFecCode(ResultModel resultModel, String msg) {
		resultModel.setCode(1003);
		resultModel.setMsg(msg);
	}

	/**
	 * 1100 服务器错误
	 * 
	 * @param resultModel
	 * @param param
	 */
	public void setServerErrCode(ResultModel resultModel, String msg) {
		resultModel.setCode(1100);
		resultModel.setMsg(msg);
	}

	/**
	 * 默认服务端错误
	 */
	public void setServerErrCode(ResultModel resultModel) {
		resultModel.setCode(1100);
		resultModel.setMsg("服务端错误！");
	}
	
	public <T extends Model> T checkEmpty(String id,String msg,ResultModel resultModel,Class<T> clazz) throws Exception{
	   if(StringUtil.isEmpty(id)){
		   setEmptyCode(resultModel, msg);
	   }else{
		 return ebi.findByOId(clazz, id);
	   }
	   return null;
	}
	@Inheritance
	protected interface ResultModelinterface{
		public void doResult(ResultModel resultModel) throws Exception;
	}
	public void requestMeth(HttpServletResponse response, ResultModelinterface modelinterface ){
		   ResultModel resultModel=initResultModel();
		  try{
			  modelinterface.doResult(resultModel);
		  }catch(Exception e){
			 setServerErrCode(resultModel);
			 error(resultModel, e);
		  }
		  toWritePhone(response, resultModel);
	}
	/**
	 * 向客户端写入数据
	 * 
	 * @param response
	 * @param contents
	 */
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

}
