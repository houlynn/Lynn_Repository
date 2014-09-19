Ext.define("core.rbac.user.store.DeptStore",{
	extend:"Ext.data.TreeStore",
	defaultRootId:"ROOT",
	model:factory.ModelFactory.getModelByName("org.yingqu.framework.model.vo.JSONTreeNode","checked").modelName,
	proxy:{
		type:"ajax",
		url:"/rbacDept/getTree.action",
		extraParams :{excludes: 'checked'},
		reader:{
			type:"json"
		},
		writer:{
			type:"json"
		}
	},
	autoLoad:true
 });