package Controller;

import DAO.Dao;
import Model.Notification;
import Model.Timetable;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tramy
 */
public class ViewTimetableStudent extends HttpServlet {

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
            out.println("<title>Servlet ViewTimetableStudent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewTimetableStudent at " + request.getContextPath() + "</h1>");
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
        Dao dao = new Dao();
        String classid = request.getParameter("classid");
        List<Timetable>[] timetable = new List[10];
        for (int i = 0; i < 10; i++) {
            timetable[i] = dao.selectTimetableStudent("Slot " + (i + 1), classid);
            List<Timetable> newList = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                newList.add(new Timetable());
            }
            for (Timetable time : timetable[i]) {
                if (time.getDay().equals("T2")) {
                    newList.set(0, time);
                }
                if (time.getDay().equals("T3")) {
                    newList.set(1, time);
                }
                if (time.getDay().equals("T4")) {
                    newList.set(2, time);
                }
                if (time.getDay().equals("T5")) {
                    newList.set(3, time);
                }
                if (time.getDay().equals("T6")) {
                    newList.set(4, time);
                }
            }
            timetable[i] = newList;
            request.setAttribute("timetableStudent" + i, newList);
        }
        request.getRequestDispatcher("studentTimetable.jsp").forward(request, response);
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
