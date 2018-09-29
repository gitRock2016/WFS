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
	<c:url value="/g00/logout" var="g00_logout" /><a href="${g00_logout}">logout</a><br/>
	<c:url value="/sample/init" var="sample_init" /><a href="${sample_init}">sample画面</a><br/>
	<c:url value="/sample/init2" var="sample_init2" /><a href="${sample_init2}">sample2画面, ファイルアップ機能検証</a><br/>
	<c:url value="/sample/showHonoka" var="sample_showHonoka" /><a href="${sample_showHonoka}">bootStrapのHonoka画面</a><br/>
	<c:url value="/sample/showMap/8" var="sample_showMap" /><a href="${sample_showMap}">map</a><br/>
<!-- 	<img src="http://www.iwatakhr69.net/wfs/img/icon/default_1.jpg" /> -->
</html>
