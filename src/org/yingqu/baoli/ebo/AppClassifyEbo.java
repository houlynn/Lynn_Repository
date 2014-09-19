package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.AppClassify;
import org.yingqu.baoli.ebi.AppClassifyEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class AppClassifyEbo extends SimpleEbo<AppClassify> implements AppClassifyEbi {

protected AppClassifyEbo()  {
		super(AppClassify.class);
	}
}
