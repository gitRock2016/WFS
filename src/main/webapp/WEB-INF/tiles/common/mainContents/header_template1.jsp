<c:url value="/" var="top" />
<c:url value="/g00/logout" var="g00_logout" />
<c:url value="/g03/init" var="g03_init" />
<c:url value="/g04/init" var="g04_init" />
<c:url value="/g06/init" var="g06_init" />
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
					<li><a href="${g04_init }" title=ディーラー検索>ディーラー検索</a></li>
					<li><a href="${g06_init }" title="ディーラー登録">ディーラー登録</a></li>
					<li><a href="${top }" title="TODO 作成中">作品検索</a></li>
					<li><a href="${top }" title="TODO 作成中">地図確認</a></li>
					<li><a href="${g00_logout }" title="logaout">LogOut</a></li>
				</ul>
			</div>
		</div>
	</div>
</header>
</div>