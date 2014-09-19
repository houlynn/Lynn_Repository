Ext.define("core.rbac.role.store.UserStore",{
	extend:"Ext.data.Store",
	model:factory.ModelFactory.getModelByName("org.yingqu.desktop.model.EndUser","checked").modelName,
	proxy:{
		type:"ajax",
		url:"/rbacRole/loadUsers.action",
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