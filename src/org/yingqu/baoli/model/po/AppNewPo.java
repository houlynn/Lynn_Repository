package org.yingqu.baoli.model.po;

public class AppNewPo {

	/**
	 * 条目ID
	 */
	private String itemId;
	
	/**
	 * 新闻标题
	 */
	private String title;
	/**
	 * 缩略图
	 */
	private String  img;
	
	/**
	 * 评论数量
	 */
	private int onCount;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public AppNewPo(String title, String img) {
		this.title = title;
		this.img = img;
	}
	public AppNewPo() {
	}
	public int getOnCount() {
		return onCount;
	}
	public void setOnCount(int onCount) {
		this.onCount = onCount;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	
}
