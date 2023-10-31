/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Dao;
import Model.Mark;
import Model.Class;
import Model.Student;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author flywt
 */
public class LockMark extends HttpServlet {

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

        Dao dao = Dao.getInstance();
        List<Class> classes = dao.getAllClass();
        List<Student> students = dao.getAllStudent();
        int count10 = 0, count11 = 0, count12 = 0;
        for (Class c : classes) {
            if (c.getClassname().startsWith("10")) {
                count10 += 1;
            }
            if (c.getClassname().startsWith("11")) {
                count11 += 1;
            }
            if (c.getClassname().startsWith("12")) {
                count12 += 1;
            }
        }

        int student10 = 0, student11 = 0, student12 = 0;
        for (Student st : students) {
            if (st.getClassName().startsWith("10")) {
                student10 += 1;
            }
            if (st.getClassName().startsWith("11")) {
                student11 += 1;
            }
            if (st.getClassName().startsWith("12")) {
                student12 += 1;
            }
        }

        int countWeak10 = 0, countAver10 = 0, countNorm10 = 0, countGreat10 = 0;
        int countWeak11 = 0, countAver11 = 0, countNorm11 = 0, countGreat11 = 0;
        int countWeak12 = 0, countAver12 = 0, countNorm12 = 0, countGreat12 = 0;
        Map<String, List<Mark>> mapClassAndMark = new HashMap<>();
        for (Class c : classes) {
            List<Mark> marks = dao.getListMarkByClasses(c.getClassid());
            mapClassAndMark.put(c.getClassname().replaceAll("\\s+", ""), marks);
            if (c.getClassname().startsWith("10")) {
                for (Mark m : marks) {
                    if ((m.getTotal_mark().compareTo(new BigDecimal("3"))) < 0) {
                        countWeak10 += 1;
                    }
                    if ((m.getTotal_mark().compareTo(new BigDecimal("3"))) >= 0 && (m.getTotal_mark().compareTo(new BigDecimal("5"))) < 0) {
                        countAver10 += 1;
                    }
                    if ((m.getTotal_mark().compareTo(new BigDecimal("5"))) >= 0 && (m.getTotal_mark().compareTo(new BigDecimal("8"))) < 0) {
                        countNorm10 += 1;
                    }
                    if ((m.getTotal_mark().compareTo(new BigDecimal("8"))) >= 0 && (m.getTotal_mark().compareTo(new BigDecimal("10"))) <= 0) {
                        countGreat10 += 1;
                    }
                }
            }
            if (c.getClassname().startsWith("11")) {
                for (Mark m : marks) {
                    if ((m.getTotal_mark().compareTo(new BigDecimal("3"))) < 0) {
                        countWeak11 += 1;
                    }
                    if ((m.getTotal_mark().compareTo(new BigDecimal("3"))) >= 0 && (m.getTotal_mark().compareTo(new BigDecimal("5"))) < 0) {
                        countAver11 += 1;
                    }
                    if ((m.getTotal_mark().compareTo(new BigDecimal("5"))) >= 0 && (m.getTotal_mark().compareTo(new BigDecimal("8"))) < 0) {
                        countNorm11 += 1;
                    }
                    if ((m.getTotal_mark().compareTo(new BigDecimal("8"))) >= 0 && (m.getTotal_mark().compareTo(new BigDecimal("10"))) <= 0) {
                        countGreat11 += 1;
                    }
                }
            }
            if (c.getClassname().startsWith("12")) {
                for (Mark m : marks) {
                    if ((m.getTotal_mark().compareTo(new BigDecimal("3"))) < 0) {
                        countWeak12 += 1;
                    }
                    if ((m.getTotal_mark().compareTo(new BigDecimal("3"))) >= 0 && (m.getTotal_mark().compareTo(new BigDecimal("5"))) < 0) {
                        countAver12 += 1;
                    }
                    if ((m.getTotal_mark().compareTo(new BigDecimal("5"))) >= 0 && (m.getTotal_mark().compareTo(new BigDecimal("8"))) < 0) {
                        countNorm12 += 1;
                    }
                    if ((m.getTotal_mark().compareTo(new BigDecimal("8"))) >= 0 && (m.getTotal_mark().compareTo(new BigDecimal("10"))) <= 0) {
                        countGreat12 += 1;
                    }
                }
            }

        }
        request.setAttribute("classes", classes);
        request.setAttribute("students", students);
        request.setAttribute("mapClassAndMark", mapClassAndMark);
        request.setAttribute("count10", count10);
        request.setAttribute("count11", count11);
        request.setAttribute("count12", count12);
        request.setAttribute("student10", student10);
        request.setAttribute("student11", student11);
        request.setAttribute("student12", student12);
        request.setAttribute("countWeak12", countWeak12);
        request.setAttribute("countAver12", countAver12);
        request.setAttribute("countNorm12", countNorm12);
        request.setAttribute("countGreat12", countGreat12);
        request.setAttribute("countWeak10", countWeak10);
        request.setAttribute("countAver10", countAver10);
        request.setAttribute("countNorm10", countNorm10);
        request.setAttribute("countGreat10", countGreat10);
        request.setAttribute("countWeak11", countWeak11);
        request.setAttribute("countAver11", countAver11);
        request.setAttribute("countNorm11", countNorm11);
        request.setAttribute("countGreat11", countGreat11);
        request.getRequestDispatcher("academicAffairLockMarkReport.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        Object lockedMarkObj = session.getAttribute("isLockedMark");
        
        if(lockedMarkObj == null){
            boolean isLockedMark = true;
            int oneMonth = 30 * 24 * 60 * 60; 
            session.setMaxInactiveInterval(oneMonth);
            session.setAttribute("isLockedMark", isLockedMark);
        }else {
            session.removeAttribute("isLockedMark");
        }
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
