package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import mypackage.dbquery;
import java.sql.*;

public final class block_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<form id=\"form1\" name=\"form1\" method=\"post\" action=\"\">\r\n");
      out.write("\r\n");
      out.write("  <div align=\"center\">\r\n");
      out.write("    <table width=\"553\" border=\"1\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"46\" height=\"63\">SLNO</td>\r\n");
      out.write("        <td width=\"50\">NAME</td>\r\n");
      out.write("        <td width=\"64\">EMAIL</td>\r\n");
      out.write("        <td width=\"123\">RE_AGAINST</td>\r\n");
      out.write("        <td width=\"107\">REPORT</td>\r\n");
      out.write("        <td width=\"123\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("         ");

      dbquery db=new dbquery();
      int i=1;
      ResultSet res=db.block();
      while(res.next())
      {
          
      
      
      out.write("\r\n");
      out.write("      <tr>\r\n");
      out.write("          <td height=\"100\">");
      out.print(i);
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print(res.getString(2));
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print(res.getString(9));
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print(res.getString(14));
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print(res.getString(28));
      out.write("</td>\r\n");
      out.write("        <td><p><a href=\"userblock.jsp?re_id=");
      out.print(res.getString(25));
      out.write("\">BLOCK</a></p>\r\n");
      out.write("        <p align=\"left\"><a href=\"userunblock.jsp?re_id=");
      out.print(res.getString(25));
      out.write("\">UNBLOCK</a></p></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("       ");

      i++;
      }
         
      out.write(" \r\n");
      out.write("  </table>\r\n");
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
