package org.yingqu.framework.irepertory;

import java.util.List;

import org.hibernate.SessionFactory;
import org.yingqu.framework.model.Model;

public interface CommonIrpertory {

	public abstract SessionFactory getSf();

	public abstract void setSf(SessionFactory sf);

	/**
	 * 根据ID加载一个实体
	 * @param clazz
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public abstract <T extends Model> T findByOId(Class<T> clazz, String id)
			throws Exception;

	/**
	 * 查询所有实体
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public abstract <T extends Model> List<T> findAll(Class<T> clazz)
			throws Exception;

	/**
	 * 根据HSQL 获取一个
	 * @param hql
	 * @return
	 * @throws Exception
	 */

	public abstract <T extends Model> T getEntityByHql(Class<T> clazz,
			String hql) throws Exception;

	/**
	 * 更新一个实体
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public abstract <T extends Model> T update(T entity) throws Exception;

	/***
	 * 加载一笔数据
	 * @param hql
	 * @param start
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public abstract List<?> queryByHql(String hql, Integer start, Integer limit)
			throws Exception;

	/**
	 * 更加ID删除
	 * @param id
	 */
	public abstract <T extends Model> void removeById(String id, Class<T> clazz)
			throws Exception;

	/**
	 * 获取一笔数
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	public abstract List<?> queryByHql(String hql) throws Exception;
	
	/**
	 * 添加一个实体
	 */
	public <T extends Model> T save(T entity) throws Exception ;
	
	
	
	/**
	 * 获取count
	 * @param hql
	 * @return
	 * @throws Exception
	 */
		public Integer getCount(String hql)  throws Exception ;
		

}