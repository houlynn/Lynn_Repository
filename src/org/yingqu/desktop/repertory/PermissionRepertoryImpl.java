package org.yingqu.desktop.repertory;

import org.yingqu.desktop.irepertory.PermissionRepertory;
import org.yingqu.desktop.model.Permission;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class PermissionRepertoryImpl extends SimpleRepertoryHibernateImpl<Permission>  implements PermissionRepertory{

	protected PermissionRepertoryImpl() {
		super( Permission.class);
	}

}
