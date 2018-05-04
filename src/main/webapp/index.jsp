<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>ログイン</title>
	</head> 
	<body>
	<h2>開発画面へ</h2>
	<c:url value="/g03/init" var="g03_init" /><a href="${g03_init}">アカウント情報画面</a><br/>
	<c:url value="/g04/init" var="g04_init" /><a href="${g04_init}">ディーラー検索画面</a><br/>
	<c:url value="/g06/init" var="g06_init" /><a href="${g06_init}">ディーラー登録画面</a><br/>
	<c:url value="/sample/init" var="sample_init" /><a href="${sample_init}">sample画面</a><br/>
	<c:url value="/g00/logout" var="g00_logout" /><a href="${g00_logout}">logout</a><br/>
	
	<c:url value="/tiles/init" var="tiles1" /><a href="${tiles1}">tilesの画面、サンプル</a><br/>

	<c:url value="/sample/s1" var="sample1" /><a href="${sample1}">sample1</a><br/>

	
</html>
