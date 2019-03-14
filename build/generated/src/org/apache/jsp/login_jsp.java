package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import mypackage.dbquery;
import java.sql.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>Untitled Document</title>\r\n");
      out.write("</head>\r\n");
      out.write("    <body>\r\n");
      out.write("      \r\n");
      out.write("    <form id=\"form1\" name=\"form1\" method=\"post\" action=\"\">\r\n");
      out.write("    <div align=\"center\" class=\"\">\r\n");
      out.write("    <table width=\"400\" border=\"1\">      <tr>\r\n");
      out.write("        <td colspan=\"2\">    <div align=\"center\">LOGIN </div></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td><div align=\"center\">USERNAME</div></td>\r\n");
      out.write("        <td><label for=\"username\"></label>\r\n");
      out.write("       <input type=\"text\" name=\"username\" id=\"username\"/></td>\r\n");
      out.write("       \r\n");
      out.write("       \r\n");
      out.write("      </tr>   \r\n");
      out.write("      <tr>\r\n");
      out.write("          <td><div align=\"center\">PASSWORD</div></td>\r\n");
      out.write("        <td><label for=\"password\"></label>\r\n");
      out.write("        <input type=\"password\" name=\"password\" id=\"password\" /></td>\r\n");
      out.write("       \r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\"><div align=\"center\">\r\n");
      out.write("          <input type=\"submit\" name=\"login\" id=\"login\" value=\"LOGIN\" />\r\n");
      out.write("        </div></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("  </div>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");

      if(request.getParameter("login")!=null)
    {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        
        dbquery db=new dbquery();
        ResultSet rs=db.login(username, password);
        if(rs.next())
        {
            String lid=rs.getString("lid");
            String type=rs.getString("type");
            session.setAttribute("lid", lid);
             session.setAttribute("type", type);
             if(type.equalsIgnoreCase("admin"))
             {
                response.sendRedirect("admin home.jsp");
             }
             else if(type.equalsIgnoreCase("employee"))
             {
                 response.sendRedirect("employee home.jsp");
             }
            
        
        
       
            
        }
        else
        {
            
      out.write("\r\n");
      out.write("            <script>alert(\"invalid user\");</script>\r\n");
      out.write("            ");

        }
    }


      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
