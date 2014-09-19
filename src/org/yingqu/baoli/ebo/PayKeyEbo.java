package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.PayKey;
import org.yingqu.baoli.ebi.PayKeyEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class PayKeyEbo extends SimpleEbo<PayKey> implements PayKeyEbi {

protected PayKeyEbo()  {
		super(PayKey.class);
	}
}
