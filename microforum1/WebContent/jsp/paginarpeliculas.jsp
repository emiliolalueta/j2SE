<%-- 
    Document   : paginarpeliculas
    Created on : 02-jun-2011, 10:49:11
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <link href="../css/panel.css" rel="stylesheet" type="text/css" />
		
        <title>JSP Page</title>
    </head>
    <body>
    
    <div id="invisible"> 
    
        <form name="form1" method="post">
        <h1>Paginar Clientes</h1>
        <%
        Connection cn=null;
        Statement st=null;
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        //try {        	
        	
         	cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
         	st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //}catch (Exception e) {
        	
        //}
        
        ResultSet rs=st.executeQuery("select nombre,direccion,email,cpostal,paginaweb,imagen_cliente from clientes");        
        int posicion,anterior,siguiente,ultimo;
        rs.last();
        ultimo=rs.getRow();
        posicion=1;       
        //paginaempleados.jsp?indice=1 
                     
        if (request.getParameter("indice")!=null)
        {
            posicion=Integer.parseInt(request.getParameter("indice"));
        }
        siguiente=posicion+1;
        anterior=posicion-1; 
        if(posicion==1)
        {
            siguiente=posicion+1;
            anterior=1;            
        }
        if(posicion==ultimo)
        {
           siguiente=ultimo; 
        }
        String tabla="<table border='10'>";
        rs.absolute(posicion);
        tabla +="<tr><td colspan='4'>" + rs.getString("nombre")+"</td><br></tr>";
        //<td>rs.getString("imagen_cliente")</td>
        tabla +="<tr><th>Direccion</th>" + "<td>" + rs.getString("direccion")+ "</td>" + "<td rowspan='3'><img src='img/CLIENTES/" + rs.getString("imagen_cliente")+ "'></td> </tr>";
        tabla +="<tr><th>Codigo Postal</th>" + "<td>" + rs.getString("cpostal")+ "</td></tr>";
        tabla +="<tr><th>Pagina Web</th>" + "<td>" + rs.getString("paginaweb")+ "</td></tr>";
        /***************
        tabla +="<tr><td>" + rs.getString("nombre")+"</td>";
        tabla +="<td>" + rs.getString("direccion")+ "</td>";
        tabla +="<td>" + rs.getString("cpostal")+ "</td>";
        tabla +="<td>" + rs.getString("paginaweb")+ "</td></tr>";
        *****************/
        tabla +="<tr><td colspan='4'>Registro " + posicion + " de " ;
        tabla +=ultimo + "</td></tr>"; 
        tabla +="<tr><td>";
        tabla +="<a href='paginarpeliculas.jsp?indice=1'>Primero</a>";
        tabla +="</td><td>";
        tabla +="<a href='paginarpeliculas.jsp?indice="+anterior+"'>Anterior</a>";
        tabla +="</td><td>";
        tabla +="<a href='paginarpeliculas.jsp?indice="+siguiente+"'>Siguiente</a>";
        tabla +="</td><td>";
        tabla +="<a href='paginarpeliculas.jsp?indice="+ ultimo +"'>Ultimo</a>";
        tabla +="</td></tr></table>";
        %>     
        <%=tabla%>
        </form>
       </div>
        
        <jsp:include page="menus/menu.jsp" flush="true"/>
        
    </body>
</html>
