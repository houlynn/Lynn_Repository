package org.yingqu.desktop.repertory;

import org.yingqu.desktop.irepertory.VDeptUserRepertory;
import org.yingqu.desktop.model.view.VDeptUser;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class VDeptUserRepertoryImpl extends SimpleRepertoryHibernateImpl<VDeptUser>  implements VDeptUserRepertory{

	protected VDeptUserRepertoryImpl() {
		super( VDeptUser.class);
	}

}
