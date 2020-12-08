<%-- 
    Document   : hospitales
    Created on : 14-jun-2011, 14:17:58
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="mibean" scope="page" class="paquetebeans.combo"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <form name="form1">        
        <h1>Seleccione hospital</h1>
        <%
        String combo="";
        String cmbemp="";
        String consulta="select nombre from hospital";
        String dept=request.getParameter("cmbdept");
        if(dept==null){         
            combo=mibean.pintarCombo(consulta,"cmbdept","");
        }
        else
        {
           //String consul="select apellido ,emp_no from emp where dept_no=" + dept;
           //cmbemp=mibean.pintarCombo(consul,"cmbemp",""));
           combo=mibean.pintarCombo(consulta,"cmbdept",dept);
           //
        }        
        %>
        <%=cmbemp%>
        <%=combo%>
        <input type="submit" value="cambiar" name="cambiar" />
        <a href="plantilla.jsp"> volver</a>
        </form>
    </body>
</html>
