package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.AppNews;
import org.yingqu.baoli.ebi.AppNewsEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class AppNewsEbo extends SimpleEbo<AppNews> implements AppNewsEbi {

protected AppNewsEbo()  {
		super(AppNews.class);
	}
}
