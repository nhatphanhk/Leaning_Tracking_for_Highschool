/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class AddAccountController extends HttpServlet {

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
            out.println("<title>Servlet AddAccountController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddAccountController at " + request.getContextPath() + "</h1>");
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
        Dao dao = Dao.getInstance();
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String newpass = request.getParameter("pass");
        String role_raw = request.getParameter("role");

        try {
            int role = Integer.parseInt(role_raw);
            if (newpass.length() < 6 || newpass.length() > 32 || !containsLetterAndNumber(newpass)) {
            request.setAttribute("msge", "Mật khẩu mới phải có từ 6-32 ký tự và phải chứa cả chữ và số");
            request.getRequestDispatcher("accountManagementAddAcc.jsp").forward(request, response);
        } else if (isEmailExist(email)) {
            request.setAttribute("msg", "Tài khoản email đã tồn tại trong hệ thống");
            request.getRequestDispatcher("accountManagementAddAcc.jsp").forward(request, response);
        } else {
            dao.addAccount(email, newpass, role);
            request.setAttribute("msgs", "Thêm tài khoản thành công");
            request.getRequestDispatcher("accountManagementAddAcc.jsp").forward(request, response);
        }

        } catch (Exception e) {
        }
    }

    private boolean isEmailExist(String email) {
        Dao dao = Dao.getInstance();
        if (dao.getAccountByEmail(email) != null) {
            return true;
        }
        return false;
    }

    private boolean containsLetterAndNumber(String str) {
        boolean hasLetter = false;
        boolean hasNumber = false;
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            }
            if (hasLetter && hasNumber) {
                return true;
            }
        }
        return false;
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
