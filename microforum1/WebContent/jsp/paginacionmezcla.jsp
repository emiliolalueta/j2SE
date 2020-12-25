<%-- 
    Document   : paginacionmezcla
    Created on : 03-jun-2011, 13:16:59
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
    <script languaje ="javascript">
        function crearOrden()
        {                                    
            var orden=document.form1.lstorden.value;
            var orde=document.form1.lstnumpaginas.value;            
            
            document.form1.txtorden.value=orden;
            document.form1.txtnumpaginas.value=orde;   
            document.form1.submit();
        }
      </script>
    <body>
    <div id="invisible"> 
    <jsp:include page="menus/horizontaldemas.jsp" flush="true"/><br><br><br>
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
        
       String  orden=request.getParameter("txtorden");
        try
        {                      
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
        Statement sentencia=cn.createStatement();
        consulta="select apellido,salario,oficio from (select tablaemp.*,rownum rnum from(select apellido,salario,oficio from emp order by apellido)tablaemp where rownum<"+(posicion+5)+")where rnum>="+posicion;
        
        ResultSet rs=sentencia.executeQuery(consulta);        
        Statement sentencia2=cn.createStatement();
        ResultSet rs2=sentencia2.executeQuery("select count(emp_no) as numero from emp");
        rs2.next();
        numeroregistros=rs2.getInt("numero");
        rs2.close();
        String tabla="<table border='1'>";
        tabla +="<tr><th>apellido</th><th>salario</th><th>oficio</th></tr>";
        while(rs.next())
        {
            tabla +="<tr><td>" + rs.getString("apellido") + "</td>";
            tabla +="<td>" + rs.getString("salario") + "</td>";
            tabla +="<td>" + rs.getString("oficio") + "</td>";
            tabla +="</tr>";            
        }
        tabla +="</table>";
        int numpagina=1;
        for(int i=0;i<numeroregistros; i+=5)
        {
            int aux=i+1;
            tabla +="<a href='paginacionmezcla.jsp?posicion=" + aux + "'>" + numpagina + "</a>&nbsp;";
            numpagina++;        
        }%>
        <span>Orden</span>
        <select name="lstorden" onchange="crearOrden()">
            <option>apellido</option>
            <option>oficio</option>
            <option>salario</option>
        </select>
        <br> <br>
        <span>Paginacion</span>
        <select name="lstnumpaginas" onchange="crearOrden()">
            <option>5</option>
            <option>10</option>
            <option>15</option>
        </select>
        <br> <br>
          <%=tabla%>
          
          <input type="text" name="txtorden" value="<%=orden%>" />
          <input type="text" name="txtnumpaginas" value="" />
          
         <%}catch(Exception ex)
          {%><h1>Error<%=ex.toString()%></h1>>
          <%}%>      
      </form>
         </div>        
        <jsp:include page="menus/menu.jsp" flush="true"/>
    </body>
</html>
