package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.SellOferImg;
import org.yingqu.baoli.irepertory.SellOferImgRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class SellOferImgRepertoryImpl extends SimpleRepertoryHibernateImpl<SellOferImg> implements SellOferImgRepertory {

	protected SellOferImgRepertoryImpl() {
		super(SellOferImg.class);
	}

}
