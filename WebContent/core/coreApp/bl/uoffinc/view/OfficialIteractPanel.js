Ext.define("core.bl.uoffinc.view.OfficialIteractPanel",{
	extend:"core.app.base.BasePanel",
	alias:"widget.bl.officialIteractPanel",
	funCode:"officialIteract_main",
	funData:{
	        action:"/bl/offinc", //请求Action
	        whereSql:"",//表格查询条件
	        orderSql:"operatingTime",//表格排序条件
	        pkName:"oinerid",
	        modelName:"org.yingqu.baoli.model.OfficialIteract",//实体全路径
	        tableName:"OfficialIteract",//表名
	        isChildren:false,//是否子功能
	        children:[{//子功能的配置
	        	funCode:"officialPhotograph_main"	        	
	        },
	        {//子功能的配置
	        	funCode:"massage_main"	        	
	        }
	        ],
	},
		items:[{
		xtype:"basecenterpanel",
				items:[{
					xtype:"basequerypanel",
					region:"north",
					items:[
			  {
				xtype:"basequeryfield",
				queryType:"basecombobox",
				fieldLabel:"分类",
				name:"type",
				config:{
					ddCode:"INCATYPE"
				}
			},
			  {
				xtype:"basequeryfield",
				queryType:"textfield",
				fieldLabel:"标题",
				name:"title",
				config:{
				}
			},
			  {
				xtype:"basequeryfield",
				queryType:"textfield",
				fieldLabel:"发帖人",
				name:"username",
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
			  {
				xtype:"basequeryfield",
				queryType:"datetimefield",
				fieldLabel:"发布时间",
				name:"ptime",
				config:{
					dateType : 'datetime'
				}
			},
			]
			},{
			xtype:"bl.officialIteractGrid",
			region:"center"
		}]
	},{
	xtype:"bl.officialIteractForm",
		hidden:true
	}]
});
