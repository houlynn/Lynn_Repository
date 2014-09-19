package org.yingqu.desktop.ebi;

import org.yingqu.desktop.model.SysIcon;
import org.yingqu.framework.ebi.SimpleEbi;

public interface SysIconEbi extends SimpleEbi<SysIcon> {
	/**
	 *  同步样式的文件信息
	 */
	public void syncIconCss() throws Exception;
}
