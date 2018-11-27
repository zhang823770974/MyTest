<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>来到这里不错</title>

</head>
<body>
	<span><h1>欢迎您，${sessionScope.user.userName}</h1></span>
	<div>
		<h3>我的头像</h3>
		<img src="${user.fileName }" style="width: 70px ;height:70px">
	</div>

</body>
</html>