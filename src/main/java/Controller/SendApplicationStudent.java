package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

/**
 *
 * @author tramy
 */
public class SendApplicationStudent extends HttpServlet {

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
        try {
            //fetch the file name from the url
            String name = request.getParameter("value");
            //get the directory of the file.
            String path = "/Users/tramy/Documents/Learning Uni/Semester 5/SWP391/" + name;

            File file = new File(path);

            if (!file.exists()) {
                throw new FileNotFoundException("File does not exist: " + path);
            }

            if (!file.canRead()) {
                throw new IOException("No read access to file: " + path);
            }

            //set the content type
            response.setContentType("APPLICATION/OCTET-STREAM");
            //force to download dialog
            response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");

            FileInputStream ins = new FileInputStream(path);
            ServletOutputStream out = response.getOutputStream();

            byte[] buffer = new byte[4096];
            int i;
            while ((i = ins.read(buffer)) != -1) {
                out.write(buffer, 0, i);
            }
            ins.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
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
