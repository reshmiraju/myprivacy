/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android_package;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "user_registration", urlPatterns = {"/user_registration"})
public class user_registration extends HttpServlet {

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
            out.println("<title>Servlet user_registration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet user_registration at " + request.getContextPath() + "</h1>");
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
            
            String name=request.getParameter("name");
            String gender=request.getParameter("gender");
            String dob=request.getParameter("dob");
            String plc=request.getParameter("place");
            String pst=request.getParameter("post");
            String pin=request.getParameter("pin");
            String dstct=request.getParameter("district");
            String email=request.getParameter("email");
            String phone=request.getParameter("phone");
            String pic=request.getParameter("image");
            String password=request.getParameter("password");
             dbquery db=new dbquery();
            int i=db.add2(name,gender,dob,plc,pst,pin,dstct,email,phone,pic,password);
            if(i>0)
            {
                json.put("status", "1");
                
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
