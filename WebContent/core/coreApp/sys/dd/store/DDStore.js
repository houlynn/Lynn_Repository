 Ext.define("core.sys.dd.store.DDStore",{
	extend:"Ext.data.Store",
	model:factory.ModelFactory.getModelByName("org.yingqu.desktop.model.Dictionary","").modelName,
	proxy:{
		type:"ajax",		
		url:"/coreDDe/load.action",
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
 });