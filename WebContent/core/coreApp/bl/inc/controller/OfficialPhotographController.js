Ext.define("core.bl.inc.controller.OfficialPhotographController",{
	extend:"Ext.app.Controller",
	init:function(){
		var self=this
		//事件注册
		this.control({
		});
	},
	views:[
	"core.bl.inc.view.OfficialPhotographGrid",
	"core.bl.inc.view.OfficialPhotographPanel",
	"core.bl.inc.view.OfficialPhotographForm"
	],
	stores:[
	        "core.bl.inc.store.OfficialPhotographStore"
		]
});