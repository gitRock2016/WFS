<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>認証失敗画面</title>
</head>
<body>
	<h3>ログインエラー</h3>
	<div>${message }</div>
	アカウント登録し再度ログインしてください。
	<br/>
	<c:url value="/g02/init" var="account"/><a href="${account} ">アカウント登録画面へ</a>
	<br/>
	<c:url value="/" var="index"/><a href="${index} ">TOPへ</a>
	
</body>
</html>