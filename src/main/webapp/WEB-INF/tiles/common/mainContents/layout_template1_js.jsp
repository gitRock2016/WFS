<tiles:useAttribute id="jsfile" name="jsfiles" classname="java.util.List" />
<c:forEach var="jsfile" items="${jsfile}">
	<script src="<c:url value="/js/${jsfile}" />"></script>
</c:forEach>