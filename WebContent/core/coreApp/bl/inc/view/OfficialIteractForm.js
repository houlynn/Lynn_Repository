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
   },
   {
		xtype : "tabpanel",
		columnWidth : 1,
		menuAlign : "center",
		items : [ {
			title : '<center height=40>上传图片</center>',
			xtype : "bl.officialPhotographPanel",
			height : comm.get("resolutionHeight") * 0.28
		} ],
		tabConfig : {// 标签配置参数
		}
   }

	
	]
});