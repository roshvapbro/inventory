<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <title><s:text name="label.products"/></title>
</head>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:text name="label.categories"/></h1>
<s:url var="url" action="addProductInput" />
<a href="<s:property value="#url"/>">Add A New Product</a>
<s:url var="caturl" action="addCategoryInput" />
<a href="<s:property value="#caturl"/>">Add A New Category</a>

<br/><br/>
<table class="borderAll">
    <tr>
        <th><s:text name="label.type"/></th>
        <th><s:text name="label.category"/></th>
    </tr>
    <s:iterator value="products" status="status">
        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
            <td class="nowrap"><s:property value="name"/></td>
            <td class="nowrap"><s:property value="categoryId"/></td>
            <td class="nowrap">
                <s:url action="editProductInput" var="url">
                    <s:param name="categoryId" value="categoryId"/>
                </s:url>
                <a href="<s:property value="#url"/>">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <s:url action="deleteProduct" var="url">
                    <s:param name="categoryId" value="categoryId"/>
                </s:url>
                <a href="<s:property value="#url"/>">Delete</a>
            </td>
        </tr>
    </s:iterator>
    </table>

</body>
</html>