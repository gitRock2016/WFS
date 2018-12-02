<!DOCTYPE html>


	<div class="container">
		<div class="page-header">
			<h1>アカウント登録画面</h1>
		</div>
		
		<spring:bind path="accountRegistForm.*" htmlEscape="true">
			<c:if test="${status.error}">
				<div class="row alert alert-dismissible alert-danger">
					<c:forEach items="${status.errorMessages}" var="msg">
					${msg}<br>
					</c:forEach>
				</div>
			</c:if>
		</spring:bind>
		<div class="alert-success">${success_message}</div>
		<div class="alert-danger">${danger_message}</div>

		<div class="panel panel-default">
			<div class="panel-body">
				<form:form action="/WonFesSys/g02/regist" id="accountRegistForm" modelAttribute="accountRegistForm">
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
					<div class="form-group">
						<label for="passwordSecond">パスワード(2回目)</label>
						<div>
							<input type="password" id="passwordSecond" name="passwordSecond"
								maxlength="32" pattern="^[0-9A-Za-z]+$">
						</div>
					</div>
					<button type="submit" class="btn btn-primary" id="accountRegistBtn">登録</button>
				</form:form>
			</div>
		</div>
	</div>