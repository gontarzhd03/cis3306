<%-- 
    Document   : ComputerOrder
    Created on : May 3, 2018, 9:37:58 AM
    Author     : 55gontarhd03
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="desktopcomputerbilling.ComputerComponents"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Computer</title>
    </head>
    <body>
        <h1>Computer</h1>
        <% ComputerComponents cc = (ComputerComponents)request.getAttribute("aComputerComponents"); %>
        <p>Processor is <%= cc.getProcessor() %> for $<%= cc.getProcessorPrice() %></p>
        <p>Drive is <%= cc.getDrive() %> for $<%= cc.getDrivePrice() %> </p>
        <p>Total Price is $<%= cc.getTotalPrice() %> </p>
    </body>
</html>
