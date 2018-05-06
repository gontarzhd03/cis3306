<%-- 
    Document   : LoanAmount
    Created on : Mar 21, 2018, 10:03:03 AM
    Author     : 55gontarhd03
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loan Amount</title>
    </head>
    <body>
        <%
            double P  = Double.parseDouble(request.getParameter("P"));
            double R  = Double.parseDouble(request.getParameter("R"));
            double T  = Double.parseDouble(request.getParameter("T"));
            double N  = Double.parseDouble(request.getParameter("N"));
            double A = P * R / (N * (1 - Math.pow(1 + R / N, -1 * N * T)));
        %>
        <p> P = <%= P %> </p>
        <p> R = <%= R %> </p>
        <p> T = <%= T %> </p>
        <p> N = <%= N %> </p>
        <p> A = <%= A %> </p>
    </body>
</html>
