package org.yingqu.baoli.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
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
public class Feedback extends BaseEntity {
	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String fbid;
	@FieldInfo(name = "反馈用户ID", visible = true)
	private String userid;
	@SearchProperty(index=1)
	@FieldInfo(name = "反馈用户", visible = true)
	private String username;
	@SearchProperty(index=1)
	@FieldInfo(name = "反馈信息", visible = true)
	private String  msg;
	@SearchProperty(index=1)
	@FieldInfo(name = "反馈时间", visible = true,type=ExtFieldType.DATE)
	private String fbtime;
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getFbid() {
		return fbid;
	}

	public void setFbid(String fbid) {
		this.fbid = fbid;
	}

	public String getFbtime() {
		return fbtime;
	}

	public void setFbtime(String fbtime) {
		this.fbtime = fbtime;
	}

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

	@Column(length=2000)
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "反馈信息";
	}

}
