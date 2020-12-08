<%-- 
    Document   : compra
    Created on : 08-jun-2011, 11:57:45
    Author     : Alumno
--%>

<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="lightgreen" text="blue">
    <center><br><h3>Total de compra<br><br>Peliculas:<br><br></h3></center>
    <%    
    HashMap list=new HashMap();
    HttpSession sesion=request.getSession();
//    lista=sesion.getAttribute("carrito");
    list=sesion.getAttribute("carrito");

%>
    
    
    <center><%=%></center>        
    </body>
</html>
