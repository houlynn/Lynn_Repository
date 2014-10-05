package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.Village;
import org.yingqu.baoli.ebi.VillageEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class VillageEbo extends SimpleEbo<Village> implements VillageEbi {

protected VillageEbo()  {
		super(Village.class);
	}
}
