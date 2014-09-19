package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.Feedback;
import org.yingqu.baoli.irepertory.FeedbackRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class FeedbackRepertoryImpl extends SimpleRepertoryHibernateImpl<Feedback> implements FeedbackRepertory {

	protected FeedbackRepertoryImpl() {
		super(Feedback.class);
	}

}
