<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 宣言 -->
<c:url value="/" var="top" />
<c:url value="/g00/logout" var="g00_logout" />
<c:url value="/g03/init" var="g03_init" />
<c:url value="/g04/init" var="g04_init" />
<c:url value="/g06/init" var="g06_init" />
<c:url value="/sample/init" var="sample_init" />
<c:url value="/g00/logout" var="g00_logout" />

<body>
<div class="container">
	<div class="page-header">
		<h1>検索画面</h1>
	</div>
	
	<div class="page-header">
		<h4>検索条件</h4>
	</div>
	
	<div class="panel panel-default">
	<div class="panel-body">
	<form:form modelAttribute="fm" method="get" action="/WonFesSys/g04/search">
		<div class="form-group">
			<label for="dealerName">ディーラー名</label>
			<div>
				<form:input path="dealerName" id="dealerName"/>
			</div>
		</div>
		<label>ジャンル</label>
		<div class="form-group">
				<form:checkboxes path="product_fields" items="${field}"/>
		</div>
		<div class="form-group">
			<button type="reset" class="btn btn-default">キャンセル</button>
			<button type="submit" class="btn btn-primary">検索</button>
		</div>
	</form:form>
	</div>
	</div>
	
	<div class="page-header">
		<h4>検索結果</h4>
	</div>
	<div class="text-danger">${message}</div>
	<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>No</th>
				<th>ディーラー名</th>
				<th>卓番</th>
				<th>詳細</th>
				<th>HP</th>
				<th>TW</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${data !=null}">
			<c:forEach var="obj" items="${data}" varStatus="obj_status">
				<tr>
					<td><c:out value="${obj_status.count}" /><br /></td>
					<td>
						<!-- TODO
						urlタグを利用してエンコードした値では遷移できない
					エンコードした値をSrpingがうまく解釈できていないのかも
					暫定で、urlタグは利用しない
--> <%--  					<c:url value="/g11/init/${obj.id}" var="url"/> --%> <!-- 						c:urlを使わないと、コンテキストを自動設定してくれない -->
						<%-- 						<a href="WonFesSys/g11/init/${obj.id}"><c:out value="${obj.dealerName}" /></a> --%>

						<c:url value="/g11/init" var="bUrl" /> <a
						href="${bUrl}/${obj.id}"><c:out value="${obj.dealerName}" /></a>
						<br />
					</td>
					<td><c:out value="${obj.takuban}" /></td>
					<td><a href="">TODO ディーラー詳細画面へ遷移する予定</a></td>
					<td><a href="${obj.hpUrl}" class="btn btn-info">HP</a></td>
					<td><a href="${obj.twUrl}" class="btn btn-info">twitter</a></td>
				</tr>
			</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>
</body>