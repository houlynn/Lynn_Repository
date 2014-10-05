package org.yingqu.baoli.model.po;

import java.util.List;

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
	 * 发表时间 
	 */
	private String postTime;
	/**
	 * 类型 参考用户论坛 数字字典
	 */
	private String typeCode;
	
	/**
	 * 发帖地址
	 * 
	 */
	 private String  postAddress;
	 
	 /**
	  * 内容
	  */
	 private String interactContent;
	 
	 /**
	  * 图片集合
	  */
	 private List<String> imgList;
	 
	 /**
	  * 用户个性签名
	  *
	  */
	 private String sefTick;
	

	public String getPostAddress() {
		return postAddress;
	}
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}
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

	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getInteractContent() {
		return interactContent;
	}
	public void setInteractContent(String interactContent) {
		this.interactContent = interactContent;
	}
	public List<String> getImgList() {
		return imgList;
	}
	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}
	public String getSefTick() {
		return sefTick;
	}
	public void setSefTick(String sefTick) {
		this.sefTick = sefTick;
	}

	
	
	
}
