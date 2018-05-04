<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 宣言 -->
<c:url value="/" var="top" />
<c:url value="/g00/logout" var="g00_logout" />
<c:url value="/g03/init" var="g03_init" />
<c:url value="/g04/init" var="g04_init" />
<c:url value="/g06/init" var="g06_init" />
<c:url value="/sample/init" var="sample_init" />
<c:url value="/g00/logout" var="g00_logout" />

<!-- 本体 -->
<div id="header">
	<h1>
		<a href="${top  }" title="top">WonFesSys</a>
	</h1>
	<ul>
		<li><a href="${g00_logout}">logout</a><br/></li>
	</ul>
</div>

<div id="header-menu">
	<ul>
		<li><a href="${g04_init }" title=ディーラー検索>ディーラー検索</a></li>
		<li><a href="${g06_init }" title="ディーラー登録">ディーラー登録</a></li>
		<li><a href="${top }" title="TODO 作成中">作品検索</a></li>
		<li><a href="${top }" title="TODO 作成中">地図確認</a></li>
	</ul>
</div>

<div id="header-image">
	<h2>
		loginId:${sessionScope.s_loginId}<br/>
		login名称:${sessionScope.s_loginName}
	</h2>
</div>
