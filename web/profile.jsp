<%@page import="mypackage.dbquery"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MPMD</title>
</head>
<% 
    String id=session.getAttribute("lid").toString();
    dbquery db=new dbquery();
    ResultSet rs=db.profile_view(id);
    if(rs.next())
    {
    
  %>
<body>
<form id="form1" name="form1" method="post" action="">
  <div align="center">
    <table width="200" border="1">
      <tr>
        <td colspan="2"><div align="center">PROFILE</div></td>
      </tr>
      <tr>
        <td>NAME</td>
        <td><label for="name"> </label>
        <input type="text" name="name" id="name" value= <%=rs.getString(2) %> > </td>
      </tr>
      <tr>
        <td>ADDRESS</td>
        <td><label for="address"></label>
        <textarea name="address" id="address" cols="45" rows="5"><%=rs.getString(3)+"\n"+rs.getString(4)+"\n"+rs.getString(5)+"\n"+rs.getString(6) %></textarea></td>
      </tr>
       <tr>
        <td>PHONE</td>
        <td><label for="name"> </label>
        <input type="text" name="phone" id="phone" value= <%=rs.getString(7) %> > </td>
      </tr>
      <tr>
        <td>GENDER</td>
        <td><input type="radio" name="radio" <% if(rs.getString(8).equalsIgnoreCase("male")){%> checked <%}%> id="male" value="male" />
          <label for="male">MALE<br />
            <input type="radio" name="radio" <% if(rs.getString(8).equalsIgnoreCase("female")){%> checked <%}%> id="female" value="female"/>
        FEMALE</label></td>
      </tr>
      <tr>
        <td>EMAIL</td>
        <td><label for="email"></label>
        <input type="text" name="email" id="email" value="<%=rs.getString(9) %>" /></td>
      </tr>
       
    </table>
       <%}%>  
  </div>
</form>
</body>
</html>
