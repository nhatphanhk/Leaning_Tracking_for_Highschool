/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.Dao;
import Model.Mark;
import Model.Semester;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ViewMarkController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet ViewMarkController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewMarkController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        String studentid = request.getParameter("studentid");
      Dao dao = Dao.getInstance();
//        List<Mark> list = dao.getListMarkOfAStudent(studentid);
//            
//        request.setAttribute("studentmarks", list);

        List<Semester> lists = dao.getAllSemester();
       
        request.setAttribute("semester", lists);
        request.getRequestDispatcher("studentMarkReport.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Dao dao = Dao.getInstance();
        String semesterid = request.getParameter("semester");
        String identify_raw = request.getParameter("identify");
        try {
            int identify = Integer.parseInt(identify_raw);
            List<Mark> list = dao.getListMarkOfAStudentV2(semesterid, identify);
            List<Semester> lists = dao.getAllSemester();
            
            request.setAttribute("sid", semesterid);
            request.setAttribute("semester", lists);
            request.setAttribute("studentmarks", list);
            request.getRequestDispatcher("studentMarkReport.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("login.jsp");
        }
        
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
