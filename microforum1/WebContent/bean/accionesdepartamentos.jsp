<%-- 
    Document   : accionesdepartamentos
    Created on : 10-jun-2011, 11:41:02
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="mibean" scope="page" class="paquetebeans.accionesdepartamentos"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <script languaje="JavaScript">
            function enviarDatos(num,nom,loc)
            {
                document.form1.txtnumero.value=num;
                document.form1.txtnumero.value=nom;
                document.form1.txtnumero.value=loc;
                document.form1.submit();
            }
            </script>
    </head>
    <body>
        <form name="form1">
            <%
            String numero=request.getParameter("txtnumero");
            String nombre=mibean.getNombre(Integer.parseInt(request.getParameter("txtnumero")));
            String localidad=mibean.getLocalidad(Integer.parseInt(request.getParameter("txtnumero")));            
            %>
            <span>numero</span>
            <input type="text" name="txtnumero" value="<%=numero%>"/><br>
            <span>nombre</span>
            <input type="text" name="txtnombre" value=""/><br>
            <span>localidad</span>
            <input type="text" name="txtlocalidad" value=""/><br>    
            <input type="submit" value="Buscar" onclick="enviarDatos(numero,nombre,localidad)" /><br>
            <input type="submit" value="Insertar" /><br>
            <input type="submit" value="Modificar" /><br>
            <input type="submit" value="Eliminar" /><br>
            
            <%=numero%>
        </form>
    </body>
</html>
