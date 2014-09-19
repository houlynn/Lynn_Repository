package org.yingqu.framework.model.vo;

public class ResultModel {
	
	/**
	 * 请求状态
	 */
	private int code;
	/**
	 * 返回对象
	 */
	private Object obj;
	/**
	 * 提示信息
	 */
	private String msg;
	
	/**
	 * 是否通过
	 */
	private int ok=1;
	
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getOk() {
		return ok;
	}
	public void setOk(int ok) {
		this.ok = ok;
	}
	

}
