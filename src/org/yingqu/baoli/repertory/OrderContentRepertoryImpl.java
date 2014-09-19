package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.OrderContent;
import org.yingqu.baoli.irepertory.OrderContentRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OrderContentRepertoryImpl extends SimpleRepertoryHibernateImpl<OrderContent> implements OrderContentRepertory {

	protected OrderContentRepertoryImpl() {
		super(OrderContent.class);
	}

}
