package org.yingqu.baoli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;

@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class Massage extends BaseEntity {
	@FieldInfo(name = "主键", type = ExtFieldType.ID,mobileField=true)
	private String msgid;
	@FieldInfo(name = "回复内容", visible = true)
	private String context;
	@FieldInfo(name = "帖子ID", visible = true)
	private String inid;
	@FieldInfo(name = "评论时间", visible = true)
	private  String backtime;
	@FieldInfo(name = "用户id", visible = true)
	private String userid;
	private String username;
	
	
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getMsgid() {
		return msgid;
	}


	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}


	public String getContext() {
		return context;
	}


	public void setContext(String context) {
		this.context = context;
	}


	@Column(nullable=false)
	public String getInid() {
		return inid;
	}


	public void setInid(String inid) {
		this.inid = inid;
	}

	@Column(nullable=false)
	public String getBacktime() {
		return backtime;
	}


	public void setBacktime(String backtime) {
		this.backtime = backtime;
	}

	@Column(nullable=false)
	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}

@Transient
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "回复";
	}

}
