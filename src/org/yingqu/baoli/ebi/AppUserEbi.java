package org.yingqu.baoli.ebi;
import org.yingqu.baoli.model.AppUser;
import org.yingqu.framework.ebi.SimpleEbi;

public interface AppUserEbi extends SimpleEbi<AppUser> {
	
	
	public void executeSql(String userid,String addid) throws Exception;

}
