<%-- 
    Document   : StudentScheduleResult
    Created on : Apr 6, 2018, 9:46:50 AM
    Author     : 55gontarhd03
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="registrationdatabaseoperations.StudentScheduleEntries"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Schedule</title>
    </head>
    <body>
        <h1>Student Schedule</h1>
        <% StudentScheduleEntries studentScheduleEntries = (StudentScheduleEntries)request.getAttribute("aStudentSchedule"); %>
        
        <p>Student ID is <%= studentScheduleEntries.get(0).getStudentId() %> </p>
        <p>Student First Name is <%= studentScheduleEntries.get(0).getStudentFirstName() %> </p>
        <p>Student Last Name is <%= studentScheduleEntries.get(0).getStudentLastName() %> </p>
        
        <p>Courses are</p>
        <p><%= studentScheduleEntries.get(0).getCourseName() %> </p>
        
        <% for(int i = 1; i < studentScheduleEntries.size(); i++) { %>
           <p><%= studentScheduleEntries.get(i).getCourseName() %> </p>
        <% } %>
    </body>
</html>
