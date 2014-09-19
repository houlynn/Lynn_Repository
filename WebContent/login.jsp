<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>保利小区管家管理后台</title>
<link rel="stylesheet" type="text/css"
	href="/extjs/resources/css/ext-all.css" />
<link rel="stylesheet" type="text/css"
	href="/extjs/resources/css/example.css" />
<link rel="stylesheet" type="text/css"
	href="/extjs/resources/css/TabScrollerMenu.css" />
<link rel="stylesheet" type="text/css"
	href="/extjs/resources/css/CheckHeader.css" />
<script type="text/javascript" src="/extjs/ext-all-debug.js"></script>
<script type="text/javascript" src="/extjs/ext-lang-zh_CN.js"></script>
<script type="text/javascript" src="/extjs/examples.js"></script>
</head>
<!-- <script type="text/javascript">
	Ext.onReady(function() {
		Ext.QuickTips.init();
		Ext.form.Field.prototype.msgTarget = 'side';
		var dr = Ext.create('Ext.FormPanel', {
			renderTo : 'tr',
			frame : true,
			title : '管理员登录',
			buttonAlign : 'center',
			iconCls : 'table_login',
			bodyStyle : 'background: White;padding:30 0 0 20;',
			height : 200,
			width : 450,
			defaultType : 'textfield',
			items : [ {
				margin : "3 0 0 0",
				id : 'uname',
				fieldLabel : '用户名',
				name : 'name',//元素名称  
				//anchor:'95%',//也可用此定义自适应宽度  
				allowBlank : false,//不允许为空  
				iconCls : 'table_login',
				blankText : '用户名不能为空'//错误提示内容  
			}, {
				margin : "3 0 0 0",
				id : 'pwd',
				//xtype: 'textfield',  
				inputType : 'password',
				fieldLabel : '密　码',
				//anchor:'95%',  
				maxLength : 10,
				name : 'password',
				allowBlank : false,

				blankText : '密码不能为空'
			},
			 {
				layout:'column',
				items:[{
				   columnWidth: .7,  
					margin : "3 0 0 0",
					id : 'vy',
					//xtype: 'textfield',  
					inputType : 'password',
					fieldLabel : '验证码',
					//anchor:'95%',  
					maxLength : 10,
					name : 'password',
					allowBlank : false,
					blankText : '密码不能为空'
					
				},{
					columnWidth: .3,
					html:"112"
					
				}],
	
			},


			],
			buttons : [ {

				text : '登录',
				type : 'submit',
				id : 'sb',
			//定义表单提交事件  

			}, {
				text : '重置',
				handler : function() {
					dr.form.reset();
				}
			} ],
			keys : [ {
				key : Ext.EventObject.ENTER,
				fn : save,
				scope : this
			} ]
		});
	});
	function save() {
		var userName = uname.getValue();
		var userPass = pwd.getValue();
		//验证合法后使用加载进度条  
		if (dr.form.isValid()) {
			//提交到服务器操作  
			dr.form.submit({
				waitMsg : '正在进行登陆验证,请稍后...',
				url : 'login!checkUser.action',
				method : 'post',
				params : {
					userName : userName,
					userPass : userPass
				},
				//提交成功的回调函数  
				success : function(form, action) {
					if (action.result.msg == 'OK') {
						window.location.href = "login!index.action?userName="
								+ userName;
					} else if (action.result.msg == 'ERROR') {
						window.location.href = "index.jsp";
					}
				},
				//提交失败的回调函数  
				failure : function(form, action) {
					switch (action.failureType) {
					case Ext.form.Action.CLIENT_INVALID:
						Ext.Msg.alert('错误提示', '表单数据非法请核实后重新输入！');
						break;
					case Ext.form.Action.CONNECT_FAILURE:
						Ext.Msg.alert('错误提示', '网络连接异常！');
						break;
					case Ext.form.Action.SERVER_INVALID:
						Ext.Msg.alert('错误提示', "您的输入用户信息有误，请核实后重新输入！");
						simple.form.reset();
					}
				}
			});
		}
	};
</script> -->
<script type="text/javascript">
/*
 * 用户带验证码登录页面
 * sheak 
 * code.php 生成验证码
 * 1202增加键盘回车提交功能（粗体部分）
 */
/*
 * 用户带验证码登录页面
 * sheak 081115
 * code.php 生成验证码
 */
   function changeCode (obj){  
     var d = new Date();  
      obj.src = "<%=request.getContextPath()%>/rbacUser/LoginVerifyCodeImage.action?d="+d; 
 }  
Ext.QuickTips.init();
LoginWindow = Ext.extend(
				Ext.Window,
	{
		title : '管理员登录',
		width : 420,
		height : 200,
		collapsible : true,
		closable :false,
		defaults : {
			border : false
		},
		buttonAlign : 'center',
		createFormPanel : function() {
			// 表单重置函数
			function reset() {
				myform.form.reset();
			}
			;
	
			// 表单提交函数，这个是重点，单独提取出来，与myform一个层级
			function subjectForm() {
				if (myform.getForm().isValid()) {
					myform.form.submit({
						waitMsg : '正在登录......',
						url : '/rbacUser/Login.action',
						timeout : 3000,
						success : function(form, action) {
							 	var obj=action.result.obj;
							 	console.log(obj);
							    if (action.result.success){
							    	   window.location.href =obj ;  
							    }else{
							    	Ext.Msg.alert('错误提示', obj);
							    }
						},
						failure : function(form, action) {
							form.reset();
							var obj=action.result.obj;
							switch (action.failureType) {
							case Ext.form.Action.CLIENT_INVALID:
								Ext.Msg.alert('错误提示', '表单数据非法请核实后重新输入！');
								break;
							case Ext.form.Action.CONNECT_FAILURE:
								Ext.Msg.alert('错误提示', '网络连接异常！');
								break;
							case Ext.form.Action.SERVER_INVALID:
								Ext.Msg.alert('错误提示', obj);
								form.reset();
							}
						}
					});
				}
			}
		
			var myform = new Ext.form.FormPanel({
				bodyStyle : 'padding-top:6px',
				defaultType : 'textfield',
				labelAlign : 'right',
				labelWidth : 35,
				labelPad : 2,
				// frame : true,
				method : 'POST',
				// 增加表单键盘事件，键盘按键10或者13会触发subjectForm方法
				keys : [ {
					key : [ 10, 13 ],
					fn : subjectForm
				} ],
				defaults : {
					allowBlank : false,
					width : 300
				},
				items : [ {
					cls : 'user',
					name : 'userCode',
					fieldLabel : '登录帐号',
					blankText : '帐号不能为空'
				}, {
					cls : 'key',
					name : 'password',
					fieldLabel : '登录密码',
					blankText : '密码不能为空',
					inputType : 'password'
				}, {
					cls : 'key',
					name : 'verifyCode',
					id : 'randCode',
					fieldLabel : '验证码',
					width : 200,
					blankText : '验证码不能为空'
				},{  
				                xtype:'panel',  
				                html:'<div style="padding-left:80px" mce_style="padding-left:80px"><a href="#" mce_href="#"><img alt="如果看不清单击图片更换图片。" onclick="javascript:changeCode(this)" id="code" height="30" width="72" src="<%=request.getContextPath()%>/rbacUser/LoginVerifyCodeImage.action" mce_src="validateCodeServlet" border=0></img></a></div>',  
					            border:false  
					            }  
 ],
				buttons : [ {
					text : '确定',
					id : 'sure',
					handler : subjectForm//鼠标按键提交表单
				}, {
					text : '重置',
					id : 'clear',
					handler : reset
				} ]
			});
			return myform;
		},
	
		initComponent : function() {
			LoginWindow.superclass.initComponent.call(this);
			this.fp = this.createFormPanel();
			this.add(this.fp);
	
		}
	});

Ext.onReady(function() {
	var win = new LoginWindow();
	win.show();

});

</script>
<body>
<center>
	<div id="tr" style="margin-top: 100px; margin-left: 100px"></div>
</center>


</body>
</html>