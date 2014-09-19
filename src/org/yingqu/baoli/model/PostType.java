package org.yingqu.baoli.model;

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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;

/**
 *
* @author HouLynn
* @date 2014年8月26日
  @version 1.0
 */
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class PostType extends BaseEntity {
	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String posttid;
	@FieldInfo(name = "类型名称", visible = true, nullAble = false)
	private String name;
	@FieldInfo(name = "代码", visible = true, nullAble = false)
	private String code;
	@FieldInfo(name = "备注", visible = true, nullAble = false)
	private String remarks;
	private PostType parent;
	private Set<PostType> children=new HashSet<PostType>();

	@Id
	@GeneratedValue(generator="systemUUID")
	@Column(length=50)
	public String getPosttid() {
		return posttid;
	}
	public void setPosttid(String posttid) {
		this.posttid = posttid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@JsonIgnore
	@ManyToOne(optional=true,fetch=FetchType.LAZY)
	@JoinColumn(name="PARENT")
	public PostType getParent() {
		return parent;
	}

	public void setParent(PostType parent) {
		this.parent = parent;
	}
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="parent",cascade={CascadeType.REMOVE})
	@LazyCollection(LazyCollectionOption.TRUE)
	public Set<PostType> getChildren() {
		return children;
	}

	public void setChildren(Set<PostType> children) {
		this.children = children;
	}

	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "帖子";
	}

}
