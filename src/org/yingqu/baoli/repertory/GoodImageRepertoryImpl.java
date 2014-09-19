package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.GoodImage;
import org.yingqu.baoli.irepertory.GoodImageRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class GoodImageRepertoryImpl extends SimpleRepertoryHibernateImpl<GoodImage> implements GoodImageRepertory {

	protected GoodImageRepertoryImpl() {
		super(GoodImage.class);
	}

}
