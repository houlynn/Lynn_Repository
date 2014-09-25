package org.yingqu.baoli.model.po;

import java.util.ArrayList;
import java.util.List;

/**
 * 帖子信息
* @author 作者 HouLynn: 
* @version 创建时间：2014年9月25日 下午9:54:40 
* version 1.0
 */
public class InteractPo extends InteractListPo {
	private List<MessagePo> mesges=new ArrayList<MessagePo>();

	public List<MessagePo> getMesges() {
		return mesges;
	}

	public void setMesges(List<MessagePo> mesges) {
		this.mesges = mesges;
	}

}
