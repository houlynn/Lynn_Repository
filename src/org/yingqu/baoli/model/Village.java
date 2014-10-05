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
import org.yingqu.baoli.model.DeptImageUrl;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.annotation.NodeType;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.constant.TreeNodeType;
import org.yingqu.framework.model.BaseEntity;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
/**
 *小区信息
* @author HouLynn
* @date 2014年8月26日
  @version 1.0
 */
@Entity
@GenericGenerator(name="systemUUID",strategy="uuid")
public class Village extends BaseEntity {
	@NodeType(type=TreeNodeType.ID)
	@FieldInfo(name="主键", type=ExtFieldType.ID)
	private String viid;
	@NodeType(type=TreeNodeType.TEXT)
	@FieldInfo(name="小区名称",visible=true,nullAble=true)
	private String name;
	@NodeType(type=TreeNodeType.PARENT)
	@FieldInfo(name = "城市", visible = true, nullAble = false)
	private String city;
	@FieldInfo(name = "地理位置", visible = true, nullAble = false)
	private String location;
	@FieldInfo(name = "简介", visible = true, nullAble = false)
	private String summary;
	@FieldInfo(name = "小区介绍", visible = true, nullAble = false)
	private String introduce;
	@FieldInfo(name = "经度纬度", visible = true, nullAble = false)
	private String locationxy;
	private Set<DeptImageUrl>  images=new HashSet<DeptImageUrl>();
	/**
	 * 省份
	 */
	private String province;
	@Id
	@GeneratedValue(generator="systemUUID")
	@Column(length=50)
	public String getViid() {
		return viid;
	}
	public String getLocationxy() {
		return locationxy;
	}
	public void setLocationxy(String locationxy) {
		this.locationxy = locationxy;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public void setViid(String viid) {
		this.viid = viid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@JsonIgnore
	@OneToMany(mappedBy="vi",cascade={CascadeType.REMOVE},fetch=FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.TRUE)
	public Set<DeptImageUrl> getImages() {
		return images;
	}
	public void setImages(Set<DeptImageUrl> images) {
		this.images = images;
	}
	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "小区信息";
	}
	
}
