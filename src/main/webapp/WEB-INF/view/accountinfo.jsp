<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta charset="utf-8">
<title>アカウント情報画面</title>
</head>

<body>
	<h2>アカウント情報画面</h2>
	TODO 作成中
	<h4>お気に入り</h4>
	<table border=1>
		<tr>
			<th>作品名</th>
			<th>値段</th>
			<th>ディーラー名</th>
		</tr>
		<c:if test="${data !=null}">
			<c:forEach var="obj" items="${data}" varStatus="obj_status">
				<tr>
					<td><c:out value="${obj.productName}" /></td>
					<td><c:out value="${obj.price}" /></td>
					<td><c:out value="${obj.dealerName}" /></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<c:url value="/g04/init" var="tosch"></c:url><a href="${tosch }">ディーラー検索画面</a><br/>
	<c:url value="/g06/init" var="toreg"></c:url><a href="${toreg}">ディーラー登録画面</a>
</body>

</html>
