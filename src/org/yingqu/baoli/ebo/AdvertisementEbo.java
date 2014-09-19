package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.Advertisement;
import org.yingqu.baoli.ebi.AdvertisementEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementEbo extends SimpleEbo<Advertisement> implements AdvertisementEbi {

protected AdvertisementEbo()  {
		super(Advertisement.class);
	}
}
