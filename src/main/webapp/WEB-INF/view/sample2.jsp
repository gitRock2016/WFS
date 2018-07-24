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
	
	<h3>アイコン画像</h3>
	<!-- プロジェクトがimgファイルを読み込んでいないと表示されない -->
	<c:url value="/img" var="img" /><img src="${img }${iconPath}"/>
	
	<h3>fileUpload</h3>
	<form:form method="post" enctype="multipart/form-data"
		action="/WonFesSys/sample/iconregist"
		modelAttribute="sampleRegistForm">
		dealerId:
		<form:input name="dealerid" id="dealerid" path="dealerId" maxlength="10" pattern="^[0-9]+$" /><br>
		dealerName:
		<form:input name="dealername" id="dealername" path="dealerName" maxlength="10" /><br>
		<form:input type="file" name="fileUploadSample" id="fileUpload" path="dealerIcon"/><br>
		<button type="submit" id="fileUploadBtn">ファイルアップロード</button><br>
	</form:form>

</body>
</html>