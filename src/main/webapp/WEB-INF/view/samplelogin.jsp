<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>samplelogin</title>
</head>
<body>
	<h3>ログインフォーム、サンプル</h3>
	<c:if test="${param.containsKey('error') }">
		<span style="color: red"><c:out
				value="${SPRING_SECURITY_LAST_EXCEPTION.message }"></c:out></span>
	</c:if>
	<c:url var="loginurl" value="/login"/>
	<form:form action=${loginurl }>
	<input type="text" id="username" name="username">:username
	<input type="text" id="password" name="password">:password
	<button>submit</button>
	</form:form>
</body>
</html>