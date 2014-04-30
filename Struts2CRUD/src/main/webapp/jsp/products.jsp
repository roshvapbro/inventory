<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
             <td>
                <div class="content">
                <div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:text name="label.products"/></h1>
                	<div id="ScrudUpdateProgress" style="display:none;" role="status" aria-hidden="true">
		<div class="ajax-container" style="height: 607px;"><img src="/spinner.gif" class="ajax-loader"></div>
	</div><hr class="hr"><span></span><div id="ScrudUpdatePanel">
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
					
						<th scope="col">Select</th>
						<th scope="col"><s:text name="label.barcodeId"/></th>
						<th scope="col"><s:text name="label.description"/></th>
						<th scope="col" ><s:text name="label.type"/></th>
						<th scope="col" ><s:text name="label.category"/></th>
						<th scope="col" ><s:text name="label.otherinfo"/></th>
						</tr>
						<tr class="tableFloatingHeaderOriginal">
						<th scope="col" >Select</th>
						<th scope="col" ><s:text name="label.barcodeId"/></th>
						<th scope="col" ><s:text name="label.description"/></th>
						<th scope="col" ><s:text name="label.type"/></th>
						<th scope="col" ><s:text name="label.category"/></th>
						<th scope="col" ><s:text name="label.otherinfo"/></th>	
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

