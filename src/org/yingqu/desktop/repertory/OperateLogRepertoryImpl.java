package org.yingqu.desktop.repertory;

import org.yingqu.desktop.irepertory.OperateLogRepertory;
import org.yingqu.desktop.model.OperateLog;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OperateLogRepertoryImpl extends SimpleRepertoryHibernateImpl<OperateLog>  implements OperateLogRepertory{

	protected OperateLogRepertoryImpl() {
		super( OperateLog.class);
	}

}
