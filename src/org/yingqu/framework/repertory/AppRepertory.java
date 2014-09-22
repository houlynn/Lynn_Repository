package org.yingqu.framework.repertory;

import java.util.List;

import org.hibernate.NonUniqueResultException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.yingqu.framework.log.AppLoggerFactory;
import org.yingqu.framework.model.Model;

public class AppRepertory {

	
	
	@Autowired
	private SessionFactory sf;
	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	/**
	 * 根据ID加载一个实体
	 * @param clazz
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public <T extends Model> T findByOId(Class<T> clazz, String id)
			throws Exception {
		// TODO Auto-generated method stub
		return  (T) sf.getCurrentSession().get(clazz.getName(), id);
	}
	
	
	/**
	 * 查询所有实体
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public <T extends Model> List<T> findAll(Class<T> clazz) throws Exception {
		// TODO Auto-generated method stub
		List<T> list=null;
		list=sf.getCurrentSession().createQuery("from "+clazz.getName()).list();
        return list;
	}
	
	/**
	 * 根据HSQL 获取一个
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	
	public <T extends Model> T getEntityByHql(Class<T>  clazz, String hql) throws Exception {
		// TODO Auto-generated method stub
		T datas=null;
		try
		{
			datas=(T) sf.getCurrentSession().createQuery(hql).uniqueResult();
		}catch(NonUniqueResultException e)
		{
			AppLoggerFactory.getyingquLogger(clazz).error("获取数据大于一条！");
			AppLoggerFactory.getyingquLogger(clazz).error(e);
			throw e ;
		}
		return datas;
	}
	
	
}
