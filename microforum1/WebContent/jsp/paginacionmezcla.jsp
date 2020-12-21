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
    <script languaje ="javascript">
        function crearOrden()
        {                                    
            var orden=document.form1.lstorden.value;
            var orde=document.form1.lstnumpaginas.value;            
            
            document.form1.seleccionado.value=orden;
            document.form1.registros.value=orde;   
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
        
       	//String  orden=request.getParameter("txtorden");
       	//String  orde=request.getParameter("txtnumpaginas");
       
        try
        {                      
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
        Statement sentencia=cn.createStatement();
        //se consige de la URL
        String orden = request.getParameter("orden");
        String paginacion = request.getParameter("paginacion");
        //se consige de las combos
        String seleccionado = request.getParameter("lstorden");
        String seleccionado2=request.getParameter("lstnumpaginas");
        int registros=0;
        if (seleccionado==null && orden==null){
        	seleccionado = "apellido";
        }else if(seleccionado!=null){
        	seleccionado=seleccionado;
        }
        else if(orden!=null){
        	seleccionado = orden;        	
        }
        registros = 5;
        if(seleccionado2!=null){
        	 registros = Integer.parseInt(seleccionado2);
        }else if(paginacion!=null){
        	registros = Integer.parseInt(paginacion);
        }
        //consulta="select apellido,salario,oficio from (select tablaemp.*,rownum rnum from(select apellido,salario,oficio from emp order by apellido)tablaemp where rownum<"+(posicion+5)+")where rnum>="+posicion;
        consulta="select apellido,salario,oficio from (select tablaemp.*,rownum rnum from(select apellido,salario,oficio from emp order by " + seleccionado + " )tablaemp where rownum<"+(posicion+registros)+")where rnum>="+posicion;
            
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
            tabla +="<a href='paginacionmezcla.jsp?posicion=" + aux + "&orden=" + seleccionado + "&paginacion=" + seleccionado2 +"'>" + numpagina + "</a>&nbsp;";
            numpagina++;        
        }%>
        <span>Orden</span>
        <!-- 
        <select name="lstorden" onchange="crearOrden()">
            <option value='selected'>apellido</option>
            <option>oficio</option>
            <option>salario</option>
        </select>
         -->
        <% String Combo="";
        if (seleccionado == null){
        	Combo += "<select name='lstorden' onchange='crearOrden()'>";
        	Combo += "<option>apellido</option>";
        	Combo += "<option>oficio</option>";
        	Combo += "<option>salario</option>";
        	Combo += "</select>";
        }else{
        	Combo += "<select name='lstorden' onchange='crearOrden()'>";
        	if (seleccionado.equals("apellido")){
        		Combo += "<option selected>apellido</option>";
        	}else{
        		Combo += "<option>apellido</option>";
        	}
        	if (seleccionado.equals("oficio")){
        		Combo += "<option selected>oficio</option>";
        	}else{
        		Combo += "<option>oficio</option>";
        	}
        	if (seleccionado.equals("salario")){
        		Combo += "<option selected>salario</option>";
        	}else{
        		Combo += "<option>salario</option>";
        	}
        	Combo += "</select>";
        }
        %>
        <%= Combo %>
                
        <br> <br>
        <span>Paginacion</span>
        <!-- 
        <select name="lstnumpaginas" onchange="crearOrden()">
            <option>5</option>
            <option>10</option>
            <option>15</option>
        </select>
         -->
        <%
        String Combo2="";
        Combo2 +="<select name='lstnumpaginas' onchange='crearOrden()'>";
        if (seleccionado2 == null){
        	Combo2 += "<option>5</option>";
        	Combo2 += "<option>10</option>";
        	Combo2 += "<option>15</option>";
        }
        else
       	{
            if (seleccionado2.equals("5")){
        		Combo2 += "<option selected>5</option>";
        	}else{
        		Combo2 += "<option>5</option>";
        	}
        	if (seleccionado2.equals("10")){
        		Combo2 += "<option selected>10</option>";
        	}else{
        		Combo2 += "<option>10</option>";
        	}
        	if (seleccionado2.equals("15")){
        		Combo2 += "<option selected>15</option>";
        	}else{
        		Combo2 += "<option>15</option>";
        	}

        }
       	
        Combo2 +="</select>";
       	%>
       	<%= Combo2 %>
        <br> <br>
          <%=tabla%>
          
          <input type="text" name="seleccionado" value="<%=seleccionado%>" />
          <input type="text" name="registros" value="<%=registros%>" />
          
         <%}catch(Exception ex)
          {%><h1>Error<%=ex.toString()%></h1>>
          <%}%>      
      </form>
    </body>
</html>
