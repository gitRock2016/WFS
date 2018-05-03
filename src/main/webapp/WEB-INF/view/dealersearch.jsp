<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<title>検索画面</title>
</head>

<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<h2>検索画面</h2>
	TODO Pre版
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
	<c:url value="/g06/init" var="toreg"></c:url><a href="${toreg}">ディーラー登録画面</a>
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
					<td><c:out value="${obj_status.count}" /><br/>
					</td>
					<td>
<!-- TODO
 						urlタグを利用してエンコードした値では遷移できない
						エンコードした値をSrpingがうまく解釈できていないのかも
						暫定で、urlタグは利用しない
 -->
<%--  					<c:url value="/g11/init/${obj.id}" var="url"/> --%>

<!-- 						c:urlを使わないと、コンテキストを自動設定してくれない -->
<%-- 						<a href="WonFesSys/g11/init/${obj.id}"><c:out value="${obj.dealerName}" /></a> --%>

	 					<c:url value="/g11/init" var="bUrl"/>
						<a href="${bUrl}/${obj.id}"><c:out value="${obj.dealerName}" /></a>
						<br/>
					</td>
					<td><c:out value="${obj.takuban}" /></td>
					<td><a href="">TODO ディーラー詳細画面へ遷移する予定</a></td>
					<td><a href="${obj.hpUrl}">HP</a></td>
					<td><a href="${obj.twUrl}">twitter</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>

</html>
