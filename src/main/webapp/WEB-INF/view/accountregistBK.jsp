<!DOCTYPE html>
<%--
	spring:bindの記載方法、暫定で参考のため残す
 	<spring:bind path="accountRegistForm01.userid" htmlEscape="true">
		status.expression:${status.expression }<br>
		status.value:${status.value}<br>
		status.errorMessages<br>
		<c:forEach items="${status.errorMessages}" var="msg">
			${msg }<br>
		</c:forEach>
	</spring:bind>
--%>
	<div class="container">
		<div class="page-header">
			<h1>アカウント登録画面</h1>
		</div>
		<%-- 		<div class="row alert alert-dismissible alert-danger">
			<form:errors path="accountRegistForm01.*" />
		</div> --%>

		<spring:bind path="accountRegistForm01.*" htmlEscape="true">
			<c:if test="${status.error}">
				<div class="row alert alert-dismissible alert-danger">
					<c:forEach items="${status.errorMessages}" var="msg">
					${msg}<br>
					</c:forEach>
				</div>
			</c:if>
		</spring:bind>

		<%-- 		<form:errors path="accountRegistForm01.*" /> --%>

		<div class="panel panel-default">
			<div class="panel-body">
				<form:form action="/WonFesSys/g02/regist" id="registForm"
					modelAttribute="accountRegistForm01">
					<div class="form-group">
						<label for="dealerId">id</label>
						<div>
							<input type="text" id="userid" name="userid" maxlength="10"
								pattern="^[0-9A-Za-z]+$">
						</div>
					</div>
					<div class="form-group">
						<label for="userName">userName</label>
						<div>
							<input type="text" id="username" name="username" maxlength="50">
						</div>
					</div>
					<div class="form-group">
						<label for="password">パスワード</label>
						<div>
							<input type="password" id="password" name="password"
								maxlength="32" pattern="^[0-9A-Za-z]+$">
						</div>
					</div>
					<button type="submit" class="btn btn-primary">登録</button>
				</form:form>
			</div>
		</div>
	</div>