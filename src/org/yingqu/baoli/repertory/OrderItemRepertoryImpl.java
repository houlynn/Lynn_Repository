package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.OrderItem;
import org.yingqu.baoli.irepertory.OrderItemRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemRepertoryImpl extends SimpleRepertoryHibernateImpl<OrderItem> implements OrderItemRepertory {

	protected OrderItemRepertoryImpl() {
		super(OrderItem.class);
	}

}
