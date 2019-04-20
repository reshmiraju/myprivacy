<%@page import="mypackage.dbquery"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>my privacy my decision
  
  
 </title>
</head>

<body>
<form id="form1" name="form1" method="post" action="">

  <div align="center">
    <table width="553" border="1">
      <tr>
        
        <td width="46" height="63">SLNO</td>
        <td width="50">NAME</td>
        <td width="64">EMAIL</td>
        <td width="123">RE_AGAINST</td>
        <td width="107">REPORT</td>
        <td width="123">&nbsp;</td>
      </tr>
      
         <%
      dbquery db=new dbquery();
      int i=1;
      ResultSet res=db.block();
      while(res.next())
      {
          
      
      %>
      <tr>
          <td height="100"><%=i%></td>
        <td><%=res.getString(2)%></td>
        <td><%=res.getString(9)%></td>
        <td><%=res.getString(14)%></td>
        <td><%=res.getString(28)%></td>
        <td><p><a href="userblock.jsp?re_id=<%=res.getString(25)%>">BLOCK</a></p>
        <p align="left"><a href="userunblock.jsp?re_id=<%=res.getString(25)%>">UNBLOCK</a></p></td>
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




