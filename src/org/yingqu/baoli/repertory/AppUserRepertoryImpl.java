package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.AppUser;
import org.yingqu.baoli.irepertory.AppUserRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserRepertoryImpl extends SimpleRepertoryHibernateImpl<AppUser> implements AppUserRepertory {

	protected AppUserRepertoryImpl() {
		super(AppUser.class);
	}

}
