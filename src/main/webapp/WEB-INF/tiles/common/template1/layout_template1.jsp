<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<c:set var="titleName"><tiles:getAsString name='titleName' /></c:set>
		<title>${titleName }</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/sample/sora.css"/>" />
 	</head>
	<body>
		<div id="wrapper">
			<tiles:insertAttribute name="header" />
			<tiles:insertAttribute name="body" />
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
</html>