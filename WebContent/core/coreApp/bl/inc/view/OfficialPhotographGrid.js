Ext.define("core.bl.inc.view.OfficialPhotographGrid", {
	extend : "core.app.base.BaseGrid",
	alias : "widget.bl.officialPhotographGrid",
	tbar:[
			{xtype:'button',text:'添加',ref:'gridInsert',iconCls:'table_add'},
			{xtype:'button',text:'删除',ref:'gridDelete',iconCls:'table_remove'},
		],
	columns : [{
		xtype:"rownumberer",
		width : 35,
		text :'No.',
		align : 'center'
	},{
		text:"主键",
		dataIndex:"pId",
		hidden:true
	}
, {
		text:"图片链接地址",
		dataIndex:"imgurl",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		allowBlank : true,
		  hideTrigger : false
		}
	}
	
	 ],
	store:"core.bl.inc.store.OfficialPhotographStore",
	bbar:{
		xtype:'pagingtoolbar',
		store:"core.bl.inc.store.OfficialPhotographStore",
		dock:'bottom',
		displayInfo:true
	}
});