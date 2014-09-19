package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.DeptImageUrl;
import org.yingqu.baoli.irepertory.DeptImageUrlRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class DeptImageUrlRepertoryImpl extends SimpleRepertoryHibernateImpl<DeptImageUrl> implements DeptImageUrlRepertory {

	protected DeptImageUrlRepertoryImpl() {
		super(DeptImageUrl.class);
	}

}
