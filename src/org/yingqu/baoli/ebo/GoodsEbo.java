package org.yingqu.baoli.ebo;
import java.security.acl.NotOwnerException;
import java.util.Set;

import org.yingqu.baoli.model.Goods;
import org.yingqu.baoli.model.OrderContent;
import org.yingqu.baoli.model.OrderItem;
import org.yingqu.baoli.model.po.OderPro;
import org.yingqu.baoli.ebi.GoodsEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class GoodsEbo extends SimpleEbo<Goods> implements GoodsEbi  {

protected GoodsEbo()  {
		super(Goods.class);
	}

@Override
public void saveOrder(OrderContent content) throws Exception {
	// TODO Auto-generated method stub
	 Set<OrderItem> items=content.getItems();
	  repertory.save(content);
	  debug("保存了content订单");
	 if(content.getItems()==null||content.getItems().size()==0){
		throw new NotOwnerException();
	 }
	 for(OrderItem item :items){
		 item.setOrderContent(content);
		 repertory.save(item);
		  debug("保存了订单明细");
	 }
}
}
