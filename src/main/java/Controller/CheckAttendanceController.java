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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
            for(Student student : students) {
            String studentid = student.getStudentid();
            String note = request.getParameter("note"+i);
            boolean sta = (request.getParameter("status" + i) == null);
            try {
                System.out.println(note);
                dao.insertAttendanceStatus(currentDate, sta, studentid, semesterid,note);
                if (sta == false){
                String studentEmail = student.getEmail();
                Boolean a = this.sendEmail(studentEmail,"Student "+ student.getLastName() + " " + student.getFirstName() +" absent "+ currentDate);
                System.out.println(a); 
                }
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
                String note = request.getParameter("note"+i);
                boolean sta = (request.getParameter("status" + i) == null);
                System.out.println("status"+i +":"+sta);
                try {
                    if (sta == false){
                    Student student_raw = dao.selectStudentById(studentid);
                    String studentEmail = student_raw.getEmail();
                    Boolean a = this.sendEmail(studentEmail,"Student "+ student.getLastName() + " " + student.getFirstName() +" absent "+ currentDate);
                    System.out.println(a); 
                    }
                    dao.updateAttendanceStatus(sta, studentid, note);
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
    
    
    public Boolean sendEmail(String to, String link){
        
        final String from ="htk09032003@gmail.com";
        final String password ="edyrpmmklyniuvyh";
    
        Properties props = new Properties();
        
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        
        
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password); 
            } 
        };
        
        Session session = Session.getInstance(props, auth);
        
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.addHeader("Content-Type", "text/HTML; charset=UTF-8");
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
            msg.setSubject("Attendance notification service -- do not reply this email");
            msg.setContent(link, "text/html");
            Transport.send(msg);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
