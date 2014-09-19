package org.yingqu.baoli.model.po;

import org.yingqu.framework.model.vo.PModel;

/**
 * 用户修改
* @author HouLynn
* @date 2014年9月2日
  @version 1.0
 */
public class UserAdressPo extends PModel {
 	/**
	 * 详细地址
	 */
   private String address;                          
 	/**
	 * 是否为默认地址
	 */
   private String defaulted;                          
 	/**
	 * 主键
	 */
   private String udid;                          
 	/**
	 * 收货人
	 */
   private String uname;  
   
 	/**
	 * 用户标示
	 */
   private String userid;                          
      public String getAddress(){
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
		}
      public String getDefaulted(){
		return defaulted;
	}
	public void setDefaulted(String defaulted) {
		this.defaulted = defaulted;
		}
      public String getUdid(){
		return udid;
	}
	public void setUdid(String udid) {
		this.udid = udid;
		}
      public String getUname(){
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
		}
      public String getUserid(){
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
		}
            
}
