package org.yingqu.baoli.repertory;
import org.yingqu.baoli.model.UserCollection;
import org.yingqu.baoli.irepertory.UserCollectionRepertory;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class UserCollectionRepertoryImpl extends SimpleRepertoryHibernateImpl<UserCollection> implements UserCollectionRepertory {

	protected UserCollectionRepertoryImpl() {
		super(UserCollection.class);
	}

}
