<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>認証画面</title>
</head>
<body>
	<h3>ログイン</h3>
	<c:url value="/accnt/accnt_01" var="login"/>
	<form:form action="${login }" method="POST" modelAttribute="loginForm">
		user:<input type="text" id="user" name="userid">
		password:<input type="text" id="password" name="userpassword">
		<input type="submit"/>
	</form:form>
</body>
</html>