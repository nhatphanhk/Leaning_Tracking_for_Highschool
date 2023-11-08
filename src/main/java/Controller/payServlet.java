/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nhatp
 */
@WebServlet(name = "payServlet", urlPatterns = {"/payServlet"})
public class payServlet extends HttpServlet {

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
            out.println("<title>Servlet payServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet payServlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {
        
        Config VNPayConfig = new Config();
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String uniqueTxnId = UUID.randomUUID().toString();
        String clientIp = request.getRemoteAddr();
        String vnp_IpAddr = "127.0.0.1";
        String vnp_TmnCode = "9UT9KZEQ";
        String orderType = "order-type";
        String hocPhiAmount = request.getParameter("hoc-phi-amount");
        String khoanPhiAmount = request.getParameter("khoan-phi-amount");
        String totalAmount = request.getParameter("totalAmount");

         
        
//            if (hocPhiAmount != null) {
//                    hocPhiAmount = hocPhiAmount.trim();
//                }
//
//                if (khoanPhiAmount != null) {
//                    khoanPhiAmount = khoanPhiAmount.trim();
//                }
//
//                // Perform the rest of your processing with trimmed values
//                int totalAmount = 0;
//                if (hocPhiAmount != null && !hocPhiAmount.isEmpty()) {
//                    totalAmount += Double.parseDouble(hocPhiAmount);
//                }
//
//                if (khoanPhiAmount != null && !khoanPhiAmount.isEmpty()) {
//                    totalAmount += Double.parseDouble(khoanPhiAmount);
//                }
                

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf((int) Double.parseDouble(totalAmount)*100));
        vnp_Params.put("vnp_CurrCode", "VND");
        vnp_Params.put("vnp_TxnRef", uniqueTxnId); 
        vnp_Params.put("vnp_OrderInfo", "info cua orther");
        vnp_Params.put("vnp_OrderType", orderType);

//        vnp_Params.put("vnp_PaymentMethod", paymentMethod);
//        vnp_Params.put("vnp_Address", address);

        String locate = "vn";
        vnp_Params.put("vnp_Locale", locate);

        String urlReturn = "http:/localhost:8080/learning-tracking/vnpay_return.jsp";
        
        vnp_Params.put("vnp_ReturnUrl", urlReturn);
        
        vnp_Params.put("vnp_IpAddr", clientIp);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                try {
                    hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    //Build query
                    query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                    query.append('=');
                    query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = VNPayConfig.hmacSHA512(VNPayConfig.secretKey    , hashData.toString());
        vnp_Params.put("vnp_SecureHash", vnp_SecureHash);

        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = VNPayConfig.vnp_PayUrl + "?" + queryUrl;
        response.sendRedirect(paymentUrl);
        
        System.out.println(paymentUrl);
    }

    @Override
    protected void doPost(HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  
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
