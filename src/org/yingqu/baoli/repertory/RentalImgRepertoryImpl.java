package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.RentalImg;
import org.yingqu.baoli.irepertory.RentalImgRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class RentalImgRepertoryImpl extends SimpleRepertoryHibernateImpl<RentalImg> implements RentalImgRepertory {

	protected RentalImgRepertoryImpl() {
		super(RentalImg.class);
	}

}
