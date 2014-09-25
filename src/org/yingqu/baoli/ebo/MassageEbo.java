package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.Massage;
import org.yingqu.baoli.ebi.MassageEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class MassageEbo extends SimpleEbo<Massage> implements MassageEbi {

protected MassageEbo()  {
		super(Massage.class);
	}
}
