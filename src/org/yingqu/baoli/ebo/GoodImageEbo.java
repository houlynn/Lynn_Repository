package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.GoodImage;
import org.yingqu.baoli.ebi.GoodImageEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class GoodImageEbo extends SimpleEbo<GoodImage> implements GoodImageEbi {

protected GoodImageEbo()  {
		super(GoodImage.class);
	}
}
