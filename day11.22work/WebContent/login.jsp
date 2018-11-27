<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="register.css">
<title>登陆页面</title>
</head>
<body>
	<div id="pos" align="center">
	<form action="loginServlet" method="post" >
		<h1>欢迎登陆</h1>
		<div style="color: red; size: 20px" >${requestScope.tip}</div>
		用户名: <input name="userName" placeholder="请输入用户名"><br/>
		密码: <input name="userPwd" type="password" placeholder="请输入密码"><br/>
		<button id="reg">登陆</button>
	</form>
	</div>

</body>
</html>