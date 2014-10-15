package org.yingqu.baoli.model.po;

import java.util.ArrayList;
import java.util.List;

public class ViewPange {
	private int totalCount;
	private List<?> items=new ArrayList<>();
	public List<?> getItems() {
		return items;
	}
	public void setItems(List<?> items) {
		this.items = items;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	

}
