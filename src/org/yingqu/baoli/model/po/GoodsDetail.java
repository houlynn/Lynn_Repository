package org.yingqu.baoli.model.po;


import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.constant.ExtFieldType;
/**
 * 商品详细信息
* @author 作者 HouLynn: 
* @version 创建时间：2014年9月23日 下午9:40:47 
* version 1.0
 */
public class GoodsDetail {

	@FieldInfo(name = "主键", type = ExtFieldType.ID,mobileField=true)
	private String gid;
	@FieldInfo(name = "商品名称", visible = true, nullAble = false)
	private String name;
	@FieldInfo(name = "价格", visible = true, nullAble = false)
	private  float price;
	@FieldInfo(name = "原价格", visible = true, nullAble = false)
	private  float yprice;
	/**
	 * 返回json数据
	 */
	@FieldInfo(name = "图片地址", visible = true, nullAble = false)
	private String img;
	@FieldInfo(name = "成分或描述", visible = true, nullAble = false,mobileField=true)
	private String remarks;
	/**
	 * 0 不包邮 1 包邮
	 */
	@FieldInfo(name = "是否包邮", visible = true, nullAble = false)
	private String free; 
	@FieldInfo(name = "月销量", visible = true, nullAble = false,type=ExtFieldType.FLOAT)
	private float saleCount;
	@FieldInfo(name = "库存", visible = true, nullAble = false,type=ExtFieldType.FLOAT)
	private float stock;
	@FieldInfo(name = "运费", visible = true, nullAble = false,type=ExtFieldType.FLOAT)
	private float moveprice;
	@FieldInfo(name = "保质期", visible = true, nullAble = false)
	private String  shelfdate;
	@FieldInfo(name = "产地", visible = true, nullAble = false)
	private String origin;
	@FieldInfo(name = "规格", visible = true, nullAble = false)
	private String specification; 
	@FieldInfo(name = "发货地", visible = true, nullAble = false)
	private String shipfrom;
	
	
	private boolean 
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getYprice() {
		return yprice;
	}
	public void setYprice(float yprice) {
		this.yprice = yprice;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getFree() {
		return free;
	}
	public void setFree(String free) {
		this.free = free;
	}
	public float getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(float saleCount) {
		this.saleCount = saleCount;
	}
	public float getStock() {
		return stock;
	}
	public void setStock(float stock) {
		this.stock = stock;
	}
	public float getMoveprice() {
		return moveprice;
	}
	public void setMoveprice(float moveprice) {
		this.moveprice = moveprice;
	}
	public String getShelfdate() {
		return shelfdate;
	}
	public void setShelfdate(String shelfdate) {
		this.shelfdate = shelfdate;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getShipfrom() {
		return shipfrom;
	}
	public void setShipfrom(String shipfrom) {
		this.shipfrom = shipfrom;
	} 
	
	
	
}
