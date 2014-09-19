Ext.define("core.bl.gd.controller.GoodsController",{
	extend:"Ext.app.Controller",
	init:function(){
		var self=this
		//事件注册
		this.control({
			
			"basegrid button[ref=gridUpload]":{
				click:function(btn){
					//得到组件
					var baseGrid=btn.up("basegrid");						
					var store=baseGrid.getStore();
					var funCode=baseGrid.funCode;
					var basePanel=baseGrid.up("basepanel[funCode="+funCode+"]");
					//得到配置信息
					var funData=basePanel.funData;
					//处理特殊默认值
					var insertObj={};
					/**----------------主子功能处理开始----------------------*/
					if(funData.isChildren){
						//得到主功能的记录
						var mainRecord=basePanel.mainRecord;
						var parentObj={};
						if(funData.connectFields){
							Ext.each(funData.connectFields,function(connectField){
								if(connectField.foreignKey){
									parentObj[connectField.foreignKey]=mainRecord[connectField.mainFieldCode];
								}else{
									parentObj[connectField.childFieldCode]=mainRecord[connectField.mainFieldCode];
								}
							});
						}
						insertObj=Ext.apply(insertObj,parentObj);
					}
					var contentObj=basePanel.contentObj;
					insertObj=Ext.apply(insertObj,contentObj);
					 var win=Ext.create("Ext.window.Window",{
							modal : true,
							maximizable : false,
							resizable:false,
							frame : false,
							title : "文件上传",
							alias : 'widget.mapWindow',
							layout : "fit",
							width : 600,
							height : 120,
							items:{
								xtype:'bl.goodimg',
								id:"goodImage"
							}});
					 win.show();
				 var from=Ext.getCmp("goodImage");
					var formObj=from.getForm();
				 var btnUpload= from.down("button[ref=formUpload]");
				 btnUpload.on("click",function(btn){
						formObj.submit({
							url:funData.action+"/uploadField.action",
							params:insertObj,
							//可以提交空的字段值
							submitEmptyText:true,
							//成功回调函数-
							success:function(form,action){
								var obj=action.result.obj;
								if(action.result.success){
									 Ext.MessageBox.alert("提示",'上传成功!');
										var store=baseGrid.getStore();
										var proxy=store.getProxy();
										proxy.extraParams.parentSql=" and goodid='"+insertObj.foreignKey+"'";
										store.load();		
								}}
						});
					 
				 });
					//执行回调函数
					if(btn.callback){
						btn.callback();
					}
				}
			}
			
		});
	},
	views:[
	"core.bl.gd.view.GoodsGrid",
	"core.bl.gd.view.GoodsPanel",
	"core.bl.gd.view.GoodsForm",
	"core.bl.gd.view.GoodImageUrlForm",
	"core.bl.gd.view.GoodImageGrid",
	"core.bl.gd.view.GoodImagePanel"
	],
	stores:[
	        "core.bl.gd.store.GoodsStore",
	        "core.bl.gd.store.GoodImageStore"
		]
});