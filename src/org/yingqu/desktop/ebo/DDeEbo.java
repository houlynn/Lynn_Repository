package org.yingqu.desktop.ebo;


import org.yingqu.desktop.ebi.DDeEbi;
import org.yingqu.desktop.model.Dictionary;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class DDeEbo extends SimpleEbo<Dictionary> implements DDeEbi {

	protected DDeEbo() {
		super(Dictionary.class);
		// TODO Auto-generated constructor stub
	}


}
