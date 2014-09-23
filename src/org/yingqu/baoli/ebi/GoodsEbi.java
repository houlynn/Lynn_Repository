package org.yingqu.baoli.ebi;
import org.yingqu.baoli.model.Goods;
import org.yingqu.baoli.model.OrderContent;
import org.yingqu.framework.ebi.SimpleEbi;

public interface GoodsEbi extends SimpleEbi<Goods>  {

	public OrderContent saveOrder(OrderContent content) throws Exception;
}
