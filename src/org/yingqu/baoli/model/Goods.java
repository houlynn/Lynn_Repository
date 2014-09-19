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
* @date 2014年8月26日
  @version 1.0
 */
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class Goods extends BaseEntity {

	@FieldInfo(name = "主键", type = ExtFieldType.ID,mobileField=true)
	private String gid;
	@SearchProperty(index=1)
	@FieldInfo(name = "商品名称", visible = true, nullAble = false)
	private String name;
	@FieldInfo(name = "价格", visible = true, nullAble = false)
	private  float price;
	@FieldInfo(name = "原价格", visible = true, nullAble = false)
	private  float yprice;
	@FieldInfo(name = "图片地址", visible = true, nullAble = false)
	private String img;
	@FieldInfo(name = "描述", visible = true, nullAble = false,mobileField=true)
	private String remarks;
	@Dictionary("ISHOTGOODS")
	@SearchProperty(index=1,value="ISHOTGOODS")
	@FieldInfo(name = "是否推荐商品", visible = true, nullAble = false)
	private String hot;
	@Dictionary("ISPOST")
	@SearchProperty(index=1,value="ISPOST")
	@FieldInfo(name = "是否发布", visible = true, nullAble = false)
	private String  releases;
	@Dictionary("ISFREE")
	@SearchProperty(index=1,value="ISFREE")
	@FieldInfo(name = "是否包邮", visible = true, nullAble = false)
	private String free; 
	@SearchProperty(index=1)
	@FieldInfo(name = "发布时间", visible = true, nullAble = false,type=ExtFieldType.DATE)
	private String releasetime;
	@FieldInfo(name = "销量", visible = true, nullAble = false,type=ExtFieldType.FLOAT)
	private float saleCount;
	@FieldInfo(name = "库存", visible = true, nullAble = false,type=ExtFieldType.FLOAT)
	private float stock;
	@FieldInfo(name = "运费", visible = true, nullAble = false,type=ExtFieldType.FLOAT)
	private float moveprice;
	@FieldInfo(name = "保质期", visible = true, nullAble = false)
	private String  shelfdate;
	@FieldInfo(name = "产地", visible = true, nullAble = false)
	private String origin;
	@FieldInfo(name = "规格", visible = true, nullAble = false)
	private String specification; 
	@FieldInfo(name = "发货地", visible = true, nullAble = false)
	private String shipfrom; 
	private Set<GoodImage> imgs=new HashSet<GoodImage>();
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getHot() {
		return hot;
	}

	public void setHot(String hot) {
		this.hot = hot;
	}


	public String getReleases() {
		return releases;
	}

	public void setReleases(String releases) {
		this.releases = releases;
	}

	public String getReleasetime() {
		return releasetime;
	}

	public void setReleasetime(String releasetime) {
		this.releasetime = releasetime;
	}
	public float getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(float saleCount) {
		this.saleCount = saleCount;
	}

	public float getStock() {
		return stock;
	}

	public void setStock(float stock) {
		this.stock = stock;
	}

	public float getMoveprice() {
		return moveprice;
	}

	public void setMoveprice(float moveprice) {
		this.moveprice = moveprice;
	}
	public float getYprice() {
		return yprice;
	}

	public void setYprice(float yprice) {
		this.yprice = yprice;
	}

	public String getShelfdate() {
		return shelfdate;
	}

	public void setShelfdate(String shelfdate) {
		this.shelfdate = shelfdate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getShipfrom() {
		return shipfrom;
	}

	public String getFree() {
		return free;
	}

	public void setFree(String free) {
		this.free = free;
	}

	public void setShipfrom(String shipfrom) {
		this.shipfrom = shipfrom;
	}
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="good",cascade={CascadeType.REMOVE})
	@LazyCollection(LazyCollectionOption.TRUE)
	public Set<GoodImage> getImgs() {
		return imgs;
	}

	public void setImgs(Set<GoodImage> imgs) {
		this.imgs = imgs;
	}

	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "商品信息";
	}

}
