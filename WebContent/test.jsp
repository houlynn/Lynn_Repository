<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>测试</title>
 <link rel="shortcut icon" href="/platform/login/images/favicon.ico"/>
  <link rel="stylesheet" type="text/css" href="/extjs/resources/css/ext-all.css" />
  <link rel="stylesheet" type="text/css" href="/extjs/resources/css/example.css" />
  <link rel="stylesheet" type="text/css" href="/extjs/resources/css/TabScrollerMenu.css" />
  <link rel="stylesheet" type="text/css" href="/extjs/resources/css/CheckHeader.css" />
  <link rel="stylesheet" type="text/css" href="/MyDesktop/css/desktop.css" />
  <link rel="stylesheet" type="text/css" href="/core/css/comm.css" /> 
  <link rel="stylesheet" type="text/css" href="/core/css/icon.css" /> 
  <script type="text/javascript" src="/extjs/ext-all-debug.js"></script>
  <script type="text/javascript" src="/extjs/ext-lang-zh_CN.js"></script>
  <script type="text/javascript" src="/extjs/examples.js"></script>
  <script type="text/javascript" src="/core/coreApp/util/overrideUtil.js"></script>
  <script type="text/javascript" src="/core/coreApp/util/comm.js"></script>
  <script type="text/javascript" src="/core/loader.js"></script>
<!--   <script type="text/javascript" src="/core/app.js"></script> -->
</head>
<script type="text/javascript">


 Ext.onReady(function(){
	//开启悬浮提示功能
	Ext.QuickTips.init();
	//开启动态加载
	Ext.Loader.setConfig({
		enabled: true
	});
	//创建应用程序的实例
	Ext.application({
		name:"core",//引用的名称
		scope :this,
        appFolder : "core/coreApp",//应用的目录
		//加载控制器
		controllers: ['core.app.controller.MainController'],
		//自动加载和实例化Viewport文件
		///autoCreateViewport: true,
		  launch: function() {
			
				var controller=coreApp.getController("core.test.controller.TestController");
				if(!controller.inited)
				{
					//controller.init();controller.inited=true
				};
			        Ext.create('Ext.container.Viewport', {
			              layout: 'fit',
			              items: [
			                 {
			                     xtype: 'testpanel',
			                     title: 'Users',
			                     html : 'List of users will go here'
			                 }
			             ] 
			         });
			  
		  }

	});
});






</script>

<!--        	<script type="text/javascript">
			<!--加载分辨率大小-->
			var clientWidth = document.body.clientWidth;
			var clientHeight = document.body.clientHeight;
			var screenWidth = document.body.scrollWidth;
			var screenHeight = document.body.scrollHeight;
			var resolutionHeight = window.screen.height;
			var resolutionWidth = window.screen.width;
			comm.add("clientWidth",clientWidth);
			comm.add("clientHeight",clientHeight);
			comm.add("screenWidth",screenWidth);
			comm.add("screenHeight",screenHeight);
			comm.add("resolutionWidth",resolutionWidth);
			comm.add("resolutionHeight",resolutionHeight);   
           <!--改造窗体的层次-->
           Ext.override(Ext.ZIndexManager, {
               tempHidden: [],
               show: function () {
                   var comp, x, y;
                   while (comp = this.tempHidden.shift()) {
                       x = comp.x;
                       y = comp.y;
                       comp.show();
                       comp.setPosition(x, y);
                   }
               }
           });
           <!--加载程序-->
           Ext.Loader.setConfig({
                 enabled: true,
                 paths: {
                     'Ext.ux.desktop': 'MyDesktop/js',
                       'MyDesktop': 'MyDesktop'
                 }
             });
           <!--引用类-->
           Ext.require([
                   'MyDesktop.App'
                   ]);
            <!--实例化-->
           var myDesktopApp;
           Ext.onReady(function () {
               myDesktopApp = new MyDesktop.App();
           });
       </script> -->
       


<script type="text/javascript">
			<!--加载分辨率大小-->
			var clientWidth = document.body.clientWidth;
			var clientHeight = document.body.clientHeight;
			var screenWidth = document.body.scrollWidth;
			var screenHeight = document.body.scrollHeight;
			var resolutionHeight = window.screen.height;
			var resolutionWidth = window.screen.width;
			comm.add("clientWidth",clientWidth);
			comm.add("clientHeight",clientHeight);
			comm.add("screenWidth",screenWidth);
			comm.add("screenHeight",screenHeight);
			comm.add("resolutionWidth",resolutionWidth);
			comm.add("resolutionHeight",resolutionHeight);   
			
			//开启动态加载
			Ext.Loader.setConfig({
				enabled : true
			});

			Ext.Loader.setPath({
				'Ext.ux' : 'extjs/ux',
				'Ext.app' : 'extjs/app'
			});
			
			Ext.require(['Ext.app.Portlet', 'Ext.app.PortalColumn', 'Ext.app.PortalPanel',
					'Ext.app.PortalDropZone', 'Ext.ux.TabReorderer',
					'Ext.ux.TabCloseMenu']);
				Ext.onReady(function() {
						var tab = Ext.create('Ext.tab.Panel', {
									activeTab : 0,
									enableTabScroll : true,
									animScroll : true,
									border : true,
									autoScroll : true,
									region : 'center',
									split : true,
									items : [{
										iconCls : 'icon-activity',
										title : '平台首页',
										xtype:'portalpanel',
										layout:'column',
										items : [{
												xtype : 'portalcolumn',
												columnWidth : 0.7,
								                items:[{ title: '新闻动态',height : 150,iconCls : 'icon-news' },
								                	{title: '最新通知',height : 150, iconCls : 'icon-notice' },
								                	{title: '业绩报表',height : 150, iconCls : 'icon-chart'}]
								            },{
								            	xtype : 'portalcolumn',
								            	columnWidth : 0.3,
								                items:[{ title: '功能链接', height : 150, iconCls : 'icon-link'},
								                	{title: '待办事项',height : 150,iconCls : 'icon-note' },
								                	{title: '邮件列表', height : 150,iconCls : 'icon-email-list'}]
								            }]
									}],
									plugins: [Ext.create('Ext.ux.TabReorderer'),
					        		  Ext.create('Ext.ux.TabCloseMenu',{
					        		  	closeTabText: '关闭面板',
					        		  	closeOthersTabsText: '关闭其他',
					        		  	closeAllTabsText: '关闭所有'
					        		  })]
								});
						var tree = Ext.create("Ext.panel.Panel", {
									region : 'west',
									title : "系统菜单",
									width : 250,
									iconCls : "icon-tree",
									autoScroll : false,
									layout : 'accordion',
									collapsible : true,
									layoutConfig : {
										animate : true
									},
									split : true
								});
						var title = Ext.create("Ext.panel.Panel", {
									height : 80,
									html : '保利后台信息管理系统',
									region : 'north',
									split : true,
									bbar : [{
										iconCls : 'icon-user',
										text : '管理员'
									},'-',{
										text : Ext.Date.format(new Date(),'Y年m月d日')
									},'->',{
										text : '退出',
										iconCls : 'icon-logout'
									}],
									bodyStyle : 'backgroud-color:#99bbe8;line-height : 50px;padding-left:20px;font-size:22px;color:#000000;font-family:黑体;font-weight:bolder;' +
											'background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(153,187, 232, 0.4) ), color-stop(50%, rgba(153, 187, 232, 1) ),color-stop(0%, rgba(153, 187, 232, 0.4) ) )'
								});
						
						
						
						
						Ext.create('Ext.container.Viewport',{
							layout : 'border',
							items : [title,tab,tree],
							listeners : {
								afterrender : function(){
									//Ext.getBody().mask('正在加载系统菜单....');
									//开启悬浮提示功能
									Ext.QuickTips.init();
									//创建应用程序的实例
									Ext.application({
										name:"core",//引用的名称
										scope :this,
								        appFolder : "core/coreApp",//应用的目录
										//加载控制器
										controllers: ['core.app.controller.MainController'],
										  launch: function() {
											    coreApp.initMenu();
												var menuTreeStore=comm.get("menuTreeStore");
										      	coreApp.buildMenu(tree,tab);
												//addTree(moduleData,coreApp,tree);
										  }
								});
								}
							}
						});
				});
				
				function addTree(moduleData,coreApp,tree) {
					Ext.getBody().unmask();
					for (var i = 0; i < moduleData.length; i++) {
						tree.add(Ext.create("Ext.tree.Panel", {
									title : moduleData[i].text,
									iconCls : moduleData[i].iconCls,
									//useArrows: true,
									autoScroll : true,
									rootVisible : false,
									viewConfig : {
										loadingText : "正在加载..."
									},
									store :comm.add("menuTreeStore"),
									listeners : {
										afterlayout : function() {
											if (this.getView().el) {
												var el = this.getView().el;
												var table = el
														.down("table.x-grid-table");
												if (table) {
													table.setWidth(el.getWidth());
												}
											}
										},
										itemclick : function(view,node){
											if (node.isLeaf()) { //判断是否是根节点
												if(node.data.type === 'URL'){ //判断资源类型
													var panel = Ext.create('Ext.panel.Panel',{
														title : node.data.text,
														closable : true,
														iconCls : 'icon-activity',
														html : '<iframe width="100%" height="100%" frameborder="0" src="http://www.baidu.com"></iframe>'
													});
													tab.add(panel);
													tab.setActiveTab(panel);
												}else if(node.data.type === 'COMPONENT'){
													var panel = Ext.create(node.data.component,{
														title : node.data.text,
														closable : true,
														iconCls : 'icon-activity'
													});
													tab.add(panel);
													tab.setActiveTab(panel);
												}
											}
										}
									}
								}));
						tree.doLayout();

					}
				}
           
       </script> 
<body>　 






</body>
</html>