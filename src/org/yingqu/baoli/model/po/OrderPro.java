package org.yingqu.baoli.model.po;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.yingqu.baoli.model.OrderItem;
import org.yingqu.framework.model.vo.PModel;

/**
 * 客户端 我的订单展示信息
* @author HouLynn
* @date 2014年9月18日
  @version 1.0
 */
public class OrderPro extends PModel {
	
	/**
	 *订单主键
	 */
	private String  ordid;
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
	 * 订单状态  1 交易 成功！ 2待付款 3  交易关闭
	 */
	private String ispay;
	
	/**
	 * 订单项
	 */
	private Set<OrderItem> items=new HashSet<OrderItem>();

	public String getOrdid() {
		return ordid;
	}

	public void setOrdid(String ordid) {
		this.ordid = ordid;
	}

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


}
