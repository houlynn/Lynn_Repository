package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.Feedback;
import org.yingqu.baoli.ebi.FeedbackEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class FeedbackEbo extends SimpleEbo<Feedback> implements FeedbackEbi {

protected FeedbackEbo()  {
		super(Feedback.class);
	}
}
