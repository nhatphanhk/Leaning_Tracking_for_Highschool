/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Dao;
import Model.Account;
import Model.Application;
import Model.Notification;
import Model.Staff;
import Model.Student;
import Model.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {

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
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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
        String email = request.getParameter("email");
        if (email.startsWith("student")) {
            Dao dao = Dao.getInstance();
            Student student = dao.getAStudentByEmail(email);
            request.setAttribute("student", student);

            response.sendRedirect("studentHomePage.jsp");
        }
        if (email.startsWith("teacher")) {
            response.sendRedirect("teacherHomePage.jsp");
        }
        if (email.startsWith("academicaffair")) {
            response.sendRedirect("academicAffairProfile.jsp");
        }
        if (email.startsWith("accountmanager")) {
            response.sendRedirect("accountManagementProfile.jsp");
        }
        if (email.startsWith("accountant")) {
            response.sendRedirect("accountantProfile.jsp");
        }
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
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Dao dao = Dao.getInstance();
        Account acc = dao.login(email, password);
        List<Notification> noti = dao.selectAllNotiSchool("1");
        Staff stf = dao.getAStaffByEmail(email);

        //  Phân QUyền sau 
        if (acc == null) {

            request.setAttribute("msg", "Tên đăng nhập hoặc mật khẩu sai");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            int role = acc.getRoleid();

            switch (role) {

                case 1:
                    session.setAttribute("account", acc);
                    Student st = dao.getAStudentByEmail(email);
                    String classIdAsString = String.valueOf(st.getClassid());
                    List<Notification> notis = dao.selectAllNotiTeacher("2", classIdAsString);
                    
                    session.setAttribute("notifications", notis);
                    session.setAttribute("notification", noti);
                    String studentid = st.getStudentid();
                    session.setAttribute("studentid", studentid);

                    session.setAttribute("student", st);
                    response.sendRedirect("studentHomePage.jsp");
                    break;
                case 2:
                    session.setAttribute("account", acc);
                    session.setAttribute("notification", noti);
                    Teacher tc = dao.getATeacherByEmail(email);
                    session.setAttribute("teacher", tc);
                    String teacherid = tc.getTeacherid();
                    session.setAttribute("teacherid", teacherid);

                    request.getRequestDispatcher("teacherHomePage.jsp").forward(request, response);
                    break;
                case 3:
                    session.setAttribute("account", acc);
                    session.setAttribute("accountManager", stf);
                    String staffid = stf.getStaffid();
                    session.setAttribute("staffid", staffid);
                    request.getRequestDispatcher("accountManagementProfile.jsp").forward(request, response);
                case 4:
                    session.setAttribute("account", acc);
                    session.setAttribute("accountant", stf);
                    request.getRequestDispatcher("accountantProfile.jsp").forward(request, response);
                case 5:
                    session.setAttribute("account", acc);

                    session.setAttribute("academicAffair", stf);
                    request.getRequestDispatcher("academicAffairProfile.jsp").forward(request, response);

            }

        }
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