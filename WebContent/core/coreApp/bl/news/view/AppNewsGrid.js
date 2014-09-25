Ext.define("core.bl.news.view.AppNewsGrid", {
	extend : "core.app.base.BaseGrid",
	alias : "widget.bl.appNewsGrid",
	tbar:[
			{xtype:'button',text:'添加',ref:'gridInsertF',iconCls:'table_add'},
			{xtype:'button',text:'编辑',ref:'gridEdit',iconCls:'table_edit',disabled:true},
			{xtype:'button',text:'删除',ref:'gridDelete',iconCls:'table_remove'},
			{xtype:'button',text:'保存',ref:'gridSave',iconCls:'table_save'},
			{xtype:'button',text:'发布信息',ref:'gridPush',iconCls:'table_save'}
		],
	columns : [{
		xtype:"rownumberer",
		width : 35,
		text :'No.',
		align : 'center'
	},{
		text:"主键",
		dataIndex:"newid",
		hidden:true
	}
, {
		text:"标题",
		dataIndex:"title",
		width : 490,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'标题必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"来源",
		dataIndex:"source",
		width : 150,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'来源必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"缩略图",
		dataIndex:"shrinkimg",
		width : 120,
		columnType:"textfield",
		 renderer:function(value,data,record){
				return "<img src='"+value+"' width:30; height:30px />"; 
		 }
	}
, {
		text:"发布时间",
		dataIndex:"adtime",
		width : 150,
		 columnType:"textfield",
	}
, {
		text:"发布状态",
		dataIndex:"state",
		width : 120,
		 columnType:"basecombobox",
	  ddCode:"ISPOST",
		field:{
			 xtype:"basecombobox",
			ddCode:"ISPOST",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'发布状态必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
	
	 ],
	store:"core.bl.news.store.AppNewsStore",
	bbar:{
		xtype:'pagingtoolbar',
		store:"core.bl.news.store.AppNewsStore",
		dock:'bottom',
		displayInfo:true
	}
});