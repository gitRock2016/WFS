<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	
	<h4>検索条件</h4>
	<form:form modelAttribute="fm" method="get" action="/WonFesSys/g04/search">
	<table border="1">
		<tr>
			<td>ディーラー名</td>
			<td><form:input path="dealerName" /></td>
		</tr>
		<tr>
			<td>ジャンル</td>
			<td><form:checkboxes path="product_fields" items="${field}" /></td>
			</tr>
	</table>
	<input type="submit" value="検索">
	</form:form>

	<h4>検索結果</h4>
	<table border=1>
		<tr>
			<th>No</th>
			<th>ディーラー名</th>
			<th>卓番</th>
			<th>詳細</th>
			<th>HP</th>
			<th>TW</th>
		</tr>
		<c:if test="${data !=null}">
			<c:forEach var="obj" items="${data}" varStatus="obj_status">
				<tr>
					<td><c:out value="${obj_status.count}" /></td>
					<td><c:out value="${obj.dealerName}" /></td>
					<td><c:out value="${obj.takuban}" /></td>
					<td><a href="">TODO ディーラー詳細画面へ遷移</a></td>
					<td><c:out value="${obj.hpUrl}" /></td>
					<td><c:out value="${obj.twUrl}" /></td>
					<%-- 				<td><c:out value="${obj.link}" /></td> --%>
				</tr>
			</c:forEach>
		</c:if>
	</table>

</body>

</html>
