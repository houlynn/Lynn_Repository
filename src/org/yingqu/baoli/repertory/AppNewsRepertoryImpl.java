package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.AppNews;
import org.yingqu.baoli.irepertory.AppNewsRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class AppNewsRepertoryImpl extends SimpleRepertoryHibernateImpl<AppNews> implements AppNewsRepertory {

	protected AppNewsRepertoryImpl() {
		super(AppNews.class);
	}

}
