package org.yingqu.framework.model;


import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.yingqu.framework.annotation.DefaultOrder;
import org.yingqu.framework.annotation.FieldInfo;
/**
 *
* @author 作者 yingqu: 
* @version 创建时间：2014年6月7日 上午10:56:11 
* version 1.0
 */

@MappedSuperclass
@DefaultOrder
@EntityListeners(value =ModelListener.class)
public abstract class BaseEntity implements Model {
	@Transient
	private static final long serialVersionUID = 1382876463188924324L;
	@FieldInfo(name="创建时间")
	private String createTime;
	@FieldInfo(name="创建人")
	private String createUser;
	@FieldInfo(name="创建部门")
	private String createDept;
	@FieldInfo(name="排序字段")
	private Integer orderIndex;
	@FieldInfo(name="修改部门")
	private String  modifyDept;
	@FieldInfo(name="修改时间")
	private String modifyTime;
	@FieldInfo(name="修改人")
	private String  modifyUser;
	@FieldInfo(name="上一次更新时间")
	private String updateTime;
	@JsonIgnore
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@JsonIgnore
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	@JsonIgnore
	public String getCreateDept() {
		return createDept;
	}
	public void setCreateDept(String createDept) {
		this.createDept = createDept;
	}
	@JsonIgnore
	public Integer getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}
	@JsonIgnore
	public String getModifyDept() {
		return modifyDept;
	}
	public void setModifyDept(String modifyDept) {
		this.modifyDept = modifyDept;
	}
	@JsonIgnore
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	@JsonIgnore
	public String getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	@JsonIgnore
    public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return this.SelfreflectionAll();
	}
}
