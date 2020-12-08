<%-- 
    Document   : plantilla
    Created on : 14-jun-2011, 12:13:37
    Author     : Alumno
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="mibean" scope="session" class="paquetebeans.plantilla" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form1">
            <span>id plantilla</span>
            <input type="text" name="txtid" value=""/>
            <input type="submit" value="buscar" /><br>
            
            Funcion <jsp:getProperty name="mibean" property="nombre"/><br>
            Salario <jsp:getProperty name="mibean" property="apellidos"/><br>
            Turno <jsp:getProperty name="mibean" property="inscripcion"/><br>
            Hospital <jsp:getProperty name="mibean" property="cuota"/><br>
            
            <a href="hospitales.jsp">Cambiar</a>
            
        <span>Apellido</span><input type="text" name="txtapellido" value="" />
        <input type="submit" value="Modificar" />        
        <%if (request.getParameter("txtapellido")!=null)
        {
             String ape=request.getParameter("txtapellido");
             mibean.modificar(ape);                    
             %>        
             <jsp:setProperty name="mibean" property="*"/>          
             <h3>Datos guardados correctamente sr/sra
             <jsp:getProperty name="mibean" property="nombre"/>
             </h3>
             <h1>
             <a href="datosregistro.jsp">Ver datos registro</a>
             </h1>
        <%}%>        
        </form>
    </body>
</html>
