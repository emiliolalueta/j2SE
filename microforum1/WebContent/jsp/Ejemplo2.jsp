<%@page import="paqueteservlets.departamentos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.sql.*, java.util.*, paquetebeans.Empleado"  %>
<html>
<head>
<script type="text/javascript" src="../js/tabla_ejemplo.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.centrar{
	float: center;
}
.uno{
	width: 10%;
}

#form{
	position:fixed;
	width  : 1160px;
	height : 550px;
	background-color:red;
}

#form1{
	padding-left:500px;
}

#tabla{
	
	text-align: left;
	background-color: #f96;
	width: 500px;
	margin-top: 5px;
	border: 2px #f30 solid;
}

#segundatabla{

	background-color: #f96;
	width: 60px;
	margin-top: 5px;
	border: 2px #f30 solid;
}

button {
  padding: 19px 39px 18px 39px;
  color: #FFF;
  background-color: #4bc970;
  font-size: 18px;
  text-align: center;
  font-style: normal;
  border-radius: 5px;
  width: 100%;
  border: 1px solid #3ac162;
  border-width: 1px 1px 3px;
  box-shadow: 0 -1px 0 rgba(255,255,255,0.1) inset;
  margin-bottom: 10px;
}

td{
	padding: 5px, 0px;
	align: left;
}

h7 {margin:0px;
	color:red;
	font-size:10px;
} 
	
</style>
</head>
<body>
<div id="wrapper">	
<form name="form" id="form" method="post">
	 <%
        //Combo tiene el departamento
        ArrayList<Empleado> listaempleados = new ArrayList<Empleado>();
        String dept_no = request.getParameter("cmbdept");
	 	String oficio = request.getParameter("cmboficio");
	 	String jefe=request.getParameter("cmbdirectores");
	 	String elementos = request.getParameter("txtelem");	 	
	 %>
	<table align="center" id='tabla' border="1">
	<div>
		<tr> 
			<th align="center">Numero Empleado</th>
			<th align="center">Apellido</th>
			<th align="center">Oficio</th>
			<th align="center">Director</th>
			<th align="center">Fecha Alta</th>
			<th align="center">Salario</th>
			<th align="center">Comision</th>
			<th align="center">Departamentos</th>
		</tr>
		<tr>
			<td><input size=5 type="text" id="numempleado" name="numempleado"></td>
			<td><input type="text" id="cajaApellido" name="Apellido"></td>	
			<%
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	        Connection cn1 = DriverManager.getConnection
	        ("jdbc:oracle:thin:@localhost:1521:XE", "BBDD", "BBDD");
	        String consulta1 = "select distinct OFICIO FROM EMP";
	        Statement st1 = cn1.createStatement();
	        ResultSet rs1 = st1.executeQuery(consulta1);
	        
	        String combo1 = "<select id='Comboficio' name='cmboficio'>";
	        combo1 += "<option value=''>Elija Opcion</option>";
	        while (rs1.next())
	        {
	            combo1 += "<option value='"+rs1.getString("OFICIO")+"'";
	            if (oficio != null)
	            {
	            	if (oficio.equals(rs1.getString("OFICIO")))
	                {
	                    combo1 += " selected";
	                }
	            }
	            combo1 += ">" + rs1.getString("OFICIO") + "</option>";
	        }
	        combo1 += "</select>";
	        rs1.close();
	        cn1.close();
			%>
			<td><%=combo1%></td>
			<%           
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection cn2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
            Statement st2=cn2.createStatement();
            String consulta2="select apellido,emp_no from emp where emp_no in (select distinct dir from emp)";
            ResultSet rs2=st2.executeQuery(consulta2);
            String combo2="<select id='ComboDirector' name='cmbdirectores'>";
            combo2 += "<option value=''>Elija Opcion</option>";
            while(rs2.next())
            {
            	combo2 +="<option value='"+rs2.getString("EMP_NO")+"'>";
            	
                if(jefe!=null)
                {
                    if(jefe.equals(rs2.getString("EMP_NO")))
                    {
                		combo2 += " selected";
               		}
               	}
                
                combo2 +=rs2.getString("APELLIDO").toUpperCase() + "</option>";
            }
            combo2 +="</select>";
            rs2.close();
            cn2.close();
           %>
           	<td><%=combo2%></td>
 
			<td><input size=5 type="text" id="cajaFecha" name="FechaAlta"></td>
			 
			<td><input type="text" id="cajaSalario" name="Salario"></td>
				 
			<td><input type="text" id="cajaComision" name="Comision"></td>
		 
			<%
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	        Connection cn = DriverManager.getConnection
	        ("jdbc:oracle:thin:@localhost:1521:XE", "BBDD", "BBDD");
	        String consulta = "select DEPT_NO, DNOMBRE FROM DEPT";
	        Statement st = cn.createStatement();
	        ResultSet rs = st.executeQuery(consulta);
	        
	        String combo = "<select id='ComboDepartamentos'name='cmbdept'>";
	        combo += "<option value=''>Elija Opcion</option>";
	        while (rs.next())
	        {
	            combo += "<option value='"+rs.getString("DEPT_NO")+"'";
	            if (dept_no != null)
	            {
	                if (dept_no.equals(rs.getString("DEPT_NO")))
	                {
	                    combo += " selected";
	                }
	            }
	            combo += ">" + rs.getString("DNOMBRE") + "</option>";
	        }
	        combo += "</select>";
	        rs.close();
	        cn.close();

			%>
			<td> <%=combo%></td>
		
			<td><input type="button" class="add" onclick="add_row();" value="Add Row"></td>
			
		</tr>
		<tr>
		 	<td id="empleado"></td>
		 	<td id="Apellido"></td>
 			<td id="Oficio"></td>
			<td id="Director"></td>
			<td id="Fecha"></td>
			<td id="Salario"></td>
			<td id="Comision"></td>
			<td id="Departamentos"></td>
	 	</tr>
	</table>
			<!-- combo1 oficios -->
			<%
			String ocu=combo1;
			ocu.replace("selected", "");%>
			<input type="hidden" id="oculto" name="oculto" value="<%=ocu%>"/>
			<!-- combo2 directores -->
			<%
			String ocu1=combo2;
			ocu1.replace("selected", "");%>
			<input type="hidden" id="oculto2" name="oculto2" value="<%=ocu1%>"/>
			<!-- combo2 departamentos -->
			<%
			String ocu2=combo;
			ocu2.replace("selected", "");%>
			<input type="hidden" id="oculto3" name="oculto3" value="<%=ocu2%>"/>		
	</div> 
</form>
	
</body>
</html>