
<%@page import="mypackage.dbquery"%>
<%

String id=request.getParameter("re_id");
dbquery dd=new dbquery();
int i=dd.user_unblock(id);
if(i>0)
{
   %> 
<script>
    alert("unblocked successfully");
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