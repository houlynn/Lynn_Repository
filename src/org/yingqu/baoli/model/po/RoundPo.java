package org.yingqu.baoli.model.po;

import java.util.HashSet;
import java.util.Set;


/**
 * 周边分类信息
 *
* @author HouLynn
* @date 2014年9月22日
  @version 1.0
 */
public class RoundPo {
	
	/**
	 * 类别名称
	 */
	private String name;
	/**
	 * 图片路径
	 */
	private String img;
	
	/**
	 * 类型代码
	 */
	private String code;
	
	/**
	 *子类别
	 */
	private Set<RoundPo> child=new HashSet<RoundPo>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Set<RoundPo> getChild() {
		return child;
	}
	public void setChild(Set<RoundPo> child) {
		this.child = child;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}


