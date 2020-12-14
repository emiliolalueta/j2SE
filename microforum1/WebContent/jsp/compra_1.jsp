<%-- 
    Document   : compra
    Created on : 08-jun-2011, 11:57:45
    Author     : Alumno
--%>

<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="lightgreen" text="blue">
    <center><br><h3>Total de compra<br><br>Peliculas:<br><br></h3></center>
    <%    
    
    HashMap lista=new HashMap();
    
    HttpSession sesion=request.getSession();
 	lista=(HashMap) sesion.getAttribute("carrito"); 	
 	 
 	while (lista.values().iterator().hasNext()) {
 		lista.values().iterator().next();
 		System.out.println(lista.values());
 		
    }
%>
    <table border="8" align="center" bgcolor="yellow">    
	     <%while (lista.values().iterator().hasNext()) {%>    
		    <tr>
		    	<td><%=lista.values().iterator().next()%></td>                
		    </tr>
	    <%}%>    
    </table><br><br>
    <!--center><%=lista%></center-->        
    </body>
</html>
