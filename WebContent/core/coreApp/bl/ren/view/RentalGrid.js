Ext.define("core.bl.ren.view.RentalGrid", {
	extend : "core.app.base.BaseGrid",
	alias : "widget.bl.rentalGrid",
	tbar : [ {
		xtype : 'button',
		text : '添加',
		ref : 'gridInsertF',
		iconCls : 'table_add'
	}, {
		xtype : 'button',
		text : '编辑',
		ref : 'gridEdit',
		iconCls : 'table_edit',
		disabled : true
	}, {
		xtype : 'button',
		text : '删除',
		ref : 'gridDelete',
		iconCls : 'table_remove'
	}, {
		xtype : 'button',
		text : '保存',
		ref : 'gridSave',
		iconCls : 'table_save'
	},
	{
		xtype : 'button',
		text : '发布',
		ref : 'gidePush',
		iconCls : 'table_save'
	}
	],
	columns : [ {
		xtype : "rownumberer",
		width : 35,
		text : 'No.',
		align : 'center'
	}, {
		text : "主键",
		dataIndex : "rid",
		hidden : true
	}, {
		text : "出租信息",
		dataIndex : "title",
		width : 490,
		columnType : "textfield",
		field : {
			xtype : "textfield",
			beforeLabelTextTpl : comm.get('required'),
			emptyText : '出租信息必填',
			allowBlank : false,
			hideTrigger : false
		}
	}, {
		text : "面积",
		dataIndex : "area",
		width : 80,
		columnType : "textfield",
	}, {
		text : "价格",
		dataIndex : "price",
		width : 80,
		columnType : "textfield",
	},
	{
		text : "发布状态",
		dataIndex : "state",
		width : 80,
		columnType : "textfield",
		ddCode : "ISPOST",
		renderer : function(value, data, record) {
			if (value) {
				if ("1" == value) {
					value = "<span style='color:red;font-weight:bold'>已发布</span>";
				}
			} else {
				value = "<span style='color:green;font-weight:bold'>未发布</span>";
			}
			  return value;
		}
       
	},
	{
		text : "发布时间",
		dataIndex : "ptime",
		width : 120,
		columnType : "textfield"
	}, {
		text : "来源",
		dataIndex : "source",
		width : 80,
		columnType : "textfield"
	},
	{
		text : "发布人",
		dataIndex : "username",
		width : 80,
		columnType : "basecombobox",
		ddCode : "ENDUSER",
	}

	],
	store : "core.bl.ren.store.RentalStore",
	bbar : {
		xtype : 'pagingtoolbar',
		store : "core.bl.ren.store.RentalStore",
		dock : 'bottom',
		displayInfo : true
	}
});