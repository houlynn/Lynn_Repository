package org.yingqu.framework.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.yingqu.framework.annotation.NodeType;
import org.yingqu.framework.constant.TreeNodeType;

/**
 * 
* @author 作者 yingqu: 
* @version 创建时间：2014年6月7日 上午11:23:01 
* version 1.0
 */
@MappedSuperclass
public abstract class TreeBaseEntity extends BaseEntity {
	@Transient
	private static final long serialVersionUID = 1L;
	@NodeType(type=TreeNodeType.LAYER)
	private Integer layer;
	@NodeType(type=TreeNodeType.NODEINFO)
	private String nodeInfo;
	@NodeType(type=TreeNodeType.LEAF)
	private String nodeType;
	@NodeType(type=TreeNodeType.NODEINFOTYPE)
	private String nodeInfoType;
	public Integer getLayer() {
		return layer;
	}
	public void setLayer(Integer layer) {
		this.layer = layer;
	}
	public String getNodeInfo() {
		return nodeInfo;
	}
	public void setNodeInfo(String nodeInfo) {
		this.nodeInfo = nodeInfo;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getNodeInfoType() {
		return nodeInfoType;
	}
	public void setNodeInfoType(String nodeInfoType) {
		this.nodeInfoType = nodeInfoType;
	}
	
}
