/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import registrationdatabaseoperations.*;

/**
 *
 * @author 55gontarhd03
 */
public class ScheduleObjectGenerator extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String dbProtocol = "jdbc:derby://localhost:1527/";
        String dbDirectory = "/home/hgontarz/NetBeansProjects/cis3306/ProjectRegistrationDerby/data/RegistrationNetworkDerbyDatabase/";
        String dbName = "Registration";
        String dbExtra = "";
        String userName = "Admin";
        String passWord = "MuCis";
        Student student;
        Course course;
        
        RegistrationDatabaseOperations.setConnection(dbProtocol, dbDirectory, dbName, dbExtra, userName, passWord);
        int StudentId = Integer.parseInt(request.getParameter("StudentId"));
        String StudentFirstName = request.getParameter("StudentFirstName");
        String StudentLastName = request.getParameter("StudentLastName");
        String HumanitiesCourse = request.getParameter("Humanities");
        String [] ComputerScienceCourses = request.getParameterValues("Computer Science");
        String MathematicsCourse = request.getParameter("Mathematics");

        student = new Student();
        student.setStudentID(StudentId);
        student.setStudentFirstName(StudentFirstName);
        student.setStudentLastName(StudentLastName);
/*
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.toString());
        }
*/
        RegistrationDatabaseOperations.insertStudent(student);
        StudentScheduleEntries studentScheduleEntries = new StudentScheduleEntries();
        course = new Course();
        course.setStudentID(StudentId);
        course.setCourseName(HumanitiesCourse);
        RegistrationDatabaseOperations.insertCourse(course);
        
        for(int i = 0; i < ComputerScienceCourses.length; i++) {
            course.setCourseName(ComputerScienceCourses[i]);
            RegistrationDatabaseOperations.insertCourse(course);
        }
        course.setCourseName(MathematicsCourse);
        RegistrationDatabaseOperations.insertCourse(course);
        
        studentScheduleEntries = RegistrationDatabaseOperations.retrieveStudentSchedule(StudentId);

        request.setAttribute("aStudentSchedule", studentScheduleEntries);
        String url = "/StudentScheduleResult.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
