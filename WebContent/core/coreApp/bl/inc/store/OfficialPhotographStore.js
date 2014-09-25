Ext.define("core.bl.inc.store.OfficialPhotographStore", {
	extend : "Ext.data.Store",
	model : factory.ModelFactory.getModelByName(
			"org.yingqu.baoli.model.OfficialPhotograph", "").modelName,
	proxy : {
		type : "ajax",
		url : "/bl/inc/load.action",
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