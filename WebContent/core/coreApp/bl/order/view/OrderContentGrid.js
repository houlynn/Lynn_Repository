Ext.define("core.bl.order.view.OrderContentGrid", {
	extend : "core.app.base.BaseGrid",
	alias : "widget.bl.orderContentGrid",
	tbar:[
	  	{xtype:'button',text:'添加',ref:'gridUpload',iconCls:'table_add'},
		{xtype:'button',text:'删除',ref:'gridDelete',iconCls:'table_remove'},
		{xtype:'button',text:'保存',ref:'gridSave',iconCls:'table_save'},
		{xtype:'button',text:'编辑',ref:'gridEdit',iconCls:'table_edit',disabled:true},
		
		],
	columns : [{
		xtype:"rownumberer",
		width : 35,
		text :'No.',
		align : 'center'
	},{
		text:"主键",
		dataIndex:"ordid",
		hidden:true
	}
, {
		text:"购买用户",
		dataIndex:"userid",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'购买用户必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"送货地址",
		dataIndex:"adressid",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'送货地址必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"下单时间",
		dataIndex:"ordertime",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"datetimefield",
		      dateType:"date",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'下单时间必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"备注",
		dataIndex:"remarks",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'备注必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"金额",
		dataIndex:"acount",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		      decimalPrecision:3,
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'金额必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"支付状态",
		dataIndex:"ispay",
		width : 120,
		 columnType:"basecombobox",
	  ddCode:"",
		field:{
			 xtype:"basecombobox",
			ddCode:"",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'支付状态必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
	
	 ],
	store:"core.bl.order.store.OrderContentStore",
	bbar:{
		xtype:'pagingtoolbar',
		store:"core.bl.order.store.OrderContentStore",
		dock:'bottom',
		displayInfo:true
	}
});