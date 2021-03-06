Ext.define("core.bl.gd.view.GoodsPanel",{
	extend:"core.app.base.BasePanel",
	alias:"widget.bl.goodsPanel",
	funCode:"goods_main",
	funData:{
	        action:"/bl/gd", //请求Action
	        whereSql:"",//表格查询条件
	        orderSql:"operatingTime",//表格排序条件
	        pkName:"gid",
	        modelName:"org.yingqu.baoli.model.Goods",//实体全路径
	        tableName:"Goods",//表名
	        isChildren:false,//是否子功能
	        children:[{//子功能的配置
	        	funCode:"goodImage_main"	        	
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
				fieldLabel:"商品名称",
				name:"name",
				config:{
				}
			},
			  {
				xtype:"basequeryfield",
				queryType:"basecombobox",
				fieldLabel:"是否推荐商品",
				name:"hot",
				config:{
					ddCode:"ISHOTGOODS"
				}
			},
			  {
				xtype:"basequeryfield",
				queryType:"basecombobox",
				fieldLabel:"是否发布",
				name:"releases",
				config:{
					ddCode:"ISPOST"
				}
			},
			  {
				xtype:"basequeryfield",
				queryType:"basecombobox",
				fieldLabel:"是否包邮",
				name:"free",
				config:{
					ddCode:"ISFREE"
				}
			},
			  {
				xtype:"basequeryfield",
				queryType:"datetimefield",
				fieldLabel:"发布时间",
				name:"releasetime",
				config:{
					dateType : 'datetime'
				}
			},
			]
			},{
			xtype:"bl.goodsGrid",
			region:"center"
		}]
	},{
	xtype:"bl.goodsForm",
		hidden:true
	}]
});
