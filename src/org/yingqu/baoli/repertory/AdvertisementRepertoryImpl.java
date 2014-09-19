package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.Advertisement;
import org.yingqu.baoli.irepertory.AdvertisementRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class AdvertisementRepertoryImpl extends SimpleRepertoryHibernateImpl<Advertisement> implements AdvertisementRepertory {

	protected AdvertisementRepertoryImpl() {
		super(Advertisement.class);
	}

}
