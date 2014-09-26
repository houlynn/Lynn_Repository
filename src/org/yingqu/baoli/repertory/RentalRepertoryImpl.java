package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.Rental;
import org.yingqu.baoli.irepertory.RentalRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class RentalRepertoryImpl extends SimpleRepertoryHibernateImpl<Rental> implements RentalRepertory {

	protected RentalRepertoryImpl() {
		super(Rental.class);
	}

}
