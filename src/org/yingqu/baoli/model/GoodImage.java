package org.yingqu.baoli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class GoodImage extends BaseEntity {

	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String igid;
	@FieldInfo(name = "图片链接地址",visible=true)
	private String url;
	private Goods good;
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getIgid() {
		return igid;
	}

	public void setIgid(String igid) {
		this.igid = igid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@JsonIgnore
    @ManyToOne(optional=false)
    @JoinColumn(name="goodid")
	public Goods getGood() {
		return good;
	}

	public void setGood(Goods good) {
		this.good = good;
	}

	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "商品图片";
	}

}
