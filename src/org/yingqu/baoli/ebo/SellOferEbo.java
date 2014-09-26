package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.SellOfer;
import org.yingqu.baoli.ebi.SellOferEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class SellOferEbo extends SimpleEbo<SellOfer> implements SellOferEbi {

protected SellOferEbo()  {
		super(SellOfer.class);
	}
}
