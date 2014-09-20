package org.yingqu.baoli.model.po;

/**
 * 周边商铺 信息
* @author HouLynn
* @date 2014年9月19日
  @version 1.0
 */
public class ColleckMercharPro extends CollectBase {
	
	/**
	 * 经度
	 */
	private String xponit;
/**
 * 纬度
 */
	private String yponit;
	/**
	 * 手机号
	 */
	private String phone;
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
	

}
