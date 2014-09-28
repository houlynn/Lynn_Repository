Ext.define("core.bl.sell.view.RentalGrid", {
	extend : "core.app.base.BaseGrid",
	alias : "widget.bl.sellGrid",
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
	}, {
		text : "面积",
		dataIndex : "area",
		width : 120,
		decimalPrecision:3,
		columnType : "numberfield",
		renderer : function(value, data, record) {
			return "<span>"+value+" m2</span>";
		}
	}, {
		text : "价格",
		dataIndex : "price",
		width : 120,
		columnType : "numberfield",
	   renderer : function(value, data, record) {
	  return "<span style=' color:#BB5500; font-weight:bold'>"+value+"万元</span>";
		}
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
		columnType : "basecombobox",
		ddCode : "SOURCEF",
	},
	{
		text : "发布人",
		dataIndex : "username",
		width : 80,
		columnType : "basecombobox",
		ddCode : "ENDUSER",
	}

	],
	store : "core.bl.sell.store.RentalStore",
	bbar : {
		xtype : 'pagingtoolbar',
		store : "core.bl.sell.store.RentalStore",
		dock : 'bottom',
		displayInfo : true
	}
});