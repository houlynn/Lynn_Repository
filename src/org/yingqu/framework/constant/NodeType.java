package org.yingqu.framework.constant;

public enum NodeType {

	ROOT("ROOT"),LEAF("LEAF"),GENERAL("GENERAL");
	private NodeType(String type)
	{
		this.type=type;
	}
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
