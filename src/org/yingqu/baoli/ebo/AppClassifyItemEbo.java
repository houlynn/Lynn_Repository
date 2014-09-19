package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.AppClassifyItem;
import org.yingqu.baoli.ebi.AppClassifyItemEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class AppClassifyItemEbo extends SimpleEbo<AppClassifyItem> implements AppClassifyItemEbi {

protected AppClassifyItemEbo()  {
		super(AppClassifyItem.class);
	}
}
