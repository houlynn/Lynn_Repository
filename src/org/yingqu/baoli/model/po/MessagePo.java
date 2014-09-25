package org.yingqu.baoli.model.po;

public class MessagePo {
	/**
	 * 评论用户
	 */
	private String userName;
	/**
	 * 评论内容
	 */
	private String mesg;
	/**
	 * 评论时间
	 */
	private String psTime;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMesg() {
		return mesg;
	}
	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	public String getPsTime() {
		return psTime;
	}
	public void setPsTime(String psTime) {
		this.psTime = psTime;
	}

}
