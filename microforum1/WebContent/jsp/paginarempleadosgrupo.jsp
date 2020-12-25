<%-- 
    Document   : paginarempleadosgrupo
    Created on : 02-jun-2011, 12:19:46
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
         <link href="../css/panel.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
     <div id="invisible"> 
     <jsp:include page="menus/horizontaldemas.jsp" flush="true"/><br><br><br>
         <form name="form1" method="post">
        <h1>Paginacion de empleados</h1>
        <%
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
        Statement st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=st.executeQuery("select distinct apellido,oficio,salario,dept_no from emp");        
        int posicion,numregistros;
        posicion=1;                    
        if (request.getParameter("posicion")!=null)
        {
            posicion=Integer.parseInt(request.getParameter("posicion"));
        }
        rs.last();
        numregistros=rs.getRow();
        rs.absolute(posicion);
        String tabla="<table border='8'>";       
        tabla +="<tr><th>Apellido</th><th>Oficio</th>";
        tabla +="<th>Salario</th><th>Departamento</th></tr>";
               
        
       
        for(int i=0;i<5 && ! rs.isAfterLast();i++)
        {
            tabla +="<tr>";
            tabla +="<td>" + rs.getString("apellido") + "</td>";
            tabla +="<td>" + rs.getString("oficio") + "</td>";
            tabla +="<td>" + rs.getString("salario") + "</td>";
            tabla +="<td>" + rs.getString("dept_no") + "</td>";
            tabla +="</tr>";
            rs.next();            
        }
        
        
            rs.close();
            int numpaginas=1;
        
            tabla +="<tr>";
            tabla +="<td colspan='4'>";
               
            for (int z=0;z <numregistros;z+=5)
            {
                int aux=z+1;
                tabla +="<a href='paginarempleadosgrupo.jsp?posicion=" + aux + "'>";
                tabla +=numpaginas + "</a> &nbsp;";
                numpaginas++;
            }
            
                
            tabla +="</td></tr></table>";
        %>
        <%=tabla%>
        
        </form>
         </div>        
        <jsp:include page="menus/menu.jsp" flush="true"/>
    </body>
</html>
