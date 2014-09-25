Ext.define("core.bl.inc.controller.PhotographController",{
	extend:"Ext.app.Controller",
	init:function(){
		var self=this
		//事件注册
		this.control({
		});
	},
	views:[
	"core.bl.inc.view.PhotographGrid",
	"core.bl.inc.view.PhotographPanel",
	"core.bl.inc.view.PhotographForm"
	],
	stores:[
	        "core.bl.inc.store.PhotographStore"
		]
});