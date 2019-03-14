
<%@page import="mypackage.dbquery"%>
<%

String emp_id=request.getParameter("emp_id");
dbquery dd=new dbquery();
int i=dd.Delete(emp_id);
if(i>0)
{
   %> 
<script>
    alert("delete successfully");
    window.location="view employee.jsp";
</script>

    <%
}
else{
    %>

    <script>
        alert("failed");
            </script>
            <%     
}
       
%>