package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.PayKey;
import org.yingqu.baoli.irepertory.PayKeyRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class PayKeyRepertoryImpl extends SimpleRepertoryHibernateImpl<PayKey> implements PayKeyRepertory {

	protected PayKeyRepertoryImpl() {
		super(PayKey.class);
	}

}
