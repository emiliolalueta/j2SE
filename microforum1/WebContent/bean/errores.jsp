<%-- 
    Document   : errores
    Created on : 10-jun-2011, 10:51:56
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%if(request.getParameter("error")!=null){
       String error=request.getParameter("error");   
       %>
           <h1><%=error%></h1>
           <h1><%=exception%></h1>
           <%}%>
    </body>
</html>
