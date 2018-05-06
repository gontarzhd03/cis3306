/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopcomputerbilling;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 55gontarhd03
 */
@WebServlet(name = "DesktopComputerBilling", urlPatterns = {"/DesktopComputerBilling"})
public class DesktopComputerBilling extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

            TreeMap<String, Integer> parts = new TreeMap<String, Integer> ();
            ComputerComponents cc = new ComputerComponents();
            parts.put("I3", 75);
            parts.put("I5", 100);
            parts.put("I7", 200);
            parts.put("HD1", 40);
            parts.put("HD2", 90);
            parts.put("HD3", 190);
            String processor = request.getParameter("Processor");
            String drive = request.getParameter("Drive");
            cc.setProcessor(processor);
            cc.setDrive(drive);
            cc.setProcessorPrice(parts.get(processor));
            cc.setDrivePrice(parts.get(drive));
            cc.setTotalPrice(parts.get(processor) + parts.get(drive));

            request.setAttribute("aComputerComponents", cc);
            String url = "/ComputerOrder.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
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
