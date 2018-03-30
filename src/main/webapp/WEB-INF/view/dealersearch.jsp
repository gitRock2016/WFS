<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<title>検索画面</title>
</head>

<body>
	<h2>検索画面</h2>
	TODO 作成中
	<div>${message}</div>
<!-- TODO POSTを利用したかきかた -->
<%--  	<form:input path="searchTxt"  />  --%>
<%-- 	<form:form modelAttribute="fm" method="GET" action="/g04/search"> --%>
	<h4>検索条件</h4> 
	<form:form modelAttribute="fm" method="get" action="/WonFesSys/g04/search">
		ディーラーコード<form:input path="dealerCode" />
		<input type="submit">
	</form:form>
<%-- GETお試し 
	<form:form modelAttribute="fm" method="post" action="/WonFesSys/g04/search">
		ディーラーコード<form:input path="dealerCode" />
		<input type="submit">
	</form:form> --%>
<%-- 		ディーラーコード<form:input path="dealerCode" var="dcode"/>
		<br/>
		<c:url value="/g04/search/${dealerCode }" var="url"></c:url>
		<a href="${url }" >url</a>
		<br/> --%>
	
	<h4>検索結果</h4>
	<table border=1>
		<tr>
			<th>No</th>
			<th>ディーラー名</th>
			<th>卓番</th>
			<!-- <th>url</th> -->
		</tr>
		<c:if test="${data !=null}" >
		<c:forEach var="obj" items="${data}" varStatus="obj_status">
			<tr>
<!-- 				0から開始する連番 -->
<%-- 				<td><c:out value="${obj_status.index}" /></td> --%>
				<td><c:out value="${obj_status.count}" /></td>
				<td><c:out value="${obj.dealerName}" /></td>
				<td><c:out value="${obj.takuban}" /></td>
<%-- 				<td><c:out value="${obj.link}" /></td> --%>
			</tr>
		</c:forEach>
		</c:if>
	</table>

</body>

</html>
