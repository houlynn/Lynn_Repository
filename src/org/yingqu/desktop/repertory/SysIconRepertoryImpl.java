package org.yingqu.desktop.repertory;

import org.yingqu.desktop.irepertory.SysIconRepertory;
import org.yingqu.desktop.model.SysIcon;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class SysIconRepertoryImpl extends SimpleRepertoryHibernateImpl<SysIcon>  implements SysIconRepertory{

	protected SysIconRepertoryImpl() {
		super( SysIcon.class);
	}

}
