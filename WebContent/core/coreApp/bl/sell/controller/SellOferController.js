Ext.define("core.bl.sell.controller.SellOferController",{
	extend:"Ext.app.Controller",
	init:function(){
		var self=this
		//事件注册
		this.control({
		});
	},
	views:[
	"core.bl.sell.view.SellOferGrid",
	"core.bl.sell.view.SellOferPanel",
	"core.bl.sell.view.SellOferForm"
	],
	stores:[
	        "core.bl.sell.store.SellOferStore"
		]
});