Ext.define("core.${dist}.view.${className}Grid", {
	extend : "core.app.base.BaseGrid",
	alias : "widget.${className?uncap_first}Grid",
	columns : [{
		xtype:"rownumberer",
		width : 35,
		text :'No.',
		align : 'center'
	},{
		text:"主键",
		dataIndex:"productId",
		hidden:true
	},{
		text:"名称",
		width : 250,
		dataIndex:"productName",
		field:{
			xtype:"textfield"
		}
	},{
		text:"字典编码",
		dataIndex:"ddCode",
		width : 180,
		field:{
			xtype:"textfield"
		}
	},{
		text:"字典类型",
		dataIndex:"ddType",
		width : 100,
		columnType:"basecombobox",
		ddCode:"DDTYPE",
		field:{
			xtype:"basecombobox",
			ddCode:"DDTYPE"
		}
	},{
		text:"启用",
		width : 100,
		dataIndex:"enabled",
		field:{
			xtype:"basecombobox",
			ddCode:"ENABLED"
		}
	} ],
	store:"core.${dist}.store.${className}Store",
	bbar:{
		xtype:'pagingtoolbar',
		store:"core.${dist}.store.${className}Store",
		dock:'bottom',
		displayInfo:true
	}
});