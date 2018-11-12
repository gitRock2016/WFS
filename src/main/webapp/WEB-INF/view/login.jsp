<c:url value="/accnt/accnt_01" var="login" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>ログイン</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/honoka/bootstrap.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/honoka/bootstrap.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"/>"/>
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
			<div class="bs-component">
					<form:form action="${login }" method="POST" modelAttribute="loginForm">
						<div class="col-lg-8 col-lg-offset-1 ">
								<div class="form-group">
										<label for="user">user</label>
										<input type="text" id="user" name="userid" class="form-control">
								</div>
								<div class="form-group">
									<label for="password">password</label>
									<input type="text" id="password" name="userpassword" class="form-control">
								</div>
							<div class="form-group formButtons">
								<button type="submit" class="btn btn-primary">ログイン</button>
								<button type="button" class="btn btn-primary">新規登録</button>
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