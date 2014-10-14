package org.yingqu.baoli.model.po;
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
	 * 下单时间（店名）
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
	 * 订单状态 
	 * 1待付款000  
	 * 2交易成功 001  
	 * 3 交易关闭002   
	 */
	private String ispay;
	
	/**
	 * 商品属性
	 */
	private  OrderDetail goodInfo=new OrderDetail();
	

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

	public OrderDetail getGoodInfo() {
		return goodInfo;
	}

	public void setGoodInfo(OrderDetail goodInfo) {
		this.goodInfo = goodInfo;
	}



}
