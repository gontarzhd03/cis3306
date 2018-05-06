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
            int idControlBtreak = studentScheduleEntries.get(0).getStudentId();
            String TitleArray[] = new String[4];
            TitleArray[0] = "Student ID";
            TitleArray[1] = "Student First Name";
            TitleArray[2] = "Student Last Name";
            TitleArray[3] = "Course Name";
        %>

        <table border = 2>
            <tr> <td> Student ID is <%= idControlBtreak %></td></tr>
            <tr> <td> Student First Name is <%= studentScheduleEntries.get(0).getStudentFirstName() %></td></tr>
            <tr> <td> Student Last Name is <%= studentScheduleEntries.get(0).getStudentLastName() %></td></tr>
            <tr> <td> <%= studentScheduleEntries.get(0).getCourseName() %></td></tr>
            <% for(int i = 1; i < studentScheduleEntries.size(); i++) {
               if(studentScheduleEntries.get(i).getStudentId() != idControlBtreak) {
                   idControlBtreak = studentScheduleEntries.get(i).getStudentId();
            %>
        </table>
        <p></p>
        <table border = 2>
            <tr> <td> Student ID is <%= idControlBtreak %></td></tr>
            <tr> <td> Student First Name is <%= studentScheduleEntries.get(i).getStudentFirstName() %></td></tr>
            <tr> <td> Student Last Name is <%= studentScheduleEntries.get(i).getStudentLastName() %></td></tr>
            <% } %>
            <tr> <td> <%= studentScheduleEntries.get(i).getCourseName() %></td></tr>
            <% } %>
        </table>
        <p></p>
    </body>
</html>
