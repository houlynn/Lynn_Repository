Ext.define("core.bl.gd.view.GoodImagePanel",{
	extend:"core.app.base.BasePanel",
	alias:"widget.bl.goodImagePanel",
	funCode:"goodImage_main",
	funData:{
	        action:"/bl/gdimg", //请求Action
	        whereSql:"",//表格查询条件
	        orderSql:"operatingTime",//表格排序条件
	        pkName:"igid",
	        modelName:"org.yingqu.baoli.model.GoodImage",//实体全路径
	        tableName:"GoodImage",//表名
	        isChildren:true,//是否子功能
	        parentCode:"goods_main",//主功能功能编码
	        connectFields:[{//关联字段
			mainFieldCode:"gid",//主功能字段名
			childFieldCode:"good",//子功能字段名
			foreignKey:"foreignKey",//外键虚字段
			isQuery:true
			}]
	},
		items:{
			xtype:"bl.goodImageGrid",
			region:"center"
		}
});
