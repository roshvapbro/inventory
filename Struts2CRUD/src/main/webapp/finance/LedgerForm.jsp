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

<s:form action="saveLedgerMaster" method="post">
<s:if test="groupheads != null">

	<s:select name="ledgermaster.groupParent" list="groupheads" headerKey="" headerValue="Select" label="Select a Parent" />
	</s:if>
	<s:textfield key="ledgermaster.ledgerName" label="Ledger Name"  size="40" />
      <s:textfield key="ledgermaster.Address" label="Address"  size="40"/>
      <s:textfield key="ledgermaster.Area" label="Area"  size="20"/>
       <s:textfield key="ledgermaster.Place" label="Place"  size="20"/>
        <s:textfield key="ledgermaster.Phone" label="Phone"  size="20"/>
        <s:textfield key="ledgermaster.Mobile" label="Mobile"   size="20"/>
         <s:textfield key="ledgermaster.Fax"  label="Fax" size="20"/>
         <s:textfield key="ledgermaster.Email" label="Email"  size="20"/>
         <s:textfield key="ledgermaster.TIN" label="TIN"  size="20"/>
         <s:textfield key="ledgermaster.CST" label="CST"  size="20"/>
         <s:textfield key="ledgermaster.PAN" label="PAN"  size="20"/>
          <s:select label="Inst Type" list="{'NONE','BANK','CASH'}" name="ledgermaster.InstType" headerKey="None" 
headerValue="Select"/>
<s:select label="AC Type" list="{'ASSET','LIABILITY'}" name="ledgermaster.ACType" headerKey="None" headerValue="Select"/>     
     <s:textfield key="ledgermaster.CrDays" label="CR Days"  size="10"/>
          <s:textfield key="ledgermaster.CrLimit" label="CrLimit"  size="10"/>
          <s:textfield key="ledgermaster.OpBalance" label="Opening Balance"  size="20"/>  
          <s:select  list="{'CR','DR'}" 
name="ledgermaster.Optype" 
headerKey="None" 
headerValue="Select"/>
<sx:datetimepicker name="ledgermaster.OPDate" label="OpBal Date (dd-MMM-yyyy)" 
displayFormat="dd-MMM-yyyy" value="%{'2014-01-01'}"/>
 <s:textfield key="ledgermaster.Remarks" label="Remarks"  size="40"/>
          
   
   
    <s:submit key="submit"/>
</s:form>
</div>
</div>
</tbody></table>

