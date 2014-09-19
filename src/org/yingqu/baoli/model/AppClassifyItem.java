package org.yingqu.baoli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.annotation.SearchProperty;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;

/**
 *
* @author HouLynn
* @date 2014年9月3日
  @version 1.0
 */
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class AppClassifyItem extends BaseEntity {

	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String itemid;
	@SearchProperty(index=1)
	@FieldInfo(name = "分类名称", visible=true)
	private String itemName;
	@FieldInfo(name = "图片链接地址",visible=true)
	private String imgurl;
	private AppClassify ac;
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	@JsonIgnore
	@ManyToOne(optional=true,fetch=FetchType.LAZY)
	@JoinColumn(name="acid")
	public AppClassify getAc() {
		return ac;
	}

	public void setAc(AppClassify ac) {
		this.ac = ac;
	}

	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "子类别";
	}

}
