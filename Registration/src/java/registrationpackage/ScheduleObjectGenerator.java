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
        int StudentId = Integer.parseInt(request.getParameter("StudentId"));
        String StudentFirstName = request.getParameter("StudentFirstName");
        String StudentLastName = request.getParameter("StudentLastName");
        String HumanitiesCourse = request.getParameter("Humanities");
        String [] ComputerScienceCourses = request.getParameterValues("Computer Science");
        String MathematicsCourse = request.getParameter("Mathematics");
        StudentScheduleEntry studentScheduleEntryNext;
        StudentScheduleEntries studentScheduleEntries = new StudentScheduleEntries();
        
        studentScheduleEntryNext = new StudentScheduleEntry();
        studentScheduleEntryNext.setStudentId(StudentId);
        studentScheduleEntryNext.setStudentFirstName(StudentFirstName);
        studentScheduleEntryNext.setStudentLastName(StudentLastName);
        studentScheduleEntryNext.setCourseName(HumanitiesCourse);
        studentScheduleEntries.add(studentScheduleEntryNext);
        
        for(int i = 0; i < ComputerScienceCourses.length; i++) {
            studentScheduleEntryNext = new StudentScheduleEntry();
            studentScheduleEntryNext.setStudentId(StudentId);
            studentScheduleEntryNext.setStudentFirstName(StudentFirstName);
            studentScheduleEntryNext.setStudentLastName(StudentLastName);
            studentScheduleEntryNext.setCourseName(ComputerScienceCourses[i]);
            studentScheduleEntries.add(studentScheduleEntryNext);
        }
        studentScheduleEntryNext = new StudentScheduleEntry();
        studentScheduleEntryNext.setStudentId(StudentId);
        studentScheduleEntryNext.setStudentFirstName(StudentFirstName);
        studentScheduleEntryNext.setStudentLastName(StudentLastName);
        studentScheduleEntryNext.setCourseName(MathematicsCourse);
        studentScheduleEntries.add(studentScheduleEntryNext);
        
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
