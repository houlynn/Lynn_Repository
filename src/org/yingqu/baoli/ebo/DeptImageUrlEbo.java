package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.DeptImageUrl;
import org.yingqu.baoli.ebi.DeptImageUrlEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class DeptImageUrlEbo extends SimpleEbo<DeptImageUrl> implements DeptImageUrlEbi {

protected DeptImageUrlEbo()  {
		super(DeptImageUrl.class);
	}
}
