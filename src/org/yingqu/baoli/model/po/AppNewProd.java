package org.yingqu.baoli.model.po;

public class AppNewProd  extends AppNewPo{
/**
 * 发布时间
 */
	private String addate;
	/**
	 * 新闻内容
	 */
	 private String newContent;
	 
	 /**
	  * 新闻来源
	  */
	 private String source;
	public String getAddate() {
		return addate;
	}
	public void setAddate(String addate) {
		this.addate = addate;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getNewContent() {
		return newContent;
	}
	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}
	 

}
