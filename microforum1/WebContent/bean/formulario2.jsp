<%-- 
    Document   : formulario2
    Created on : 14-jun-2011, 11:15:04
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="mibean" scope="page" class="paquetebeans.formulario" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form name="form1">            
            <span>Nombre</span>
            <input type="text" name="nombre"/></br>
            <span>Cantidad</span>
             <input type="text" name="cantidad" /></br>
            <span>Rango inicio</span>
             <input type="text" name="inicio" /></br>
            <span>Rango final</span>
             <input type="text" name="fin"/></br>
             <input type="submit" value="Mostrar" />
             <%
                if (request.getParameter("cantidad")!=null)
                {%>
                <jsp:setProperty name="mibean" property="*"/>                
                <%=mibean.getAleatorios()%>
                <%}%>
        </form>
    </body>
</html>
