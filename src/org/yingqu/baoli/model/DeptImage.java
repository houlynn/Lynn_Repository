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
import org.yingqu.framework.model.BaseEntity;
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class DeptImage extends BaseEntity {

	private String id;
	private Village vi;
	private String url;
	@JsonIgnore
	@ManyToOne(optional=true,fetch=FetchType.LAZY)
	@JoinColumn(name="vid")

	public String getUrl() {
		return url;
	}

	public Village getVi() {
		return vi;
	}

	public void setVi(Village vi) {
		this.vi = vi;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@Id
	@GeneratedValue(generator="systemUUID")
	@Column(length=50)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "小区图片";
	}

}
