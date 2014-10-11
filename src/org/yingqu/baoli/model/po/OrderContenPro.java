package org.yingqu.baoli.model.po;

import java.util.HashSet;
import java.util.Set;

import org.yingqu.framework.annotation.FieldInfo;

public class OrderContenPro {

		private String ordid;
		@FieldInfo(name = "购买用户", visible = true, nullAble = false)
		private String userid;
		@FieldInfo(name = "送货地址", visible = true, nullAble = false)
		private String adressid;
		@FieldInfo(name = "下单时间", visible = true, nullAble = false)
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
		@FieldInfo(name = "交易状态", visible = true, nullAble = false)
		private String ispay;
		private Set<OrderItemPro> items=new HashSet<OrderItemPro>();
		public String getOrdid() {
			return ordid;
		}

		public void setOrdid(String ordid) {
			this.ordid = ordid;
		}

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

		public Set<OrderItemPro> getItems() {
			return items;
		}

		public void setItems(Set<OrderItemPro> items) {
			this.items = items;
		}
}
