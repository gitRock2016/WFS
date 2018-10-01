<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:url value="/sample/showMap" var="url_showMap" /> --%>
<c:url value="/mp/show" var="url_showMap" />
<c:set var="showHole" value="${showHole}" />
<c:set var="usrId" value="${usrId}" />
<c:set var="takuban" value="${takuban}" />
<input type="hidden" value="${usrId}" id="usrId"/>
<input type="hidden" value="${takuban}" id="takuban"/>


<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<title>会場</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/map/sample.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/map/map.css"/>"/>
	<script src="<c:url value="/js/jquery-3.3.1.js" />"></script>
	<script src="<c:url value="/js/wfs-common.js" />"></script>
	<script src="<c:url value="/js/map/map.js" />"></script>
	<script src="<c:url value="/js/mapForDojin.js" />"></script>
</head>

<body>
 	<a href="${url_showMap}/8">8hole</a>
 	<a href="${url_showMap}/7">7hole</a>
 	<a href="${url_showMap}/6">6hole</a>
 	<a href="${url_showMap}/5">5hole</a>
 	<a href="${url_showMap}/4">4hole</a>

	<div id="hole" class="m-hole">
		<c:if test="${showHole == 8}" >
			<div id="hole8" class="m-hole-detail">
				<h2>8hole</h2>
				<div id="hole8content" class="m-hole-detail-content1">
					<%@ include file="./map/8.html"%>
				</div>
			</div>
		</c:if>
		<c:if test="${showHole == 7}" >
			<div id="hole7" class="m-hole-detail">
				<h2>7hole</h2>
				<div id="hole7content" class="m-hole-detail-content1">
					<%@ include file="./map/7.html"%>
				</div>
			</div>
		</c:if>
		<c:if test="${showHole == 6}" >
			<div id="hole6" class="m-hole-detail">
				<h2>6hole</h2>
				<div id="hole6content" class="m-hole-detail-content1">
					<%@ include file="./map/6.html"%>
				</div>
			</div>
		</c:if>
		<c:if test="${showHole == 5}" >
			<div id="hole5" class="m-hole-detail">
				<h2>5hole</h2>
				<div id="hole6content" class="m-hole-detail-content1">
					<%@ include file="./map/5.html"%>
				</div>
			</div>
		</c:if>
		<c:if test="${showHole == 4}" >
			<div id="hole4" class="m-hole-detail">
				<h2>4hole</h2>
				<div id="hole6content" class="m-hole-detail-content1">
					<%@ include file="./map/4.html"%>
				</div>
			</div>
		</c:if>
	</div>
</body>
