<%-- 
    Document   : buscarapellido
    Created on : 09-jun-2011, 12:32:31
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="mibean" scope="page" class="paquetebeans.buscasalario"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
        <form name="form1" method="POST">     
        Apellido:<input type="text" name="txtapellido" value="" />
        <input type="submit" value="Mostrar salario" />
        <%
        String nom=request.getParameter("txtapellido");
        int resp=0;
        if(nom !=null)
        {
            resp=mibean.getSal(nom);}
            String resultado="";
            if(resp==-1){
                resultado="<h1>sin resultado</h1>";
            }else{
                resultado="<h1>Salario" + resp;
            }            
            %>
            <span>Salario:</span>            
            <%=resultado%>
        </form>
    </body>
</html>
