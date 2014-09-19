package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.Merchant;
import org.yingqu.baoli.irepertory.MerchantRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantRepertoryImpl extends SimpleRepertoryHibernateImpl<Merchant> implements MerchantRepertory {

	protected MerchantRepertoryImpl() {
		super(Merchant.class);
	}

}
