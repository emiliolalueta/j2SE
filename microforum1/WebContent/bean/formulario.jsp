<%-- 
    Document   : formulario
    Created on : 14-jun-2011, 9:40:47
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
            <input type="text" name="txtnombre"/></br>
            <span>Cantidad</span>
             <input type="text" name="txtcantidad" /></br>
            <span>Rango inicio</span>
             <input type="text" name="txtinicio" /></br>
            <span>Rango final</span>
             <input type="text" name="txtfin"/></br>
             <input type="submit" value="Mostrar" />
             <%
                if (request.getParameter("txtcantidad")!=null)
                {%>
                <jsp:setProperty name="mibean" property="nombre" param="txtnombre"/>
                <jsp:setProperty name="mibean" property="cantidad" param="txtcantidad"/>
                <% int inicio=Integer.parseInt(request.getParameter("txtinicio"));%>
                <jsp:setProperty name="mibean" property="inferior" value="<%=inicio%>"/>
                <jsp:setProperty name="mibean" property="superior" param="txtfin"/>
                <%=mibean.getAleatorios()%>
                <%}%>
        </form>
    </body>
</html>
