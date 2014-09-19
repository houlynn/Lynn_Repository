Ext.define("core.rbac.role.store.ModuleStore",{
	extend:"Ext.data.TreeStore",
	defaultRootId:"ROOT",
	model:factory.ModelFactory.getModelByName("org.yingqu.framework.model.vo.JSONTreeNode","checked").modelName,
	proxy:{
		type:"ajax",
		url:"/rbacRole/getModuleTree.action",
		extraParams :{excludes: 'checked',whereSql:" and 1=1",orderSql:" order by orderIndex"},
		reader:{
			type:"json"
		},
		writer:{
			type:"json"
		}
	},
	autoLoad:true
 });