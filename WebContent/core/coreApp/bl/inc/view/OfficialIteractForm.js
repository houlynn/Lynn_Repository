Ext.define("core.bl.inc.view.OfficialIteractForm", {
	extend : "core.app.base.BaseForm",
	alias : "widget.bl.officialIteractForm",
	items : [ {
		fieldLabel : "主键",
		name : "hId",
		hidden : true
	}
 ,
 {
		fieldLabel:"分类",
		name:"type",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'分类必填',
		allowBlank : false,
		ddCode:"INCATYPE",
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
		fieldLabel:"发布时间",
		name:"ptime",
		allowBlank : true,
		xtype:"datetimefield"
   }
 ,
 {
		fieldLabel:"发帖人",
		name:"username",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'发帖人必填',
		allowBlank : false,
		ddCode:"ENDUSER",
		xtype:"basecombobox"
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