Ext.onReady(function(){
	Ext.application({
		name:"core",//引用的名称
		scope :this,
        appFolder : "core/coreApp",//应用的目录
        launch:function(){//当前页面加载完成执行的函数
        },
        controllers:[
         "core.app.controller.MainController"          //装在主控制器
        ]

	})
});