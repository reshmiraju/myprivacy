<%@page import="mypackage.dbquery"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MY PRIVACY MY DECISION</title>
</head>
 <script>
   function valid()
   {
	   var flag=true;
	    if(document.getElementById("name").value=="")
	{
            flag=false;
            document.getElementById("a").style.visibility="visible";
    	
 	}
	else
        {
            document.getElementById("a").style.visibility="hidden";
        }
        if(/[^a-z\s]/gi.test(document.getElementById("name").value))
	{
		alert("Special characters are not allowed in name");
		document.getElementById("name").focus();
		return false;
	}
        if(document.getElementById("place").value=="")
	{
            flag=false;
            document.getElementById("b").style.visibility="visible";
    	
 	}
        else
        {
            document.getElementById("b").style.visibility="hidden";
        }
        if(document.getElementById("post").value=="")
	{
            flag=false;
            document.getElementById("c").style.visibility="visible";
    	
 	}
        else
        {
            document.getElementById("c").style.visibility="hidden";
        }
         if(document.getElementById("pin").value=="")
	{
            flag=false;
            document.getElementById("d").style.visibility="visible";
    	
 	}
        else
        {
            document.getElementById("d").style.visibility="hidden";
        }
        if(document.getElementById("district").value=="")
	{
		flag=false;
		document.getElementById("e").style.visibility="visible";
    	}
        else
        {
            document.getElementById("e").style.visibility="hidden";
        }
        
         if(document.getElementById("phone").value=="")
	{
            flag=false;
            document.getElementById("f").style.visibility="visible";
    	
 	}
        if((document.getElementById("phone").value).length!=10)
	
	{
            
	    flag=false;
            document.getElementById("f").style.visibility="visible";
            alert("Phone number should be 10 digit");
	}
        else
        {
            document.getElementById("f").style.visibility="hidden";
        }
        if(document.getElementById("email").value=="")
	{
		  flag=false;
		document.getElementById("g").style.visibility="visible";
	}
	else
        {
            document.getElementById("g").style.visibility="hidden";
        }
	var emailPat =/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	var emailid=document.getElementById("email").value;
	var matchArray = emailid.match(emailPat);
	if (matchArray == null)
	{
		 flag=false;
		document.getElementById("g").style.visibility="visible";
		
	}
	else
        {
            document.getElementById("g").style.visibility="hidden";
        }
       
          return flag;
      }
</script>

  <% 
    String id=request.getParameter("emp_id");
    dbquery db=new dbquery();
    ResultSet rs=db.employee_view_edit(id);
    if(rs.next())
    {
    
  %>
<body>
<form id="form1" name="form1" method="post" action="">
  <div align="center">
    <table width="200" border="1">
      <tr>
        <td colspan="2"><div align="center">ADD EMPLOYEE</div></td>
      </tr>
      <tr>
        <td>NAME</td>
        <td><label for="name"></label>
        <input type="text" name="name" id="name" value="<%=rs.getString(2) %>"/> </td>
         <td width="141"><div style="visibility:hidden" id="a"><font color="#FF0000">Invalid Entry!!!</font></div></td>
       </tr>
      <tr>
        <td> PLACE </td>
        <td><label for="place"></label>
        <input type="text" name="place" id="place" value="<%=rs.getString(3) %>"/></td>
        <td><div style="visibility:hidden" id="b"><font color="#FF0000">Invalid Entry!!!</font></div></td>
      </tr>
      <tr>
        <td> POST </td>
        <td><label for="post"></label>
        <input type="text" name="post" id="post" value="<%=rs.getString(4) %>"/></td>
             <td width="141"><div style="visibility:hidden" id="c"><font color="#FF0000">Invalid Entry!!!</font></div></td>
      </tr>
      <tr>
        <td> PIN </td>
        <td><label for="pin"></label>
        <input type="text" name="pin" id="pin" value="<%=rs.getString(5) %>"/></td>
        <td width="141"><div style="visibility:hidden" id="d"><font color="#FF0000">Invalid Entry!!!</font></div></td>
      </tr>
      <tr>
        <td> DISTRICT </td>
        <td><label for="district"></label>
        <input type="text" name="district" id="district" value="<%=rs.getString(6) %>"/></td>
       <td width="141"><div style="visibility:hidden" id="e"><font color="#FF0000">Invalid Entry!!!</font></div></td>
      </tr>
       <tr>
        <td> PHONE </td>
        <td><label for="district"></label>
        <input type="text" name="phone" id="phone" value="<%=rs.getString(7) %>"/></td>
        <td><div style="visibility:hidden" id="f"><font color="#FF0000">Invalid Entry!!!</font></div></td>
      </tr>
      <tr>
        <td>GENDER</td>
        <td><input type="radio" name="radio" <% if(rs.getString(8).equalsIgnoreCase("male")){%> checked <%}%> id="male" value="male" />
          MALE <br>
          <input type="radio" name="radio" id="male" value="male" <% if(rs.getString(8).equalsIgnoreCase("female")){%> checked <%}%> />FEMALE </td>
      </tr>
      <tr>
        <td>EMAIL</td>
        <td><label for="email"></label>
        <input type="text" name="email" id="email" value="<%=rs.getString(9) %>"/></td>
       <td><div style="visibility:hidden" id="g"><font color="#FF0000">Invalid Entry!!!</font></div></td>
      </tr>
      
      <tr>
        <td colspan="2"><div align="center">
          <input type="submit" name="add" id="add" value="ADD" onclick="return valid()"  />
        </div></td>
      </tr>
             
 
    </table>
      <%}%>  
  </div>
</form>

</body>
</html>
  
<%
   if(request.getParameter("add")!=null)
   {
       String name=request.getParameter("name");
       String place=request.getParameter("place");
       String post=request.getParameter("post");
       String pin=request.getParameter("pin");
       String district=request.getParameter("district");
       String phone=request.getParameter("phone");
       String gender=request.getParameter("radio");
       String email=request.getParameter("email");
       
     
     int i=db.updt(name,place,post,pin,district,phone,gender,email,id);
     if(i>0)
     {
                 %>
                 <script>
                     alert("Succesfully updated");
                     
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
  
