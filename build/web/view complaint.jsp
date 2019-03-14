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
  <div align="center">
    <table width="275" border="1">
      <tr>
        <td height="35">SLNO</td>
        <td>NAME</td>
        <td>EMAIL</td>
        <td>COMPLAINT</td>
        <td>REPLY</td>
      </tr>
         <%
      dbquery db=new dbquery();
      int i=1;
      ResultSet res=db.complaint_view();
      while(res.next())
      {
          
      
      %>
      <tr>
        <td height="165"><%=i%></td>
        <td><%=res.getString("name")%></td>
        <td><%=res.getString("email")%></td>
        <td><%=res.getString("complaint")%></td>
        <td><a href="reply.jsp?cid=<%=res.getString(1)%>">REPLY</a></td>
      </tr>
        
      <%
      i++;
      }
         %> 
    </table>
  </div>
</form>
</body>
</html>