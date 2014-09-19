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
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class AppVersion extends BaseEntity {
	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String id;
	@SearchProperty(index=1)
	@FieldInfo(name = "应用名称", visible = true, nullAble = false)
	private String versonName;
	@SearchProperty(index=1)
	@FieldInfo(name = "版本号", visible = true, nullAble = false)
	private String versonCode;
	@FieldInfo(name = "备注", visible = true, nullAble = false)
	private String remarks;
	@SearchProperty(index=1)
	@FieldInfo(name = "发布时间", visible = true, nullAble = false,type=ExtFieldType.DATE)
	private String uptime;
	@FieldInfo(name = "下载地址", visible = true, nullAble = false)
	private String downloadUrl ;
	@FieldInfo(name = "发布组织", visible = true, nullAble = false)
	private String publishCy;
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVersonName() {
		return versonName;
	}

	public void setVersonName(String versonName) {
		this.versonName = versonName;
	}

	public String getVersonCode() {
		return versonCode;
	}

	public void setVersonCode(String versonCode) {
		this.versonCode = versonCode;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getPublishCy() {
		return publishCy;
	}

	public void setPublishCy(String publishCy) {
		this.publishCy = publishCy;
	}

	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "APP版本信息";
	}

}
