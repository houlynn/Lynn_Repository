package org.yingqu.framework.repertory;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.persistence.Id;
import org.yingqu.framework.annotation.FetchProperty;
import org.yingqu.framework.assist.Condition;
import org.yingqu.framework.assist.Messenger;
import org.yingqu.framework.assist.Page;
import org.yingqu.framework.irepertory.Irepertory;
import org.yingqu.framework.log.AppLoggerFactory;
import org.yingqu.framework.model.BaseEntity;
import org.yingqu.framework.model.BaseViewModel;
import org.yingqu.framework.model.Model;
import org.yingqu.framework.utils.EntityUtil;
import org.yingqu.framework.utils.ModelUtil;
import org.yingqu.framework.utils.StringUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Criteria;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
* @author 作者 yingqu: 
* @version 创建时间：2014年7月9日 上午9:48:43 
* version 1.0
 */
public abstract class RepertoryImpl<M extends BaseEntity,V extends BaseViewModel> implements Irepertory< M, V> {

	protected final Class<? extends BaseEntity>  clazz;
	
	@Autowired
	private SessionFactory sf;
	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	protected RepertoryImpl(Class<M> clazz)
	{
		this.clazz=clazz;
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends M> T findById(Class<T> clazz, String id) throws Exception {
		// TODO Auto-generated method stub
		return  (T) sf.getCurrentSession().get(clazz.getName(), id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends V> T findByVId(Class<V> clazz, long id) throws Exception {
		// TODO Auto-generated method stub
		return  (T) sf.getCurrentSession().get(clazz.getName(), id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends V> T findByVId(Class<V> clazz, int id) throws Exception {
		// TODO Auto-generated method stub
		return  (T) sf.getCurrentSession().get(clazz.getName(), id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Model> T findByOId(Class<T> clazz, String id)
			throws Exception {
		// TODO Auto-generated method stub
		return  (T) sf.getCurrentSession().get(clazz.getName(), id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends M> List<T> findAll(Class<M> clazz) throws Exception {
		// TODO Auto-generated method stub
		List<T> list=null;
		list=sf.getCurrentSession().createQuery("from "+clazz.getName()).list();
        return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends V> List<T> findVAll(Class<V> clazz) throws Exception {
		// TODO Auto-generated method stub
		List<T> list=null;
		list=sf.getCurrentSession().createQuery("from "+clazz.getName()).list();
        return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Model> List<T> findOAll(Class<T> clazz) throws Exception {
		// TODO Auto-generated method stub
		List<T> list=null;
		list=sf.getCurrentSession().createQuery("from "+clazz.getName()).list();
        return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends M> T getEntityByHql(String hql) throws Exception {
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
	@SuppressWarnings("unchecked")
	@Override
	public <T extends V> T getEntityByVHql(String hql) throws Exception {
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
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Model> T getEntityByOHql(String hql) throws Exception {
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
	@SuppressWarnings("unchecked")
	@Override
	public <T extends M> List<T> queryByHql(String hql) throws Exception {
		// TODO Auto-generated method stub
		Query query=sf.getCurrentSession().createQuery(hql);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends V> List<T> queryByVHql(String hql) throws Exception {
		// TODO Auto-generated method stub
		Query query=sf.getCurrentSession().createQuery(hql);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Model> List<T> queryByOHql(String hql) throws Exception {
		// TODO Auto-generated method stub
		Query query=sf.getCurrentSession().createQuery(hql);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends M> List<M> findByPage(final Class<M> clazz,final String whereSql,
		final	int from, final int size) throws Exception {
		// TODO Auto-generated method stub
     	return sf.getCurrentSession().createQuery("from " + clazz.getName()+" where 1=1 "+whereSql)
						.setFirstResult(from).setMaxResults(size).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends V> List<T> findByVPage(final Class<V> clazz,final String whereSql,
			final	int from,final int size) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from " + clazz.getName()+" where 1=1 "+whereSql)
				.setFirstResult(from).setMaxResults(size).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Model> List<T> findByOPage(final Class<T> clazz,
			final	String whereSql,final int from,final int size) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from " + clazz.getName()+" where 1=1 "+whereSql)
				.setFirstResult(from).setMaxResults(size).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends M> List<T> queryByHql(String hql, Integer start,
			Integer limit) throws Exception {
		// TODO Auto-generated method stub
		Query query=sf.getCurrentSession().createQuery(hql);
		if(limit>0){
			query.setFirstResult(start);
			query.setMaxResults(limit);
		}
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends V> List<T> queryByVHql(String hql, Integer start,
			Integer limit) throws Exception {
		// TODO Auto-generated method stub
		Query query=sf.getCurrentSession().createQuery(hql);
		if(limit>0){
			query.setFirstResult(start);
			query.setMaxResults(limit);
		}
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Model> List<T> queryByOHql(String hql, Integer start,
			Integer limit) throws Exception {
		// TODO Auto-generated method stub
		Query query=sf.getCurrentSession().createQuery(hql);
		if(limit>0){
			query.setFirstResult(start);
			query.setMaxResults(limit);
		}
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends M> List<T> queryBySql(String sql, Class<T> clazz)
			throws Exception {
		// TODO Auto-generated method stub
	Query query = sf.getCurrentSession().createSQLQuery(sql);
		List<T> list = query.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends V> List<T> queryByVSql(String sql, Class<T> clazz)
			throws Exception {
		// TODO Auto-generated method stub
		Query query = sf.getCurrentSession().createSQLQuery(sql);
		List<T> list = query.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Model> List<T> queryByOSql(String sql, Class<T> clazz)
			throws Exception {
		// TODO Auto-generated method stub
		Query query = sf.getCurrentSession().createSQLQuery(sql);
		List<T> list = query.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends M> List<T> queryBySql(String sql) throws Exception {
		// TODO Auto-generated method stub
		Query query = sf.getCurrentSession().createSQLQuery(sql);
		List<T> list = query.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends V> List<T> queryByVSql(String sql) throws Exception {
		// TODO Auto-generated method stub
		Query query = sf.getCurrentSession().createSQLQuery(sql);
		List<T> list = query.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Model> List<T> queryByOSql(String sql) throws Exception {
		// TODO Auto-generated method stub
		Query query = sf.getCurrentSession().createSQLQuery(sql);
		List<T> list = query.list();
		return list;
	}
	@Override
	public Number getCount(String hql) throws Exception {
		// TODO Auto-generated method stub
		Query query = sf.getCurrentSession().createQuery(hql);
		Number count = (Number) query.uniqueResult();
		return count;
	}
	@Override
	public M save(M entity) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(entity);
		return entity;
	}
	@Override
	public M update(M entity) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(entity);
		return entity;
	}
	@Override
	public void delete(M entity) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(entity);
	}
	@Override
	public Number executeSql(String sql) throws Exception {
		// TODO Auto-generated method stub
		Long c = 0L;
		Query query = sf.getCurrentSession().createSQLQuery(sql);
		Object count = query.executeUpdate();
		if(null != count && StringUtil.isInteger(count.toString())) {
			c = Long.parseLong(count.toString());
		}
		return c;
	}
	@Override
	public Number executeHql(String hql) throws Exception {
		// TODO Auto-generated method stub
		return (Number) sf.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}
	@Override
	public void delete(List<M> entitys) throws Exception {
		// TODO Auto-generated method stub
		for(M m : entitys)
		{
			this.delete(m);
		}
		
	}
	@Override
	public M saveOrUpdate(M entity) throws Exception {
		// TODO Auto-generated method stub
		 sf.getCurrentSession().saveOrUpdate(entity);
		 return entity;
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Model> List<T> query(Class<T> clazz, Condition cnd,
			Page page) {
		// TODO Auto-generated method stub

        Criteria cri = sf.getCurrentSession().createCriteria(clazz);

        if (cnd != null)
            for (Messenger msg : cnd.getMessages()) {
                if (msg.criterion != null) cri.add(msg.criterion);
                if (msg.order != null) cri.addOrder(msg.order);
                if (msg.max != null) cri.setMaxResults(msg.max);
            }

        if (page != null) {
            int limitFrom = page.getPageSize() * (page.getPageNumber() - 1);
            int limitTo = page.getPageSize() * page.getPageNumber();

            cri.setFirstResult(limitFrom);
            cri.setMaxResults(limitTo - limitFrom);
        }

        return cri.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Model> T fetch(Class<T> c, String value) throws Exception {
		// TODO Auto-generated method stub
        Field[] fields = c.getDeclaredFields();

        for (Field f : fields) {
           if(null != f.getAnnotation(FetchProperty.class)){
                String sql = String.format("from %s where %s = ?", c.getName(), f.getName());
                Query query = sf.getCurrentSession().createQuery(sql);
                query.setString(0, value);
                return (T) query.uniqueResult();
            }
        }
        return null;
	}
	@Override
	public <T extends Model> Number count(Class<T> c, Condition cnd) throws Exception  {
		// TODO Auto-generated method stub
	      Criteria cri = sf.getCurrentSession().createCriteria(c);

	        if (cnd != null)
	            for (Messenger msg : cnd.getMessages()) {
	                if (msg.criterion != null) cri.add(msg.criterion);
	                if (msg.order != null) cri.addOrder(msg.order);
	            }

	        return (Number) cri.setProjection(Projections.rowCount()).uniqueResult();
	}
	@Override
	public <T extends Model> List<T> query(Class<T> c, Page page) throws Exception{
		// TODO Auto-generated method stub
		  return this.query(c, null, page);
	}
	@Override
	public <T extends Model> List<T> query(Class<T> c, Condition cnd)  throws Exception{
		// TODO Auto-generated method stub
		   return this.query(c, cnd, null);
	}
	@Override
	public <T extends Model> void clear(Class<T> c) throws Exception {
		// TODO Auto-generated method stub
		  String sql = String.format("delete %s", c.getName());
	        Query query = sf.getCurrentSession().createQuery(sql);
	        query.executeUpdate();
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Model> T fetch(Class<T> c, Condition cnd) throws Exception {
		// TODO Auto-generated method stub
	    Criteria cri = sf.getCurrentSession().createCriteria(c);

        for (Messenger msg : cnd.getMessages()) {
            if (msg.criterion != null) cri.add(msg.criterion);
            if (msg.order != null) cri.addOrder(msg.order);
        }

        return (T) cri.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Model> T last(Class<T> c, Condition cnd) throws Exception {
		// TODO Auto-generated method stub

        Criteria cri = sf.getCurrentSession().createCriteria(c);

        if(cnd != null)
        for (Messenger msg : cnd.getMessages()) {
            if (msg.criterion != null) cri.add(msg.criterion);
            if (msg.order != null) cri.addOrder(msg.order);
        }

        cri.setMaxResults(1);

        for(Field f : c.getDeclaredFields()){
            if( null != f.getAnnotation(Id.class)){
                cri.addOrder(Order.desc(f.getName()));
                return (T) cri.uniqueResult();
            }
        }

        cri.addOrder(Order.desc("id"));

        return (T) cri.uniqueResult();
	}
	@Override
	public <T extends Model> Criteria convertToCriteria(Class<T> c,
			Condition cnd) throws Exception {
		// TODO Auto-generated method stub
	     Criteria cri = sf.getCurrentSession().createCriteria(c);

	        for (Messenger msg : cnd.getMessages()) {
	            if (msg.criterion != null) cri.add(msg.criterion);
	            if (msg.order != null) cri.addOrder(msg.order);
	        }

	        return cri;
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Model> List<T> query(Criteria criteria) throws Exception {
		// TODO Auto-generated method stub
		   return criteria.list();
	}
	@Override
	public <T extends Model> T last(Class<T> c)  throws Exception{
		// TODO Auto-generated method stub
		  return this.last(c, null);
	}
	@SuppressWarnings("unchecked")
	@Override
	public M formUpdate(M obj) throws Exception {
		// TODO Auto-generated method stub
		String pkName=ModelUtil.getClassPkName(obj.getClass());
		String pkValue=(String) EntityUtil.getPropertyValue(obj, pkName);
		//查询当前更新的实体
		 M entity=(M) sf.getCurrentSession().get(obj.getClass(), pkValue);
		 BeanUtils.copyProperties(entity,obj);
		 sf.getCurrentSession().update(entity);
		 return ((M) entity);
	}
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		sf.getCurrentSession().flush();
		
	}
	@Override
	public void save(Object entity) throws Exception {
		sf.getCurrentSession().save(entity);
		
	}

	public  float sum(String sql){
		 StringBuffer buffer=new StringBuffer();
		  sf.getCurrentSession().doWork(conn->{
				 Statement smnt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet resut= smnt.executeQuery(sql);
			     if(resut.next()){
			    	 buffer.append(resut.getObject(1));
			     }
	});
		  if(StringUtil.isEmpty(buffer.toString())){
			  return 0;
		  }else{
		 return Float.parseFloat( buffer.toString());
		  }
	}
	
}
