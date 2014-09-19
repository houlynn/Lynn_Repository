Ext.define("core.rbac.user.store.UserStore",{
	extend:"Ext.data.Store",
	model:factory.ModelFactory.getModelByName("org.yingqu.desktop.model.EndUser","checked").modelName,
	proxy:{
		type:"ajax",
		url:"/rbacUser/load.action",
		extraParams :{whereSql: " and deptId in('ROOT')"},
		reader:{
			type:"json",
			root:"rows",
			totalProperty :'totalCount'
		},
		writer:{
			type:"json"
		}
	},
	autoLoad:true
})