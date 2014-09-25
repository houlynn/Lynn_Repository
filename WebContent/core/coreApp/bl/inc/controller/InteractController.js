Ext.define("core.bl.inc.controller.InteractController",{
	extend:"Ext.app.Controller",
	init:function(){
		var self=this
		//事件注册
		this.control({
		});
	},
	views:[
	"core.bl.inc.view.InteractGrid",
	"core.bl.inc.view.InteractPanel",
	"core.bl.inc.view.InteractForm"
	],
	stores:[
	        "core.bl.inc.store.InteractStore"
		]
});