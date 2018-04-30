<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>認証画面</title>
</head>
<body>
	<h3>ログイン</h3>
	<c:url value="/g00/login" var="login"/>
	<form action="${login }" method="POST">
		user:<input type="text" id="user" name="user">
		password:<input type="text" id="password" name="password">
		<input type="submit"/>
	</form>
</body>
</html>