<%-- 
    Document   : viewCart
    Created on : May 3, 2018, 4:28:06 PM
    Author     : tuan5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <td>Product</td>
                <td>Amount</td>
            </tr>
            <s:iterator value="products" var="product">
                <tr>
                    <td><s:property value="key.name"/></td>
                    <td><s:property value="value"/></td>
                </tr>
            </s:iterator>
        </table>
        <label>Total: <s:property value="total"/></label>
    </body>
</html>
