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
	<h3>fileUpload</h3>
<!-- 	<form method="post" enctype="multipart/form-data"
		action="/WonFesSys/sample/iconregist">
		<input type="text" name="dealerid" id="dealerid" />
		<input type="text" name="dealername" id="dealername" />
		<input type="file" name="fileUploadSample" id="fileUpload" />
		<button type="submit" id="fileUploadBtn">ファイルアップロード</button>
	</form>
 -->
	<form:form method="post" enctype="multipart/form-data"
		action="/WonFesSys/sample/iconregist"
		modelAttribute="sampleRegistForm">
		<form:input name="dealerid" id="dealerid" path="dealerId" maxlength="6" pattern="^[0-9]+$" />
		<form:input name="dealername" id="dealername" path="dealerName" maxlength="6" />
		<form:input type="file" name="fileUploadSample" id="fileUpload" path="dealerIcon"/>
		<button type="submit" id="fileUploadBtn">ファイルアップロード</button>
	</form:form>

</body>
</html>