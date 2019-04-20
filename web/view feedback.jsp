<%@page import="mypackage.dbquery"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MY PRIVACY MY DECISION</title>
</head>

<body>
<form id="form1" name="form1" method="post" action="">
  <div align="center">
    <table width="270" border="1">
      <tr>
        <td height="34" colspan="4"><div align="center">FEEDBACK</div></td>
      </tr>
      <tr>
        <td width="50" height="34">SLNO</td>
        <td width="48">NAME</td>
        <td width="58">EMAIL</td>
         <td width="58">FEEDBACK</td>
         <td width="123">&nbsp;</td>
         <td width="123">&nbsp;</td>
         
         <%
      dbquery db=new dbquery();
      int i=1;
      ResultSet res=db.feedback_view();
      while(res.next())
      {
          
      
      %>
       
      <tr>
        <td height="100"><%=i%></td>
        <td><%=res.getString("name")%></td>
        <td><%=res.getString("email")%></td>
        <td><%=res.getString("feedback")%></td>
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