package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.Photograph;
import org.yingqu.baoli.irepertory.PhotographRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class PhotographRepertoryImpl extends SimpleRepertoryHibernateImpl<Photograph> implements PhotographRepertory {

	protected PhotographRepertoryImpl() {
		super(Photograph.class);
	}

}
