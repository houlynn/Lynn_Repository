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
import org.yingqu.framework.annotation.FieldInfo;
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
public class OrderItem extends BaseEntity {
	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String  oitmid;
	@FieldInfo(name = "商品id", visible = true, nullAble = false)
	private String gid;
	@FieldInfo(name = "价格", visible = true, nullAble = false,type=ExtFieldType.FLOAT)
	private float price;
	@FieldInfo(name = "购买数量", visible = true, nullAble = false,type=ExtFieldType.INTEGER)
	private Integer count;
	@FieldInfo(name = "金额", visible = true, nullAble = false,type=ExtFieldType.FLOAT)
	private float acount;
	private OrderContent orderContent;

	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getOitmid() {
		return oitmid;
	}

	public void setOitmid(String oitmid) {
		this.oitmid = oitmid;
	}

	@Column(nullable=false)
	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public float getAcount() {
		return acount;
	}

	public void setAcount(float acount) {
		this.acount = acount;
	}
	@JsonIgnore
    @ManyToOne(optional=false)
    @JoinColumn(name="orderid")
	public OrderContent getOrderContent() {
		return orderContent;
	}

	public void setOrderContent(OrderContent orderContent) {
		this.orderContent = orderContent;
	}

	@JsonIgnore
	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "订单详细信息";
	}

}
