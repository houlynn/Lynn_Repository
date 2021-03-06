Ext.define("core.bl.sysuser.view.EndUserPanel",{
	extend:"core.app.base.BasePanel",
	alias:"widget.bl.endUserPanel",
	funCode:"endUser_main",
	funData:{
	        action:"/bl/sysuser", //请求Action
	        whereSql:"",//表格查询条件
	        orderSql:"operatingTime",//表格排序条件
	        pkName:"userId",
	        modelName:"org.yingqu.desktop.model.EndUser",//实体全路径
	        tableName:"EndUser",//表名
	        defaultObj:{enabled:"1"},//默认信息，用于表格添加的时候字段默认值
	        isChildren:false,//是否子功能
	},
		items:[{
			xtype:"bl.endUserGrid",
			region:"center"
	},{
	xtype:"bl.endUserForm",
		hidden:true
	}]
});
