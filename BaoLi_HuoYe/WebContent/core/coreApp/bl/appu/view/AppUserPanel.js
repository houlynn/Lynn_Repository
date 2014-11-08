Ext.define("core.bl.appu.view.AppUserPanel",{
	extend:"core.app.base.BasePanel",
	alias:"widget.bl.appUserPanel",
	funCode:"appUser_main",
	funData:{
	        action:"/bl/appu", //请求Action
	        whereSql:"",//表格查询条件
	        orderSql:"operatingTime",//表格排序条件
	        pkName:"userid",
	        modelName:"org.yingqu.baoli.model.AppUser",//实体全路径
	        tableName:"AppUser",//表名
	        defaultObj:{enabled:"1"},//默认信息，用于表格添加的时候字段默认值
	        isChildren:false,//是否子功能
	        children:[{//子功能的配置
	        }],
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
				fieldLabel:"用户名",
				name:"username",
				config:{
				}
			},
			  {
				xtype:"basequeryfield",
				queryType:"textfield",
				fieldLabel:"登录帐号",
				name:"loginCode",
				config:{
				}
			},
			  {
				xtype:"basequeryfield",
				queryType:"textfield",
				fieldLabel:"是否业主",
				name:"owner",
				config:{
				}
			},
			]
			},{
			xtype:"bl.appUserGrid",
			region:"center"
		}]
	},{
	xtype:"bl.appUserForm",
		hidden:true
	}]
});