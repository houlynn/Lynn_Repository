package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.SellOfer;
import org.yingqu.baoli.irepertory.SellOferRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class SellOferRepertoryImpl extends SimpleRepertoryHibernateImpl<SellOfer> implements SellOferRepertory {

	protected SellOferRepertoryImpl() {
		super(SellOfer.class);
	}

}
