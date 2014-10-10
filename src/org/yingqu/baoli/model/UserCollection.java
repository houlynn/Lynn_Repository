package org.yingqu.baoli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;

@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class UserCollection extends BaseEntity {

	@FieldInfo(name = "主键", type = ExtFieldType.ID)
	private String id;
	@FieldInfo(name = "收藏ID", visible=true)
	private String cid;
	
	/***
	 * 1 收藏类型   001周边商铺
	 * 2       002 商品
	 * 3       003帖子类型
	 */
	@FieldInfo(name = "分类名称", visible=true)
	private String  ctype;
	@FieldInfo(name = "用户ID", visible=true)
	private String uid;
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	@Column(nullable=false)
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "用户收藏";
	}

}
