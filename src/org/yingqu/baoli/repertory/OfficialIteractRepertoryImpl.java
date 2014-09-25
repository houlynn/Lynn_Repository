package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.OfficialIteract;
import org.yingqu.baoli.irepertory.OfficialIteractRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OfficialIteractRepertoryImpl extends SimpleRepertoryHibernateImpl<OfficialIteract> implements OfficialIteractRepertory {

	protected OfficialIteractRepertoryImpl() {
		super(OfficialIteract.class);
	}

}
