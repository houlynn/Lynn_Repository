Ext.define("core.bl.renimg.view.RentalImgPanel",{
	extend:"core.app.base.BasePanel",
	alias:"widget.bl.rentalImgPanel",
	funCode:"rentalImg_main",
	funData:{
	        action:"/bl/renimg", //请求Action
	        whereSql:"",//表格查询条件
	        orderSql:"operatingTime",//表格排序条件
	        pkName:"imgid",
	        modelName:"org.yingqu.baoli.model.RentalImg",//实体全路径
	        tableName:"RentalImg",//表名
	        defaultObj:{enabled:"1"},//默认信息，用于表格添加的时候字段默认值
	        isChildren:false,//是否子功能
	        children:[{//子功能的配置
	        	funCode:"rentalImgitem_main"	        	
	        }],
	        //子功能信息
	        childFun:[],
	        parentCode:"rentalImg_main",//主功能功能编码
	        connectFields:[{//关联字段
			mainFieldCode:"",//主功能字段名
			childFieldCode:"",//子功能字段名
			foreignKey:"foreignKey",//外键虚字段
			isQuery:true
			}]
	},
		items:[{
		xtype:"basecenterpanel",
				items:[{
					xtype:"basequerypanel",
					region:"north",
					items:[
			]
			},{
			xtype:"bl.rentalImgGrid",
			region:"center"
		}]
	},{
	xtype:"bl.rentalImgForm",
		hidden:true
	}]
});
