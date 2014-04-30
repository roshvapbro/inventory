<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="product==null || product.pdocutId == null">
	<s:set name="title" value="%{'Add New Product'}" />
</s:if>
<s:else>
	<s:set name="title" value="%{'Update Product'}"/>
</s:else>

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

<s:form action="addProductSave" method="post">
    <s:textfield key="product.description"   size="40"/>
    <s:textfield key="product.type"   size="40"/>
    <s:textfield key="product.barcodeId" size="20"/>
    <s:select key="product.category.categoryId"  list="categories" listKey="categoryId" listValue="name"/>
    <s:textfield key="product.otherInfo"   size="20"/>
    <s:hidden name="product.pdocutId" />
    <s:submit key="submit"/>
</s:form>
</div>
</div>
</tbody></table>

