package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.SellOferImg;
import org.yingqu.baoli.ebi.SellOferImgEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class SellOferImgEbo extends SimpleEbo<SellOferImg> implements SellOferImgEbi {

protected SellOferImgEbo()  {
		super(SellOferImg.class);
	}
}
