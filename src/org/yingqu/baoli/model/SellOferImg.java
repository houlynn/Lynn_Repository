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
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class SellOferImg extends BaseEntity {
	@FieldInfo(name = "主键", type = ExtFieldType.ID, mobileField = true)
	private String imgid;
	private SellOfer  sell;
	@FieldInfo(name = "图片", visible = true, nullAble = false)
	private String  url;
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getImgid() {
		return imgid;
	}

	public void setImgid(String imgid) {
		this.imgid = imgid;
	}
	@JsonIgnore
	@ManyToOne(optional=true,fetch=FetchType.LAZY)
	@JoinColumn(name="sellid",nullable=false)
	public SellOfer getSell() {
		return sell;
	}

	public void setSell(SellOfer sell) {
		this.sell = sell;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "";
	}

}
