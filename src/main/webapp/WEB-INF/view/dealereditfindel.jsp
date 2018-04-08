<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
	<head>
		<meta charset="utf-8">
		<title>登録編集完了（削除）画面</title>
	</head> 
	<body>
		<h2>登録編集完了（削除）画面</h2>
		<div>ディーラー情報を削除しました。</div>
		<c:url value="/g04/init" var="tosch"></c:url>
		<a href="${tosch }">検索画面へ</a>
	</body>
	
</html>