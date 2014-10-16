package org.yingqu.baoli.model;

import org.yingqu.framework.annotation.Dictionary;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.annotation.SearchProperty;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;

public class OrderView extends BaseEntity {
	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String ordid;
	@SearchProperty(index=1)
	@FieldInfo(name = "购买用户", visible = true, nullAble = false)
	private String loginCode;
	@SearchProperty(index=2)
	@FieldInfo(name = "下单时间", visible = true, nullAble = false,type=ExtFieldType.DATE)
	private String ordertime;
	@SearchProperty(index=1)
	@FieldInfo(name = "商品名称", visible = true, nullAble = false)
	private String gdName;
	@FieldInfo(name = "价格", visible = true, nullAble = false,type=ExtFieldType.FLOAT)
	private float price;
	@FieldInfo(name = "购买数量", visible = true, nullAble = false,type=ExtFieldType.INTEGER)
	private Integer count;
	@FieldInfo(name = "金额", visible = true, nullAble = false)
	private float acount;
	@FieldInfo(name = "送货地址", visible = true, nullAble = false)
	private String address;
	@SearchProperty(index=1)
	@FieldInfo(name = "收货人", visible = true)
	private String uname;
	@FieldInfo(name = "电话号码", visible = true)
	private String phone;
	@FieldInfo(name = "邮编", visible = true)
	private String postcode;
	@Dictionary
	@SearchProperty(index=1,value="PAYTYPE")
	@FieldInfo(name = "支付类型", visible = true, nullAble = false)
	private String payType;
	/**
	 * 是否周末送货 WEEKAN
	 */
	@Dictionary
	@SearchProperty(index=1,value="WEEKAN")
	@FieldInfo(name = "工作人,双休日与节假日均可送货", visible = true, nullAble = false)
	private String weekendto;
	@Dictionary
	@SearchProperty(index=1,value="ISPAY")
	@FieldInfo(name = "交易状态", visible = true, nullAble = false)
	private String ispay;
	public String getOrdid() {
		return ordid;
	}
	public void setOrdid(String ordid) {
		this.ordid = ordid;
	}
	public String getLoginCode() {
		return loginCode;
	}
	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getGdName() {
		return gdName;
	}
	public void setGdName(String gdName) {
		this.gdName = gdName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
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
	public String getIspay() {
		return ispay;
	}
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
