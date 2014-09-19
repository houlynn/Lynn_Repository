package org.yingqu.baoli.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.yingqu.framework.annotation.Dictionary;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.annotation.SearchProperty;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;

/**
* @author HouLynn
* @date 2014年8月26日
  @version 1.0
 */
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class Merchant extends BaseEntity {
	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String merid;
	@SearchProperty(index=1)
	@FieldInfo(name = "商户名称", visible = true, nullAble = false,mobileField=true)
	private String name;
	@FieldInfo(name = "手机号码", visible = true, nullAble = false,mobileField=true)
	private String phone;
	@FieldInfo(name = "联系方式", visible = true, nullAble = false,mobileField=true)
	private String homePhone;
	@FieldInfo(name = "营业时间", visible = true, nullAble = false,mobileField=true)
	private String businesstime;
	private String btype;
	@FieldInfo(name = "服务描述", visible = true, nullAble = false,mobileField=true)
	private String remarks;
	@Dictionary("ISCOME")
	@SearchProperty(index=1, value="ISCOME")
	@FieldInfo(name = "是否上门", visible = true, nullAble = false,mobileField=true)
	private String come; 
	@FieldInfo(name = "营业执照", visible = true, nullAble = false,mobileField=true)
	private String cardid;
	@FieldInfo(name = "申请用户id", visible = true, nullAble = false,mobileField=true)
	private String userid;
	@FieldInfo(name = "用户名", visible = true, nullAble = false)
	private String username;
	@Dictionary("AUDIT")
	@FieldInfo(name = "审核状态", visible = true, nullAble = false)
	private String audit;
	@FieldInfo(name = "审核时间", visible = true,type=ExtFieldType.DATE)
	private String audittiem;
	@FieldInfo(name = "申请时间", visible = true,type=ExtFieldType.DATE)
	private String applytime;
	private String xponit;
	private String yponit;
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getMerid() {
		return merid;
	}
	public void setMerid(String merid) {
		this.merid = merid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getBusinesstime() {
		return businesstime;
	}
	public void setBusinesstime(String businesstime) {
		this.businesstime = businesstime;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getCome() {
		return come;
	}
	public void setCome(String come) {
		this.come = come;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAudit() {
		return audit;
	}
	public void setAudit(String audit) {
		this.audit = audit;
	}
	public String getAudittiem() {
		return audittiem;
	}
	public void setAudittiem(String audittiem) {
		this.audittiem = audittiem;
	}
	public String getApplytime() {
		return applytime;
	}

	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getXponit() {
		return xponit;
	}
	public void setXponit(String xponit) {
		this.xponit = xponit;
	}
	public String getYponit() {
		return yponit;
	}
	public void setYponit(String yponit) {
		this.yponit = yponit;
	}
	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "周边商户信息";
	}

}
