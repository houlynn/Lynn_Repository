package org.yingqu.baoli.model.po;

import org.yingqu.framework.annotation.FieldInfo;

/**
 * 虚拟小区信息
 *
* @author HouLynn
* @date 2014年9月25日
  @version 1.0
 */
public class VirtualIconPo {
	@FieldInfo(name = "名称",visible=true,nullAble=false)
	private String name;
	@FieldInfo(name = "跳转地址",visible=true,nullAble=false)
	private String linkUrl;
	@FieldInfo(name = "图片链接地址",visible=true,nullAble=false)
	private String inconUrl;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getInconUrl() {
		return inconUrl;
	}
	public void setInconUrl(String inconUrl) {
		this.inconUrl = inconUrl;
	}
	
}
