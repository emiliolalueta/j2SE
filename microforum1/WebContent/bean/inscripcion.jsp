<%-- 
    Document   : inscripcion
    Created on : 14-jun-2011, 11:27:47
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
        <form name="form1">
      
        <span>nombre</span><input type="text" name="txtnombre" value="" /><br>        
        <span>apellidos</span><input type="text" name="txtapellidos" value="" /><br>     
        <span>inscripcion</span><input type="text" name="txtinscripcion" value="" /><br>     
        <spemian>cuota</span><input type="text" name="txtcuota" value="" /><br>     
        <input type="submit" value="Guardar datos" />
       
        
        <%if (request.getParameter("txtnombre")!=null)
             {%>
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
