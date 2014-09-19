package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.VirtualIcon;
import org.yingqu.baoli.irepertory.VirtualIconRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class VirtualIconRepertoryImpl extends SimpleRepertoryHibernateImpl<VirtualIcon> implements VirtualIconRepertory {

	protected VirtualIconRepertoryImpl() {
		super(VirtualIcon.class);
	}

}
