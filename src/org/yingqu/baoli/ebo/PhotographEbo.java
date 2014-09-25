package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.Photograph;
import org.yingqu.baoli.ebi.PhotographEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class PhotographEbo extends SimpleEbo<Photograph> implements PhotographEbi {

protected PhotographEbo()  {
		super(Photograph.class);
	}
}
