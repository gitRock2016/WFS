<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
	<head>
		<meta charset="utf-8">
		<title>登録画面</title>
	</head> 
	<body>

		<h2>登録画面</h2>
		<div><font color="red">${message}</font></div>
		TODO　作成中
		<form:form modelAttribute="delaerRegistForm" method="post" action="/WonFesSys/g06/regist">
			TODO　画像アイコン、アップボタン<br>
			TODO クリアボタン<br>
			TODO 検索画面へのリンク
			<table border=1>
				<tr>
					<th bgcolor="#CCFF99">ディーラー名</th>
					<td><form:input path="dealerName" /></td>
				</tr>
				<tr>
					<th bgcolor="#CCFF99">卓番号</th>
					<td><form:input path="takuban" /></td>
				</tr>
			</table>
			※JSで4桁半角数字に保管（1234⇒12-34）
			<br>
			<table border=1>
				<tr>
					<th bgcolor="#CCFF99">作品名</th>
					<th bgcolor="#CCFF99">ジャンル</th>
					<th bgcolor="#CCFF99">値段</th>
				</tr>
				<!-- 入れ子の値は、modelattribute名（formタグ参照）＋入れ子クラスのフィールド名 -->
				<c:if test="${delaerRegistForm.productList !=null}">
					<c:forEach var="plist" items="${delaerRegistForm.productList}" varStatus="status">
					<tr>
						<td><input type="text" value="${plist.productName}"></td>
						<td>
							<select>
							<option value="0001">ガルパン</option>
							<option value="0002">FGO</option>
							<option value="0003">艦これ</option>
							<option value="0004">その他</option>
							</select>
						</td> 
						<td><input type="text" value="${plist.price}"></td>
					</tr>
					</c:forEach>
				</c:if>
			</table>

			<input type="submit" value="登録ボタン">
		</form:form>
	</body>
	
</html>