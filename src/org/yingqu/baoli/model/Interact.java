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
import org.yingqu.framework.annotation.Dictionary;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.annotation.SearchProperty;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;

/**
 * 
* @author xing
* @date 2014年9月19日
  @业主互动
 */
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")//id的生成策略
public class Interact extends BaseEntity
{
	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String hId;
	@SearchProperty(index=1)
	@FieldInfo(name="用户名", visible = true, nullAble = false)
	private String username;
    @Dictionary("INCTYPE")
	@FieldInfo(name="分类", visible = true, nullAble = false)
	private String type;
    @SearchProperty(index=1)
	@FieldInfo(name="标题", visible = true, nullAble = false)
	private String title;
	@FieldInfo(name="内容", visible = true, nullAble = false)
	private String content;
	@FieldInfo(name = "活动时间", visible = true, nullAble = false,type=ExtFieldType.DATE)
	private String htime;
	@FieldInfo(name="人数限制")
	private int people;
	@FieldInfo(name="活动地点")
	private int site;
	@SearchProperty(index=1)
	@FieldInfo(name="发布时间",nullAble = false,type=ExtFieldType.DATE)
	private String ptime;
	/**
	 * 用户接受页面参数
	 */
	private String userid;
	private AppUser uid;
	private Set<Photograph> photourl=new  HashSet<Photograph>();

	
	@JsonIgnore
	@ManyToOne(optional=true,fetch=FetchType.LAZY)
	@JoinColumn(name="userid")
	public AppUser getUid() {
		return uid;
	}


	public void setUid(AppUser uid) {
		this.uid = uid;
	}
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String gethId() {
		return hId;
	}


	public void sethId(String hId) {
		this.hId = hId;
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

	public String getHtime() {
		return htime;
	}
	public void setHtime(String htime) {
		this.htime = htime;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public int getSite() {
		return site;
	}

	public void setSite(int site) {
		this.site = site;
	}
	
	public String getPtime() {
		return ptime;
	}


	public void setPtime(String ptime) {
		this.ptime = ptime;
	}


	@Transient
	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="it",cascade={CascadeType.REMOVE})
	@LazyCollection(LazyCollectionOption.TRUE)
	public Set<Photograph> getPhotourl() {
		return photourl;
	}
	public void setPhotourl(Set<Photograph> photourl) {
		this.photourl = photourl;
	}
	@Transient
	@Override
	public String getDescription() 
	{
		// TODO Auto-generated method stub
		return "用户贴";
	}

}
