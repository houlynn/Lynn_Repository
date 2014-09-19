package org.yingqu.baoli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;
/**
 *
* @author HouLynn
* @date 2014年8月30日
  @version 1.0
 */
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class AvvertiseImageUrl extends BaseEntity {
	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String id;
	@FieldInfo(name = "链接路径", visible = true, nullAble = false)
	private String url;
	private Advertisement adt;
	
	
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@JsonIgnore
    @ManyToOne(optional=false)
    @JoinColumn(name="adverid")
	public Advertisement getAdt() {
		return adt;
	}
	public void setAdt(Advertisement adt) {
		this.adt = adt;
	}
	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "小区图片列表";
	}


}
