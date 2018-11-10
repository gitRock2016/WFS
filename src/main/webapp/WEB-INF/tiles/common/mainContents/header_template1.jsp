<c:url value="/" var="top" />
<c:url value="/g00/logout" var="g00_logout" />
<c:url value="/g03/init" var="g03_init" />
<c:url value="/dlr/dlr_05/init" var="dlr05_init" />
<c:url value="/dlr/dlr_01_01/show?reg=new" var="dlr_01_01_show" />
<c:url value="/sample/init" var="sample_init" />
<c:url value="/g00/logout" var="g00_logout" />

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
					<li><a href="${top }" title="TODO 作成中">作品登録</a></li>
					<li><a href="${dlr05_init }" title=ディーラー検索>ディーラー検索</a></li>
					<li><a href="${dlr_01_01_show }" title="ディーラー登録">ディーラー登録</a></li>
					<li><a href="${g00_logout }" title="logaout">LogOut</a></li>
					<li><a href="${g00_logout }" title="logaout">アカウント情報</a></li>
					<li><a href="${g00_logout }" title="logaout">アカウント管理</a></li>
				</ul>
			</div>
		</div>
	</div>
</header>
</div>