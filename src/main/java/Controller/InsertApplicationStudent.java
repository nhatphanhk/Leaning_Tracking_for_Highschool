package Controller;

import DAO.Dao;
import jakarta.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.time.LocalDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tramy
 */
@MultipartConfig
public class InsertApplicationStudent extends HttpServlet {

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
            out.println("<title>Servlet InsertApplicationStudent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertApplicationStudent at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("sendApplication.jsp").forward(request, response);
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
        try {
            Part filePart = request.getPart("attachmentFile"); // Retrieves <input type="file" name="attachmentFile">
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();

            // Define the path to the directory where you want to save the file
            String uploadPath = "/Users/tramy/Documents/Learning Uni/Semester 5/SWP391/Saved File/";

            // Create a new File object
            File file = new File(uploadPath + File.separator + fileName);

            // Use try-with-resources to ensure that resources are closed properly
            try ( FileOutputStream fos = new FileOutputStream(file)) {
                // Create a buffer
                byte[] buffer = new byte[1024];
                int bytesRead;

                // Read from the InputStream and write to the FileOutputStream
                while ((bytesRead = fileContent.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

            // insert application
            String title = request.getParameter("title");
            String categoryid = request.getParameter("categoryid");
            String teacherid = request.getParameter("teacherid");
            LocalDate currentDate = LocalDate.now();
            HttpSession session = request.getSession();
            String studentid = (String) session.getAttribute("studentid");

            Dao noti = Dao.getInstance();
            noti.insertApplicationStudent(title, categoryid, currentDate, studentid, teacherid);
        }   catch (SQLException ex) {
            Logger.getLogger(InsertApplicationStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("studentHomePage.jsp");
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
