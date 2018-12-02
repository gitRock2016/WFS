<c:url value="/accnt/accnt_01/login" var="login" />
<c:url value="/accnt/accnt_03/init" var="toregist" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>ログイン</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/honoka/bootstrap.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/honoka/bootstrap.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"/>"/>
	<script src="<c:url value="/js/jquery-3.3.1.js" />"></script>
	<script src="<c:url value="/js/wfs-common.js" />"></script>
	<script src="<c:url value="/js/login.js" />"></script>

</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-lg-8  col-lg-offset-1">
			<div class="page-header">
				<h1 id="forms">Wfsにログイン</h1>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-8 col-lg-offset-1 col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1">
		<div class="alert-success">${success_message}</div>
		<div class="alert-danger">${danger_message}</div>
			<div class="bs-component">
					<form:form action="${login }" method="POST" modelAttribute="loginForm" id="loginForm">
						<div class="col-lg-8 col-lg-offset-1 ">
								<div class="form-group">
										<label for="user">user</label>
										<input type="text" id="user" name="userid" class="form-control" value="${loginForm.userid }">
								</div>
								<div class="form-group">
									<label for="password">password</label>
									<input type="text" id="password" name="password" class="form-control">
								</div>
							<div class="form-group formButtons">
								<button type="submit" class="btn btn-primary" id="loginBtn">ログイン</button>
								<button type="button" class="btn btn-primary" id="accountRegistBtn" onclick='location.href="${toregist}"'>新規登録</button>
							</div>
						</div>
					</form:form>
					<div class="clear"></div>
				</div>
		</div>
	</div>
</div>
</body>
</html>