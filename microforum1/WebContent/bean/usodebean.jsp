<%-- 
    Document   : usodebean
    Created on : 09-jun-2011, 12:00:40
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="mibean" scope="session" class="paquetebeans.PrimerBean"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form1" method="POST">
        
        <h1>
            <%=mibean.getHora()%>
        </h1> 
        <input type="text" name="txtnombre" value="" />
        <input type="submit" value="Mostrar saludo" />
        <%
        String nom=request.getParameter("txtnombre");
        String resp="";
        if(nom !=null)
        {
            resp=mibean.getSaludo(nom);} %>
            
                   <%=resp%>
        </form>
    </body>
</html>
