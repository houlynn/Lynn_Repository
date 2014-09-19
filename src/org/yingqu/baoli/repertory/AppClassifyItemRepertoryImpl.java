package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.AppClassifyItem;
import org.yingqu.baoli.irepertory.AppClassifyItemRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class AppClassifyItemRepertoryImpl extends SimpleRepertoryHibernateImpl<AppClassifyItem> implements AppClassifyItemRepertory {

	protected AppClassifyItemRepertoryImpl() {
		super(AppClassifyItem.class);
	}

}
