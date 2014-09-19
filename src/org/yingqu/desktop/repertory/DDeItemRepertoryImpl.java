package org.yingqu.desktop.repertory;

import org.yingqu.desktop.irepertory.DDeItemRepertory;
import org.yingqu.desktop.model.DictionaryItem;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class DDeItemRepertoryImpl extends SimpleRepertoryHibernateImpl<DictionaryItem>  implements DDeItemRepertory{

	protected DDeItemRepertoryImpl() {
		super(DictionaryItem.class);
	}

}
