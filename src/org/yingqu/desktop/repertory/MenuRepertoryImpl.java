package org.yingqu.desktop.repertory;

import org.yingqu.desktop.irepertory.MenuRepertory;
import org.yingqu.desktop.model.Menu;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class MenuRepertoryImpl extends SimpleRepertoryHibernateImpl<Menu>  implements MenuRepertory{

	protected MenuRepertoryImpl() {
		super( Menu.class);
	}

}
