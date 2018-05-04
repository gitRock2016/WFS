<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<body>
	<div id="main-contents">
		<h2>アカウント情報画面</h2>
		<div id="main-contents-inner">
			<h3>お気に入り</h3>
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
		</div>
	</div>
</body>