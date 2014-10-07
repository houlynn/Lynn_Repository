Ext.define("core.bl.sysuser.view.EndUserGrid", {
	extend : "core.app.base.BaseGrid",
	alias : "widget.bl.endUserGrid",
	tbar:[
			{xtype:'button',text:'添加',ref:'gridInsertF',iconCls:'table_add'},
			{xtype:'button',text:'编辑',ref:'gridEdit',iconCls:'table_edit',disabled:true},
			{xtype:'button',text:'删除',ref:'gridDelete',iconCls:'table_remove'},
		],
	columns : [{
		xtype:"rownumberer",
		width : 35,
		text :'No.',
		align : 'center'
	},{
		text:"主键",
		dataIndex:"userId",
		hidden:true
	}
, {
		text:"用户姓名",
		dataIndex:"username",
		width : 220,
		 columnType:"textfield",
	}
, {
		text:"登陆账号",
		dataIndex:"userCode",
		width : 120,
		 columnType:"textfield",
	}
, {
		text:"密码",
		dataIndex:"password",
		width : 120,
		 columnType:"textfield",
	}
, {
		text:"性别",
		dataIndex:"sex",
		width : 120,
		 columnType:"basecombobox",
	  ddCode:"SEX",
	}
, {
		text:"出生日期",
	 	dataIndex:"birthday",
		  width : 120,
		 columnType:"textfield",
	},{
		text:"备注",
		dataIndex:"remark",
		width:300,
		field:{
			 xtype:"textfield",
		}
		
	}
	
	 ],
	store:"core.bl.sysuser.store.EndUserStore",
	bbar:{
		xtype:'pagingtoolbar',
		store:"core.bl.sysuser.store.EndUserStore",
		dock:'bottom',
		displayInfo:true
	}
});