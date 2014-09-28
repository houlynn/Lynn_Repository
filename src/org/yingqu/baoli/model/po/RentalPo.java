package org.yingqu.baoli.model.po;

import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.annotation.SearchProperty;
import org.yingqu.framework.constant.ExtFieldType;
/**
 * 出租信息
 *
* @author HouLynn
* @date 2014年9月28日
  @version 1.0
 */
public class RentalPo {
	@FieldInfo(name = "主键", type = ExtFieldType.ID, mobileField = true)
	private String rid;
	@FieldInfo(name = "出租信息", visible = true, nullAble = false)
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
	
	 
	
	
}
