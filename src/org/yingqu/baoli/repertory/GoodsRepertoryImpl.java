package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.Goods;
import org.yingqu.baoli.irepertory.GoodsRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsRepertoryImpl extends SimpleRepertoryHibernateImpl<Goods> implements GoodsRepertory {


	protected GoodsRepertoryImpl() {
		super(Goods.class);
	}

}
