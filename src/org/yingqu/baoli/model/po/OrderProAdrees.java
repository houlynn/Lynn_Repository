package org.yingqu.baoli.model.po;

import java.util.HashSet;
import java.util.Set;

import org.yingqu.baoli.model.OrderItem;
import org.yingqu.baoli.model.UserAdress;
import org.yingqu.framework.model.vo.PModel;

/**
 * 客户端 我的订单展示信息
* @author HouLynn
* @date 2014年9月18日
  @version 1.0
 */
public class OrderProAdrees extends PModel {
	
	/**
	 * 下单时间
	 */
	private String ordertime;
	/**
	 * 共几件商品
	 */
	private int itemCount;
	/**
	 * 总金额
	 */
	private float  acount;
	
	/**
	 * 订单状态 1待付款000  2支付成功 001  3 交易 成功 002   4交易关闭003
	 */
	private String ispay;
	
	/**
	 * 用户送货地址
	 */
	private UserAdress adress;

	
	/**
	 * 订单项
	 */
	private Set<OrderItem> items=new HashSet<OrderItem>();


	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
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

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	public UserAdress getAdress() {
		return adress;
	}

	public void setAdress(UserAdress adress) {
		this.adress = adress;
	}


}
