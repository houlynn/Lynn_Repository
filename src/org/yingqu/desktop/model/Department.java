package org.yingqu.desktop.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.yingqu.baoli.model.DeptImageUrl;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.annotation.NodeType;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.constant.TreeNodeType;
import org.yingqu.framework.model.TreeBaseEntity;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
/**
 *小区信息
* @author HouLynn
* @date 2014年8月26日
  @version 1.0
 */
@Entity
@GenericGenerator(name="systemUUID",strategy="uuid")
public class Department extends TreeBaseEntity {
	@NodeType(type=TreeNodeType.ID)
	@FieldInfo(name="主键", type=ExtFieldType.ID)
	private String deptId;
	@NodeType(type=TreeNodeType.TEXT)
	@FieldInfo(name="小区名称",visible=true,nullAble=true)
	private String deptName;
	@NodeType(type=TreeNodeType.CODE)
	@FieldInfo(name="小区代码")
	private String deptCode;
	@NodeType(type=TreeNodeType.PARENT)
	private Department parent;
	private Set<Department> children=new HashSet<Department>();
	private Set<EndUser> users=new HashSet<EndUser>();
	@FieldInfo(name = "城市", visible = true, nullAble = false)
	private String city;
	@FieldInfo(name = "地理位置", visible = true, nullAble = false)
	private String location;
	@FieldInfo(name = "简介", visible = true, nullAble = false)
	private String summary;
	@FieldInfo(name = "小区介绍", visible = true, nullAble = false)
	private String introduce;
	@FieldInfo(name = "经度纬度", visible = true, nullAble = false)
	private String locationxy;
	private Set<DeptImageUrl>  images=new HashSet<DeptImageUrl>();
	
	@Id
	@GeneratedValue(generator="systemUUID")
	@Column(length=50)
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	@JsonIgnore
	@ManyToOne(optional=true,fetch=FetchType.LAZY)
	@JoinColumn(name="PARENT")
	public Department getParent() {
		return parent;
	}
	public void setParent(Department parent) {
		this.parent = parent;
	}
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="parent",cascade={CascadeType.REMOVE})
	@LazyCollection(LazyCollectionOption.TRUE)
	public Set<Department> getChildren() {
		return children;
	}
	public void setChildren(Set<Department> children) {
		this.children = children;
	}
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="department",cascade={CascadeType.MERGE})
	@LazyCollection(LazyCollectionOption.TRUE)
	public Set<EndUser> getUsers() {
		return users;
	}
	public void setUsers(Set<EndUser> users) {
		this.users = users;
	}
	public String getLocationxy() {
		return locationxy;
	}
	public void setLocationxy(String locationxy) {
		this.locationxy = locationxy;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	@JsonIgnore
	@OneToMany(mappedBy="dept",cascade={CascadeType.REMOVE},fetch=FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.TRUE)
	public Set<DeptImageUrl> getImages() {
		return images;
	}
	public void setImages(Set<DeptImageUrl> images) {
		this.images = images;
	}
	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return " 部门实体";
	}
	
}
