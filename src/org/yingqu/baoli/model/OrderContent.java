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
public class OrderContent extends BaseEntity {
	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String ordid;
	@SearchProperty(index=1)
	@FieldInfo(name = "购买用户", visible = true, nullAble = false)
	private String userid;
	@FieldInfo(name = "送货地址", visible = true, nullAble = false)
	private String adressid;
	@SearchProperty(index=1)
	@FieldInfo(name = "下单时间", visible = true, nullAble = false,type=ExtFieldType.DATE)
	private String ordertime;
	@FieldInfo(name = "备注", visible = true, nullAble = false)
	private String remarks;
	@FieldInfo(name = "金额", visible = true, nullAble = false)
	private float acount;
	private String payType;
	
	/**
	 * 是否周末送货
	 */
	private String weekendto;
	
	@Dictionary
	@SearchProperty(index=1,value="ISPAY")
	@FieldInfo(name = "交易状态", visible = true, nullAble = false)
	private String ispay;
	private Set<OrderItem> items=new HashSet<OrderItem>();
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getOrdid() {
		return ordid;
	}

	public void setOrdid(String ordid) {
		this.ordid = ordid;
	}

	@Column(nullable=false)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public float getAcount() {
		return acount;
	}

	public void setAcount(float acount) {
		this.acount = acount;
	}

	public String getIspay() {
		return ispay;
	}

	public void setIspay(String ispay) {
		this.ispay = ispay;
	}

	public String getAdressid() {
		return adressid;
	}

	public void setAdressid(String adressid) {
		this.adressid = adressid;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getWeekendto() {
		return weekendto;
	}

	public void setWeekendto(String weekendto) {
		this.weekendto = weekendto;
	}

	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "订单信息";
	}
	@JsonIgnore
	@OneToMany(mappedBy="orderContent",cascade={CascadeType.REMOVE},fetch=FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.TRUE)
	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

}
