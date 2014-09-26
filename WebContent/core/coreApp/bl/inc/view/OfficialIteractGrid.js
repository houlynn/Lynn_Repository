Ext.define("core.bl.inc.view.OfficialIteractGrid", {
	extend : "core.app.base.BaseGrid",
	alias : "widget.bl.officialIteractGrid",
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
		text:"分类",
		dataIndex:"type",
		width : 120,
		 columnType:"basecombobox",
	  ddCode:"INCATYPE",
		field:{
			 xtype:"basecombobox",
			ddCode:"INCATYPE",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'分类必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"标题",
		dataIndex:"title",
		width : 520,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'标题必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}, {
		text:"发帖人",
		dataIndex:"username",
		width : 120,
		 columnType:"basecombobox",
	  ddCode:"ENDUSER",
		field:{
			 xtype:"basecombobox",
			ddCode:"ENDUSER",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'发帖人必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
	
	 ],
	store:"core.bl.inc.store.OfficialIteractStore",
	bbar:{
		xtype:'pagingtoolbar',
		store:"core.bl.inc.store.OfficialIteractStore",
		dock:'bottom',
		displayInfo:true
	}
});