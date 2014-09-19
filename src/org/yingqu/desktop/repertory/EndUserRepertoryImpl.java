package org.yingqu.desktop.repertory;

import org.yingqu.desktop.irepertory.EndUserRepertory;
import org.yingqu.desktop.model.EndUser;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class EndUserRepertoryImpl extends SimpleRepertoryHibernateImpl<EndUser>  implements EndUserRepertory{

	protected EndUserRepertoryImpl() {
		super( EndUser.class);
	}

}
