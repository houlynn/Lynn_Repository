package com.ufo.framework.common.core.exception;

import com.ufo.framework.common.constant.CommConstants;



/**
 *  调用存储过程异常
* @author 作者 yingqu: 
* @version 创建时间：2014年6月28日 下午5:37:54 
* version 1.0
 */
@SuppressWarnings("serial")
public class PrcException extends RuntimeException {

	private String appCode;
	private String errorMsg;
	private String prcName;

	public PrcException(String prcName, String errorMsg) {
		super(CommConstants.Exception_Head + "调用存储过程[" + prcName
				+ "]发生错误,错误原因：[" + errorMsg + "]");
		setErrorMsg(errorMsg);
	}

	public PrcException(String prcName, String appCode, String errorMsg) {
		super(CommConstants.Exception_Head + "调用存储过程[" + prcName
				+ "]发生错误,错误编码为：[" + appCode + "] 错误原因：[" + errorMsg + "]");
		setAppCode(appCode);
		setPrcName(prcName);
		setErrorMsg(errorMsg);
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getPrcName() {
		return prcName;
	}

	public void setPrcName(String prcName) {
		this.prcName = prcName;
	}

}
