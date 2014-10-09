package org.yingqu.baoli.model.po;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.yingqu.framework.utils.JsonBuilder;

public class ImageParam {
	private String imgStr;
	private String postfix;
	public String getImgStr() {
		return imgStr;
	}
	public void setImgStr(String imgStr) {
		this.imgStr = imgStr;
	}
	public String getPostfix() {
		return postfix;
	}
	public void setPostfix(String postfix) {
		this.postfix = postfix;
	}
	
/*public static void main(String[] args) {
	List<ImageParam>  list=new ArrayList<>();
	ImageParam param=new ImageParam();
	param.setImgStr("qqwqw");
	param.setPostfix("jpg");
	ImageParam param1=new ImageParam();
	param1.setImgStr("qqwqw");
	param1.setPostfix("jpg");
	list.add(param1);
	list.add(param);
	System.out.println(JsonBuilder.getInstance().toJson(list));
}*/
}
