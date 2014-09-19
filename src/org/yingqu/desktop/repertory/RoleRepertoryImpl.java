package org.yingqu.desktop.repertory;

import org.yingqu.desktop.irepertory.RoleRepertory;
import org.yingqu.desktop.model.Role;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepertoryImpl extends SimpleRepertoryHibernateImpl<Role>  implements RoleRepertory{

	protected RoleRepertoryImpl() {
		super( Role.class);
	}

}
