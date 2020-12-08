<%-- 
    Document   : ahorro
    Created on : 08-jun-2011, 11:17:42
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="lightgreen" text="blue">
    <center><br><h3>Totalahorro<br><br>EMPLEADOS JUBILADOS:<br><br></h3></center>
    <%
    String ahorrado;
    HttpSession sesion=request.getSession();
    ahorrado=sesion.getAttribute("ahorro").toString();%>
    <center><%=ahorrado%></center>        
    </body>
</html>
