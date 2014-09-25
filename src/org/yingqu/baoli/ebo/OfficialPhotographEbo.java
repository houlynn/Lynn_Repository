package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.OfficialPhotograph;
import org.yingqu.baoli.ebi.OfficialPhotographEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class OfficialPhotographEbo extends SimpleEbo<OfficialPhotograph> implements OfficialPhotographEbi {

protected OfficialPhotographEbo()  {
		super(OfficialPhotograph.class);
	}
}
