package org.yingqu.desktop.ebo;


import org.yingqu.desktop.ebi.RoleEbi;
import org.yingqu.desktop.model.Role;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class RoleEbo extends SimpleEbo<Role> implements RoleEbi {

	protected RoleEbo() {
		super(Role.class);
	}


}
