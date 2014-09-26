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
	"core.bl.inc.view.OfficialIteractForm",
	
	"core.bl.inc.view.OfficialPhotographGrid",
	"core.bl.inc.view.OfficialPhotographPanel",
	],
	stores:[
	        "core.bl.inc.store.OfficialIteractStore",
	        "core.bl.inc.store.OfficialPhotographStore"
		]
});