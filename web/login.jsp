<%@page import="mypackage.dbquery"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>
    <body>
      
    <form id="form1" name="form1" method="post" action="">
    <div align="center" class="">
    <table width="400" border="1">      <tr>
        <td colspan="2">    <div align="center">LOGIN </div></td>
      </tr>
      <tr>
        <td><div align="center">USERNAME</div></td>
        <td><label for="username"></label>
       <input type="text" name="username" id="username"/></td>
       
       
      </tr>   
      <tr>
          <td><div align="center">PASSWORD</div></td>
        <td><label for="password"></label>
        <input type="password" name="password" id="password" /></td>
       
      </tr>
      <tr>
        <td colspan="2"><div align="center">
          <input type="submit" name="login" id="login" value="LOGIN" />
        </div></td>
      </tr>
    </table>
  </div>
</form>
</body>
</html>
<%
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
            %>
            <script>alert("invalid user");</script>
            <%
        }
    }

%>












