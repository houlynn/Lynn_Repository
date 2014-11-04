package org.yingqu.baoli.model.po;

import org.yingqu.framework.annotation.FieldInfo;
public class MerChartViewDetail {
	 private String icon;
	 private String name;
	 private String address;
		/**
		 * 经度
		 */
		private String xponit;
		/**
		 * 纬度
		 */
		private String yponit;
		
		@FieldInfo(name = "手机号码", visible = true, nullAble = false,mobileField=true)
		private String phone;
		
		
		private String merid;
		private boolean collection;

		public String getIcon() {
			return icon;
		}


		public void setIcon(String icon) {
			this.icon = icon;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getXponit() {
			return xponit;
		}


		public void setXponit(String xponit) {
			this.xponit = xponit;
		}


		public String getYponit() {
			return yponit;
		}


		public void setYponit(String yponit) {
			this.yponit = yponit;
		}


		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		public String getMerid() {
			return merid;
		}


		public void setMerid(String merid) {
			this.merid = merid;
		}


		public boolean isCollection() {
			return collection;
		}


		public void setCollection(boolean collection) {
			this.collection = collection;
		}



}
