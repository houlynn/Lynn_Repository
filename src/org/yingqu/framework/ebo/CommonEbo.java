package org.yingqu.framework.ebo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yingqu.framework.ebi.CommonEbi;
import org.yingqu.framework.irepertory.CommonIrpertory;
import org.yingqu.framework.model.Model;
import org.yingqu.framework.model.vo.PModel;

@Service
public class CommonEbo implements CommonEbi {

	@Autowired
	private CommonIrpertory ci;
	public CommonIrpertory getCi() {
		return ci;
	}
	public void setCi(CommonIrpertory ci) {
		this.ci = ci;
	}


	@Override
	public <T extends Model> T findByOId(Class<T> clazz, String id)
			throws Exception {
		// TODO Auto-generated method stub
		return ci.findByOId(clazz, id);
	}

	@Override
	public <T extends Model> List<T> findAll(Class<T> clazz) throws Exception {
		// TODO Auto-generated method stub
		return ci.findAll(clazz);
	}

	@Override
	public <T extends Model> T getEntityByHql(Class<T> clazz, String hql)
			throws Exception {
		// TODO Auto-generated method stub
		return ci.getEntityByHql(clazz, hql);
	}

	@Override
	public <T extends Model> T update(T entity) throws Exception {
		// TODO Auto-generated method stub
		return ci.update(entity);
	}

	@Override
	public List<?> queryByHql(String hql, Integer start, Integer limit)
			throws Exception {
		// TODO Auto-generated method stub
		return ci.queryByHql(hql, start, limit);
	}

	@Override
	public <T extends Model> void removeById(String id, Class<T> clazz)
			throws Exception {
		// TODO Auto-generated method stub
		ci.removeById(id, clazz);

	}

	@Override
	public List<?> queryByHql(String hql) throws Exception {
		// TODO Auto-generated method stub
		return ci.queryByHql(hql);
	}

	@Override
	public <T extends Model> T save(T entity) throws Exception {
		// TODO Auto-generated method stub
		return ci.save(entity);
	}
	@Override
	public Integer getCount(String hql) throws Exception {
		// TODO Auto-generated method stub
		return ci.getCount(hql);
	}
	@Override
	public Object updateByPhone(PModel entity) throws Exception {
		// TODO Auto-generated method stub
		return ci.updateByPhone(entity);
	}

}
