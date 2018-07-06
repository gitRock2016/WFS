<!DOCTYPE html>


<html>
	<head>
		<meta charset="utf-8">
		<title>sample画面</title>
		<script src="<c:url value="/js/jquery-3.3.1.js" />"></script>
		<script src="<c:url value="/js/sample.js" />"></script>
		<script>
			// alert("jsp直書きのJSの呼び出し");
		</script>
	</head> 
	<body>
		<h2>sample画面</h2>
		<div>${message}</div>
		TODO 実装の実験を行う
		<spring:message code="welcome.message" />
	</body>
	
</html>
