Ext.define("core.bl.sell.view.SellOferForm", {
	extend : "core.app.base.BaseForm",
	alias : "widget.bl.sellOferForm",
	items : [ {
		fieldLabel : "主键",
		name : "rid",
		hidden : true
	}
 ,
 {
		fieldLabel:"出售信息",
		name:"title",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'出售信息必填',
		allowBlank : false,
		xtype:"textfield"
   }
 ,
 {
		fieldLabel:"面积",
		name:"area",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'面积必填',
		allowBlank : false,
		decimalPrecision:3,
		hideTrigger : false,
		emptyText :'请输输入小数',
		xtype:"textfield"
   }
 ,
 {
		fieldLabel:"价格",
		name:"price",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'价格必填',
		allowBlank : false,
		xtype:"textfield"
   }
 ,
 {
		fieldLabel:"发布时间",
		name:"ptime",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'发布时间必填',
		allowBlank : false,
		xtype:"textfield"
   }
 ,
 {
		fieldLabel:"来源",
		name:"source",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'来源必填',
		allowBlank : false,
		xtype:"textfield"
   }
 ,
 {
		fieldLabel:"发布状态",
		name:"state",
		allowBlank : true,
		ddCode:"ISPOST",
		xtype:"basecombobox"
   }
	]
});