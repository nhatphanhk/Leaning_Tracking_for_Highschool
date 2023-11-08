/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Dao;
import Model.PayFee;
import Model.payment_category;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static jdk.vm.ci.meta.JavaKind.Int;

/**
 *
 * @author nhatp
 */
@WebServlet(name = "AddFeeController", urlPatterns = {"/AddFeeController"})
public class AddFeeController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddFeeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddFeeController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("accountantCreate.jsp").forward(request, response);

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
//    try {
//        // Retrieve data from the form
//        int categoryid = Integer.parseInt(request.getParameter("categoryid"));
//        String payment_category =request.getParameter("payment_category");
//        String amount = request.getParameter("amount");
//
//        // Create a PayFee object with the retrieved data
//        payment_category newFee = new payment_category(categoryid,payment_category,amount);
//
//        // Call the addPayFee method to insert the data into the database
//        Dao dao = new Dao();
//        dao.addPayFee(newFee);
//        request.getRequestDispatcher("accountantViewFee.jsp").forward(request, response);
//
//        // You can redirect to a success page or display a success message here
//    } catch (Exception e) {
//        // Handle exceptions, log errors, or redirect to an error page
//        e.printStackTrace();
//        response.sendRedirect("error.jsp");
//    }
        request.getRequestDispatcher("accountantViewFee.jsp").forward(request, response);
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
