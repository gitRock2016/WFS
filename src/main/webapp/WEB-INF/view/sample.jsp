<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>sample画面</title>
<script src="<c:url value="/js/jquery-3.3.1.js" />"></script>
<script src="<c:url value="/js/sample.js" />"></script>
<script>
			function showDialog1(){
				 alert("jsp直書きのJSの呼び出し");
			}
		</script>
</head>
<body>

	<h2>sample画面</h2>

	<div>
		name:<input type="text" id="name" name="name" maxlength="30"><br/>
		age:<input type="text" id="age" name="age" maxlength="3"pattern="^[0-9A-Za-z]+$" value="99"><br/>
		email:<input type="text" id="email" name="email" maxlength="50"><br/>
		<button type="button" name="JSボタン" onclick="showDialog1()">
			<font size="2">JS</font><font size="5" color="#333399">呼び出し（JSP直書き）</font>
		</button>
		<br/>
		<button type="button" name="JSボタン" onclick="ohayou()">
			<font size="2">JS</font><font size="5" color="#333399">呼び出し（sample.js）</font>
		</button>
		<input type="button" id="btn1" value="検索" />
	</div>

	<div>
		<span>${message}</span><br>
		\${message}はコントローラクラスでmappingしていなくても画面は落ちない。
	</div>

	<div>
		springタグによるプロパティファイルからメッセージを取得
		<spring:message code="welcome.message" />
	</div>

</body>
</html>