<c:url value="/top" var="top" />
<c:url value="/accnt/accnt_01/show" var="accnt_accnt_01" />
<c:url value="/accnt/accnt_02" var="accnt_accnt_02" />
<c:url value="/accnt/accnt_04/init" var="accnt_accnt_04_init" />
<c:url value="/g03/init" var="g03_init" />
<c:url value="/dlr/dlr_05/init" var="dlr05_init" />
<c:url value="/dlr/dlr_01/show?reg=new" var="dlr_01_show" />
<c:url value="/sample/init" var="sample_init" />
<c:url value="/accnt/accnt_02" var="accnt_accnt_02" />
<c:url value="/accnt/accnt_03/init" var="accnt_accnt_03_init" />
<c:set var="isSession" value="${sessionScope.login !=null }"/>

<div id="header">
<header>
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="${top}" class="navbar-brand">WonFesSys</a>
			</div>
			<div class="navbar-collapse collapse" id="navbar-main">
				<ul class="nav navbar-nav">
					<li><a href="${top }" title="TODO 作成中">作品検索</a></li>
					<c:if test="${isSession }">
						<li><a href="${top }" title="TODO 作成中">作品登録</a></li>
					</c:if>
					<li><a href="${dlr05_init }" title=ディーラー検索>ディーラー検索</a></li>
					<c:if test="${isSession }">
						<li><a href="${dlr_01_show }" title="ディーラー登録">ディーラー登録</a></li>
					</c:if>
					<c:if test="${isSession }">
						<li><a href="${accnt_accnt_02 }" title="logout">LogOut</a></li>
						<li><a href="${accnt_accnt_04_init }" title="アカウント情報">アカウント情報</a></li>
						<li><a href="${top }" title="TODO 作成中">アカウント管理</a></li>
					</c:if>
					<c:if test="${! isSession }">
						<li><a href="${accnt_accnt_01 }" title="ログイン">LogIn</a></li>
						<li><a href="${accnt_accnt_03_init }" title="アカウントの新規登録">アカウント登録</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</header>
</div>