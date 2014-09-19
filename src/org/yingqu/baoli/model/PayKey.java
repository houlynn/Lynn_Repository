package org.yingqu.baoli.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.annotation.SearchProperty;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;

/**
 *
* @author HouLynn
* @date 2014年8月26日
  @version 1.0
 */
@Entity
@GenericGenerator(name="systemUUID",strategy="uuid")
public class PayKey extends BaseEntity {
	@FieldInfo(name="主键",type=ExtFieldType.ID)
	private String pid;
	@SearchProperty(index=1)
	@FieldInfo(name = "帐号人姓名", visible = true, nullAble = false)
	private String realname;
	@FieldInfo(name = "帐号", visible = true, nullAble = false)
	private String payCode;
	@FieldInfo(name = "密钥", visible = true, nullAble = false)
	private String keyword;
	@FieldInfo(name = "所属小区", visible = true, nullAble = false)
	private String deptid;
	@FieldInfo(name = "备注", visible = true)
	private String remarks;
	
	@Id
	@GeneratedValue(generator="systemUUID")
	@Column(length=50)
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "支付平台管理";
	}

}
