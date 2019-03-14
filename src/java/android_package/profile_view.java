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
import org.json.simple.JSONObject;

/**
 *
 * @author User
 */
@WebServlet(name = "profile_view", urlPatterns = {"/profile_view"})
public class profile_view extends HttpServlet {

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
            out.println("<title>Servlet profile_view</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet profile_view at " + request.getContextPath() + "</h1>");
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
         try {
            String uid=request.getParameter("lid");
            dbquery db=new dbquery();
             ResultSet rs=db.pro1(uid);
             if(rs.next())
             {
                   json.put("status", "1");
                   json.put("name", rs.getString("name"));
                   json.put("gender", rs.getString("gender"));
                   json.put("dob", rs.getString("dob"));
                    json.put("place", rs.getString("place"));
                    json.put("post", rs.getString("post"));
                    json.put("pin", rs.getString("pin"));
                    json.put("district", rs.getString("district"));
                    json.put("email", rs.getString("email"));
                    json.put("phone", rs.getString("phone"));
             }
            else
             {
                 json.put("status", "0");
             }
        } catch (Exception e) {
            System.err.println(e.toString());
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
