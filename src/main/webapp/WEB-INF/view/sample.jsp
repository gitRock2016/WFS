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
	<spring:message code="welcome.message" />

	<br>
	<input type="button" value="js1" onclick="ohayou()" id="js1" />

	<br>
	<input type="button" value="ajax1" id="ajax1" />

	<br>
	<span id="outputdata">initial data</span>

	<h3>fileUpload_old</h3>
	<br>
	<form method="post" enctype="multipart/form-data"
		action="/WonFesSys/sample/fileuploadOld">
		<input type="file" name="fileUploadSample" id="fileUpload" />
		<button type="submit" id="fileUploadBtn">ファイルアップロード</button>
	</form>


</body>
</html>
