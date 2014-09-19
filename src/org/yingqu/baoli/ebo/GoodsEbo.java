package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.Goods;
import org.yingqu.baoli.ebi.GoodsEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class GoodsEbo extends SimpleEbo<Goods> implements GoodsEbi {

protected GoodsEbo()  {
		super(Goods.class);
	}
}
