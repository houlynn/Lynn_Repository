 Ext.define("core.sys.dd.store.DDItemStore",{
	extend:"Ext.data.Store",
	model:factory.ModelFactory.getModelByName("org.yingqu.desktop.model.DictionaryItem","").modelName,
	proxy:{
		type:"ajax",		
		url:"/coreDDeItem/load.action",
		extraParams:{
			orderSql:" order by orderIndex"
		},
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