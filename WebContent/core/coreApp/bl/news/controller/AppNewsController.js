Ext.define("core.bl.news.controller.AppNewsController",{
	extend:"Ext.app.Controller",
	init:function(){
		var self=this
		//事件注册
		this.control({
			"basegrid button[ref=gridPush]":{
				click:function(btn){
					var baseGrid=btn.up("basegrid");
        			var rescords=baseGrid.getSelectionModel().getSelection();
        			 var id=null;
        			if(rescords.length==1){							
						var data=rescords[0].data;
					    id=data["newid"];
						}else{
							  Ext.MessageBox.alert("提示","请选择要发布的新闻!");
							  return;
						}
				    Ext.MessageBox.confirm("确认框", "你确定要发布这条新闻吗？", function(btn) {  
	        	    	 if("yes"==btn){}else{
	        	    		 Ext.Ajax.request({
		                    		url:'/bl/news/postnews.action',
		                    		method:'POST',
		                    		params:{newid:newid},
		                    		timeout:4000,
		                    		async:false,
		                    		success:function(response,opts){
		                    
		                    			
		                    		}
	        	    		 });
	        	    	 }
					
				});
				}
			},
			"basegrid button[ref=gridEdit]":{
				click:function(btn){
					var baseGrid=btn.up("basegrid");
					var funCode=baseGrid.funCode;
					var basePanel=baseGrid.up("basepanel[funCode="+funCode+"]");
					var baseForm=basePanel.down("baseform[funCode="+funCode+"]");
					//得到选中数据
					var rescords=baseGrid.getSelectionModel().getSelection();
					var baseCenterPanel=baseGrid.up("basecenterpanel[funCode="+funCode+"]");
					var funData=basePanel.funData;
					if(rescords.length==1){							
						var data=rescords[0].data;
						var insertObj=data;
						}
				var ajax=	function(config){
						var data={};
						var request={
							method:"POST",
							async:false,
							success:function(response){
								data = Ext.decode(Ext.value(response.responseText,'{}'));
							},
							failure : function(response){
						    	alert('数据请求出错了！！！！\n错误信息：\n'+response.responseText);
						    }
						};
						var request=Ext.apply(request,config);
						Ext.Ajax.request(request);
						return data;		
					}
					var resObj=ajax({url:funData.action+"/getInfoById.action",params:{pkValue:insertObj[funData.pkName]}});
					var formObj=baseForm.getForm();
					var contextField=formObj.findField("context");
					contextField.setValue(resObj.obj.context);
				}
			},
			"basegrid":{
				itemdblclick:function(grid,record,item,index,e,eOpts){
					
					var basePanel=grid.up("basepanel");
					var funCode=basePanel.funCode;
					var baseForm=basePanel.down("baseform[funCode="+funCode+"]");
					//得到选中数据
					var rescords=grid.getSelectionModel().getSelection();
					var baseCenterPanel=grid.up("basecenterpanel[funCode="+funCode+"]");
					var funData=basePanel.funData;
					if(rescords.length==1){							
						var data=rescords[0].data;
						var insertObj=data;
						}
				var ajax=	function(config){
						var data={};
						var request={
							method:"POST",
							async:false,
							success:function(response){
								data = Ext.decode(Ext.value(response.responseText,'{}'));
							},
							failure : function(response){
						    	alert('数据请求出错了！！！！\n错误信息：\n'+response.responseText);
						    }
						};
						var request=Ext.apply(request,config);
						Ext.Ajax.request(request);
						return data;		
					}
					var resObj=ajax({url:funData.action+"/getInfoById.action",params:{pkValue:insertObj[funData.pkName]}});
					var formObj=baseForm.getForm();
					var contextField=formObj.findField("context");
					contextField.setValue(resObj.obj.context);
					
					
				}
			}
		});
	},
	views:[
	"core.bl.news.view.AppNewsGrid",
	"core.bl.news.view.AppNewsPanel",
	"core.bl.news.view.AppNewsForm",
	"core.app.view.editor.ExtKindEditor"
	],
	stores:[
	        "core.bl.news.store.AppNewsStore"
		]
});