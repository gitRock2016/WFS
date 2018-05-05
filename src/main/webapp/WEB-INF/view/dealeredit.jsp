<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>登録編集画面</title>
		<script>
			function mysubmit(btn){
				// 初期値
				var url="/WonFesSys/g11/edit";
				var btnId = btn.id
				if(btnId=="editBtn"){
					url="/WonFesSys/g11/edit"
				}
				if(btnId=="delBtn"){
					url="/WonFesSys/g11/del"
				}
				document.editform.action=url;
				document.editform.submit();
			}
		</script>
	</head> 
	<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
		<h2>登録編集画面</h2>
		<div><font color="red">${message}</font></div>
		TODO　Pre版
		<form:form modelAttribute="delaerRegistForm" method="post" action="/WonFesSys/g11/edit" name="editform">
			<form:hidden path="id"/>
			<input type="hidden" id="regkbn" name="hdn" value ="edit">
			TODO　画像アイコン、アップボタン<br>
			<table border=1>
				<tr>
					<th bgcolor="#CCFF99">ディーラー名</th>
					<td><form:input path="dealerName" /></td>
				</tr>
				<tr>
					<th bgcolor="#CCFF99">卓番号</th>
				<td><form:input path="takuban" maxlength="6" pattern="^[0-9A-Za-z]+$" /></td>
			</tr>
				<tr>
					<th bgcolor="#CCFF99">HP</th>
					<td><form:input path="hpLink" /></td>
				</tr>
				<tr>
					<th bgcolor="#CCFF99">tweet</th>
					<td><form:input path="twLink" /></td>
				</tr>
			</table>
			※JSで4桁半角数字に保管（1234⇒12-34）
			<br>
 			<input type="submit" value="登録ボタン" name="edit" onclick="mysubmit(this)" id="editBtn">
			<input type="submit" value="削除ボタン"name="del" onclick="mysubmit(this)" id="delBtn">
			
			<c:url value="/g11/init" var="bUrl"/>
			TODO　↓実験用
<!-- 			TODO　 お試し 　↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ -->
			<c:url value="/g11/edit" var="bUrl"/>
			<a href="${bUrl}?action=edit">登録</a>
			<a href="${bUrl }?action=del">削除</a>
<!-- 			TODO　 お試し 　↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ -->
		</form:form>
		<c:url value="/g04/init" var="tosch"></c:url>
		<a href="${tosch }">ディーラー検索画面</a>
	</body>
	
</html>
