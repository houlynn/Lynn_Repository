package org.yingqu.desktop.model.view;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.yingqu.desktop.model.Department;
import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.annotation.NodeType;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.constant.TreeNodeType;
import org.yingqu.framework.model.TreeBaseEntity;

/**
* @author 作者 yingqu: 
* @version 创建时间：2014年6月21日 下午10:42:58 
* version 1.0
 */

public class VDeptUser extends TreeBaseEntity {
	@NodeType(type=TreeNodeType.ID)
	@FieldInfo(name="主键",type=ExtFieldType.ID)
	private String id;
	@NodeType(type=TreeNodeType.TEXT)
	@FieldInfo(name="名称")
	private String text;
	@NodeType(type=TreeNodeType.CODE)
	@FieldInfo(name="编码")
	private String code;
	@NodeType(type=TreeNodeType.DISABLED)
	@FieldInfo(name="是否不可选")
	private String disabled;
	@NodeType(type=TreeNodeType.ICON)
	@FieldInfo(name="图标")
	private String icon;
	@NodeType(type=TreeNodeType.PARENT)
	@FieldInfo(name="图标")
	private Department parent;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public Department getParent() {
		return parent;
	}
	public void setParent(Department parent) {
		this.parent = parent;
	}
	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
