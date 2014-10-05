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
 * 出售
 *
* @author HouLynn
* @date 2014年9月26日
  @version 1.0
 */
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class SellOfer extends BaseEntity {
	@FieldInfo(name = "主键", type = ExtFieldType.ID, mobileField = true)
	private String rid;
	@FieldInfo(name = "出售信息", visible = true, nullAble = false)
	private String title;
	@FieldInfo(name = "面积", visible = true, nullAble = false)
	private float area;
	@FieldInfo(name = "价格", visible = true, nullAble = false)
	private String  price;
	@SearchProperty(index=1)
	@FieldInfo(name = "发布时间", visible = true, nullAble = false)
	private String ptime;
	@FieldInfo(name = "来源", visible = true, nullAble = false)
	private String source;
	@Dictionary("ISPOST")
	@SearchProperty(index=2)
	@FieldInfo(name="发布状态")
	private String  state;
	private String username;
	
	private String sellContent;
	@Column(name="content", columnDefinition="MEDIUMTEXT")
	public String getSellContent() {
		return sellContent;
	}

	public void setSellContent(String sellContent) {
		this.sellContent = sellContent;
	}
	private Set<SellOferImg> imgs= new  HashSet<SellOferImg>();
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}
	@Column(nullable=false,length=500)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPtime() {
		return ptime;
	}

	public void setPtime(String ptime) {
		this.ptime = ptime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	@OneToMany(mappedBy="sell",cascade={CascadeType.REMOVE},fetch=FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.TRUE)
	public Set<SellOferImg> getImgs() {
		return imgs;
	}

	public void setImgs(Set<SellOferImg> imgs) {
		this.imgs = imgs;
	}
	@JsonIgnore
	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "出售";
	}

}
