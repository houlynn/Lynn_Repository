package org.yingqu.desktop.ebo;


import org.yingqu.desktop.ebi.DDeItemEbi;
import org.yingqu.desktop.model.DictionaryItem;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class DDeItemEbo extends SimpleEbo<DictionaryItem> implements DDeItemEbi {

	protected DDeItemEbo() {
		super(DictionaryItem.class);
		// TODO Auto-generated constructor stub
	}


}
