<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title><s:text name="label.products"/></title>
</head>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:text name="label.products"/></h1>


<br/><br/>
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
                	<div id="ScrudUpdateProgress" style="display:none;" role="status" aria-hidden="true">
		<div class="ajax-container" style="height: 607px;"><img src="/spinner.gif" class="ajax-loader"></div>
	</div><h1><span id="TitleLabel">Items</span></h1><hr class="hr"><span></span><div id="ScrudUpdatePanel">
		<div class="vpad16">
	
		<s:url var="url" action="addProductInput" />
		<a href="<s:property value="#url" />">Add A New Product</a>
<!-- 		<input name="" type="button" class="menu" title="ALT + A" value="Add New"  >
 -->                
          </div>
          
          
          <div id="GridPanel" style="width: 1018px; overflow: auto;">
			<div>
				<div class="floating-header" style="position:relative">
				<table class="grid" cellspacing="0" id="FormGridView" style="width:2000px;border-collapse:collapse;">
					<tbody>
					<tr class="tableFloatingHeader" style="position: absolute; top: 0px; left: 0px; visibility: hidden; width: 2000px;">
					
						<th scope="col" style="width: 30px;">Select</th>
						<th scope="col" style="width: 41px;"><s:text name="label.barcodeId"/></th>
						<th scope="col" style="width: 60px;"><s:text name="label.description"/></th>
						<th scope="col" style="width: 60px;"><s:text name="label.type"/></th>
						<th scope="col" style="width: 81px;"><s:text name="label.category"/></th>
						<th scope="col" style="width: 50px;"><s:text name="label.otherinfo"/></th>
						</tr>
						<tr class="tableFloatingHeaderOriginal">
						<th scope="col" style="width: 30px;">Select</th>
						<th scope="col" style="width: 41px;"><s:text name="label.barcodeId"/></th>
						<th scope="col" style="width: 60px;"><s:text name="label.description"/></th>
						<th scope="col" style="width: 60px;"><s:text name="label.type"/></th>
						<th scope="col" style="width: 81px;"><s:text name="label.category"/></th>
						<th scope="col" style="width: 50px;"><s:text name="label.otherinfo"/></th>	
						</tr>
          
    <s:iterator value="products" status="status">
        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
        <td style="width:20px;"><input value="2" name="" type="radio" id="SelectRadio_0"></td>
            <td class="nowrap"><s:property value="barcodeId"/></td>
            <td class="nowrap"><s:property value="description"/></td>
            <td class="nowrap"><s:property value="type"/></td>
            <td class="nowrap"><s:property value="category.name"/></td>
            <td class="nowrap"><s:property value="otherInfo"/></td>
            <td class="nowrap">
                <s:url action="editProductInput" var="url">
                    <s:param name="product.pdocutId" value="pdocutId"/>
                </s:url>
                <a href="<s:property value="#url"/>">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <s:url action="deleteProduct" var="url">
                    <s:param name="product.pdocutId" value="pdocutId"/>
                </s:url>
                <a href="<s:property value="#url"/>">Delete</a>
            </td>
        </tr>
    </s:iterator>
    </tbody></table></div>
			</div>
			
</div>

</body>
</html>