package org.yingqu.baoli.model.po;

import java.util.ArrayList;
import java.util.List;

import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.annotation.SearchProperty;
import org.yingqu.framework.constant.ExtFieldType;

public class OrderItemPro {
	
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
	private List<String> imgs=new ArrayList<String>();
	
	@FieldInfo(name = "购买数量", visible = true, nullAble = false,type=ExtFieldType.INTEGER)
	private Integer count;
	@FieldInfo(name = "发货地", visible = true, nullAble = false)
	private String shipfrom; 
	@FieldInfo(name = "销量", visible = true, nullAble = false,type=ExtFieldType.FLOAT)
	private float saleCount;
	@FieldInfo(name = "是否包邮", visible = true, nullAble = false)
	private String free; 
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
	public float getYprice() {
		return yprice;
	}
	public void setYprice(float yprice) {
		this.yprice = yprice;
	}
	public List<String> getImgs() {
		return imgs;
	}
	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}
	

}
