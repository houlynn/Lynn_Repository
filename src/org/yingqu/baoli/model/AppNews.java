package org.yingqu.baoli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.yingqu.framework.annotation.Dictionary;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.annotation.SearchProperty;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.model.BaseEntity;

/**
 *
 * @author HouLynn
 * @date 2014年9月11日
 * @version 1.0
 */
@Entity
@GenericGenerator(name = "systemUUID", strategy = "uuid")
public class AppNews extends BaseEntity {

	@FieldInfo(name = "主键", type = ExtFieldType.ID, mobileField = true)
	private String newid;
	@SearchProperty(index = 1)
	@FieldInfo(name = "标题", visible = true, nullAble = false)
	private String title;
	@FieldInfo(name = "来源", visible = true, nullAble = false)
	private String source;
	@FieldInfo(name = "缩略图", visible = true, nullAble = false)
	private String shrinkimg;
	@SearchProperty(index = 2)
	@FieldInfo(name = "发布时间", visible = true, nullAble = false, type = ExtFieldType.DATE)
	private String addtime;
	@SearchProperty(index = 1)
	@Dictionary(value = "ISPOST")
	@FieldInfo(name = "发布状态", visible = true, nullAble = false)
	private String state;
	
	private String adddate;
	private String context;

	@Id
	@GeneratedValue(generator = "systemUUID")
	@Column(length = 50)
	public String getNewid() {
		return newid;
	}

	public void setNewid(String newid) {
		this.newid = newid;
	}
	@Column(length = 500)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getShrinkimg() {
		return shrinkimg;
	}

	public void setShrinkimg(String shrinkimg) {
		this.shrinkimg = shrinkimg;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@Column(name="context", columnDefinition="TEXT")
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getAdddate() {
		return adddate;
	}

	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}

	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "APP新闻";
	}

}
