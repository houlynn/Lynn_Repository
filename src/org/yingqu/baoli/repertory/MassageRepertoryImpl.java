package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.Massage;
import org.yingqu.baoli.irepertory.MassageRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class MassageRepertoryImpl extends SimpleRepertoryHibernateImpl<Massage> implements MassageRepertory {

	protected MassageRepertoryImpl() {
		super(Massage.class);
	}

}
