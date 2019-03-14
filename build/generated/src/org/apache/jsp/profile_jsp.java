package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import mypackage.dbquery;
import java.sql.*;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 
    String id=session.getAttribute("lid").toString();
    dbquery db=new dbquery();
    ResultSet rs=db.profile_view(id);
    if(rs.next())
    {
    
  
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<form id=\"form1\" name=\"form1\" method=\"post\" action=\"\">\r\n");
      out.write("  <div align=\"center\">\r\n");
      out.write("    <table width=\"200\" border=\"1\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\"><div align=\"center\">PROFILE</div></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>NAME</td>\r\n");
      out.write("        <td><label for=\"name\"> </label>\r\n");
      out.write("        <input type=\"text\" name=\"name\" id=\"name\" value= ");
      out.print(rs.getString(2) );
      out.write(" > </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>ADDRESS</td>\r\n");
      out.write("        <td><label for=\"address\"></label>\r\n");
      out.write("        <textarea name=\"address\" id=\"address\" cols=\"45\" rows=\"5\">");
      out.print(rs.getString(3)+"\n"+rs.getString(4)+"\n"+rs.getString(5)+"\n"+rs.getString(6) );
      out.write("</textarea></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("       <tr>\r\n");
      out.write("        <td>PHONE</td>\r\n");
      out.write("        <td><label for=\"name\"> </label>\r\n");
      out.write("        <input type=\"text\" name=\"phone\" id=\"phone\" value= ");
      out.print(rs.getString(7) );
      out.write(" > </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>GENDER</td>\r\n");
      out.write("        <td><input type=\"radio\" name=\"radio\" ");
 if(rs.getString(8).equalsIgnoreCase("male")){
      out.write(" checked ");
}
      out.write(" id=\"male\" value=\"male\" />\r\n");
      out.write("          <label for=\"male\">MALE<br />\r\n");
      out.write("            <input type=\"radio\" name=\"radio\" ");
 if(rs.getString(8).equalsIgnoreCase("female")){
      out.write(" checked ");
}
      out.write(" id=\"female\" value=\"female\"/>\r\n");
      out.write("        FEMALE</label></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>EMAIL</td>\r\n");
      out.write("        <td><label for=\"email\"></label>\r\n");
      out.write("        <input type=\"text\" name=\"email\" id=\"email\" value=\"");
      out.print(rs.getString(9) );
      out.write("\" /></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("       \r\n");
      out.write("    </table>\r\n");
      out.write("       ");
}
      out.write("  \r\n");
      out.write("  </div>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
