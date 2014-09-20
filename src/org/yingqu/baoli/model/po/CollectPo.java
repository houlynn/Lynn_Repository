package org.yingqu.baoli.model.po;

import java.util.ArrayList;
import java.util.List;

import org.yingqu.framework.model.BaseEntity;

/**
 *
* @author HouLynn
* @date 2014年9月19日
  @version 1.0
 */
public class CollectPo {
	
	/**
	 * 收藏类型
	 */
	private String type;
	
	/**
	 * 收藏信息列表
	 */
	private List<?> item;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<?> getItem() {
		return item;
	}

	public void setItem(List<?> item) {
		this.item = item;
	}


	


}
