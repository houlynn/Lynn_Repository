package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.AppClassify;
import org.yingqu.baoli.irepertory.AppClassifyRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class AppClassifyRepertoryImpl extends SimpleRepertoryHibernateImpl<AppClassify> implements AppClassifyRepertory {

	protected AppClassifyRepertoryImpl() {
		super(AppClassify.class);
	}

}
