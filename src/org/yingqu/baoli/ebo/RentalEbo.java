package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.Rental;
import org.yingqu.baoli.ebi.RentalEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class RentalEbo extends SimpleEbo<Rental> implements RentalEbi {

protected RentalEbo()  {
		super(Rental.class);
	}
}
