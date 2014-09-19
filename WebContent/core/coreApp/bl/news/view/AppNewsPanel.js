Ext.define("core.bl.news.view.AppNewsPanel",{
	extend:"core.app.base.BasePanel",
	alias:"widget.bl.appNewsPanel",
	funCode:"appNews_main",
	funData:{
	        action:"/bl/news", //请求Action
	        whereSql:"",//表格查询条件
	        orderSql:"operatingTime",//表格排序条件
	        pkName:"newid",
	        modelName:"org.yingqu.baoli.model.AppNews",//实体全路径
	        tableName:"AppNews",//表名
	        defaultObj:{enabled:"1"},//默认信息，用于表格添加的时候字段默认值
	        isChildren:false,//是否子功能
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
				fieldLabel:"标题",
				name:"title",
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
				name:"addtime",
				config:{
					dateType : 'datetime'
				}
			},
			]
			},{
			xtype:"bl.appNewsGrid",
			region:"center"
		}]
	},{
	xtype:"bl.appNewsForm",
		hidden:true
	}]
});
