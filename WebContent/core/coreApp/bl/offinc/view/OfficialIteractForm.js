Ext.define("core.bl.offinc.view.OfficialIteractForm", {
	extend : "core.app.base.BaseForm",
	alias : "widget.bl.officialIteractForm",
	items : [ {
		fieldLabel : "主键",
		name : "oinerid",
		hidden : true
	}, {
		fieldLabel : "分类",
		name : "type",
		beforeLabelTextTpl : comm.get('required'),
		emptyText : '分类必填',
		allowBlank : false,
		ddCode : "INCATYPE",
		xtype : "basecombobox",
		columnWidth : 0.2,
	}, {
		fieldLabel : "标题",
		name : "title",
		beforeLabelTextTpl : comm.get('required'),
		emptyText : '标题必填',
		allowBlank : false,
		xtype : "textfield",
		columnWidth : 0.8,
	}, {
		fieldLabel : "内容",
	    xtype: 'extkindeditor',
		name : "content",
		id:"html_content1",
		height:300,
		columnWidth : 1,
		
	}, {
		xtype : "tabpanel",
		columnWidth : 1,
		menuAlign : "center",
		margin:"1 1 0 99 0",
		items : [ {
			title : '<center height=40>上传图片</center>',
			xtype : "bl.officialPhotographPanel",
			height : comm.get("resolutionHeight") * 0.48
		},
		{
			title : '<center height=40>回复内容</center>',
			xtype : "bl.massagePanel",
			height : comm.get("resolutionHeight") * 0.48
		}
		],
		tabConfig : {// 标签配置参数
		}
	}

	]
});