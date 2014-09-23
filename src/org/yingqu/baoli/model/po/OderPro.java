package org.yingqu.baoli.model.po;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *订单提交参数
* @author HouLynn
* @date 2014年9月23日
  @version 1.0
 */
public class OderPro {

	/**
	 * 地址标示
	 */
	private String udid;
	/**
	 * 详细订单信息   返回订单详细的json数据
	 * key gid  value 商品 id
	 * key count value 购买数量
	 */
	private String oderStr;
	/**
	 * 送货备注
	 */
	private  String remark;
	/**
	 * 总金额
	 */
	private float aoucnt;
	
	/**
	 * 下单时间
	 */
	private String ordertime;
	public String getUdid() {
		return udid;
	}
	public void setUdid(String udid) {
		this.udid = udid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public float getAoucnt() {
		return aoucnt;
	}
	public void setAoucnt(float aoucnt) {
		this.aoucnt = aoucnt;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getOderStr() {
		return oderStr;
	}
	public void setOderStr(String oderStr) {
		this.oderStr = oderStr;
	}
	
	
}
