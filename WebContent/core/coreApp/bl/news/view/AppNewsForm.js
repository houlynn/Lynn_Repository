Ext.define("core.bl.news.view.AppNewsForm", {
	extend : "core.app.base.BaseForm",
	alias : "widget.bl.appNewsForm",
	items : [ {
		fieldLabel : "主键",
		name : "newid",
		hidden : true
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
		fieldLabel:"来源",
		name:"source",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'来源必填',
		allowBlank : false,
		xtype:"textfield"
   }
 ,
 {
		fieldLabel:"缩略图",
		name:"shrinkimg",
		beforeLabelTextTpl : comm.get('required'),
		emptyText :'缩略图必填',
		allowBlank : false,
		xtype:"textfield"
   },
   {
	   xtype: 'extkindeditor',
	   name: 'context',
	   id:"appnewsid-input",
	  　columnWidth:1,
	   height:800,
	   fieldLabel: '新闻编辑',

   }
	]
});


