package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.Village;
import org.yingqu.baoli.irepertory.VillageRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class VillageRepertoryImpl extends SimpleRepertoryHibernateImpl<Village> implements VillageRepertory {

	protected VillageRepertoryImpl() {
		super(Village.class);
	}

}
