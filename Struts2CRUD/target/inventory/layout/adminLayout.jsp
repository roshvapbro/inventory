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


<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<tiles:importAttribute name="page" scope="request"/>
<tiles:importAttribute name="menuIndex" scope="request"/>

<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title><s:property value="pageTitle"/></title> 
		<jsp:include page="/common/adminLinks.jsp" />




</head>




<body>
<div id="page">
<a href="#">
                <img src="logo.png" height="50" width="250">
            </a>

  <jsp:include page="/common/adminMenu.jsp" />
   <tiles:insertAttribute name="menu"/>

<div id="content">

		<tiles:insertAttribute name="body"/>
</div>


   <jsp:include page="/common/footer.jsp" />
</div>
</body>
</html>


