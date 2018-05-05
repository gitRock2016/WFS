<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
<div class="container">
	<div class="page-header">
		<h1>アカウント登録画面</h1>
	</div>
	
	<!-- TODO BeanValidationによるエラーメッセージ表示、エラーメッセージが取得できない -->
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
	
	下記にアカウント情報を入力し、アカウント情報を登録してください。
	<div class="text-danger">${message}</div>
	<form:form action="/WonFesSys/g02/regist" id="registForm" modelAttribute="accountRegistForm01">
		<div class="form-group">
			<label for="userid">ユーザーID</label>
			<div>
				<input type="text" id="userid" name="userid" maxlength="19" pattern="^[0-9A-Za-z]+$">
			</div>
		</div>
		<div class="form-group">
			<label for="username">ユーザー名</label>
			<div>
				<input type="text" id="username" name="username" maxlength="10">
			</div>
		</div>
		<div class="form-group">
			<label for="password">パスワード</label>
			<div>
				<input type="password" id="password" name="password"maxlength="10" pattern="^[0-9A-Za-z]+$" placeholder="パスワード">
			</div>
		</div>
<!-- TODO 確認パスワードを実装する、値チェックをJS利用して作成する
 			<tr>
				<th>パスワード(確認用)</th>
				<td><input type="password" id="passwordConfirm" name="passwordConfirm"></td>
			</tr>
 -->
		<div class="form-group">
			<button type="reset" class="btn btn-default">キャンセル</button>
			<button type="submit" class="btn btn-primary">登録</button>
		</div>
	</form:form>
</div>
</body>