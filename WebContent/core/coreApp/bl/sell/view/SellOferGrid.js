Ext.define("core.bl.sell.view.SellOferGrid", {
	extend : "core.app.base.BaseGrid",
	alias : "widget.bl.sellOferGrid",
	tbar:[
			{xtype:'button',text:'添加',ref:'gridInsert',iconCls:'table_add'},
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
		dataIndex:"rid",
		hidden:true
	}
, {
		text:"出售信息",
		dataIndex:"title",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'出售信息必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"面积",
		dataIndex:"area",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		      decimalPrecision:3,
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'面积必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"价格",
		dataIndex:"price",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'价格必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"发布时间",
		dataIndex:"ptime",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'发布时间必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
, {
		text:"来源",
		dataIndex:"source",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'来源必填',
		allowBlank : false,
		  hideTrigger : false
		}
	}
	
	 ],
	store:"core.bl.sell.store.SellOferStore",
	bbar:{
		xtype:'pagingtoolbar',
		store:"core.bl.sell.store.SellOferStore",
		dock:'bottom',
		displayInfo:true
	}
});