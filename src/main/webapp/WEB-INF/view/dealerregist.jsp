<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
	<head>
		<meta charset="utf-8">
		<title>アカウント情報画面</title>
	</head> 
	
	<body>
		<h2>登録画面</h2>
		<div><font color="red">${message}</font></div>
		TODO　作成中
		<form:form modelAttribute="delaerRegistForm" method="post" action="/WonFesSys/g06/regist">
			TODO　画像アイコン、アップボタン
			<br>
			<table border=1>
				<tr>
					<th bgcolor="#CCFF99">ディーラーコード、例：D001</th>
					<td><form:input path="dealerCode" /></td>
				</tr>
				<tr>
					<th bgcolor="#CCFF99">ディーラー名</th>
					<td><form:input path="dealerName" /></td>
				</tr>
				<tr>
					<th bgcolor="#CCFF99">卓番号、JSで4桁半角数字に保管（1234⇒12-34）</th>
					<td><form:input path="takuban" /></td>
				</tr>
				<tr>
					<th bgcolor="#CCFF99">ジャンル</th>
					<td><form:checkboxes path="filed" items="${fieldMap }"/></td>
				</tr>
			</table>
			TODO 作品登録ボタン、別画面で登録させる？
			<br>
			TODO クリアボタン
			<br>
			TODO 検索画面へのリンク
			<br>
			TODO　性別、お試し
			<br>
			<%-- 	
			<form:radiobutton path="sex" value="male" label="男" name="seibetsu"/>
			<form:radiobutton path="sex" value="female" label="女" name="seibetsu"/>
			--%>
			<!-- nameは指定しなくても、pathと同じ値が自動で設定される 例 name="sex"-->
			<form:radiobuttons path="sex" items="${seibetsuList }" itemLabel="label" itemValue="value" delimiter="       "/> 
			
			TODO　出身地、お試し
			<br>
			<form:select  path="birthplace" items="${birthplaceList }" /> 
			
			<br>
			<input type="submit" value="登録ボタン">
		</form:form>
	</body>
	
</html>
