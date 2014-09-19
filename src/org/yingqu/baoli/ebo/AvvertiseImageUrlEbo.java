package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.AvvertiseImageUrl;
import org.yingqu.baoli.ebi.AvvertiseImageUrlEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class AvvertiseImageUrlEbo extends SimpleEbo<AvvertiseImageUrl> implements AvvertiseImageUrlEbi {

protected AvvertiseImageUrlEbo()  {
		super(AvvertiseImageUrl.class);
	}
}
