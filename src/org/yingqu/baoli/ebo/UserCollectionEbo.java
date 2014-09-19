package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.UserCollection;
import org.yingqu.baoli.ebi.UserCollectionEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class UserCollectionEbo extends SimpleEbo<UserCollection> implements UserCollectionEbi {

protected UserCollectionEbo()  {
		super(UserCollection.class);
	}
}
