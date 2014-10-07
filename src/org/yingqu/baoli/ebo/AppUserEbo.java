package org.yingqu.baoli.ebo;
import org.yingqu.baoli.model.AppUser;
import org.yingqu.baoli.ebi.AppUserEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class AppUserEbo extends SimpleEbo<AppUser> implements AppUserEbi {

protected AppUserEbo()  {
		super(AppUser.class);
	}

@Override
public void executeSql(String userid,String addid) throws Exception {
	 String sql=" update  UserAdress set defaulted='0' where appuser_id='"+userid+"'";
	 repertory.executeSql(sql);
	 String usql=" update  UserAdress set defaulted='1' where appuser_id='"+userid+"' and udid='"+addid+"'";
	 repertory.executeSql(usql);
	
}
}
