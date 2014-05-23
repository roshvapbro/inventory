<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

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
<s:form action="savecashReceiptform" method="post" id="frm_demo" name="frm_demo" theme="simple">
<table border="0">
<tr>
<td><s:select    style='width: 300px;' list="transhead"  listKey="acId"  headerKey="" headerValue="Select" listValue="acHead" name="id"
onchange="javascript:show_details();return false;" label="Transaction Type"><s:label>TransType::</s:label></s:select>
</td>
<td><s:url id="d_url" action="CashReceiptDetailAction" /> 
<sx:div id="details" href="%{d_url}" listenTopics="show_detail" formId="frm_demo" showLoadingText=""></sx:div>
</td>
<br>
</tr>
<tr>
<td><s:select   style='width: 300px;' list="ledgerheads" listKey="ledgerId" headerKey="" headerValue="Select" listValue="ledgerHead" name="lid"
onchange="javascript:show_details1();return false;" label="Ledger">LedgerType</s:select>
</td>
<td><s:url id="d_url" action="CashReceiptledgerAction" /> 
<sx:div id="details1" href="%{d_url}" listenTopics="show_detail1" formId="frm_demo" showLoadingText=""></sx:div>
<br>
</tr>
 <tr>
  <td><s:textfield key="" label="Conversion Rate"  style='width: 300px;'>ConvRate</s:textfield></td>

   <td><s:textfield key="" label="Quantity"  style='width: 200px;'>Quantity</s:textfield></td>
   </tr>
   <tr>
  <td><s:textfield key="" label="Amount"  style='width: 300px;'>Amount::</s:textfield></td>
 </tr>
   <tr>
  <td><s:textfield key="" label="Remarks"  style='width: 300px;'>Remarks::</s:textfield></td>
 </tr>
 <tr>
   <td><s:submit key="submit"/></td>
          
 </tr>
</table>

</s:form>
</div>
</div>
