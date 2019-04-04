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
    <table width="365" border="1">
      <tr>
        <td><div align="center">REPLY</div></td>
      </tr>
      <tr>
        <td><label for="reply"></label>
        <textarea name="reply" id="reply" cols="45" rows="5"></textarea></td>
      </tr>
      <tr>
        <td><div align="center">
          <input type="submit" name="ok" id="ok" value="OK" />
        </div></td>
      </tr>
    </table>
  </div>
</form>
</body>
</html>

<%
    String cid=request.getParameter("cid");
   if(request.getParameter("ok")!=null)
   {
       String reply=request.getParameter("reply");
       dbquery db=new dbquery();
     int i=db.reply_add(reply,cid);
     if(i>0)
     {
                 %>
                 <script>
                     alert("Succesfull");
                     
                     </script>
                 <%
     }
else
{

                 %>
                 <script>
                     alert("failed");
                     
                     </script>
                 <%
}
}

%>
