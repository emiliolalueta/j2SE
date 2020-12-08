<%-- 
    Document   : hospitales
    Created on : 31-may-2011, 10:55:10
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hospitales (En revision)</h1>
        <%DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("select nombre,hospital_cod from hospital");
        while (rs.next())
                       {%>
                       <input type="radio" value='<%=rs.getString("hospital_cod")%>'/>
                       <%=rs.getString("nombre")%><br>
                       <%}
        rs.close();%>
        <input type="submit" value="Mostrar doctores"/>                              
                
    </body>
</html>
