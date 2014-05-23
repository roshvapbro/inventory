<%

response.setCharacterEncoding("UTF-8");
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", -1);

%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>



<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<tiles:importAttribute name="page" scope="request"/>
<tiles:importAttribute name="menuIndex" scope="request"/>

<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title><s:property value="pageTitle"/></title> 
		<jsp:include page="/common/adminLinks.jsp" />


<sx:head/>
<title>Listing</title>
<script>
function show_details() {
dojo.event.topic.publish("show_detail");
}
function show_details1() {
	dojo.event.topic.publish("show_detail1");
	}
</script>
</head>
<body>
<div id="page">
<a href="#">
                <img src="logo.png" height="50" width="250">
            </a>

  <jsp:include page="/common/adminMenu.jsp" />

<div id="content">
<table id="menu-table" width="100%" cellpadding="0" cellspacing="0">
        <tbody>
		 <tiles:insertAttribute name="menu"/>
		<tiles:insertAttribute name="body"/>
	</tbody>
</table>	
</div>


   <jsp:include page="/common/footer.jsp" />
</div>
</body>
</html>


