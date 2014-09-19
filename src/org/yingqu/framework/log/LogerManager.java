package org.yingqu.framework.log;

import org.apache.log4j.Logger;
/**
 * 
* @author 作者 yingqu: 
* @version 创建时间：2014年7月9日 下午3:10:34 
* version 1.0
 */
public interface LogerManager {

	public default void info( String msg) {
		Logger log = AppLoggerFactory.getyingquLogger(this.getClass());
		if (AppLoggerFactory.INFO) {
			log.info(msg);
		}
	}
	public default void debug(String msg) {
		Logger log = AppLoggerFactory.getyingquLogger(this.getClass());
		if (AppLoggerFactory.DEBUG) {
			log.info(msg);
		}
	}
	public default void error(String msg) {
		Logger log = AppLoggerFactory.getyingquLogger(this.getClass());
		if (AppLoggerFactory.ERROR) {
			log.error(msg);
		}
	}
	public default void error(String msg, Throwable e) {
		Logger log = AppLoggerFactory.getyingquLogger(this.getClass());
		if (AppLoggerFactory.ERROR) {
			log.error(msg,e);
		}
	}
}
