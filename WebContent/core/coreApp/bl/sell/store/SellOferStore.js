Ext.define("core.bl.sell.store.SellOferStore", {
	extend : "Ext.data.Store",
	model : factory.ModelFactory.getModelByName(
			"org.yingqu.baoli.model.SellOfer", "").modelName,
	proxy : {
		type : "ajax",
		url : "/bl/sell/load.action",
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