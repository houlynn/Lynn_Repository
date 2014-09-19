package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.OrderItem;
import org.yingqu.baoli.ebi.OrderItemEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class OrderItemEbo extends SimpleEbo<OrderItem> implements OrderItemEbi {

protected OrderItemEbo()  {
		super(OrderItem.class);
	}
}
