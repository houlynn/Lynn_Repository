Ext.define("core.sys.dd.view.DDItemPanel",{
	extend:"core.app.base.BasePanel",
	alias:"widget.dd.dditemlayout",
	funCode:"dictionaryitem_main",
	funData:{
	        action:"/coreDDeItem", //请求Action
	        whereSql:"",//表格查询条件
	        orderSql:"",//表格排序条件
	        pkName:"itemId",
	        uploadFields:"",
	        modelName:"com.model.hibernate.system.shared.DictionaryItem",//实体全路径
	        tableName:"DictionaryItem",//表名
	        defaultObj:{},//默认信息，用于表格添加的时候字段默认值
			isChildren:true,
			parentCode:"dictionary_main",//主功能功能编码
			connectFields:[{//关联字段
				mainFieldCode:"ddId",//主功能字段名
				childFieldCode:"dictionary",//子功能字段名
				foreignKey:"foreignKey",//外键虚字段
				isQuery:true
			}]
	},
	items:[{
		xtype:"dd.dditemgrid"
	},{
		xtype:"dd.dditemform",
		hidden:true
	}]
});