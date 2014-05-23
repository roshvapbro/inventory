<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <style>td { white-space:nowrap; }</style>
    <title><s:property value="#title"/></title>
    <s:head />
</head>

             <td>
                <div class="content">

<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:property value="#title"/></h1>
<s:actionerror />
<s:actionmessage />
<div class="form">

<s:form action="saveGroupMaster" method="post">
	<s:textfield name="group.groupName" label="Group Name"  size="40" />
	<s:select name="group.groupParent" list="groupheads" headerKey="" headerValue="Select" label="Select a Parent" />
 	
 	<s:submit key="submit"/>
</s:form>
</div>
</div>
</tbody></table>

