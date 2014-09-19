package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.Merchant;
import org.yingqu.baoli.ebi.MerchantEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class MerchantEbo extends SimpleEbo<Merchant> implements MerchantEbi {

protected MerchantEbo()  {
		super(Merchant.class);
	}
}
