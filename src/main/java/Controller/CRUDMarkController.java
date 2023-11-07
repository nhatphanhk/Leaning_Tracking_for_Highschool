/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.Dao;
import Model.Class;
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
public class CRUDMarkController extends HttpServlet {
   
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
            out.println("<title>Servlet CRUDMarkController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CRUDMarkController at " + request.getContextPath () + "</h1>");
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
        String teacherid = request.getParameter("teacherid");
        //String classid = request.getParameter("classid");
        
        //request.setAttribute("classid", classid);
        Dao dao = Dao.getInstance();
        List<Class> list = dao.getClassByTeacherID(teacherid);
        List<Semester> list1 = dao.getAllSemester();
        request.setAttribute("classes", list);
        request.setAttribute("semester", list1);
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
        String teacherid = request.getParameter("teacherid");
        String classid_raw = request.getParameter("classid");
       String semesterid = request.getParameter("semesterid");
        //String teacherid = request.getParameter("teacherid");
        //String classid = request.getParameter("classid");
        
        //request.setAttribute("classid", classid);
        List<Class> list = dao.getClassByTeacherID(teacherid);
        request.setAttribute("classes", list);
        int classid = Integer.parseInt(classid_raw);
        //request.setAttribute("classid", classid);
        //Dao dao = Dao.getInstance();
       List<Mark> list1 = dao.getListMarkBySemester("MAT", semesterid);
        //List<Class> listc = dao.getClassByTeacherID(teacherid);
        List<Semester> lists = dao.getAllSemester();
        //request.setAttribute("classes", listc);
        request.setAttribute("semester", lists);
        
        request.setAttribute("marklist", list1);
        request.getRequestDispatcher("teacherMarkReport.jsp").forward(request, response);
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
