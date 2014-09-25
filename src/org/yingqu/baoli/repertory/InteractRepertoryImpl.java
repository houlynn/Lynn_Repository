package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.Interact;
import org.yingqu.baoli.irepertory.InteractRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class InteractRepertoryImpl extends SimpleRepertoryHibernateImpl<Interact> implements InteractRepertory {

	protected InteractRepertoryImpl() {
		super(Interact.class);
	}

}
