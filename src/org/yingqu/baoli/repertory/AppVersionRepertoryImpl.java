package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.AppVersion;
import org.yingqu.baoli.irepertory.AppVersionRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class AppVersionRepertoryImpl extends SimpleRepertoryHibernateImpl<AppVersion> implements AppVersionRepertory {

	protected AppVersionRepertoryImpl() {
		super(AppVersion.class);
	}

}
