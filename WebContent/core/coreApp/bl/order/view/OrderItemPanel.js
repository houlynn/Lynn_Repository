Ext.define("core.bl.order.view.OrderItemPanel",{
	extend:"core.app.base.BasePanel",
	alias:"widget.bl.orderItemPanel",
	funCode:"orderItem_main",
	funData:{
	        action:"/bl/orderitem", //请求Action
	        whereSql:"",//表格查询条件
	        orderSql:"operatingTime",//表格排序条件
	        pkName:"oitmid",
	        modelName:"org.yingqu.baoli.model.OrderItem",//实体全路径
	        tableName:"OrderItem",//表名
	        isChildren:true,//是否子功能
	        parentCode:"orderContent_main",//主功能功能编码
	        connectFields:[{//关联字段
			mainFieldCode:"ordid",//主功能字段名
			childFieldCode:"orderContent",//子功能字段名
			foreignKey:"foreignKey",//外键虚字段
			isQuery:true
			}]
	},
		items:{
			xtype:"bl.orderItemGrid",
			region:"center"
		}
});
