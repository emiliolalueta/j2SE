<%-- 
    Document   : paginacion
    Created on : 01-jun-2011, 14:38:07
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
    <body>        
        <form name="form1" method="post">
        <h1>Doctores del Hospital</h1>
        <%
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("select apellido,oficio,salario,departamento from emp");
        
        %>
        
        </form>
    </body>
</html>
