<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<sx:head/>
<title>Listing</title>
</head>
<script>
function show_details() {
dojo.event.topic.publish("show_detail");
}
</script>
<body>
<s:form id="frm_demo" name="frm_demo" theme="simple">
<table border="0">
<tr>
<td><s:select   style='width: 300px;' list="transhead"  listKey="acId"  headerKey="" headerValue="Select" listValue="acHead" name="id"
onchange="javascript:show_details();return false;" label="Transaction Type"><s:label>TransType::</s:label></s:select>
</td>
<td><s:url id="d_url" action="DetailAction" /> 
<sx:div id="details" href="%{d_url}" listenTopics="show_detail" formId="frm_demo" showLoadingText=""></sx:div>
<s:if test="currentbal != null">
	<s:textfield readonly="true" name="currentbal" label="CurrentBalance:"  style='width: 200px;' />
</s:if>
</tr>
</table>
</s:form>
</body>
</html>