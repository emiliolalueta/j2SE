<%@page import="paqueteservlets.departamentos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.sql.*, java.util.*, paquetebeans.Empleado"  %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.centrar{
	float: center;
}

#form{
	position:fixed;
}
#form1{
	padding-left:500px;
}
#primeratabla{
	
	float:left;
	text-align: left;
	background-color: #f96;
	width: 500px;
	margin-top: 5px;
	border: 2px #f30 solid;
}
#segundatabla{
	float: top;
	background-color: #f96;
	width: 60px;
	margin-top: 5px;
	border: 2px #f30 solid;
}
.add, button {
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
	padding: 5px;
	align: left;
}
h7 {margin:0px;
	color:red;
	font-size:10px;} 
	
</style>
<script type="text/javascript" src="../js/tabla_ejemplo.js"></script>
</head>
<body>

	<form name="form" id="form" method="post" action=Practica1_alta.jsp>
		<!-- <fieldset>
			<legend>Datos del empleado</legend>
			 -->
			 <%
		        //Combo tiene el departamento
		        ArrayList<Empleado> listaempleados = new ArrayList<Empleado>();
		        String dept_no = request.getParameter("cmbdept");
			 	String oficio = request.getParameter("cmboficio");
			 	String jefe=request.getParameter("cmbdirectores");
			 	String elementos = request.getParameter("txtelem");
			 %>
			<table id='primeratabla'>
				<tr> 
					<td><label>Numero Empleado </label></td>
					<td><input type="text" id="numempleado" name="numempleado"></td>
				</tr>
				<tr id="empleado"></tr>

				<tr>
					<td><label>Apellido</label></td>
					<td><input type="text" id="cajaApellido" name="Apellido"></td>
				</tr>
				<tr id="Apellido"></tr>
				<tr> 
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
			            combo1 += ">" + rs1.getString("OFICIO") + "</option>";
			        }
			        combo1 += "</select>";
			        rs1.close();
			        cn1.close();

					%>
					<td>Oficio</td><td> <%=combo1%></td>

					<!-- <td><label>Oficio</label></td>
					<td><input type="text" name="Oficio"></td><br> -->
				</tr>
				<tr id="Oficio"></tr>
				<tr>
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
            	combo2 +="<option value='"+rs2.getString("EMP_NO")+"'";           	
                combo2 += ">" + rs2.getString("APELLIDO").toUpperCase() + "</option>";
            }
            combo2 +="</select>";
            rs2.close();
            cn2.close();
            %>
            <td>Director</td><td><%=combo2%></td>
					<!-- 
					<td><label>Director</label></td>
					<td><input type="text" name="Director"></td><br> -->
				</tr>
				<tr id="Director"></tr>
				<tr> 
					<td><label>Fecha Alta</label></td>
					<td><input type="text" id="cajaFecha" name="FechaAlta"></td>
				</tr>
				<tr id="Fecha"></tr>
				<tr> 
					<td><label>Salario </label></td>
					<td><input type="text" id="cajaSalario" name="Salario"></td>
				</tr>
				<tr id="Salario"></tr>
				<tr> 
					<td><label>Comision </label></td>
					<td><input type="text" id="cajaComision" name="Comision"></td>
				</tr>
				<tr id="Comision"></tr>
				<tr> 
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
			            combo += ">" + rs.getString("DNOMBRE") + "</option>";
			        }
			        combo += "</select>";
			        rs.close();
			        cn.close();

					%>
					<td>Departamentos</td><td> <%=combo%></td>
					
					<!-- Tendria que ser una select con option de departamentos
					<td><label>Departamento </label></td>
					<td><input type="text" name="Departamento"></td><br> -->
				</tr>
				<tr id="Departamentos"></tr>
				<tr>
				<td Colspan=2><input type="button" id="anadir" class="add" value="Añadir"></td>
				</tr>
				<tr>
				<td><input type="hidden" id="valores" name="valores"/></td>
				</tr>		
			</table> 

			<table id="segundatabla" border="2">
				<tr>
					<th>Num. Empleado</th>
					<th>Apellido</th>
					<th>Oficio</th>
					<th>Director</th>
					<th>Fecha Alta</th>
					<th>Salario</th>
					<th>Comision</th>
					<th>Departamento</th>
				</tr>
			<tr>
					<td Colspan=2><button type="submit">Insertar</button></td>
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
	</form>
</body>
</html>