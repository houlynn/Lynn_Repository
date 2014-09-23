Ext.define("core.${dist}.view.${className?uncap_first}Panel",{
	extend:"core.app.base.BasePanel",
	alias:"widget.${className?uncap_first}Panel",
	funCode:"${className?uncap_first}_main",
	funData:{
	        action:"${namespace}", //请求Action
	        whereSql:"",//表格查询条件
	        orderSql:"operatingTime",//表格排序条件
	        pkName:"${productId}",
	        modelName:"${classFullName}",//实体全路径
	        tableName:"${className}",//表名
	        defaultObj:{name:"@createUserName@",birthday:"@createTime@"},//默认信息，用于表格添加的时候字段默认值
	        childFun:[]
	},
	items:[{
			xtype:"${className?uncap_first}Grid",
	},
	{
		xtype:"${className?uncap_first}Form",
		hidden:true
	}
	
	]
});