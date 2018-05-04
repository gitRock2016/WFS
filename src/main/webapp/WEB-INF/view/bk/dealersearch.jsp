<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>æ¤ç´¢ç»é¢</title>
</head>

<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<h2>æ¤ç´¢ç»é¢</h2>
	TODO Preç
	<div>${message}</div>
	
	<h4>æ¤ç´¢æ¡ä»¶</h4>
	<form:form modelAttribute="fm" method="get" action="/WonFesSys/g04/search">
	<table border="1">
		<tr>
			<td>ãã£ã¼ã©ã¼å</td>
			<td><form:input path="dealerName" /></td>
		</tr>
		<tr>
			<td>ã¸ã£ã³ã«</td>
			<td><form:checkboxes path="product_fields" items="${field}" /></td>
			</tr>
	</table>
	<input type="submit" value="æ¤ç´¢">
	<c:url value="/g06/init" var="toreg"></c:url><a href="${toreg}">ãã£ã¼ã©ã¼ç»é²ç»é¢</a>
	</form:form>

	<h4>æ¤ç´¢çµæ</h4>
	<table border=1>
		<tr>
			<th>No</th>
			<th>ãã£ã¼ã©ã¼å</th>
			<th>åçª</th>
			<th>è©³ç´°</th>
			<th>HP</th>
			<th>TW</th>
		</tr>
		<c:if test="${data !=null}">
			<c:forEach var="obj" items="${data}" varStatus="obj_status">
				<tr>
					<td><c:out value="${obj_status.count}" /><br/>
					</td>
					<td>
<!-- TODO
 						urlã¿ã°ãå©ç¨ãã¦ã¨ã³ã³ã¼ãããå¤ã§ã¯é·ç§»ã§ããªã
						ã¨ã³ã³ã¼ãããå¤ãSrpingããã¾ãè§£éã§ãã¦ããªãã®ãã
						æ«å®ã§ãurlã¿ã°ã¯å©ç¨ããªã
 -->
<%--  					<c:url value="/g11/init/${obj.id}" var="url"/> --%>

<!-- 						c:urlãä½¿ããªãã¨ãã³ã³ãã­ã¹ããèªåè¨­å®ãã¦ãããªã -->
<%-- 						<a href="WonFesSys/g11/init/${obj.id}"><c:out value="${obj.dealerName}" /></a> --%>

	 					<c:url value="/g11/init" var="bUrl"/>
						<a href="${bUrl}/${obj.id}"><c:out value="${obj.dealerName}" /></a>
						<br/>
					</td>
					<td><c:out value="${obj.takuban}" /></td>
					<td><a href="">TODO ãã£ã¼ã©ã¼è©³ç´°ç»é¢ã¸é·ç§»ããäºå®</a></td>
					<td><a href="${obj.hpUrl}">HP</a></td>
					<td><a href="${obj.twUrl}">twitter</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>

</html>
