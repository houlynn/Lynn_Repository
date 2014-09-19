package org.yingqu.framework.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.yingqu.framework.annotation.FieldInfo;

/**
 * 
* @author 作者 yingqu: 
* @version 创建时间：2014年6月7日 上午10:57:37 
* version 1.0
 */
@MappedSuperclass
public abstract class BaseExtendEntity extends BaseEntity {
	@Transient
	private static final long serialVersionUID = 1L;
	@FieldInfo(name="备用字段1")
	private String ext01;
	@FieldInfo(name="备用字段2")
	private String ext02;
	@FieldInfo(name="备用字段3")
	private String ext03;
	@FieldInfo(name="备用字段4")
	private String ext04;
	@FieldInfo(name="备用字段5")
	private String ext05;
	@Column(length=1000)
	public String getExt01() {
		return ext01;
	}
	public void setExt01(String ext01) {
		this.ext01 = ext01;
	}
	@Column(length=1000)
	public String getExt02() {
		return ext02;
	}
	public void setExt02(String ext02) {
		this.ext02 = ext02;
	}
	@Column(length=1000)
	public String getExt03() {
		return ext03;
	}
	public void setExt03(String ext03) {
		this.ext03 = ext03;
	}
	@Column(length=1000)
	public String getExt04() {
		return ext04;
	}
	public void setExt04(String ext04) {
		this.ext04 = ext04;
	}
	@Column(length=1000)
	public String getExt05() {
		return ext05;
	}
	public void setExt05(String ext05) {
		this.ext05 = ext05;
	}
	
}
