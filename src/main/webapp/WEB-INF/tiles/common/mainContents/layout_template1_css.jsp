<tiles:useAttribute id="cssfile" name="cssfiles" classname="java.util.List" />
<c:forEach var="cssfile" items="${cssfile}">
	<%-- 	<link rel="stylesheet" type="text/css" href="<c:url value="/css/honoka/bootstrap.css" />"> --%>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/${cssfile }"/>"/>
</c:forEach>