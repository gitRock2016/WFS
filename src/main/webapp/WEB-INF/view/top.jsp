<!DOCTYPE html>
<%
String ss = (String)session.getAttribute("target");
boolean isSession = false;
if(ss!=null){
	isSession=true;
}

%>

<div class="container">
	<div class="page-header">
		<img src="${url_logo }" id="topImgId" name="topImg"/>
	</div>
</div>
