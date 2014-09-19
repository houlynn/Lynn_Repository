Ext.define("core.sys.log.store.LogStore", {
	extend : "Ext.data.Store",
	model : factory.ModelFactory.getModelByName(
			"org.yingqu.desktop.model.OperateLog", "").modelName,
	proxy : {
		type : "ajax",
		url : "/log/load.action",
		actionMethods : {
			create : "POST",
			read : "GET",
			update : "POST",
			destroy : "POST"
		},
		reader : {
			type : "json",
			root : "rows",
			totalProperty : 'totalCount'
		},
		writer : {
			type : "json"
		}
	},
	autoLoad : true
});