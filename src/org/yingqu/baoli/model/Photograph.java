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
import org.yingqu.framework.annotation.SearchProperty;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;

/**
 * 
* @author xing
* @date 2014年9月19日
  @业主互动帖子图片
 */
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class Photograph extends BaseEntity 
{
	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String iimgid;
    @FieldInfo(name = "图片链接地址",visible=true)
	private String imgurl;
    private Interact inter;
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getIimgid() {
		return iimgid;
	}
    
	public void setIimgid(String iimgid) {
		this.iimgid = iimgid;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getImgurl() {
		return imgurl;
	}
    @JsonIgnore
    @ManyToOne(optional=false)
    @JoinColumn(name="iterid")
	public Interact getInter() {
		return inter;
	}
	public void setInter(Interact inter) {
		this.inter = inter;
	}


	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "业主互动图片地址";
	}
}
