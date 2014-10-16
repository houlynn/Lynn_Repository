Ext.define("core.bl.vi.view.VirtualIconGrid", {
	extend : "core.app.base.BaseGrid",
	alias : "widget.bl.virtualIconGrid",
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
		dataIndex:"iconid",
		hidden:true
	}
, {
		text:"名称",
		dataIndex:"name",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'名称必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"跳转地址",
		dataIndex:"linkUrl",
		width : 320,
		 columnType:"textfield",
		 renderer:function(value,data,record){
			 	return "<a href ='"+value+"'>"+value+"</a>";
		 },
		field:{
			 xtype:"textfield",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'跳转地址必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"图片链接地址",
		dataIndex:"inconUrl",
		width : 120,
		 columnType:"textfield",
		 renderer:function(value,data,record){
				var width=16;
				var height=16;
			 	return "<img src='"+value+"' width="+width+" height="+height+" />";
		 }
	}
, {
		text:"备注",
		dataIndex:"remark",
		width : 220,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		allowBlank : true,
		  hideTrigger : false
		}
	},
	 {
		text:"发布状态",
		dataIndex:"state",
		width : 120,
		columnType:"basecombobox",
		ddCode:"ISPOST",
		field:{
		 xtype:"basecombobox",
		 ddCode:"ISPOST",
		 beforeLabelTextTpl : comm.get('required'),
		 emptyText :'请选择发布状态',
		 allowBlank : false,
			}
	}
	
	 ],
	store:"core.bl.vi.store.VirtualIconStore",
	bbar:{
		xtype:'pagingtoolbar',
		store:"core.bl.vi.store.VirtualIconStore",
		dock:'bottom',
		displayInfo:true
	}
});