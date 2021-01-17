<%-- 
    Document   : selecciondepartamento
    Created on : 20-jun-2011, 10:43:16
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="tagdepartamentos" prefix="emp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>                
       	<emp:combo nombre="VENTAS"/>         	
       	<!--emp:combo/-->  
       	<h1>En la tabla sale ventas porque es lo que  hemos metido como parametro en la pagina jsp.</h1>
    </body>
</html>
