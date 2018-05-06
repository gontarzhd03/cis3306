/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanamount5;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 55gontarhd03
 */
//@WebServlet(urlPatterns = {"/LoanAmount"})
public class LoanAmount5 extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoanAmount5</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Loan Amount </h1>");

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
        
            out.println("<TABLE>");
            out.println("<TR>");
            out.println("<TD> Interest Rate </TD>");
            out.println("<TD> <input type='text' NAME = 'R' VALUE = " + R + " ></TD>");
            out.println("<TD> Amount of Time </TD>");
            out.println("<TD> <input type='text' NAME = 'T' VALUE =  " + T + " ></TD>");
            out.println("</TR>");
            out.println("<TR>");
            out.println("<TD> Number of Compoundings </TD>");
            out.println("<TD> <input type='text' NAME = 'N' VALUE = " + N + " ></TD>");
            out.println("<TD> Principal </TD>");
            out.println("<TD> <input type='text' NAME = 'P' VALUE = " + P + " ></TD>");
            out.println("</TR>");
            out.println("<TR>");
            out.println("<TD> Payment Amount </TD>");
            out.println("<TD> <input type='text' NAME = 'A' VALUE = " + A + " ></TD>");
            out.println("</TR>");
            out.println("</TABLE>");
                    
            out.println("<TABLE BORDER = 2>");
            for (int j = 0; j < 5; j++) {
		out.println("<TH> " +  TitleArray[j] + " </TH>");
            }
            for (int i = 1; i <= N * T; i++) {
                double I = B * R / N;
                double PrincipalPart = A - I;
                B = B - PrincipalPart;

                out.println("<TR>");
                out.println("<TD> " + i + "</TD>");
                out.println("<TD>" + A + "</TD>");
                out.println("<TD>" + I + "</TD>");        
                out.println("<TD>" + PrincipalPart + "</TD>");
                out.println("<TD>" + B + "</TD>");
                out.println("</TR>");
            }
            out.println("</TABLE>");
      
            out.println("</body>");
            out.println("</html>");
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
