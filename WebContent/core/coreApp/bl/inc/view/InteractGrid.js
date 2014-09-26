Ext.define("core.bl.inc.view.InteractGrid", {
	extend : "core.app.base.BaseGrid",
	alias : "widget.bl.interactGrid",
	tbar:[
	  	{xtype:'button',text:'添加',ref:'gridInsertF',iconCls:'table_add'},
		{xtype:'button',text:'编辑',ref:'gridEdit',iconCls:'table_edit',disabled:true},
		{xtype:'button',text:'删除',ref:'gridDelete',iconCls:'table_remove'},
		{xtype:'button',text:'保存',ref:'gridSave',iconCls:'table_save'}
		],
	columns : [{
		xtype:"rownumberer",
		width : 35,
		text :'No.',
		align : 'center'
	},{
		text:"主键",
		dataIndex:"hId",
		hidden:true
	}
, {
		text:"用户名",
		dataIndex:"username",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'用户名必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"分类",
		dataIndex:"type",
		width : 120,
		 columnType:"basecombobox",
	  ddCode:"INCTYPE",
		field:{
			 xtype:"basecombobox",
			ddCode:"INCTYPE",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'分类必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"标题",
		dataIndex:"title",
		width : 120,
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
		text:"内容",
		dataIndex:"content",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'内容必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"活动时间",
		dataIndex:"htime",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"datetimefield",
		      dateType:"date",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'活动时间必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
	
	 ],
	store:"core.bl.inc.store.InteractStore",
	bbar:{
		xtype:'pagingtoolbar',
		store:"core.bl.inc.store.InteractStore",
		dock:'bottom',
		displayInfo:true
	}
});