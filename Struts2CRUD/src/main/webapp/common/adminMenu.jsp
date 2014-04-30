<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
	
<%@taglib prefix="s" uri="/struts-tags" %>

 
 <div id="menu">
                <a href="#" title="Dashboard">Dashboard</a>
                <a href="#" title="Sales">Sales</a>
                <a href="#" title="Purchase">Purchase</a>
                <a href="<%=request.getContextPath() %>/index.action" title="Products &amp; Items">Products &amp; Items</a>
                <a href="#" title="Finance">Finance</a>
                <div style="float: right;">
                    <a href="/Account/SignOut.aspx" class="icon">
                        <img src="/Resource/Icons/signout-16.png">
                    </a>
                    <a href="/Account/ChangePassword.aspx" class="icon">
                        <img src="/Resource/Icons/password-16.png">
                    </a>
                </div>
            </div>
 
 