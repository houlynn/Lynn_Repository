Ext.define("core.bl.ren.view.RentalGrid", {
	extend : "core.app.base.BaseGrid",
	alias : "widget.bl.rentalGrid",
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
		text:"出租信息",
		dataIndex:"title",
		width : 120,
		 columnType:"textfield",
		field:{
			 xtype:"textfield",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'出租信息必填',
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
	store:"core.bl.ren.store.RentalStore",
	bbar:{
		xtype:'pagingtoolbar',
		store:"core.bl.ren.store.RentalStore",
		dock:'bottom',
		displayInfo:true
	}
});