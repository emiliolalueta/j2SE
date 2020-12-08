<%-- 
    Document   : ordenartabla
    Created on : 03-jun-2011, 8:35:14
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
        <h1>Paginacion de empleados ordenado</h1>
        <%
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
        Statement st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);  
        String cadena="";
        int orden=0;
        switch (orden)
        {
                    case 0:
                        cadena="apellido";
                      break;        
                    case 1:
                        cadena="oficio";                     
                      break;
                    case 2:
                        cadena="salario";                      
                      break;
                    case 3:
                       cadena="dept_no";
                    default:   
                           break;                     
         }
            
        ResultSet rs=st.executeQuery("select distinct apellido,oficio,salario,dept_no from emp order by=cadena");                         
         
        
        
        int posicion,numregistros,numpaginacion;
        posicion=1;    
                
        if (request.getParameter("posicion")!=null)
        {
            posicion=Integer.parseInt(request.getParameter("posicion"));
        }
        rs.last();
        numregistros=rs.getRow();
        rs.absolute(posicion);
        String tabla="<table border='8'>";       
        tabla +="<tr><th><a href='ordenartabla.jsp?posicion=1&orden=0'>Apellido</a></th>";
        tabla +="<th><a href='ordenartabla.jsp?posicion=1&orden=1'>Oficio</a></th>";
        tabla +="<th><a href='ordenartabla.jsp?posicion=1&orden=2'>Salario</a></th>";               
        tabla +="<th><a href='ordenartabla.jsp?posicion=1&orden=3'>Departamento</a></th></tr>";
        
        for(int i=0;i<numregistros;i++)
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
  
            tabla +="</td></tr></table>";                      
         %>
        <%=tabla%>             
        </form>
    </body>
</html>
