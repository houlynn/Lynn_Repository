package org.yingqu.baoli.model.po;

/**
 * 客户端 收藏信息 基础字段
* @author HouLynn
* @date 2014年9月19日
  @version 1.0
 */
public class CollectBase {
	
	/**
	 * 对应ID
	 */
	private String cid;
	/**
	 * 收藏id
	 */
	private String id;
	
	/**
	 * 图标
	 */
 private String icon;
 /**
  * 收藏展示标题
  */
 private String title;
 /**
  * 收藏描述信息
  */
 private String remark;
 /**
  * 收藏类型
  */
 private String type;
 
public String getIcon() {
	return icon;
}
public void setIcon(String icon) {
	this.icon = icon;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
 
	
	
}
