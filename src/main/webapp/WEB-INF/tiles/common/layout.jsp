<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%> 

<!-- 
TODO DTDを利用しなくても、通常のJSPでの定義が使えるので、そちらを使う。
参考サイトはDTD使ってたんだけど、使えるものなの・・
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> -->
<!DOCTYPE html>
<html>

<c:set var="titleName"><tiles:getAsString name='titleName' /></c:set> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>${titleName}</title>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
</body>
</html>