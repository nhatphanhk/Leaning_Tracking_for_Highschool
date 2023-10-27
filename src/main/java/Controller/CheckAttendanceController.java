/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Dao;
import Model.AttendanceList;
import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author htk09
 */
public class CheckAttendanceController extends HttpServlet {

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
            out.println("<title>Servlet CheckAttendanceController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckAttendanceController at " + request.getContextPath() + "</h1>");
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

        HttpSession session = request.getSession();
        String classid = (String) session.getAttribute("classid");
        Dao dao = new Dao();
        List<Student> students = dao.selectAllStudent(classid);
        int i = 0;
        String semesterid = "FI23";
        LocalDate currentDate = LocalDate.now();
        List<AttendanceList> students2 = dao.getAttendanceStudentByDate(java.sql.Date.valueOf(currentDate),classid);
        if("[]".equals(students2.toString())){
            for (Student student : students) {
            String studentid = student.getStudentid();
            boolean sta = (request.getParameter("status" + i) != null);
            try {
                dao.insertAttendanceStatus(currentDate, sta, studentid, semesterid);
            } catch (SQLException ex) {
                Logger.getLogger(CheckAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
            String msg = "Add Successfully";
             request.setAttribute("msg", msg);
        }else{
            for (AttendanceList student : students2) {
                String studentid = student.getStudentid();
                Boolean sta = Boolean.valueOf(request.getParameter("status"+i));
                try {
                    dao.updateAttendanceStatus(currentDate, sta, studentid, semesterid, studentid);
                } catch (SQLException ex) {
                    Logger.getLogger(CheckAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
             String msg = "Update Successfully";
             request.setAttribute("msg", msg);
        }
        
        session.removeAttribute("classid");
        request.getRequestDispatcher("academicAffairCheckAttendance.jsp").forward(request, response);
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
