<!DOCTYPE html>
</head>

<body>
	<h2>アカウント登録画面</h2>
	<div>${message}</div>
	<%-- <form:errors path="acform.userid"/> --%>
	<c:if test="${acform !=null}">
	<spring:bind path="acform.userid" htmlEscape="true">
		status.expression:${status.expression }<br>
		status.value:${status.value}<br>
		status.errorMessages<br>
		<c:forEach items="${status.errorMessages}" var="msg">
			${msg }<br>
		</c:forEach>
	</spring:bind>
	</c:if>
	
	<form:errors path="acform.userid"/>
	
	<form:form action="/WonFesSys/g02/regist" id="registForm" modelAttribute="accountRegistForm01">
		<table border=1>
			<tr>
				<th>id</th>
				<td><input type="text" id="userid" name="userid" maxlength="10" pattern="^[0-9A-Za-z]+$"></td>
			</tr>
			<tr>
				<th>userName</th>
				<td><input type="text" id="username" name="username" maxlength="50"></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="password" id="password" name="password"maxlength="32" pattern="^[0-9A-Za-z]+$"></td>
			</tr>
<!-- 			<tr>
				<th>パスワード(確認用)</th>
				<td><input type="password" id="passwordConfirm" name="passwordConfirm"></td>
			</tr>
 -->
 		</table>
		<input type="submit"/>
	</form:form>


	<c:url value="/" var="top" />
	<a href="${top}">TOPへ</a>
	<br />

</body>

</html>