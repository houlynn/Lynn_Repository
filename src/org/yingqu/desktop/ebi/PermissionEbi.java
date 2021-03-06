package org.yingqu.desktop.ebi;

import java.util.List;

import org.yingqu.desktop.model.Permission;
import org.yingqu.framework.ebi.SimpleEbi;
import org.yingqu.framework.model.vo.JSONTreeNode;

/**
 * 
* @author 作者 yingqu: 
* @version 创建时间：2014年6月23日 下午12:51:32 
* version 1.0
 */
public interface PermissionEbi extends SimpleEbi<Permission> {

	/**
	 * 得到权限树形
	 * @param rooId
	 * @param roleId
	 * @param isSee
	 * @return
	 */
	public List<JSONTreeNode> getPermTree(String roodId,String author,String authorType,Boolean isSee,Boolean expanded) throws Exception;
	/**
	 * 更新权限
	 * @param roleId
	 * @param addIds
	 * @param delIds
	 */
	public void doUpdatePerm(String roleId,String addIds,String delIds) throws Exception ;
}
