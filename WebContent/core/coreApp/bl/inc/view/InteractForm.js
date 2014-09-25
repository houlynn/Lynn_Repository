Ext.define("core.bl.inc.view.InteractForm", {
	extend : "core.app.base.BaseForm",
	alias : "widget.bl.interactForm",
	items : [ {
		fieldLabel : "主键",
		name : "hId",
		hidden : true
	}
 ,
 {
		fieldLabel:"用户名",
		name:"username",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'用户名必填',
		allowBlank : false,
		xtype:"textfield"
   }
 ,
 {
		fieldLabel:"分类",
		name:"type",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'分类必填',
		allowBlank : false,
		ddCode:"INCTYPE",
		xtype:"basecombobox"
   }
 ,
 {
		fieldLabel:"标题",
		name:"title",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'标题必填',
		allowBlank : false,
		xtype:"textfield"
   }
 ,
 {
		fieldLabel:"内容",
		name:"content",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'内容必填',
		allowBlank : false,
		xtype:"textfield"
   }
 ,
 {
		fieldLabel:"活动时间",
		name:"htime",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'活动时间必填',
		allowBlank : false,
		xtype:"datetimefield"
   }
 ,
 {
		fieldLabel:"人数限制",
		name:"people",
		allowBlank : true,
		allowDecimals:false,
		emptyText :'请输输入整数',
		xtype:"textfield"
   }
 ,
 {
		fieldLabel:"活动地点",
		name:"site",
		allowBlank : true,
		allowDecimals:false,
		emptyText :'请输输入整数',
		xtype:"textfield"
   }
 ,
 {
		fieldLabel:"发布时间",
		name:"ptime",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'发布时间必填',
		allowBlank : false,
		xtype:"datetimefield"
   }
	]
});