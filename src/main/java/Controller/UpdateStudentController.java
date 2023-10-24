/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.Dao;
import Model.Student;
import Model.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

/**
 *
 * @author Admin
 */
public class UpdateStudentController extends HttpServlet {
   
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
            out.println("<title>Servlet UpdateStudentController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateStudentController at " + request.getContextPath () + "</h1>");
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
        String email = request.getParameter("email");
        Dao dao = Dao.getInstance();
        if(email.startsWith("stu")){
        Student st = dao.getAStudentByEmail(email);
        request.setAttribute("st", st);
        request.getRequestDispatcher("academicAffairFixStudentList.jsp").forward(request, response);
        }
        if(email.startsWith("tea")){
        Teacher tc = dao.getATeacherByEmail(email);
        request.setAttribute("tc", tc);
        request.getRequestDispatcher("academicAffairFixTeacherList.jsp").forward(request, response);
        }
        
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
        
        String id = request.getParameter("id");
        String lastname = request.getParameter("lastname");
        String firstname = request.getParameter("firstname");
        String phone = request.getParameter("phone");
        String gender_raw = request.getParameter("gender");
        String dob_raw =  request.getParameter("dob");
        String address = request.getParameter("address");
        String classid = request.getParameter("classid");
        boolean gender ;
            if(gender_raw.equals("Nam")){
                gender = true;
            }else{
                gender =false;
            }
        try {
            
            SimpleDateFormat sfm =  new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date dob = null;
            java.util.Date dobjava = sfm.parse(dob_raw);
            dob = new java.sql.Date(dobjava.getTime());
            if(id.startsWith("ST")){
                dao.updateStudent(id, firstname, lastname, phone, address, dob, gender);
                //request.getRequestDispatcher("StudentListByClassController?classid="+classid).forward(request, response);
                response.sendRedirect("StudentListByClassController?classid="+classid);
            }
            if(id.startsWith("TC")){
                dao.updateTeacher(id, firstname, lastname, phone, address, dob, gender);
                //request.getRequestDispatcher("StudentListByClassController?classid="+classid).forward(request, response);
                response.sendRedirect("teacherlistcontroller");
            }
            
        } catch (Exception e) {
            
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
