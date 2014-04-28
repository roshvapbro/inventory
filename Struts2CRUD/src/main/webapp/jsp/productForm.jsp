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
<body>

<table id="menu-table" width="100%" cellpadding="0" cellspacing="0">
        <tbody><tr>
            <td class="menu2" id="menu2">
                <div style="padding: 12px 0px 0px 12px;">
                    <input name="" type="text" id="SearchTextBox">
                </div>
                <div class="sub-menu"><div class="menu-title">Inventory Movements</div><a href="/Inventory/Transfer.aspx" title="Stock Transfer Journal" data-menucode="STJ" class="sub-menu-anchor">Stock Transfer Journal</a><a href="/Inventory/Adjustment.aspx" title="Stock Adjustments" data-menucode="STA" class="sub-menu-anchor">Stock Adjustments</a></div><div class="sub-menu"><div class="menu-title">Setup &amp; Maintenance</div><a href="/Inventory/Setup/PartyTypes.aspx" title="Party Types" data-menucode="PT" class="sub-menu-anchor">Party Types</a><a href="/Inventory/Setup/Parties.aspx" title="Party Accounts" data-menucode="PA" class="sub-menu-anchor">Party Accounts</a><a href="/Inventory/Setup/ShippingAddresses.aspx" title="Shipping Addresses" data-menucode="PSA" class="sub-menu-anchor">Shipping Addresses</a><a href="/Inventory/Setup/Items.aspx" title="Item Maintenance" data-menucode="SSI" class="sub-menu-anchor">Item Maintenance</a><a href="/Inventory/Setup/CostPrices.aspx" title="Cost Prices" data-menucode="ICP" class="sub-menu-anchor">Cost Prices</a><a href="/Inventory/Setup/SellingPrices.aspx" title="Selling Prices" data-menucode="ISP" class="sub-menu-anchor">Selling Prices</a><a href="/Inventory/Setup/ItemGroups.aspx" title="Item Groups" data-menucode="SSG" class="sub-menu-anchor">Item Groups</a><a href="/Inventory/Setup/Brands.aspx" title="Brands" data-menucode="SSB" class="sub-menu-anchor">Brands</a><a href="/Inventory/Setup/UOM.aspx" title="Units of Measure" data-menucode="UOM" class="sub-menu-anchor">Units of Measure</a><a href="/Inventory/Setup/CUOM.aspx" title="Compound Units of Measure" data-menucode="CUOM" class="sub-menu-anchor">Compound Units of Measure</a><a href="/Inventory/Setup/Shipper.aspx" title="Shipper Information" data-menucode="SHI" class="sub-menu-anchor">Shipper Information</a></div>
            </td>
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

</body>
</html>