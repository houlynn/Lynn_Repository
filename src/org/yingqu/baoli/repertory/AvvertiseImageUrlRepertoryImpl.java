package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.AvvertiseImageUrl;
import org.yingqu.baoli.irepertory.AvvertiseImageUrlRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class AvvertiseImageUrlRepertoryImpl extends SimpleRepertoryHibernateImpl<AvvertiseImageUrl> implements AvvertiseImageUrlRepertory {

	protected AvvertiseImageUrlRepertoryImpl() {
		super(AvvertiseImageUrl.class);
	}

}
