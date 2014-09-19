<!DOCTYPE HTML>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="/platform/login/images/favicon.ico" />

<title>Desktop实战架构</title>
<link href="/platform/login/css/operating-license.css" rel="stylesheet"
	type="text/css">

<style>
.main {
	width: 992px;
	height: 447px;
	background: url(/platform/login/images/operating-license/body-bg.png)
		no-repeat center top;
	margin: 0 auto;
	position: relative;
}
</style>
<%
	// 读取cookie
	String loginUserCode = "";
	javax.servlet.http.Cookie userCode = org.springframework.web.util.WebUtils
			.getCookie(request, "loginUserCode");
	if (null != userCode) {
		loginUserCode = userCode.getValue();
	}
%>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<h1>Desktop实战架构</h1>
		</div>
		<div class="main">
			<form id="loginForm" name="userform" method="post"
				action="/rbacUser/Login.action">
				<div class="hidden-input">
					<input type="hidden" name=""> <input type="hidden" name="">
					<input type="hidden" name="">
				</div>
				<%
					if (null != request.getParameter("error")) {
				%>
				<div style="text-align: center; color: red;">用户名或密码错误!</div>
				<%
					} else {
				%>
				<div style="text-align: center; color: red;">&nbsp;</div>
				<%
					}
				%>
				<div class="user-name">
					<label class="lb">用户名：</label> <input type="text" name="userCode"
						id="userCode" value="admin" class="ipt-t"
						onFocus="this.className+=' ipt-t-focus'"
						onBlur="this.className='ipt-t'">
				</div>
				<div class="pass-word">
					<label class="lb">密&nbsp;&nbsp;&nbsp;码：</label> <input
						type="password" name="password" id="password" class="ipt-t"
						value="123456" onFocus="this.className+=' ipt-t-focus'"
						onBlur="this.className='ipt-t'">
				</div>

				<div class="verify-CodeImage">
					验证：<input type="text" name="verifyCode" /> &nbsp;&nbsp; <img
						id="verifyCodeImage" onclick="reloadVerifyCode()"
						src="<%=request.getContextPath()%>/rbacUser/LoginVerifyCodeImage.action" /><br />
				</div>

				<div class="login-button">
					<input name="" type="submit" value="登录" class="button"
						id="btnSearch" onmouseover="this.className+=' button-focus'"
						onmouseout="this.className='button'"> <input name=""
						type="reset" value="重置" class="button-rewrite" id="btnSearch"
						onmouseover="this.className+=' button-focus'"
						onmouseout="this.className='button-rewrite'">
				</div>
			</form>
		</div>
		<div class="footer">
			<p>Copyright &copy; 2012 版权所有: Marico</p>
		</div>
	</div>
	<script type="text/javascript">
		document.getElementById("userCode").focus();
	</script>
</body>
</html>
