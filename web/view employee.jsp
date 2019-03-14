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
    <table width="420" border="1">
      <tr>
        <td colspan="7"><div align="center">VIEW EMPLOYEE</div></td>
      </tr>
      <tr>
        <td width="28">SLNO</td>
        <td width="24">NAME</td>
        <td width="26">ADDRESS</td>
        <td width="26">PHONE</td>
        <td width="26">GENDER</td>
        <td width="26">EMAIL</td>
        <td> </td>
      </tr>
         <%
      dbquery db=new dbquery();
      int i=1;
      ResultSet res=db.employee_view();
      while(res.next())
      {
          
      
      %>
        
      <tr>
          <td height="100"><%=i%></td>
          <td><%=res.getString("name")%></td>
        <td><%=res.getString("place")+"\n"+res.getString("post")+"\n"+res.getString("pin")+"\n"+res.getString("district")%></td>
        <td><%=res.getString("phone")%></td>
         <td><%=res.getString("gender")%></td>
          <td><%=res.getString("email")%></td>
          
        <td><p><a href="empupdate.jsp?emp_id=<%=res.getString(1)%>">UPDATE</a></p>
        <p><a href="empdelete.jsp?emp_id=<%=res.getString(1)%>">DELETE</a></p></td>
       
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