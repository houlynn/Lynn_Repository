Ext.define("core.bl.ren.controller.RentalController",{
	extend:"Ext.app.Controller",
	init:function(){
		var self=this
		//事件注册
		this.control({
		});
	},
	views:[
	"core.bl.ren.view.RentalGrid",
	"core.bl.ren.view.RentalPanel",
	"core.bl.ren.view.RentalForm"
	],
	stores:[
	        "core.bl.ren.store.RentalStore"
		]
});