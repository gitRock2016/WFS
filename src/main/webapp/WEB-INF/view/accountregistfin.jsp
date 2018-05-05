<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>アカウント登録画面</title>
</head>

<body>
	<h2>アカウント登録完了画面</h2>
	<div>登録が完了しました。</div>
	login画面から再度ログインをお願いします。
	<br />
	<c:url value="/g00/login" var="login"></c:url>
	<a href="${login}">login画面へ</a>
</body>

</html>
