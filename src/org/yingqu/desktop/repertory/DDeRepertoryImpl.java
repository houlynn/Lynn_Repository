package org.yingqu.desktop.repertory;

import org.yingqu.desktop.irepertory.DDeRepertory;
import org.yingqu.desktop.model.Dictionary;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class DDeRepertoryImpl extends SimpleRepertoryHibernateImpl<Dictionary>  implements DDeRepertory{

	protected DDeRepertoryImpl() {
		super(Dictionary.class);
	}

}
