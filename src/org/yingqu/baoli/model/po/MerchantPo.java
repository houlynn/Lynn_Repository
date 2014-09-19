package org.yingqu.baoli.model.po;

import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.vo.PModel;

/**
 * 用户修改
* @author HouLynn
* @date 2014年9月2日
  @version 1.0
 */
public class MerchantPo extends PModel {
	
	@FieldInfo(type=ExtFieldType.ID)
	private String merid;
 	/**
	 * 营业时间
	 */
   private String businesstime;                          
 	/**
	 * 营业执照
	 */
   private String cardid;                          
 	/**
	 * 是否上门
	 */
   private String come;                          
 	/**
	 * 联系方式
	 */
   private String homePhone;                          
 	/**
	 * 商户名称
	 */
   private String name;                          
 	/**
	 * 手机号码
	 */
   private String phone;                          
 	/**
	 * 服务描述
	 */
   private String remarks;                          
 	/**
	 * 申请用户id
	 */
   private String userid;                          
      public String getBusinesstime(){
		return businesstime;
	}
	public void setBusinesstime(String businesstime) {
		this.businesstime = businesstime;
		}
      public String getCardid(){
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
		}
      public String getCome(){
		return come;
	}
	public void setCome(String come) {
		this.come = come;
		}
      public String getHomePhone(){
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
		}
      public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
		}
      public String getPhone(){
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
		}
      public String getRemarks(){
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
		}
      public String getUserid(){
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
		}
	public String getMerid() {
		return merid;
	}
	public void setMerid(String merid) {
		this.merid = merid;
	}
            
}
