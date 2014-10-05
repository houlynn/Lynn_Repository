package org.yingqu.baoli.model.po;

import java.util.ArrayList;
import java.util.List;

import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.annotation.SearchProperty;
import org.yingqu.framework.constant.ExtFieldType;

public class SellOferPoDetail {
	@FieldInfo(name = "主键", type = ExtFieldType.ID, mobileField = true)
	private String rid;
	@FieldInfo(name = "出售信息", visible = true, nullAble = false)
	private String title;
	@FieldInfo(name = "面积", visible = true, nullAble = false)
	private float area;
	@FieldInfo(name = "价格", visible = true, nullAble = false)
	private String  price;
	@SearchProperty(index=1)
	@FieldInfo(name = "发布时间", visible = true, nullAble = false)
	private String ptime;
	@FieldInfo(name = "来源", visible = true, nullAble = false)
	private String source;
	private String sellContent;
	private List<String> imgs=new ArrayList<String>();
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSellContent() {
		return sellContent;
	}
	public void setSellContent(String sellContent) {
		this.sellContent = sellContent;
	}
	public List<String> getImgs() {
		return imgs;
	}
	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}

	
}
