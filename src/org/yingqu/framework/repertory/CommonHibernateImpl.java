package org.yingqu.framework.repertory;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yingqu.framework.irepertory.CommonIrpertory;
import org.yingqu.framework.log.AppLoggerFactory;
import org.yingqu.framework.model.Model;
import org.yingqu.framework.model.vo.PModel;
import org.yingqu.framework.utils.EntityUtil;
import org.yingqu.framework.utils.ModelUtil;
import org.yingqu.framework.utils.StringUtil;

@Repository
public class CommonHibernateImpl implements CommonIrpertory {

	
	
	@Autowired
	private SessionFactory sf;
	/* (non-Javadoc)
	 * @see org.yingqu.framework.repertory.CommonIrpertory#getSf()
	 */
	@Override
	public SessionFactory getSf() {
		return sf;
	}
	/* (non-Javadoc)
	 * @see org.yingqu.framework.repertory.CommonIrpertory#setSf(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	/* (non-Javadoc)
	 * @see org.yingqu.framework.repertory.CommonIrpertory#findByOId(java.lang.Class, java.lang.String)
	 */
	@Override
	public <T extends Model> T findByOId(Class<T> clazz, String id)
			throws Exception {
		// TODO Auto-generated method stub
		return  (T) sf.getCurrentSession().get(clazz.getName(), id);
	}
	
	
	/* (non-Javadoc)
	 * @see org.yingqu.framework.repertory.CommonIrpertory#findAll(java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> findAll(Class<T> clazz) throws Exception {
		// TODO Auto-generated method stub
		List<T> list=null;
		list=sf.getCurrentSession().createQuery("from "+clazz.getName()).list();
        return list;
	}
	
	/* (non-Javadoc)
	 * @see org.yingqu.framework.repertory.CommonIrpertory#getEntityByHql(java.lang.Class, java.lang.String)
	 */
	
	@Override
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
	
	
	/* (non-Javadoc)
	 * @see org.yingqu.framework.repertory.CommonIrpertory#update(T)
	 */
	@Override
	public <T extends Model>  T update(T entity)  throws Exception {
		// TODO Auto-generated method stub
		String pkName=ModelUtil.getClassPkName(entity.getClass());
		String pkValue=(String) EntityUtil.getPropertyValue(entity,pkName);
		//查询当前更新的实体
		 T model=(T) sf.getCurrentSession().get(entity.getClass(), pkValue);
		// EntityUtil.copyNewField(model, entity);
		 BeanUtils.copyProperties(model,entity );
		sf.getCurrentSession().update(model);
		return model;
	}
	
	
	
	/* (non-Javadoc)
	 * @see org.yingqu.framework.repertory.CommonIrpertory#queryByHql(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<?> queryByHql(String hql, Integer start, Integer limit)  throws Exception{
		// TODO Auto-generated method stub
		Query query=sf.getCurrentSession().createQuery(hql);
		if(limit>0){
			query.setFirstResult(start);
			query.setMaxResults(limit);
		}
		return query.list();
	}
	
	/* (non-Javadoc)
	 * @see org.yingqu.framework.repertory.CommonIrpertory#removeById(java.lang.String, java.lang.Class)
	 */
   @Override
public <T extends Model> void removeById(String id,Class<T> clazz) throws Exception {
		Object obj=sf.getCurrentSession().load(clazz, id);
		sf.getCurrentSession().delete(obj);
	   
   }
	
/* (non-Javadoc)
 * @see org.yingqu.framework.repertory.CommonIrpertory#queryByHql(java.lang.String)
 */
   @Override
public List<?> queryByHql(String hql)  throws Exception{
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery(hql).list();
	}
   
   /* (non-Javadoc)
    * @see org.yingqu.framework.repertory.CommonIrpertory#queryByHql(java.lang.String)
    */
   @Override
public <T extends Model> T save(T entity) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(entity);
		return entity;
	}
   /* (non-Javadoc)
    * @see org.yingqu.framework.repertory.CommonIrpertory#queryByHql(java.lang.String)
    */
@Override
public Integer getCount(String hql) throws Exception {
	// TODO Auto-generated method stub
	Integer c = 0;
	Query query = sf.getCurrentSession().createQuery(hql);
	Object count = query.uniqueResult();
	if(null != count && StringUtil.isInteger(count.toString())) {
		c = Integer.parseInt(count.toString());
	}else{
		c=0;
	}
	return c;
}

/* (non-Javadoc)
 * @see org.yingqu.framework.repertory.updateByPhone#queryByHql(PModel entity )
 */
@Override
public Object updateByPhone(PModel entity) throws Exception {
	// TODO Auto-generated method stub
	String pkName=ModelUtil.getClassPkName(entity.getClazz());
	String pkValue=(String) EntityUtil.getPropertyValue(entity,pkName);
	//查询当前更新的实体
	 Object model=sf.getCurrentSession().get(entity.getClazz(), pkValue);
	 BeanUtils.copyProperties(model,entity );
	sf.getCurrentSession().update(model);
	return model;
}


	
}
