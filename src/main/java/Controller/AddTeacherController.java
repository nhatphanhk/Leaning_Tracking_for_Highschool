/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.Dao;
import Model.Account;
import Model.Major;
import Model.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AddTeacherController extends HttpServlet {
   
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
            out.println("<title>Servlet AddTeacherController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddTeacherController at " + request.getContextPath () + "</h1>");
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
        HttpSession session = request.getSession();
        Dao dao = Dao.getInstance();
        List<Major> list = dao.getAllMajor();
        session.setAttribute("majorlist", list);
        request.getRequestDispatcher("academicAffairAddTeacherList.jsp").forward(request, response);
        
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
        String oldteacherid = dao.getLastTeacher().getTeacherid();
        String numPart = oldteacherid.substring(2); 
        int num = Integer.parseInt(numPart); 
        num++; 
        String newteacherid = "TC" + num;
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String majorid = request.getParameter("majorid");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String dob_raw = request.getParameter("dob");
        String gender_raw = request.getParameter("gender");
        boolean gender;
        if(gender_raw.equals("Nam")){
            gender = true;
        }else{
            gender = false;
        }
            if(checkAvailableEmail(email)){
                String ms = "Email này chưa được đăng kí trong hệ thống";
                request.setAttribute("msg", ms);
                request.getRequestDispatcher("academicAffairAddTeacherList.jsp").forward(request, response);
            }else{
        
            if(checkDuplicatedEmail(email)){
                String ms = "Email này đã được sử dụng cho giáo viên khác";
                request.setAttribute("ms", ms);
                request.getRequestDispatcher("academicAffairAddTeacherList.jsp").forward(request, response);
            
        }
            }
        try {
            SimpleDateFormat sfm =  new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date dob = null;
            java.util.Date dobjava = sfm.parse(dob_raw);
            dob = new java.sql.Date(dobjava.getTime());
            
            
            dao.addTeacher(newteacherid, firstname, lastname, email, phone, address, dob, majorid, gender);
            //response.sendRedirect("StudentListByClassController?classid="+classid_raw);
            response.sendRedirect("teacherlistcontroller");
        } catch (Exception e) {
            response.sendRedirect("login.jsp");
        }
    }
    private boolean checkAvailableEmail(String email){
        Dao dao = Dao.getInstance();
        List<Account> list = dao.getAll();
        for (Account acc : list) {
            if(acc.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }
     private boolean checkDuplicatedEmail(String email){
        Dao dao = Dao.getInstance();
        List<Teacher> list = dao.getAllTeacher();
        for (Teacher student : list) {
            if(student.getEmail().equals(email)){
                return true;
            }
        }
        return false;
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
