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

/**
 *
* @author HouLynn
* @date 2014年8月26日
  @version 1.0
 */
@Entity
@GenericGenerator(name="systemUUID",strategy="uuid")
public class PostText extends BaseEntity {
	@FieldInfo(name="主键",type=ExtFieldType.ID)
	private String postid;
	@FieldInfo(name = "标题", visible = true, nullAble = false)
	private String title;
	@FieldInfo(name = "内容", visible = true, nullAble = false)
	private String context;
	@FieldInfo(name = "发送时间", visible = true, nullAble = false,type=ExtFieldType.DATE)
	private String posttime;
	@FieldInfo(name = "是否发贴", visible = true, nullAble = false)
	private String isPost;
	@FieldInfo(name = "类别", visible = true, nullAble = false)
	private String typid;
	@FieldInfo(name = "发送人", visible = true, nullAble = false)
	private String  userid;
	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getPostid() {
		return postid;
	}

	public void setPostid(String postid) {
		this.postid = postid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getPosttime() {
		return posttime;
	}

	public void setPosttime(String posttime) {
		this.posttime = posttime;
	}

	public String getIsPost() {
		return isPost;
	}

	public void setIsPost(String isPost) {
		this.isPost = isPost;
	}

	public String getTypid() {
		return typid;
	}

	public void setTypid(String typid) {
		this.typid = typid;
	}

	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "贴子信息";
	}

}
