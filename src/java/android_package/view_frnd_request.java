/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypackage.dbquery;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author User
 */
@WebServlet(name = "view_frnd_request", urlPatterns = {"/view_frnd_request"})
public class view_frnd_request extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet view_frnd_request</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet view_frnd_request at " + request.getContextPath() + "</h1>");
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
        
        JSONObject json=new JSONObject();
            JSONArray ja=new JSONArray();
            try {
            String lid=request.getParameter("lid");
                dbquery db=new dbquery();
                ResultSet rs=db.frnd_request_view(lid);
                if(rs.next())
                {
                    json.put("status", "1");
                    do
                    {
                        JSONObject jo=new JSONObject();
                        
                        jo.put("name", rs.getString("name"));
                        jo.put("ulid", rs.getString("lid"));
                        jo.put("gndr", rs.getString("gender"));
                        jo.put("mail", rs.getString("email"));
                        jo.put("phn", rs.getString("phone"));
                        
                        ja.add(jo);
                        
                    }while(rs.next());
                    json.put("result",ja);
                }
                else
                {
                    json.put("status", "0");
                }
        } catch (Exception e) {
            
    }
              response.getWriter().write(json.toString());
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
