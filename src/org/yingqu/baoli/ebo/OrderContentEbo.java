package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.OrderContent;
import org.yingqu.baoli.ebi.OrderContentEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class OrderContentEbo extends SimpleEbo<OrderContent> implements OrderContentEbi {

protected OrderContentEbo()  {
		super(OrderContent.class);
	}
}
