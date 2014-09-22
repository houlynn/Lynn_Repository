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
* @date 2014年9月3日
  @version 1.0
 */
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class AppClassify extends BaseEntity {
	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String cid;
	@SearchProperty(index=1)
	@FieldInfo(name = "分类名称", visible=true)
	private String classify;
	@FieldInfo(name = "图片链接地址",visible=true)
	private String imgurl;
	@Dictionary("ROUNDTYPE")
	private String typeCode;
	private Set<AppClassifyItem> items=new HashSet<AppClassifyItem>();
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	@Column(unique=true,length=100)
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	@Column(length=500)
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="ac",cascade={CascadeType.REMOVE})
	@LazyCollection(LazyCollectionOption.TRUE)
	public Set<AppClassifyItem> getItems() {
		return items;
	}
	public void setItems(Set<AppClassifyItem> items) {
		this.items = items;
	}
	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "app类别信息";
	}
}
