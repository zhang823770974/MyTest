<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="register.css">
<title>注册页面</title>
</head>
<body>
	<div id="pos" align="center">
	<form action="registerServlet" method="post" enctype="multipart/form-data">
		<h1>欢迎注册</h1>
		
		用户名: <input name="userName" placeholder="请输入用户名"><br/>
		密码: <input name="userPwd" type="password" placeholder="请输入密码"><br/>
		年龄: <input name="userAge"><br/>
		性别: <input name="userSexy" type="radio" value="男">男
		<input name="userSexy" type="radio" value="女">女<br/><br/>
		<input type="file" name="fileName">
		<input type="submit" ><br/><br/>
		
		<button id="reg">注册</button>
	</form>
	</div>

</body>
</html>