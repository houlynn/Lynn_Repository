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

/**
 *
* @author HouLynn
* @date 2014年9月9日
  @version 1.0
 */
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class UserAdress extends BaseEntity {
	@FieldInfo(name = "主键", type = ExtFieldType.ID,mobileField=true)
	private String udid;
	@FieldInfo(name = "收货人",mobileField=true)
	private String uname;
	@FieldInfo(name = "详细地址",mobileField=true)
	private String address;
	@FieldInfo(name = "是否为默认地址",mobileField=true)
	private String defaulted;
	@FieldInfo(name = "用户标示",mobileField=true)
	private String userid;
	@FieldInfo(name = "电话号码",mobileField=true)
	private String phone;
	
	private AppUser appUser;
	
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getUdid() {
		return udid;
	}

	public void setUdid(String udid) {
		this.udid = udid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDefaulted() {
		return defaulted;
	}

	public void setDefaulted(String defaulted) {
		this.defaulted = defaulted;
	}
	@JsonIgnore
	@ManyToOne(optional=true,fetch=FetchType.LAZY)
	@JoinColumn(name="appuser_id",nullable=false)
	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonIgnore
	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "用户地址";
	}

}
