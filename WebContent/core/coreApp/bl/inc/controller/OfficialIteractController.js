Ext.define("core.bl.inc.controller.OfficialIteractController",{
	extend:"Ext.app.Controller",
	init:function(){
		var self=this
		//事件注册
		this.control({
		});
	},
	views:[
	"core.bl.inc.view.OfficialIteractGrid",
	"core.bl.inc.view.OfficialIteractPanel",
	"core.bl.inc.view.OfficialIteractForm"
	],
	stores:[
	        "core.bl.inc.store.OfficialIteractStore"
		]
});