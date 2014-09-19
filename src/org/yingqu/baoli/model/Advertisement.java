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
import org.yingqu.framework.annotation.SearchProperty;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;

/**
 *
* @author HouLynn
* @date 2014年9月1日
  @version 1.0
 */
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class Advertisement extends BaseEntity {

	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String adverid;
	@FieldInfo(name = "广告类型", visible = true, nullAble = false)
	private String advertype;
	@FieldInfo(name = "标题", visible = true, nullAble = false)
	private String title;
	@SearchProperty(index=1)
	@FieldInfo(name = "内容", visible = true, nullAble = false)
	private String msg;
	@SearchProperty(index=1, value="TSTATE")
	@Dictionary("TSTATE")
	@FieldInfo(name = "投放状态", visible = true, nullAble = false)
	private String ispost;
	@FieldInfo(name = "投放时间", visible = true, nullAble = false,type=ExtFieldType.DATE)
	private String posttime;
	@FieldInfo(name = "操作人", visible = true, nullAble = false)
	private String userid;
	@FieldInfo(name = "链接地址", visible = true, nullAble = false)
	private String linkUrl;
	private Set<AvvertiseImageUrl> images=new  HashSet<AvvertiseImageUrl>();
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getAdverid() {
		return adverid;
	}

	public void setAdverid(String adverid) {
		this.adverid = adverid;
	}

	public String getAdvertype() {
		return advertype;
	}

	public void setAdvertype(String advertype) {
		this.advertype = advertype;
	}
	@Column(length=500)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column(length=3000)
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getIspost() {
		return ispost;
	}

	public void setIspost(String ispost) {
		this.ispost = ispost;
	}

	public String getPosttime() {
		return posttime;
	}

	public void setPosttime(String posttime) {
		this.posttime = posttime;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="adt",cascade={CascadeType.REMOVE})
	@LazyCollection(LazyCollectionOption.TRUE)
	public Set<AvvertiseImageUrl> getImages() {
		return images;
	}
	public void setImages(Set<AvvertiseImageUrl> images) {
		this.images = images;
	}

	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "广告信息";
	}

}
