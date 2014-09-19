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
 *
* @author HouLynn
* @date 2014年8月26日
  @version 1.0
 */
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class LoginLog extends BaseEntity {

	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String logId;
	@SearchProperty(index=1)
	@FieldInfo(name = "登录时间", visible = true, nullAble = false,type=ExtFieldType.DATE)
	private String logintime;
	@FieldInfo(name = "登录IP", visible = true, nullAble = false)
	private String logIp;
	@SearchProperty(index=1)
	@FieldInfo(name = "用户名", visible = true, nullAble = false)
	private String loginName;
	@Dictionary("DISTRICT") 
	@FieldInfo(name = "所属小区", visible = true, nullAble = false)
	private String deptName;
	private String loginId;
	private String deptId;
	@FieldInfo(name = "登录次数", visible = true, nullAble = false)
	private int count;
	@FieldInfo(name = "上次登录时间", visible = true, nullAble = false,type=ExtFieldType.DATE)
	private String backtime;
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getLogIp() {
		return logIp;
	}

	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getBacktime() {
		return backtime;
	}

	public void setBacktime(String backtime) {
		this.backtime = backtime;
	}

	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "用户登录日志";
	}

}
