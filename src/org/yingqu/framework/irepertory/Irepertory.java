package org.yingqu.framework.irepertory;

import java.util.List;

import org.yingqu.framework.assist.Condition;
import org.yingqu.framework.assist.Page;
import org.yingqu.framework.log.LogerManager;
import org.yingqu.framework.model.BaseEntity;
import org.yingqu.framework.model.BaseViewModel;
import org.yingqu.framework.model.Model;
import org.hibernate.Criteria;

/**
 * 
 * @author 作者 yingqu:
 * @version 创建时间：2014年7月8日 下午8:26:39 version 1.0
 */
public interface Irepertory<M extends BaseEntity, V extends BaseViewModel> extends LogerManager{

	/**
	 * 根据id查询当前实体
	 * 
	 * @param id
	 * @return Class clazz;
	 */
	public <T extends M> T findById(Class<T> clazz, String id) throws Exception;

	public <T extends V> T findByVId(Class<V> clazz, long id) throws Exception;

	public <T extends V> T findByVId(Class<V> clazz, int id) throws Exception;

	public <T extends Model> T findByOId(Class<T> clazz, String id)
			throws Exception;

	/**
	 * 查询所有实体集合
	 * 
	 * @return
	 */
	public <T extends M> List<T> findAll(Class<M> clazz) throws Exception;

	public <T extends V> List<T> findVAll(Class<V> clazz) throws Exception;

	public <T extends Model> List<T> findOAll(Class<T> clazz) throws Exception;

	/**
	 * 使用hql查询获取一条记录
	 * 
	 * @param hql
	 * @return
	 */
	public <T extends M> T getEntityByHql(String hql) throws Exception;

	public <T extends V> T getEntityByVHql(String hql) throws Exception;

	public <T extends Model> T getEntityByOHql(String hql) throws Exception;

	/**
	 * 根据HQL查询实体列表
	 * 
	 * @param hql
	 * @return
	 */
	public <T extends M> List<T> queryByHql(String hql) throws Exception;

	public <T extends V> List<T> queryByVHql(String hql) throws Exception;

	public <T extends Model> List<T> queryByOHql(String hql) throws Exception;

	/**
	 * 查询当前页信息
	 * 
	 * @param whereSql
	 * @param from
	 * @param size
	 * @return
	 */
	public <T extends M> List<M> findByPage(final Class<M> clazz,
			final String whereSql, final int from, final int size)
			throws Exception;

	public <T extends V> List<T> findByVPage(final Class<V> clazz,
			final String whereSql, final int from, final int size)
			throws Exception;

	public <T extends Model> List<T> findByOPage(final Class<T> clazz,
			final String whereSql, final int from, final int size)
			throws Exception;

	/**
	 * 根据HQL分页查询
	 * 
	 * @param hql
	 * @param start
	 * @param limit
	 * @return
	 */
	public <T extends M> List<T> queryByHql(String hql, Integer start,
			Integer limit) throws Exception;

	public <T extends V> List<T> queryByVHql(String hql, Integer start,
			Integer limit) throws Exception;

	public <T extends Model> List<T> queryByOHql(String hql, Integer start,
			Integer limit) throws Exception;

	/**
	 * 根据SQL查询实体列表
	 * 
	 * @param sql
	 * @return
	 */
	public <T extends M> List<T> queryBySql(String sql, Class<T> clazz)
			throws Exception;

	public <T extends V> List<T> queryByVSql(String sql, Class<T> clazz)
			throws Exception;

	public <T extends Model> List<T> queryByOSql(String sql, Class<T> clazz)
			throws Exception;

	/**
	 * 根据SQL查询实体列表
	 * 
	 * @param sql
	 * @return
	 */
	public <T extends M> List<T> queryBySql(String sql) throws Exception;

	public <T extends V> List<T> queryByVSql(String sql) throws Exception;

	public <T extends Model> List<T> queryByOSql(String sql) throws Exception;

	/**
	 * 根据HQL查询条件查询总记录
	 * 
	 * @param whereSql
	 * @return
	 */
	public Number getCount(String hql) throws Exception;

	/**
	 * 添加实体
	 * 
	 * @param entity
	 */
	public M save(final M entity) throws Exception;
	
	public  void save(Object entity) throws Exception;

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	public M update(final M entity) throws Exception;

	/**
	 * 删除一个实体
	 * 
	 * @param entity
	 */
	public void delete(final M entity) throws Exception;

	/**
	 * 执行一条sql语句
	 * 
	 * @param sql
	 * @return
	 */
	public Number executeSql(String sql) throws Exception;

	/**
	 * 执行hql语句
	 * 
	 * @param hql
	 * @return
	 */
	public Number executeHql(String hql) throws Exception;

	/**
	 * 批量删除
	 * 
	 * @param os
	 * @throws Exception
	 */
	public void delete(List<M> entitys) throws Exception;

	/**
	 * 更新或删除
	 * 
	 * @param o
	 * @throws Exception
	 */
	public M saveOrUpdate(final M entity) throws Exception;

	
	/**
	 * 表单更新方法
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public M formUpdate(M entity) throws Exception;
	
	/**
	 * 手动提交到数据库存
	 */
	public void flush();
	/**
	 * 使用 Criteria查询方式
	 * 
	 * @param clazz
	 * @param cnd
	 * @param page
	 * @return
	 */
	public <T extends Model> List<T> query(Class<T> clazz, Condition cnd,
			Page page)throws Exception;

	public <T extends Model> T fetch(Class<T> c, String value)throws Exception;

	public <T extends Model> Number count(Class<T> c, Condition cnd)throws Exception;

	public <T extends Model> List<T> query(Class<T> c, Page page)throws Exception;

	public <T extends Model> List<T> query(Class<T> c, Condition cnd)throws Exception;

	public <T extends Model> void clear(Class<T> c)throws Exception;

	public <T extends Model> T fetch(Class<T> c, Condition cnd)throws Exception;

	public <T extends Model> T last(Class<T> c, Condition cnd)throws Exception;

	public <T extends Model> Criteria convertToCriteria(Class<T> c,
			Condition cnd)throws Exception;

	public <T extends Model> List<T> query(Criteria criteria)throws Exception;

	public <T extends Model> T last(Class<T> c)throws Exception;
	//public <T extends Model> List<T> queryVOBySql(String hql, V vo, Integer start,
			//Integer limit) throws Exception;
	public  float sum(String sql);

}
