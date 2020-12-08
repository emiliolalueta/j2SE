<%-- 
    Document   : datosregistro
    Created on : 14-jun-2011, 11:35:38
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="mibean" scope="session" class="paquetebeans.inscripcion" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos registro</h1>
        nombre<jsp:getProperty name="mibean" property="nombre"/><br>
        Apellido<jsp:getProperty name="mibean" property="apellidos"/><br>
        Inscripcion<jsp:getProperty name="mibean" property="inscripcion"/><br>
        Cuota<jsp:getProperty name="mibean" property="cuota"/><br>
    </body>
</html>
