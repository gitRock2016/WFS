<div id="header">
	<h1>WonFesSys</h1>
	<div style="text-align: right">
		loginId:${sessionScope.s_loginId},
		login名称:${sessionScope.s_loginName}</div>
	<div style="text-align: right">
		<c:url value="/accnt/accnt_02" var="accnt_accnt_02" />
		<a href="${accnt_accnt_02}">logout</a>
	</div>

</div>
