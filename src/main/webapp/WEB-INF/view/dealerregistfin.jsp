<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
	<head>
		<meta charset="utf-8">
		<title>登録完了画面</title>
	</head> 
	<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
		<h2>登録完了画面</h2>

		<div>登録が完了しました。</div>
		作品を登録する場合は、作品登録ボタンを押下して作品を登録してください。<br/>
		<a href="">作品登録画面へ, TODO　作成中</a>

		<div>登録内容を確認する場合は、検索画面へ</div>
		<c:url value="/g04/init" var="tosch"></c:url>
		<a href="${tosch }">検索画面へ</a>
	</body>
	
</html>
