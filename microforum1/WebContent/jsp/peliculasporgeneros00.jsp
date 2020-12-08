<%-- 
    Document   : peliculasporgeneros
    Created on : 06-jun-2011, 8:37:21
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
        function cargarGenero()
        {                                    
            var genero=document.form1.lstgenero.value;    
            
            document.form1.txtgenero.value=genero;   
            document.form1.submit();
        }
      </script>
    <body>
    
        <form name="form1" method="POST">
        
        <%
        // corregido en archivo word  (paginar y ordenar empleados.doc)    
        String consulta;
        int posicion;
        int numeroregistros=0;
        if (request.getParameter("posicion")!=null)
        {
            posicion=Integer.parseInt(request.getParameter("posicion"));
        }
        else
        {
            posicion=1;
        }
        
       String  genero=request.getParameter("txtorden");
        try
        {                      
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
        Statement sentencia=cn.createStatement();
        consulta="select titulo,foto from peliculas where idgenero=(select idgenero from generos where genero=" + genero + ")";
        
        ResultSet rs=sentencia.executeQuery(consulta);        
        Statement sentencia2=cn.createStatement();
        ResultSet rs2=sentencia2.executeQuery("select count(emp_no) as numero from emp");
        rs2.next();
        numeroregistros=rs2.getInt("numero");
        rs2.close();
        String tabla;
        
        while(rs.next())
        {
            tabla="<table border='6'>";
            tabla +="<tr><td>" + rs.getString("titulo") + "</td>";
            tabla +="<td>" + rs.getString("foto") + "</td>";            
            tabla +="</tr>";   
            tabla +="</table>";
        }
        
        int numpagina=1;
        

        
        %>
        <span>Genero</span>
        <select name="lstgenero">
            <option></option>
            <option></option>
            <option></option>
        </select>
         <input type="submit" value="ver peliculas" onClick="cargarGenero()"/>   
         <input type="text" name="txtgenero" value="<%=genero%>" />
        <br> <br>       
       
          <%=tabla%>
          
         
          
         <%}catch(Exception ex)
          {%><h1>Error<%=ex.toString()%></h1>>
          <%}%>      
      </form>
    </body>
</html>
