package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.OfficialIteract;
import org.yingqu.baoli.ebi.OfficialIteractEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class OfficialIteractEbo extends SimpleEbo<OfficialIteract> implements OfficialIteractEbi {

protected OfficialIteractEbo()  {
		super(OfficialIteract.class);
	}
}
