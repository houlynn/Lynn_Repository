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
	private String msgContext;
	@FieldInfo(name = "帖子ID", visible = true)
	private String inid;
	@FieldInfo(name = "评论时间", visible = true)
	private  String backtime;
	@FieldInfo(name = "用户id", visible = true)
	private String userid;
	private String username;
	
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 省份
	 */
	private String province;
	
	
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	@Column(name="content", columnDefinition="TEXT")
	public String getMsgContext() {
		return msgContext;
	}
	public void setMsgContext(String msgContext) {
		this.msgContext = msgContext;
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

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "回复";
	}

}
