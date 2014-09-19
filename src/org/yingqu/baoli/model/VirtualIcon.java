package org.yingqu.baoli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;

/**
* @author HouLynn
* @date 2014年9月11日
  @version 1.0
 */
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class VirtualIcon extends BaseEntity {

	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String iconid;
	@FieldInfo(name = "名称",visible=true,nullAble=false)
	private String name;
	@FieldInfo(name = "跳转地址",visible=true,nullAble=false)
	private String linkUrl;
	@FieldInfo(name = "图片链接地址",visible=true,nullAble=false)
	private String inconUrl;
	@FieldInfo(name = "备注",visible=true)
	private String remark;
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getIconid() {
		return iconid;
	}

	public void setIconid(String iconid) {
		this.iconid = iconid;
	}

	@Column(nullable=false,unique=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable=false,unique=true)
	public String getLinkUrl() {
		return linkUrl;
	}


	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	@Column(nullable=false)
	public String getInconUrl() {
		return inconUrl;
	}

	public void setInconUrl(String inconUrl) {
		this.inconUrl = inconUrl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "虚拟小区";
	}

}
