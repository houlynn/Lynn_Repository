package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.AppVersion;
import org.yingqu.baoli.ebi.AppVersionEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class AppVersionEbo extends SimpleEbo<AppVersion> implements AppVersionEbi {

protected AppVersionEbo()  {
		super(AppVersion.class);
	}
}
