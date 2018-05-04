<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>logout画面</title>
</head>
<body>
	<h3>ログアウト</h3>
	ログアウトしました。
	<br/>
	<c:url value="/" var="top"/><a href="${top }">TOP画面へ</a>
	<br/>
	<c:url value="/g00/login" var="login"/><a href="${login }">Login画面へ</a>
	<br/>
	

</body>
</html>