package org.yingqu.desktop.ebo;


import org.yingqu.desktop.ebi.MenuEbi;
import org.yingqu.desktop.model.Menu;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class MenuEbo extends SimpleEbo<Menu> implements MenuEbi {

	protected MenuEbo() {
		super(Menu.class);
		// TODO Auto-generated constructor stub
	}


}
