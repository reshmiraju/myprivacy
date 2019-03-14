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
    <table width="483" border="1">
      <tr>
        <td height="30" colspan="8"><div align="center">USER VIEW</div></td>
      </tr>
      <tr>
        <td width="42" height="67">SLNO</td>
        <td width="46">NAME</td>
        <td width="62">GENDER</td>
        <td width="42">DOB</td>
        <td width="53">PHONE</td>
        <td width="70">ADDRESS</td>
        
        <td width="49">EMAIL</td>
        <td width="67">PICTURE</td>
      </tr>
         <%
      dbquery db=new dbquery();
      int i=1;
      ResultSet res=db.user_view();
      while(res.next())
      {
          
      
      %>
      <tr>
        <td height="155"><%=i%></td>
        <td><%=res.getString("name")%></td>
        <td><%=res.getString("gender")%></td>
        <td><%=res.getString("dob")%></td>
        <td><%=res.getString("phone")%></td>
        <td><%=res.getString("place")+"\n"+res.getString("post")+"\n"+res.getString("pin")+"\n"+res.getString("district")%></td>
        
        <td><%=res.getString("email")%></td>
        <td><%=res.getString("pic")%></td>
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