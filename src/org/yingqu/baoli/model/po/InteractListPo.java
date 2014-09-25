package org.yingqu.baoli.model.po;

/**
 * 用户论坛条目
* @author 作者 HouLynn: 
* @version 创建时间：2014年9月25日 下午9:45:26 
* version 1.0
 */
public class InteractListPo {
	
	/**
	 * 帖子标识
	 */
	private String inid;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户头衔
	 */
	private String topUrl;
	/**
	 * 帖子标题
	 */
	private String title;
	/**
	 * 发表时间 
	 */
	private String postTime;
	/**
	 * 类型
	 */
	private String typeVale;
	
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 省份
	 */
	private String province;

	public String getInid() {
		return inid;
	}
	public void setInid(String inid) {
		this.inid = inid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTopUrl() {
		return topUrl;
	}
	public void setTopUrl(String topUrl) {
		this.topUrl = topUrl;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public String getTypeVale() {
		return typeVale;
	}
	public void setTypeVale(String typeVale) {
		this.typeVale = typeVale;
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
	
	
	
	
}
