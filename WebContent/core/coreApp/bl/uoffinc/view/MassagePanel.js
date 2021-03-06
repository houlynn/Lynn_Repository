Ext.define("core.bl.uoffinc.view.MassagePanel",{
	extend:"core.app.base.BasePanel",
	alias:"widget.bl.massagePanel",
	funCode:"massage_main",
	funData:{
	        action:"/bl/mesg", //请求Action
	        whereSql:"",//表格查询条件
	        orderSql:"operatingTime",//表格排序条件
	        pkName:"msgid",
	        modelName:"org.yingqu.baoli.model.Massage",//实体全路径
	        tableName:"Massage",//表名
	        isChildren:true,//是否子功能
	        parentCode:"officialIteract_main",//主功能功能编码
	        connectFields:[{//关联字段
			mainFieldCode:"oinerid",//主功能字段名
			childFieldCode:"inid",//子功能字段名
			foreignKey:"foreignKey",//外键虚字段
			isQuery:true
			}]
	},
		items:{
			xtype:"bl.massageGrid",
			region:"center"
		}
});
