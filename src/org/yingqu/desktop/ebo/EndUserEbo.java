package org.yingqu.desktop.ebo;


import org.yingqu.desktop.ebi.EndUserEbi;
import org.yingqu.desktop.model.EndUser;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class EndUserEbo extends SimpleEbo<EndUser> implements EndUserEbi {

	protected EndUserEbo() {
	
		super(EndUser.class);
		System.out.println("EndUserEbo ivokeing ");
	}


}
