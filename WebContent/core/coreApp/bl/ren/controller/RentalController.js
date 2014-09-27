Ext.define("core.bl.ren.controller.RentalController",{
	extend:"Ext.app.Controller",
	init:function(){
		var self=this
		//事件注册
		this.control({
			"basegrid button[ref=gridInsertF]":{
				click:function(btn){
					var  ren_imgGid=Ext.getCmp("ren_imgGid");
					ren_imgGid.getStore().removeAll();
					
				}
		},
		"baseform button[ref=formSave]":{
			beforeclick:function(btn){
				btn.callback=function(reusltObj){
				}
			}
			
			
		},
			"basegrid button[ref=gidePush]":{
				click:function(btn){
					var baseGrid=btn.up("basegrid");
        			var rescords=baseGrid.getSelectionModel().getSelection();
        			 var rid=null;
        			 var title=null;
        			if(rescords.length==1){							
						var data=rescords[0].data;
						rid=data["rid"];
						title=data["title"];
						}else{
							  Ext.MessageBox.alert("提示","请选择要发布的出租信息!");
							  return;
						}
				    Ext.MessageBox.confirm("确认框", "你要对：<span style='color:red;font-weight:bold'>"+title+"</span> 进行发布吗？", function(btn) {  
	        	    	 if("yes"==btn){
	        	    		 Ext.Ajax.request({
		                    		url:'/bl/ren/push.action',
		                    		method:'POST',
		                    		params:{rid:rid},
		                    		timeout:4000,
		                    		async:false,
		                    		success:function(response,opts){
		                    			var  obj = Ext.decode(response.responseText);
										if(obj.success){
											 Ext.MessageBox.alert("提示",'发布成功!这条信息将会在APPP端显示');
											 baseGrid.getStore().load();
											 
										}else{
											 Ext.MessageBox.alert("提示",obj.obj);
										}
		                    		}
	        	    		 });
	        	    		 
	        	    	 }else{
	        
	        	    	 }
					
				});
				}
			},
			
			"basegrid button[ref=gridUpload]":{
				click:function(btn){
					//得到组件
					var baseGrid=btn.up("basegrid");						
					var store=baseGrid.getStore();
					var funCode=baseGrid.funCode;
					var basePanel=baseGrid.up("basepanel[funCode="+funCode+"]");
					//得到配置信息
					var funData=basePanel.funData;
					var  parentCode=funData["parentCode"];
					console.log(parentCode);
	                var mainForm=basePanel.up("baseform[funCode="+parentCode+"]");
				    var formObj=mainForm.getForm();
				    var f=formObj.findField("rid");
				    var oinerid=f.getValue();
				    if(!oinerid){
				    	var msg='出租信息并未保存，请先保存再进行图片上传.';
				    	 Ext.MessageBox.alert("提示",msg);
				    	 return ;
				    }
				  	var insertObj={foreignKey:oinerid};
					 var win=Ext.create("Ext.window.Window",{
							modal : true,
							maximizable : false,
							resizable:false,
							frame : false,
							layout : "fit",
							width : 600,
							height : 120,
							closeAction: 'hide',
							items:{
								xtype:'bl.renimgformm',
								id:"renImageForm"
							}});
					 win.show();
				 var from=Ext.getCmp("renImageForm");
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
										var proxy=store.getProxy();
										proxy.extraParams.parentSql=" and rental='"+insertObj.foreignKey+"'";
										store.load();		
								}else{
									 Ext.MessageBox.alert("提示",obj);
								}}
						});
					 
				 });
					//执行回调函数
					if(btn.callback){
						btn.callback();
					}
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
				var contextField=formObj.findField("content");
				contextField.setValue(resObj.obj.content);
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
				var contextField=formObj.findField("content");
				contextField.setValue(resObj.obj.content);
			}
		}
		});
	},
	views:[
	"core.bl.ren.view.RentalGrid",
	"core.bl.ren.view.RentalPanel",
	"core.bl.ren.view.RentalForm",
	"core.bl.ren.view.RentalImgGrid",
	"core.bl.ren.view.RentalImgPanel",
	"core.bl.ren.view.UploadForm",
	 "core.app.view.editor.ExtKindEditor"
	],
	stores:[
	        "core.bl.ren.store.RentalStore",
	        "core.bl.ren.store.RentalImgStore"
		]
});