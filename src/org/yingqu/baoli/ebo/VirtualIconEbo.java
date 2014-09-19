package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.VirtualIcon;
import org.yingqu.baoli.ebi.VirtualIconEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class VirtualIconEbo extends SimpleEbo<VirtualIcon> implements VirtualIconEbi {

protected VirtualIconEbo()  {
		super(VirtualIcon.class);
	}
}
