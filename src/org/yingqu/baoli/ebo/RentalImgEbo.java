package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.RentalImg;
import org.yingqu.baoli.ebi.RentalImgEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class RentalImgEbo extends SimpleEbo<RentalImg> implements RentalImgEbi {

protected RentalImgEbo()  {
		super(RentalImg.class);
	}
}
