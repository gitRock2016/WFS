<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
	<head>
		<meta charset="utf-8">
		<title>登録画面</title>
	</head> 
	<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
		<h2>登録画面</h2>
		<div><font color="red">${message}</font></div>
		TODO　Pre版
		<form:form modelAttribute="delaerRegistForm" method="post" action="/WonFesSys/g06/regist">
			TODO　画像アイコン、アップボタン<br>
			<table border=1>
				<tr>
					<th bgcolor="#CCFF99">ディーラー名</th>
					<td><form:input path="dealerName" /></td>
				</tr>
				<tr>
					<th bgcolor="#CCFF99">卓番号</th>
				<td><form:input path="takuban" maxlength="6" pattern="^[0-9A-Za-z]+$" /></td>
			</tr>
				<tr>
					<th bgcolor="#CCFF99">HP</th>
					<td><form:input path="hpLink" /></td>
				</tr>
				<tr>
					<th bgcolor="#CCFF99">tweet</th>
					<td><form:input path="twLink" /></td>
				</tr>
			</table>
			※JSで4桁半角数字に保管（1234⇒12-34）
			<br>
			<input type="submit" value="登録ボタン">
		</form:form>
	<c:url value="/g04/init" var="tosch"></c:url><a href="${tosch }">ディーラー検索画面</a><br/>
	</body>
	
</html>