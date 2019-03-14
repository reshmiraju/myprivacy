
<%@page import="mypackage.dbquery"%>
<%

String id=request.getParameter("re_id");
dbquery dd=new dbquery();
int i=dd.user_block(id);
if(i>0)
{
   %> 
<script>
    alert("blocked successfully");
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
