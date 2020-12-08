<%-- 
    Document   : ordenartabla2
    Created on : 03-jun-2011, 10:50:35
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script languaje ="javascript">
        function crearOrden(campo)
        {
            var orden=document.form1.txtorden.value;
            if(orden==campo + " asc")
                {
                    orden=campo + " desc";
                }
                else if(orden==campo + " desc")
                {
                    orden=campo + " asc";
                }
                else
                {
                    orden=campo + " asc";
                }
                    document.form1.txtorden.value=orden;
                    document.form1.submit();
        }
        </script>
    <body>
        <form name="form1" method="POST">
            <%
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
      
        String orden="apellido asc";
        if (request.getParameter("txtorden")!=null)
        {
            orden=request.getParameter("txtorden");
        }
        %>
        <input type="text" name="txtorden" value="<%=orden%>" />
        <%
              Statement st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);  
              ResultSet rs=st.executeQuery("select distinct apellido,oficio,salario,dept_no from emp order by " + orden);                         

         String tabla="<table border='1'><tr>";
            tabla +="<td><a href='javascript:crearOrden(\"apellido\")'>";
            tabla +="apellido</a></td>";
            tabla +="<td><a href='javascript:crearOrden(\"oficio\")'>";
            tabla +="oficio</a></td>";                
            tabla +="<td><a href='javascript:crearOrden(\"salario\")'>";
            tabla +="salario</a></td>";              
            tabla +="<td><a href='javascript:crearOrden(\"dept_no\")'>";//  poner esto \" sirve para incluir doble comillas dentro de doble comillas
            tabla +="dept_no</a></td>";                          
            tabla +="</tr>";
            while (rs.next())
            {
                tabla += "<tr>";
                tabla += "<td>" + rs.getString(1)+"</td>";
                tabla += "<td>" + rs.getString(2)+"</td>";
                tabla += "<td>" + rs.getString(3)+"</td>";
                tabla += "<td>" + rs.getString(4)+"</td>";
                tabla += "</tr>";
            }
            tabla +="</table>";
        %>
             <%=tabla%>
        </form>
    </body>
</html>
