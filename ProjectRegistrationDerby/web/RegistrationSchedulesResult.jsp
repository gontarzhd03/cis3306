<%-- 
    Document   : RegistrationSchedulesResult
    Created on : Apr 12, 2018, 10:40:45 AM
    Author     : hgontarz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="registrationdatabaseoperations.StudentScheduleEntries"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Schedules List</title>
    </head>
    <body>
        <h1>Student Schedules List</h1>
        <%
            StudentScheduleEntries studentScheduleEntries = (StudentScheduleEntries)request.getAttribute("allStudentSchedules");
            String TitleArray[] = new String[4];
            TitleArray[0] = "Student ID";
            TitleArray[1] = "Student First Name";
            TitleArray[2] = "Student Last Name";
            TitleArray[3] = "Course Name";
        %>

        <table border = 2>
            <% for(int j = 0; j < TitleArray.length; j++) { %>
                <th> <%= TitleArray[j] %> </th>
            <% } %>
            <% for(int i = 0; i < studentScheduleEntries.size(); i++) { %>
                <tr> 
                    <td><%= studentScheduleEntries.get(i).getStudentId() %></td>
                    <td><%= studentScheduleEntries.get(i).getStudentFirstName() %></td>
                    <td><%= studentScheduleEntries.get(i).getStudentLastName() %></td>
                    <td><%= studentScheduleEntries.get(i).getCourseName() %></td>
                </tr>
            <% } %>
        </table>
    </body>
</html>
