package org.yingqu.desktop.ebo;


import org.yingqu.desktop.ebi.VDeptUserEbi;
import org.yingqu.desktop.model.view.VDeptUser;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class VDeptUserEbo extends SimpleEbo<VDeptUser> implements VDeptUserEbi {

	protected VDeptUserEbo() {
		super(VDeptUser.class);
	}


}
