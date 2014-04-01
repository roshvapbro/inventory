<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="category==null || category.categoryId==null">
	<s:set name="title" value="%{'Add New Category'}" />
</s:if>
<s:else>
	<s:set name="title" value="%{'Update Category'}"/>
</s:else>

<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td { white-space:nowrap; }</style>
    <title><s:property value="#title"/></title>
    <s:head />
</head>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:property value="#title"/></h1>
<s:actionerror />
<s:actionmessage />
<s:form action="addCategorySave" method="post">
    <s:textfield key="category.categoryId"   size="20"/>
    <s:textfield key="category.name"   size="20"/>
    <s:submit key="submit"/>
</s:form>

</body>
</html>