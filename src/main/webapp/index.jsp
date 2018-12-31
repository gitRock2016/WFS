<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:url value="/top" var="top" />

<html>
<head>
	<meta charset="utf-8">
<%--
	TODO 最終的にTOPへリダイレクトさせる
	<meta http-equiv="refresh" content="0; URL='${top }'" />
--%>
	<title>TOP</title>
<script type="text/javascript">
// TODO 踏み台JSPを作成する際は、直書きのJSを利用する
//	function send(){
//		alert("aaa");
//	}
//	send();
</script>
<style type="text/css">
/*
	TODO　背景画像を設定する場合は、直書きのCSSを利用する
 	.sample {
		background-image:url("http://localhost:81/wfs/img/common/log2.jpg");
	}
 */
</style>

</head> 

<body>
<%--
 	<%	String isSession = (String) session.getAttribute("target");%>
	EL式はスクリプトレットで変数に値を格納しても、それを取得できない
	<c:if test="${ isSession!=null}">sessionあり</c:if>
 --%>
<%--
セッションスコープから値を取得
<br>	${sessionScope.target }
<br>	${sessionScope.login }
<br>${pageContext.session.id}
 --%>
 	<h2>開発画面へ</h2>
	<a href="${top}">top</a><br/>
	<c:url value="/wrk/wrk_05/init/1/1" var="wrk_wrk_05_init" /><a href="${wrk_wrk_05_init}">作品情報画面、ディーラ１、作品１</a><br/>
	<c:url value="/g03/init" var="g03_init" /><a href="${g03_init}">アカウント情報画面</a><br/>
	<c:url value="/dlr/dlr_05/init" var="dlr05_init" /><a href="${dlr05_init}">ディーラー検索画面2</a><br/>
	<c:url value="/dlr/dlr_01/show?reg=new" var="dlr_01_show" /><a href="${dlr_01_show}">ディーラー登録画面2</a><br/>
	<c:url value="/dlr/dlr_06/show/dealerId/1" var="dlr_06_show_dealerId_1" /><a href="${dlr_06_show_dealerId_1}">ディーラー情報画面</a><br/>
	<c:url value="/accnt/accnt_06/init" var="accnt_accnt_06_init" /><a href="${accnt_accnt_06_init}">アカウント管理画面</a><br/>
	<c:url value="/accnt/accnt_02" var="accnt_accnt_02" /><a href="${accnt_accnt_02}">logout</a><br/>
	<c:url value="/sample/init" var="sample_init" /><a href="${sample_init}">sample画面</a><br/>
	<c:url value="/sample/init2" var="sample_init2" /><a href="${sample_init2}">sample2画面, ファイルアップ機能検証</a><br/>
	<c:url value="/sample/showHonoka" var="sample_showHonoka" /><a href="${sample_showHonoka}">bootStrapのHonoka画面</a><br/>
	<c:url value="/mp/show/8" var="sample_showMap" /><a href="${sample_showMap}">map</a><br/>

</html>
