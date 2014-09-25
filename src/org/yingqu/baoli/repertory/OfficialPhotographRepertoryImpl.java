package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.OfficialPhotograph;
import org.yingqu.baoli.irepertory.OfficialPhotographRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OfficialPhotographRepertoryImpl extends SimpleRepertoryHibernateImpl<OfficialPhotograph> implements OfficialPhotographRepertory {

	protected OfficialPhotographRepertoryImpl() {
		super(OfficialPhotograph.class);
	}

}
