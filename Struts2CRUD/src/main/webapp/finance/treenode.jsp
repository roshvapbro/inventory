<%@ page language="java" contentType="text/html; charset=UTF-8"

pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<html>

<head>

<sx:head/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>LedgerTree Tag</title>

</head>

<body>

<div>

<sx:tree id="books" label="Books" title="test" >

<sx:treenode label="Programing books" title="test">

<sx:treenode label="Java" title="test">

<sx:treenode id="Thread-Books" label="Core-Java" >

<sx:treenode id="Thread-Books" label="Java in Action" />

<sx:treenode id="Thread-Books" label="Core-Java Essentials" />

<sx:treenode id="Thread-Books" label="Head first Java" />

<sx:treenode id="Thread-Books" label="Multi-threading" />

<sx:treenode id="Thread-Books" label="Networking" />

</sx:treenode>

<sx:treenode label="J2EE" title="test1">

<sx:treenode id="Thread-Books" label="JSP in Action" />

<sx:treenode id="Thread-Books" label="Core-JSP-Servlet" />

<sx:treenode id="Thread-Books" label="Advance JSP-Servlet" />

</sx:treenode>

</sx:treenode>

</sx:treenode>

<sx:treenode label="Technical" >

<sx:treenode label="Science books"></sx:treenode>

</sx:treenode>

</sx:tree>

</div>

</body>

</html>