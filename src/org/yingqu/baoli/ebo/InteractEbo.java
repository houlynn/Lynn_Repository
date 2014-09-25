package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.Interact;
import org.yingqu.baoli.ebi.InteractEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class InteractEbo extends SimpleEbo<Interact> implements InteractEbi {

protected InteractEbo()  {
		super(Interact.class);
	}
}
