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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.yingqu.framework.annotation.DDItemCode;
import org.yingqu.framework.annotation.DDItemName;
import org.yingqu.framework.annotation.DefaultOrder;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;
import org.yingqu.framework.utils.PropUtil;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;

/**
 * 人员表
* @author 作者 yingqu: 
* @version 创建时间：2014年6月21日 下午10:33:58 
* version 1.0
 */
@Entity
@GenericGenerator(name="systemUUID",strategy="uuid")
public class EndUser extends BaseEntity implements UserDetails {
	@FieldInfo(name="主键",type=ExtFieldType.ID)
	@DDItemCode
	private String userId;
	@DDItemName
	@FieldInfo(name="用户姓名")
	private String username;
	@FieldInfo(name="用户编码")
	private String userCode;
	@FieldInfo(name="密码")
	private String password;
	@FieldInfo(name="性别")
	private String sex="0";//0代表男，1代表女
	@FieldInfo(name="出生日期")
	private String birthday;
	/**后面属性不进行持久化操作*/
	@FieldInfo(name="图标")
	private String icon=PropUtil.get("sys.rbac.userIcon");
	@FieldInfo(name="部门主键")
	private String deptId;
	@FieldInfo(name="部门名称")
	private String deptName;
	@FieldInfo(name="部门编码")
	private String deptCode;
	
/*	@FieldInfo(name="是否启用")
	private String enabled;*/
	
/*	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}*/
	/**角色*/
	private Set<Role> roles=new HashSet<Role>();
	/**部门*/
	private Department department=new Department();
	@Id
	@GeneratedValue(generator="systemUUID")
	@Column(length=50)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(unique=true)
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Transient
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Transient
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	@Transient
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Transient
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.MERGE})
	@JoinTable(name = "ROLE_USER", joinColumns = {
				@JoinColumn(name = "userId") },
				inverseJoinColumns = { @JoinColumn(name = "roleId")
	})
	@LazyCollection(LazyCollectionOption.TRUE)
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@JsonIgnore //构建json数据的时候排除此字段
	@ManyToOne(optional=false, fetch=FetchType.LAZY, cascade={CascadeType.MERGE})
	@JoinColumn(name="deptId")
	@LazyCollection(LazyCollectionOption.TRUE)
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@JsonIgnore
	@Override
	@Transient
	public GrantedAuthority[] getAuthorities() {
		// TODO Auto-generated method stub
		return new GrantedAuthority[0];
	}
	@JsonIgnore
	@Override
	@Transient
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@JsonIgnore
	@Override
	@Transient
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@JsonIgnore
	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@JsonIgnore
	@Override
	@Transient
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "人员表";
	}
}
