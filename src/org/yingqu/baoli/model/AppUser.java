package org.yingqu.baoli.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.yingqu.framework.annotation.Dictionary;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.annotation.MobileFieldInfo;
import org.yingqu.framework.annotation.SearchProperty;
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
public class AppUser extends BaseEntity {

	@FieldInfo(name = "主键", type = ExtFieldType.ID,mobileField=true)
	private String userid;
	@SearchProperty(index=1)
	@FieldInfo(name = "昵称", visible = true, nullAble = false,mobileField=true)
	private String username;
	@SearchProperty(index=1)
	@FieldInfo(name = "帐号", visible = true, nullAble = false,mobileField=true)
	private String loginCode;
	@FieldInfo(name = "登录密码", visible = true, nullAble = false,mobileField=true)
	private String pwd;
	@FieldInfo(name = "小区名称", visible = true, nullAble = false,mobileField=true)
	private String deptname;
	@FieldInfo(name = "职业", visible = true, nullAble = false,mobileField=true)
	private String occupation;
	@FieldInfo(name = "星座", visible = true, nullAble = false,mobileField=true)
	private String constellation;
	@FieldInfo(name = "家乡", visible = true, nullAble = false,mobileField=true)
	private String home;
	@FieldInfo(name = "个性签名", visible = true, nullAble = false,mobileField=true)
	private String sefTick;
	@FieldInfo(name = "感情状态", visible = true, nullAble = false,mobileField=true)
	private String feelings;
	@FieldInfo(name = "性别", visible = true, nullAble = false,mobileField=true)
	private String sex;
	@FieldInfo(name = "年龄", visible = true, nullAble = false,mobileField=true)
	private Integer age;
	@FieldInfo(name = "城市", visible = true, nullAble = false,mobileField=true)
	private String city;
	@FieldInfo(name="兴趣爱好",visible = true, nullAble = false,mobileField=true)
	private String hoby;
	@FieldInfo(name = "区ID", visible = true, nullAble = false)
	private String deptid;
	@FieldInfo(name = "身份证", visible = true, nullAble = false)
	private String idcar;
	@FieldInfo(name = "用户等级", visible = true, nullAble = false)
	 private int levf;
	@FieldInfo(name = "QQ", visible = true, nullAble = false)
	private String qq;
	@FieldInfo(name = "email", visible = true, nullAble = false)
	private String email;
	@FieldInfo(name = "手机", visible = true, nullAble = false)
	private String phone;
	@FieldInfo(name = "联系电话", visible = true, nullAble = false)
	private String hoemPhone;
	@Dictionary("ISOWNER")
	@SearchProperty(index=1)
	@FieldInfo(name = "是否业主", visible = true, nullAble = false)
	private String owner;
	@FieldInfo(name = "备注", visible = true, nullAble = false)
	private String remarks;
	@FieldInfo(name = "房产信息", visible = true, nullAble = false)
	private String house; 
	@FieldInfo(name = "用户头像", visible = true, nullAble = false,mobileField=true)
	private String topUrl; 
	private String defaultadi;
	private Set<UserAdress> adress=new HashSet<UserAdress>();
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(unique=true,nullable=false)
	public String getLoginCode() {
		return loginCode;
	}

	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}
	@Column(nullable=false)
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHoemPhone() {
		return hoemPhone;
	}

	public void setHoemPhone(String hoemPhone) {
		this.hoemPhone = hoemPhone;
	}

	@Column(nullable=false,length=10)
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	@Column(length=500)
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getIdcar() {
		return idcar;
	}

	public void setIdcar(String idcar) {
		this.idcar = idcar;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getTopUrl() {
		return topUrl;
	}

	public void setTopUrl(String topUrl) {
		this.topUrl = topUrl;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getSefTick() {
		return sefTick;
	}

	public void setSefTick(String sefTick) {
		this.sefTick = sefTick;
	}

	public String getFeelings() {
		return feelings;
	}

	public void setFeelings(String feelings) {
		this.feelings = feelings;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHoby() {
		return hoby;
	}

	public void setHoby(String hoby) {
		this.hoby = hoby;
	}
	
	
	public int getLevf() {
		return levf;
	}

	public void setLevf(int levf) {
		this.levf = levf;
	}

	
	@Transient
	public String getDefaultadi() {
		return defaultadi;
	}

	public void setDefaultadi(String defaultadi) {
		this.defaultadi = defaultadi;
	}

	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="appUser",cascade={CascadeType.REMOVE})
	@LazyCollection(LazyCollectionOption.TRUE)
	public Set<UserAdress> getAdress() {
		return adress;
	}

	public void setAdress(Set<UserAdress> adress) {
		this.adress = adress;
	}

	@JsonIgnore
	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "APP用户信息";
	}

}
