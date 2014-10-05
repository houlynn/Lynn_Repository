package org.yingqu.baoli.model.po;

import java.util.ArrayList;
import java.util.List;

/**
 * 官方帖子详细信息
* @author 作者 HouLynn: 
* @version 创建时间：2014年9月25日 下午9:54:40 
* version 1.0
 */
public class OfferInteractPo  {
	
	/**
	 * 帖子标识
	 */
	private String inid;
	/**
	 * 发表时间 
	 */
	private String postTime;
	/**
	 * 类型 参考官方论坛 数字字典
	 */
	private String typeCode;
	
	 
	 /**
	  * 内容
	  */
	 private String officialContent;
	 
	 /**
	  * 图片集合
	  */
	 private List<String> imgList=new ArrayList<String>();
	
	 
	 
	 
	public String getInid() {
		return inid;
	}
	public void setInid(String inid) {
		this.inid = inid;
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
	public List<String> getImgList() {
		return imgList;
	}
	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}
	public String getOfficialContent() {
		return officialContent;
	}
	public void setOfficialContent(String officialContent) {
		this.officialContent = officialContent;
	}

	
/*	private List<MessagePo> mesges=new ArrayList<MessagePo>();

	public List<MessagePo> getMesges() {
		return mesges;
	}

	public void setMesges(List<MessagePo> mesges) {
		this.mesges = mesges;
	}*/

}
