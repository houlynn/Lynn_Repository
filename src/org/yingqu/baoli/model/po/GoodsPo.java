package org.yingqu.baoli.model.po;

import java.util.ArrayList;
import java.util.List;


/**
 * 商品信息
* @author HouLynn
* @date 2014年9月22日
  @version 1.0
 */
public class GoodsPo {
	
	/**
	 * 图片集合
	 */
	private List<String> imgs=new ArrayList<String>();
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 价格
	 */
	private  float price;
	/**
	 * 原价格
	 */
	private  float yprice;
	
	/**
	 * saleCount
	 */
	private float  saleCount;
	
	
	/**
	 * 广告词
	 */
	private String trip;
	

	public String getTrip() {
		return trip;
	}

	public void setTrip(String trip) {
		this.trip = trip;
	}

	public GoodsPo(List<String> imgs, String name, float price, float yprice,
			float saleCount) {
		super();
		this.imgs = imgs;
		this.name = name;
		this.price = price;
		this.yprice = yprice;
		this.saleCount = saleCount;
	}

	public GoodsPo() {
		super();
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

	public float getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(float saleCount) {
		this.saleCount = saleCount;
	}
	
	

}
