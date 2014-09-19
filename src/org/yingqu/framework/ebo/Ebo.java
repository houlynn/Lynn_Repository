package org.yingqu.framework.ebo;

import java.util.ArrayList;
import java.util.List;

import org.yingqu.desktop.ebi.OperateLogEbi;
import org.yingqu.desktop.model.OperateLog;
import org.yingqu.framework.ebi.Ebi;
import org.yingqu.framework.ebi.SimpleEbi;
import org.yingqu.framework.irepertory.Irepertory;
import org.yingqu.framework.model.BaseEntity;
import org.yingqu.framework.model.BaseViewModel;
import org.yingqu.framework.model.Model;
import org.yingqu.framework.model.modelHandler.LogModelHandler;
import org.yingqu.framework.model.vo.JSONTreeNode;
import org.yingqu.framework.utils.StringUtil;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.yingqu.framework.assist.Condition;
import org.yingqu.framework.assist.Page;
import org.yingqu.framework.constant.NodeType;
import org.yingqu.framework.constant.OperateLogType;

/**
 * 
 * @author 作者 yingqu:
 * @version 创建时间：2014年7月9日 下午12:25:26 version 1.0
 */
public class Ebo<M extends BaseEntity, V extends BaseViewModel> implements
		Ebi<M, V> {

	@Autowired
	protected Irepertory<M, V> repertory;
	@Autowired
	protected SimpleEbi<OperateLog> ebi;

	public SimpleEbi<OperateLog> getEbi() {
		return ebi;
	}

	public void setEbi(SimpleEbi<OperateLog> ebi) {
		this.ebi = ebi;
	}

	public Irepertory<M, V> getRepertory() {
		return repertory;
	}

	public void setRepertory(Irepertory<M, V> repertory) {
		this.repertory = repertory;
	}

	@Override
	public <T extends M> T findById(Class<T> clazz, String id) throws Exception {
		// TODO Auto-generated method stub
		return repertory.findById(clazz, id);
	}

	@Override
	public <T extends V> T findByVId(Class<V> clazz, long id) throws Exception {
		// TODO Auto-generated method stub
		return repertory.findByVId(clazz, id);
	}

	@Override
	public <T extends V> T findByVId(Class<V> clazz, int id) throws Exception {
		// TODO Auto-generated method stub
		return repertory.findByVId(clazz, id);
	}

	@Override
	public <T extends Model> T findByOId(Class<T> clazz, String id)
			throws Exception {
		// TODO Auto-generated method stub
		return repertory.findByOId(clazz, id);
	}

	@Override
	public <T extends M> List<T> findAll(Class<M> clazz) throws Exception {
		// TODO Auto-generated method stub
		return repertory.findAll(clazz);
	}

	@Override
	public <T extends V> List<T> findVAll(Class<V> clazz) throws Exception {
		// TODO Auto-generated method stub
		return repertory.findVAll(clazz);
	}

	@Override
	public <T extends Model> List<T> findOAll(Class<T> clazz) throws Exception {
		// TODO Auto-generated method stub
		return repertory.findOAll(clazz);
	}

	@Override
	public <T extends M> T getEntityByHql(String hql) throws Exception {
		// TODO Auto-generated method stub
		return repertory.getEntityByHql(hql);
	}

	@Override
	public <T extends V> T getEntityByVHql(String hql) throws Exception {
		// TODO Auto-generated method stub
		return repertory.getEntityByVHql(hql);
	}

	@Override
	public <T extends Model> T getEntityByOHql(String hql) throws Exception {
		// TODO Auto-generated method stub
		return repertory.getEntityByOHql(hql);
	}

	@Override
	public <T extends M> List<T> queryByHql(String hql) throws Exception {
		// TODO Auto-generated method stub
		return repertory.queryByHql(hql);
	}

	@Override
	public <T extends V> List<T> queryByVHql(String hql) throws Exception {
		// TODO Auto-generated method stub
		return repertory.queryByVHql(hql);
	}

	@Override
	public <T extends Model> List<T> queryByOHql(String hql) throws Exception {
		// TODO Auto-generated method stub
		return repertory.queryByOHql(hql);
	}

	@Override
	public <T extends M> List<M> findByPage(Class<M> clazz, String whereSql,
			int from, int size) throws Exception {
		// TODO Auto-generated method stub
		return repertory.findByPage(clazz, whereSql, from, size);
	}

	@Override
	public <T extends V> List<T> findByVPage(Class<V> clazz, String whereSql,
			int from, int size) throws Exception {
		// TODO Auto-generated method stub
		return repertory.findByVPage(clazz, whereSql, from, size);
	}

	@Override
	public <T extends Model> List<T> findByOPage(Class<T> clazz,
			String whereSql, int from, int size) throws Exception {
		// TODO Auto-generated method stub
		return repertory.findByOPage(clazz, whereSql, from, size);
	}

	@Override
	public <T extends M> List<T> queryByHql(String hql, Integer start,
			Integer limit) throws Exception {
		// TODO Auto-generated method stub
		return repertory.queryByHql(hql, start, limit);
	}

	@Override
	public <T extends V> List<T> queryByVHql(String hql, Integer start,
			Integer limit) throws Exception {
		// TODO Auto-generated method stub
		return repertory.queryByVHql(hql, start, limit);
	}

	@Override
	public <T extends Model> List<T> queryByOHql(String hql, Integer start,
			Integer limit) throws Exception {
		// TODO Auto-generated method stub
		return repertory.queryByOHql(hql, start, limit);
	}

	@Override
	public <T extends M> List<T> queryBySql(String sql, Class<T> clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return repertory.queryBySql(sql, clazz);
	}

	@Override
	public <T extends V> List<T> queryByVSql(String sql, Class<T> clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return repertory.queryByVSql(sql, clazz);
	}

	@Override
	public <T extends Model> List<T> queryByOSql(String sql, Class<T> clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return repertory.queryByOSql(sql, clazz);
	}

	@Override
	public <T extends M> List<T> queryBySql(String sql) throws Exception {
		// TODO Auto-generated method stub
		return repertory.queryBySql(sql);
	}

	@Override
	public <T extends V> List<T> queryByVSql(String sql) throws Exception {
		// TODO Auto-generated method stub
		return repertory.queryByVSql(sql);
	}

	@Override
	public <T extends Model> List<T> queryByOSql(String sql) throws Exception {
		// TODO Auto-generated method stub
		return repertory.queryByOSql(sql);
	}

	@Override
	public Number getCount(String hql) throws Exception {
		// TODO Auto-generated method stub
		return repertory.getCount(hql);
	}

	@Override
	public M save(M entity) throws Exception {
		// TODO Auto-generated method stub
		return repertory.save(entity);
	}

	@Override
	public M update(M entity) throws Exception {
		// TODO Auto-generated method stub
		return repertory.update(entity);
	}

	@Override
	public void delete(M entity) throws Exception {
		// TODO Auto-generated method stub
		repertory.delete(entity);

	}

	@Override
	public Number executeSql(String sql) throws Exception {
		// TODO Auto-generated method stub
		return repertory.executeSql(sql);
	}

	@Override
	public Number executeHql(String hql) throws Exception {
		// TODO Auto-generated method stub
		return repertory.executeHql(hql);
	}

	@Override
	public void doUpdateList(String[] updateSqls, M model) throws Exception {
		// TODO Auto-generated method stub
		OperateLogEbi logEbi = (OperateLogEbi) ebi;
		for (String sql : updateSqls) {
			repertory.executeHql(sql);
			if (LogModelHandler.UPDATE) {
				logEbi.saveLog(model, OperateLogType.UPDATE);
			}
		}
	}

	@Override
	public void delete(List<M> entitys) throws Exception {
		// TODO Auto-generated method stub
		repertory.delete(entitys);

	}

	@Override
	public M saveOrUpdate(M entity) throws Exception {
		// TODO Auto-generated method stub
		return repertory.saveOrUpdate(entity);
	}

	@Override
	public <T extends Model> List<T> query(Class<T> clazz, Condition cnd,
			Page page) throws Exception {
		// TODO Auto-generated method stub
		return repertory.query(clazz, cnd, page);
	}

	@Override
	public <T extends Model> T fetch(Class<T> c, String value) throws Exception {
		// TODO Auto-generated method stub
		return repertory.fetch(c, value);
	}

	@Override
	public <T extends Model> Number count(Class<T> c, Condition cnd)
			throws Exception {
		// TODO Auto-generated method stub
		return repertory.count(c, cnd);
	}

	@Override
	public <T extends Model> List<T> query(Class<T> c, Page page)
			throws Exception {
		// TODO Auto-generated method stub
		return repertory.query(c, page);
	}

	@Override
	public <T extends Model> List<T> query(Class<T> c, Condition cnd)
			throws Exception {
		// TODO Auto-generated method stub
		return repertory.query(c, cnd);
	}

	@Override
	public <T extends Model> void clear(Class<T> c) throws Exception {
		// TODO Auto-generated method stub
		repertory.clear(c);

	}

	@Override
	public <T extends Model> T fetch(Class<T> c, Condition cnd)
			throws Exception {
		// TODO Auto-generated method stub
		return repertory.fetch(c, cnd);
	}

	@Override
	public <T extends Model> T last(Class<T> c, Condition cnd) throws Exception {
		// TODO Auto-generated method stub
		return repertory.last(c, cnd);
	}

	@Override
	public <T extends Model> Criteria convertToCriteria(Class<T> c,
			Condition cnd) throws Exception {
		// TODO Auto-generated method stub
		return repertory.convertToCriteria(c, cnd);
	}

	@Override
	public <T extends Model> List<T> query(Criteria criteria) throws Exception {
		// TODO Auto-generated method stub
		return repertory.query(criteria);
	}

	@Override
	public <T extends Model> T last(Class<T> c) throws Exception {
		// TODO Auto-generated method stub
		return repertory.last(c);
	}

	@Override
	public void deleteBatchById(Class<? extends BaseEntity> clazz,
			String idName, String ids) throws Exception {
		// TODO Auto-generated method stub
		List<M> models = repertory.queryByHql(" from " + clazz.getName()
				+ " where " + idName + " in (" + ids + ")");
		for (M obj : models) {
			repertory.delete(obj);
		}
	}

	@Override
	public void executeBatchHql(String[] updateSqls) throws Exception {
		// TODO Auto-generated method stub
		for (String sql : updateSqls) {
			repertory.executeHql(sql);
		}

	}

	@Override
	public M formUpdate(M model) throws Exception {
		// TODO Auto-generated method stub
		return repertory.formUpdate(model);
	}

	@Override
	public JSONTreeNode buildJSONTreeNode(List<JSONTreeNode> list, String rootId) {
		// TODO Auto-generated method stub
		JSONTreeNode root = new JSONTreeNode();
		for (JSONTreeNode node : list) {
			if (!(StringUtil.isNotEmpty(node.getParent()) && !node.getId()
					.equals(rootId))) {
				root = node;
				list.remove(node);
				break;
			}
		}
		createTreeChildren(list, root);
		return root;
	}

	private void createTreeChildren(List<JSONTreeNode> childrens,
			JSONTreeNode root) {
		String parentId = root.getId();
		for (int i = 0; i < childrens.size(); i++) {
			JSONTreeNode node = childrens.get(i);
			if (StringUtil.isNotEmpty(node.getParent())
					&& node.getParent().equals(parentId)) {
				root.getChildren().add(node);
				createTreeChildren(childrens, node);
			}
			if (i == childrens.size() - 1) {
				if (root.getChildren().size() < 1) {
					root.setLeaf(true);
				}
				return;
			}
		}
	}

	@Override
	public List<JSONTreeNode> getTreeList(String rootId, String tableName,
			String whereSql, JSONTreeNode template, Boolean expanded)
			throws Exception {
		// TODO Auto-generated method stub
		List<JSONTreeNode> chilrens = new ArrayList<JSONTreeNode>();
		StringBuffer sql = new StringBuffer("select ");
		sql.append("t." + template.getId() + ",");
		sql.append("t." + template.getText() + ",");
		sql.append("t." + template.getCode() + ",");
		sql.append("t." + template.getNodeType() + ",");
		sql.append("t." + template.getNodeInfo() + ",");
		sql.append("t." + template.getNodeInfoType() + ",");
		sql.append("t." + template.getParent() + ",");
		sql.append("t.orderIndex ");
		if (StringUtil.isNotEmpty(template.getIcon())) {
			sql.append(",t." + template.getIcon());
		}
		if (StringUtil.isNotEmpty(template.getHref())) {
			sql.append(",t." + template.getHref());
		}
		if (StringUtil.isNotEmpty(template.getBigIcon())) {
			sql.append(",t." + template.getBigIcon());
		}
		sql.append(" from " + tableName + " t where 1=1");
		if (StringUtil.isNotEmpty(whereSql)) {
			sql.append(whereSql);
		}
		sql.append(" start with t." + template.getId() + "='" + rootId
				+ "' CONNECT BY t." + template.getParent() + "= PRIOR t."
				+ template.getId() + " ");
		sql.append(" order by t." + template.getParent() + ",t.orderIndex");
		List<?> alist = repertory.queryBySql(sql.toString());
		for (int i = 0; i < alist.size(); i++) {
			Object[] obj = (Object[]) alist.get(i);
			JSONTreeNode node = new JSONTreeNode();
			node.setId((String) obj[0]);
			node.setText((String) obj[1]);
			node.setCode((String) obj[2]);
			if (NodeType.LEAF.getType().equalsIgnoreCase((String) obj[3])) {
				node.setLeaf(true);
			} else {
				node.setLeaf(false);
			}
			node.setNodeInfo((String) obj[4]);
			node.setNodeInfoType((String) obj[5]);
			node.setParent((String) obj[6]);
			if (StringUtil.isNotEmpty((obj[7]) + "")) {
				node.setOrderIndex(Integer.parseInt(obj[7] + ""));
			}
			if (StringUtil.isNotEmpty(template.getIcon())) {
				node.setIcon((String) obj[8]);
				if (StringUtil.isNotEmpty(template.getHref())) {
					node.setDisabled(Boolean.parseBoolean(obj[9].toString()));
					if (StringUtil.isNotEmpty(template.getBigIcon())) {
						node.setBigIcon((String) obj[10]);
					}
				} else if (StringUtil.isNotEmpty(template.getBigIcon())) {
					node.setBigIcon((String) obj[9]);
				}
			} else {
				if (StringUtil.isNotEmpty(template.getIcon())) {
					node.setDisabled(Boolean.parseBoolean(obj[8].toString()));
					if (StringUtil.isNotEmpty(template.getBigIcon())) {
						node.setBigIcon((String) obj[9]);
					}
				} else if (StringUtil.isNotEmpty(template.getBigIcon())) {
					node.setBigIcon((String) obj[8]);
				}
			}
			if (expanded != null) {
				node.setExpanded(expanded);
			}
			chilrens.add(node);
		}
		return chilrens;
	}

	@Override
	public void getOrderIndex(BaseEntity entity) throws Exception {
		// TODO Auto-generated method stub
		Integer rowIndex=0;
		if (entity.getOrderIndex() == null) {
			
			Number nuber=  repertory.getCount("select    max(rownum) from "
							+ entity.getClass().getSimpleName() + " o "
							+ entity.defaultOrderString());
			if(nuber!=null)
			{
			entity.setOrderIndex(nuber.intValue()+1);
			}else
			{
				entity.setOrderIndex(0);
			}
		}
	}

	@Override
	public  void save(Object entity) throws Exception {
		// TODO Auto-generated method stub
		repertory.save(entity);
		
	}

	@Override
	public float sum(String sql) {
		// TODO Auto-generated method stub
		return repertory.sum(sql);
	}

/*	@Override
	public <T extends Model> List<T> queryVOBySql(String hql, V vo,
			Integer start, Integer limit) throws Exception {
		// TODO Auto-generated method stub
		return repertory.queryVOBySql(hql,vo,start,limit);
	}*/
}
