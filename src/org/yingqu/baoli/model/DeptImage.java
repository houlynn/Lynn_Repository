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
import org.yingqu.desktop.model.Department;
import org.yingqu.framework.model.BaseEntity;
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class DeptImage extends BaseEntity {

	private String id;
	private Department dept;
	private String url;
	private String remarks;
	@JsonIgnore
	@ManyToOne(optional=true,fetch=FetchType.LAZY)
	@JoinColumn(name="deptid")
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public String getUrl() {
		return url;
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
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "小区图片";
	}

}
