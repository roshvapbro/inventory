<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
	
<%@taglib prefix="s" uri="/struts-tags" %>	



	<link type="text/css" href="<%=request.getContextPath()%>/common/css/theme.css" rel="stylesheet" />
	<link type="text/css" href="<%=request.getContextPath()%>/common/css/style.css" rel="stylesheet" />
	
      
	

	

	<style type="text/css">

	<!-- general page text elements -->

	td {
		width:30%;
	}


	<!-- left navigation -->

	.left-nav, .left-nav ul, .left-nav li { 
		margin: 0; 
		padding: 0 
	} 
	.left-nav { 
		float: left; 
		width: 170px; 
		font-size: 1.1em; 
	} 
	.left-nav h4 { 
		margin: 0; 
		padding: 0; 
		color: #e87b10; 
	} 
	.left-nav h4 { 
		margin-top: 1.5em; 
		margin-bottom: 0; 
		padding-left: 8px; 
		padding-bottom:5px; 
		line-height: 1.2em; 
		border-bottom: 1px solid #F4F4F4; 
	} 

	.left-nav li a { 
		border-bottom: 1px solid #F4F4F4; 
		display:block; 
		padding: 4px 3px 4px 8px; 
		font-size: 90%; 
		text-decoration: none; 
		color: #555 ; 
		margin:2px 0; 
		height:13px; 
	}


	.icon-ok{
		border:solid 1px #90ac13;
		background:#eef4d3;
		color:#6b800d;
		font-weight:bold;
		padding:17px;
		margin-bottom:10px;
		text-align:left;
	}

	.icon-error{
		border:solid 1px #CC0000;
		background:#F7CBCA;
		color:#CC0000;
		font-weight:bold;
		padding:17px;
            margin-bottom:10px;
		text-align:left;
	}

	.clean-yellow{
		border:solid 1px #DEDEDE;
		background:#FFFFCC;
		color:#222222;
		padding:4px;
		text-align:center;
	} 


	</style>





	<script> jQuery.noConflict(); </script>




<script type="text/javascript">


	function block() {

		jQuery.blockUI('<h1><s:text name="label.generic.wait" /></h1>');

	 }


	jQuery(document).ready(function(){
		jQuery( "#accordion" ).accordion({
			autoHeight: false,
			navigation: true
		});

	});




</script>