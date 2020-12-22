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
    </head>
    <script type="text/javascript">
    	function pulsa(){
    		  var orden=document.form1.lstorden.value;            
              document.form1.txtorden.value=document.form1.lstorden.value;  
              
              var orde=document.form1.lstnumpaginas.value;            
              document.form1.txtnumpaginas.value=document.form1.lstnumpaginas.value;
              
    	}    
        
        
      </script>
    <body>
    
        <form name="form1" method="POST" action="paginacionmezclados.jsp">
        
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
       String  orde=request.getParameter("txtnumpaginas");
       
       int registros;
       if (orden==null)  orden="apellido";
       if (orde==null)  orde="5";
       registros = Integer.parseInt(orde);
       
        try
        {                   
       
        	DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        	Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
        	Statement sentencia=cn.createStatement();
        
        //consulta="select apellido,salario,oficio from (select tablaemp.*,rownum rnum from(select apellido,salario,oficio from emp order by apellido)tablaemp where rownum<"+(posicion+5)+")where rnum>="+posicion;
        consulta="select apellido,salario,oficio from (select tablaemp.*,rownum rnum from(select apellido,salario,oficio from emp order by " + orden + " )tablaemp where rownum<"+(posicion+registros)+")where rnum>="+posicion;

        
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
        for(int i=0;i<numeroregistros; i+=registros)
        {
            int aux=i+1;
            //tabla +="<a href='paginacionmezcla.jsp?posicion=" + aux + "'>" + numpagina + "</a>&nbsp;";
            tabla +="<a href='paginacionmezclados.jsp?posicion=" + aux + "&txtorden=" + orden + "&txtnumpaginas=" + orde +"'>" + numpagina + "</a>&nbsp;";
            numpagina++;        
        }%>
        <span>Orden</span>
        <!-- 
        <select name="lstorden">
            <option>apellido</option>
            <option>oficio</option>
            <option>salario</option>
        </select>
         -->
        <%
        String Combo="";
        Combo += "<select name='lstorden' onchange='crearOrden()'>";
       	if (orden.equals("apellido")){
       		Combo += "<option selected>apellido</option>";
       	}else{
       		Combo += "<option>apellido</option>";
       	}
       	if (orden.equals("oficio")){
       		Combo += "<option selected>oficio</option>";
       	}else{
       		Combo += "<option>oficio</option>";
       	}
       	if (orden.equals("salario")){
       		Combo += "<option selected>salario</option>";
       	}else{
       		Combo += "<option>salario</option>";
       	}
       	
       	Combo += "</select>";
        
        %>
        <%= Combo %>
        
        <br> <br>
        <span>Paginacion</span>
        <!-- 
        <select name="lstnumpaginas">
            <option>5</option>
            <option>10</option>
            <option>15</option>
        </select>
         -->
                 <%
        String Combo2="";
        Combo2 +="<select name='lstnumpaginas' onchange='crearOrden()'>";
        if (orde.equals("5")){
       		Combo2 += "<option selected>5</option>";
       	}else{
       		Combo2 += "<option>5</option>";
       	}
       	if (orde.equals("10")){
       		Combo2 += "<option selected>10</option>";
       	}else{
       		Combo2 += "<option>10</option>";
       	}
       	if (orde.equals("15")){
       		Combo2 += "<option selected>15</option>";
       	}else{
       		Combo2 += "<option>15</option>";
       	}
       	
        Combo2 +="</select>";
       	%>
       	<%= Combo2 %>
         
        <br> <br>
          <%=tabla%>
          
          <input type="hidden" name="txtorden" value="<%=orden%>" />
          <input type="hidden" name="txtnumpaginas" value="<%=orde%>" />
          <input type="submit" value="Cambiar Paginacion" onclick="pulsa()" />  
         <%}catch(Exception ex)
          {%><h1>Error<%=ex.toString()%></h1>>
          <%}%>      
      </form>
    </body>
</html>