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
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 省份
	 */
	private String province;
	
	/**
	 * 头像
	 */
	private String topUrl;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getTopUrl() {
		return topUrl;
	}
	public void setTopUrl(String topUrl) {
		this.topUrl = topUrl;
	}

}
