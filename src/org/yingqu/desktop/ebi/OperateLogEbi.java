package org.yingqu.desktop.ebi;

import org.yingqu.desktop.model.OperateLog;
import org.yingqu.framework.ebi.SimpleEbi;
import org.yingqu.framework.model.Model;

public interface OperateLogEbi extends SimpleEbi<OperateLog> {
    public void saveLog(Model model, String type);
}
