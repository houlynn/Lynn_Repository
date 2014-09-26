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
import org.yingqu.desktop.model.EndUser;
import org.yingqu.framework.annotation.Dictionary;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.annotation.SearchProperty;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")//id的生成策略
public class OfficialIteract extends BaseEntity {

	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String oinerid;
	@SearchProperty(index=1,value="INCATYPE")
	@Dictionary("INCATYPE")
	@FieldInfo(name="分类", visible = true, nullAble = false)
	private String type;
	@SearchProperty(index=1)
	@FieldInfo(name="标题", visible = true, nullAble = false)
	private String title;
	@FieldInfo(name="内容", visible = true, nullAble = false)
	private String content;
	@SearchProperty(index=6)
	@FieldInfo(name="发布时间",type=ExtFieldType.DATE)
	private String ptime;
	@SearchProperty(index=1)
	@Dictionary("ENDUSER")
	@FieldInfo(name = "发帖人", visible = true, nullAble = false)
	private String username;
	@Dictionary("ISPOST")
	@SearchProperty(index=2)
	@FieldInfo(name="发布状态")
	private String  state;
	private EndUser uid;
	private Set<OfficialPhotograph> photourl=new  HashSet<OfficialPhotograph>();
	
	public void setUid(EndUser uid) {
		this.uid = uid;
	}

	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getOinerid() {
		return oinerid;
	}

	public void setOinerid(String oinerid) {
		this.oinerid = oinerid;
	}
	@JsonIgnore
	@ManyToOne(optional=true,fetch=FetchType.LAZY)
	@JoinColumn(name="uid")
	public EndUser getUid() {
		return uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	@Column(nullable=false)
	public void setType(String type) {
		this.type = type;
	}

@Column(nullable=false,length=2000)
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	@Column(length=5000)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	public String getPtime() {
		return ptime;
	}


	public void setPtime(String ptime) {
		this.ptime = ptime;
	}


	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="it",cascade={CascadeType.REMOVE})
	@LazyCollection(LazyCollectionOption.TRUE)
	public Set<OfficialPhotograph> getPhotourl() {
		return photourl;
	}
	public void setPhotourl(Set<OfficialPhotograph> photourl) {
		this.photourl = photourl;
	}
	@Transient
	@Override
	public String getDescription() 
	{
		// TODO Auto-generated method stub
		return "官方贴";
	}

}
