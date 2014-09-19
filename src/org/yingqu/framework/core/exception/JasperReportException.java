package org.yingqu.framework.core.exception;

import org.yingqu.framework.core.CommConstants;

@SuppressWarnings("serial")
public class JasperReportException extends Exception {

	public JasperReportException() {
		super();
	}

	public JasperReportException(String msg) {
		super(CommConstants.Exception_Head + msg);
	}
}
