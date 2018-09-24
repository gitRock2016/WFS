<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<title>会場</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/map/sample.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/map/map.css"/>"/>
	<script src="<c:url value="/js/jquery-3.3.1.js" />"></script>
	<script src="<c:url value="/js/wfs-common.js" />"></script>
	<script src="<c:url value="/js/map/map.js" />"></script>
</head>

<body>
	<div id="hole" class="m-hole">
		<div id="hole8-7" class="m-hole-detail">
			<h2>８～７hole</h2>
			<div id="hole8-7-content" class="m-hole-detail-content1">
				<%@ include file="./map/hole-7.html"%>
			</div>
		</div>
		<div id="hole6-4" class="m-hole-detail">
			<h2>６～４hole</h2>
			<div id="hole6-4-content" class="m-hole-detail-content2">
				<%@ include file="./map/hole-6.html"%>
			</div>
		</div>
		
		<input type="button" value="8-7hole" id="show8-7hole"/>
		<input type="button" value="6-4hole" id="show6-4hole"/>
		
	</div>
</body>
