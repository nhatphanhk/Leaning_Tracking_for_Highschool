/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Dao;
import Model.Application;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author tramy
 */
@WebServlet("/DownloadFileServlet")
public class DownloadFileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int appId = Integer.parseInt(request.getParameter("appId"));

        // Sử dụng Dao để lấy thông tin ứng dụng dựa trên appId
        Dao notiDAO = new Dao();
        Application selectedApplication = notiDAO.getApplicationById(appId);

        if (selectedApplication != null) {
            // Thiết lập các thông tin liên quan đến tải xuống trên phản hồi
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + selectedApplication.getTitle());

            // Sao chép dữ liệu từ dữ liệu byte vào phản hồi
            try (InputStream is = new ByteArrayInputStream(selectedApplication.getFileContent())) {
                OutputStream os = response.getOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
        } else {
            // Xử lý trường hợp không tìm thấy ứng dụng
            response.setContentType("text/plain");
            response.getWriter().write("Không tìm thấy ứng dụng.");
        }
    }
}
