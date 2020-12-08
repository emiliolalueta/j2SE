<%-- 
    Document   : combo
    Created on : 13-jun-2011, 10:48:25
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="mibean" scope="page" class="paquetebeans.combo"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form name="form1">
        
        <h1>Hello World!</h1>
        <%
        String combo="";
        String cmbemp="";
        String consulta="select dnombre,dept_no from dept";
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
<input type="submit" value="enviar" name="enviar" />
</form>
    </body>
</html>
