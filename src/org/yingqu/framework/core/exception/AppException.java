package org.yingqu.framework.core.exception;

import org.yingqu.framework.core.CommConstants;


/**
 * 公共异常类<br>
* @author 作者 yingqu: 
* @version 创建时间：2014年6月28日 下午5:34:04 
* version 1.0
 */
@SuppressWarnings("serial")
public class AppException extends RuntimeException {

	public AppException() {
		super();
	}

	public AppException(String msg) {
		super(CommConstants.Exception_Head + msg);
	}
}
