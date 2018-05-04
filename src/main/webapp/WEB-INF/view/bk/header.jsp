<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--
TODO
ログイン情報を表示するヘッダーは、必要な画面と必要でない画面がある。
例えばログイン画面では不要である。なので画面構成がすべて同じというわけでないので、
tilesを利用してパターンごとに管理したほうがいいかも
処理完了形の画面、処理エラー時の画面、ログイン画面、業務画面など
 -->
<div id="header">
	<h1>WonFesSys</h1>
	<div style="text-align: right">
		loginId:${sessionScope.s_loginId},
		login名称:${sessionScope.s_loginName}</div>
	<div style="text-align: right">
		<c:url value="/g00/logout" var="g00_logout" />
		<a href="${g00_logout}">logout</a>
	</div>

</div>
