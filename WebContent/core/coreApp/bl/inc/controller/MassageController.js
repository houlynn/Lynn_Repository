Ext.define("core.bl.inc.controller.MassageController",{
	extend:"Ext.app.Controller",
	init:function(){
		var self=this
		//事件注册
		this.control({
		});
	},
	views:[
	"core.bl.inc.view.MassageGrid",
	"core.bl.inc.view.MassagePanel",
	"core.bl.inc.view.MassageForm"
	],
	stores:[
	        "core.bl.inc.store.MassageStore"
		]
});