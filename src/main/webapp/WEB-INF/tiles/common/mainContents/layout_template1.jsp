<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<c:set var="titleName"><tiles:getAsString name='titleName' /></c:set>
	<title>${titleName }</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/honoka/bootstrap.css" />">
	<style type="text/css">
	body {
		padding-top: 80px;
	}
	
	@media ( min-width : 768px ) {
		#banner {
			min-height: 300px;
			border-bottom: none;
		}
		.bs-docs-section {
			margin-top: 8em;
		}
		.bs-component {
			position: relative;
		}
		.bs-component .modal {
			position: relative;
			top: auto;
			right: auto;
			left: auto;
			bottom: auto;
			z-index: 1;
			display: block;
		}
		.bs-component .modal-dialog {
			width: 90%;
		}
		.bs-component .popover {
			position: relative;
			display: inline-block;
			width: 220px;
			margin: 20px;
		}
		.nav-tabs {
			margin-bottom: 15px;
		}
		.progress {
			margin-bottom: 10px;
		}
	}
	</style>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</body>
</html>