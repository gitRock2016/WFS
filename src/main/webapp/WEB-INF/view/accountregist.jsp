<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta charset="utf-8">
<title>アカウント登録画面</title>
<script>
 // TODO パスワードチェック処理を後で作成
	function submit() {
		// エラーメッセージをクリアする
		form.password.setCustomValidity("");
		// パスワードの一致確認
		if (form.password.value != form.passwordConfirm.value) {
			// 一致していなかったら、エラーメッセージを表示する
			form.password.setCustomValidity("パスワードと確認用パスワードが一致しません");
		}
	};
	//	function check() {
		//document.getElementById("errorMessage").innerHTML = "入力値にエラーがあります";
		//	};
	// 入力値チェックエラーが発生したときの処理
//	document.forms.registForm.addEventListener("invalid",
			//		check
//		, false);
</script>
</head>

<body>
	<h2>アカウント登録画面</h2>
	<div>${message}</div>
	
	<c:if test="${acform !=null}">
<%-- 	<form:errors path="acform.userid" /> --%>
	userid:<br>
	<spring:bind path="acform.userid" htmlEscape="true">
		プロパティのリクエストパラメータ名:${status.expression }<br>
		プロパティの値:${status.value}<br>
		<!-- TODOアノテーションで直接メッセージを指定しているが出力されない -->
		エラーメッセージ<br>
		<c:forEach items="${status.errorMessages }" var="abc">
			${abc }<br>
		</c:forEach>
	</spring:bind>

	password:<br>
	<spring:bind path="acform.password" htmlEscape="true">
		プロパティのリクエストパラメータ名:${status.expression }<br>
		プロパティの値:${status.value}<br>
		エラーメッセージ<br>
		<c:forEach items="${status.errorMessages }" var="abc">
			${abc }<br>
		</c:forEach>
	</spring:bind>


 	</c:if>
	
	<form:form action="/WonFesSys/g02/regist" id="registForm" modelAttribute="accountRegistForm01">
	
		<table border=1>
			<tr>
				<th>id</th>
				<td><input type="text" id="userid" name="userid" maxlength="19" pattern="^[0-9A-Za-z]+$"></td>
			</tr>
			<tr>
				<th>userName</th>
				<td><input type="text" id="username" name="username" maxlength="10"></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="password" id="password" name="password"maxlength="10" pattern="^[0-9A-Za-z]+$"></td>
			</tr>
<!-- 			<tr>
				<th>パスワード(確認用)</th>
				<td><input type="password" id="passwordConfirm" name="passwordConfirm"></td>
			</tr>
 -->
 		</table>
		<input type="submit"/>
	</form:form>


	<c:url value="/" var="top" />
	<a href="${top}">TOPへ</a>
	<br />

</body>

</html>
