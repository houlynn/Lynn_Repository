package org.yingqu.baoli.model.po;

import java.util.ArrayList;
import java.util.List;

public class OrderDetail {

	
	/**
	 * 图片集合
	 */
	private List<String> imgs=new ArrayList<String>();
	/**
	 * 商品名称
	 */
	private String name;
	
	/**
	 * 描述信息
	 */
	private String remarks;
	
	/**
	 * 单价
	 */
	private float price;

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<String> getImgs() {
		return imgs;
	}

	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
}
