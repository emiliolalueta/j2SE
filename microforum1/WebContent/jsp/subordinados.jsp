<%-- 
    Document   : subordinados
    Created on : 06-jun-2011, 13:37:47
    Author     : Alumno
--%>


<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <%
        String jefe;
        jefe=request.getParameter("txtjefe");
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD" ,"BBDD");
        String consulta="select apellido,oficio from emp where emp_no=?";
        PreparedStatement pst=cn.prepareStatement(consulta);
        pst.setInt(1,Integer.parseInt(jefe));
        ResultSet rs=pst.executeQuery();
        rs.next();
        %>
        <h1> Subordinados de <%=rs.getString("apellido").toUpperCase()%>,<%=rs.getString("oficio").toUpperCase()%>
        </h1>
        <div style="font-family:verdana;font-size:20px;color:red;">El salario completo es <%=request.getParameter("txtsalario")%></div>
        <%rs.close();
        Statement st=cn.createStatement();
        String empleados=request.getParameter("txtempleados");
        consulta="select apellido,salario,oficio,fecha_alt,dept_no from emp where emp_no in ("+empleados+")";
        rs=st.executeQuery(consulta);
        String tabla="<table border='6'>";
        tabla  +="<tr><th>APELLIDO</th><th>Salario</th><th>oficio</th><th>fecha alta</th><th>Departamento</th></tr>";
        while(rs.next())
        {
            tabla +="<tr>";
            tabla +="<td>" + rs.getString("apellido") + "</td>";
            tabla +="<td>" + rs.getString("salario") + "</td>";
            tabla +="<td>" + rs.getString("oficio") + "</td>";
            tabla +="<td>" + rs.getString("fecha_alt") + "</td>";
            tabla +="<td>" + rs.getString("dept_no") + "</td>";
            tabla +="</tr>";
        }
        tabla +="</table>";
        rs.close();%>
        <%=tabla%>           
    
    </body>
</html>
