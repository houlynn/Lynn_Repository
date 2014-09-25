Ext.define("core.bl.inc.view.OfficialPhotographForm", {
	extend : "core.app.base.BaseForm",
	alias : "widget.bl.officialPhotographForm",
	items : [ {
		fieldLabel : "主键",
		name : "pId",
		hidden : true
	}
 ,
 {
		fieldLabel:"图片链接地址",
		name:"imgurl",
		allowBlank : true,
		xtype:"textfield"
   }
	]
});