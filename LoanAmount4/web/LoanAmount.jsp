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
            String TitleArray[] = new String[5];
            TitleArray[0] = "Payment Number";
            TitleArray[1] = "Payment Amount";
            TitleArray[2] = "Interest";
            TitleArray[3] = "Principal Part";
            TitleArray[4] = "Balance";
            double P  = Double.parseDouble(request.getParameter("P"));
            double R  = Double.parseDouble(request.getParameter("R"));
            double T  = Double.parseDouble(request.getParameter("T"));
            double N  = Double.parseDouble(request.getParameter("N"));
            double A = P * R / (N * (1 - Math.pow(1 + R / N, -1 * N * T)));
            double B = P;
        %>
        <table>
            <tr>
                <td>Interest Rate</td>
                <td><input type="text" name="R" value="<%= R %>"></td>
                <td>Amount of Time</td>
                <td><input type="text" name="T" value="<%= T %>"></td>
            </tr>
            <tr>
                <td>Number of Compoundings</td>
                <td><input type="text" name="N" value="<%= N %>"></td>
                <td>Principal</td>
                <td><input type="text" name="P" value="<%= P %>"></td>
            </tr>
            <tr>
                <td>Payment Amount</td>
                <td><input type="text" name="A" value="<%= A %>"></td>
            </tr>
        </table>
        <br>
        <table border = 2>
            <% for(int j = 0; j < 5; j++) { %>
                <th> <%= TitleArray[j] %> </th>
            <% } %>
            <% for(int i = 1; i <= N * T; i++) { 
                double I = B * R / N;
                double PrincipalPart = A - I;
                B = B - PrincipalPart;
            %>
                <tr> 
                    <td><%= i %></td>
                    <td><%= A %></td>
                    <td><%= I %></td>
                    <td><%= PrincipalPart %></td>
                    <td><%= B %></td>
                </tr>
            <% } %>
        </table>
    </body>
</html>
