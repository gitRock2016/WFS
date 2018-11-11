<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<meta charset="utf-8">
	<title>TOP</title>
<script type="text/javascript">
	function send(){
		alert("aaa");
	}
//	send();
</script>

</head> 

<body>
	
	<h2>開発画面へ</h2>
	<c:url value="/top" var="top" /><a href="${top}">top</a><br/>
	<c:url value="/g03/init" var="g03_init" /><a href="${g03_init}">アカウント情報画面</a><br/>
	<c:url value="/dlr/dlr_05/init" var="dlr05_init" /><a href="${dlr05_init}">ディーラー検索画面2</a><br/>
	<c:url value="/dlr/dlr_01_01/show?reg=new" var="dlr_01_01_show" /><a href="${dlr_01_01_show}">ディーラー登録画面2</a><br/>
	<c:url value="/dlr/dlr_06/show/dealerId/1" var="dlr_06_show_dealerId_1" /><a href="${dlr_06_show_dealerId_1}">ディーラー情報画面</a><br/>
	<c:url value="/accnt/accnt_02" var="accnt_accnt_02" /><a href="${accnt_accnt_02}">logout</a><br/>
	<c:url value="/sample/init" var="sample_init" /><a href="${sample_init}">sample画面</a><br/>
	<c:url value="/sample/init2" var="sample_init2" /><a href="${sample_init2}">sample2画面, ファイルアップ機能検証</a><br/>
	<c:url value="/sample/showHonoka" var="sample_showHonoka" /><a href="${sample_showHonoka}">bootStrapのHonoka画面</a><br/>
	<c:url value="/mp/show/8" var="sample_showMap" /><a href="${sample_showMap}">map</a><br/>
<!-- 	<img src="http://www.iwatakhr69.net/wfs/img/icon/default_1.jpg" /> -->
</html>
