Ext.define("core.bl.sell.view.SellOferPanel",{
	extend:"core.app.base.BasePanel",
	alias:"widget.bl.sellOferPanel",
	funCode:"sellOfer_main",
	funData:{
	        action:"/bl/sell", //请求Action
	        whereSql:"",//表格查询条件
	        orderSql:"operatingTime",//表格排序条件
	        pkName:"rid",
	        modelName:"org.yingqu.baoli.model.SellOfer",//实体全路径
	        tableName:"SellOfer",//表名
	        defaultObj:{enabled:"1"},//默认信息，用于表格添加的时候字段默认值
	        isChildren:false,//是否子功能
	        children:[{//子功能的配置
	        	funCode:"sellOferitem_main"	        	
	        }],
	        //子功能信息
	        childFun:[],
	        parentCode:"sellOfer_main",//主功能功能编码
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
			  {
				xtype:"basequeryfield",
				queryType:"textfield",
				fieldLabel:"发布时间",
				name:"ptime",
				config:{
				}
			},
			  {
				xtype:"basequeryfield",
				queryType:"textfield",
				fieldLabel:"发布状态",
				name:"state",
				config:{
				}
			},
			]
			},{
			xtype:"bl.sellOferGrid",
			region:"center"
		}]
	},{
	xtype:"bl.sellOferForm",
		hidden:true
	}]
});
