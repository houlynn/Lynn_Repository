package org.yingqu.baoli.model.po;

public class AppNewPo {

	/**
	 * 新闻标题
	 */
	private String title;
	/**
	 * 缩略图
	 */
	private String  img;
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
	
	
}
