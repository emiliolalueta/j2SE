<%-- 
    Document   : parametros
    Created on : 20-jun-2011, 10:06:38
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="tagparametros" prefix="parametros"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form1">
            Introduccion su nombre:
            <input type="text" name="txtnombre"/><br>
            <input type="submit" value="Mostrar saludo"/>
            <%if (request.getParameter("txtnombre")!=null)
            {
                String dato=request.getParameter("txtnombre");%>
                <parametros:mostrarsaludo nombre="Pedro"/>  <%=dato%>  
            <%}%>
        </form>
    </body>
</html>
