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
<script languaje="javascript" type="text/javascript">
window.onload = function () 
{
	document.getElementById("numempleado").addEventListener("blur", validarEmpleado);
	document.getElementById("cajaApellido").addEventListener("blur", validarApellido);
	document.getElementById("Comboficio").addEventListener("blur", validarOficio);
	document.getElementById("ComboDirector").addEventListener("blur", validarDirector);
	//document.getElementById("cajaFecha").addEventListener("blur", validarFecha);
	document.getElementById("cajaSalario").addEventListener("blur", validarSalario);
	document.getElementById("cajaComision").addEventListener("blur", validarComision);
	document.getElementById("ComboDepartamentos").addEventListener("blur", validarDepartamentos);
	document.form.addEventListener("submit", validar);
//	form.addEventListener("change", ocultarAvisos);
}
function ocultarAvisos() 
{
	document.getElementById('empleado').style.visibility = 'hidden';
	document.getElementById('Apellido').style.visibility = 'hidden';
	document.getElementById('Oficio').style.visibility = 'hidden';
	document.getElementById('Director').style.visibility = 'hidden';
	document.getElementById('Fecha').style.visibility = 'hidden';
	document.getElementById('Salario').style.visibility = 'hidden';
	document.getElementById('Comision').style.visibility = 'hidden';
	document.getElementById('Departamentos').style.visibility = 'hidden';
	
}
function validarEmpleado(elEvento){
	
	var regEx = /^d{2}\d{2}\d{2}$/;
	var matched = regEx.test("15\11\15")
	
	var empleado = document.getElementById('empleado'); //Nodo donde vamos a mostrar la validación de datos
	var numempleado = document.getElementById('numempleado');
	empleado.innerHTML = '';
	var valor = numempleado.value;
	var retorno =true;
	if (/^[1-9]\d$/.test(numempleado.value)==false || valor==''){
		document.getElementById('empleado').style.visibility = 'visible';
		empleado.innerHTML = '<h7>Numero empleado tiene que ser numerico </h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}
function validarApellido(elEvento){
	
	var cajaApellido = document.getElementById('cajaApellido'); //Nodo donde vamos a mostrar la validación de datos
	var Apellido = document.getElementById('Apellido');
	Apellido.innerHTML = '';
	var valor = cajaApellido.value;
	var retorno =true;
	if (valor=='' || valor==null){
		document.getElementById('Apellido').style.visibility = 'visible';
		Apellido.innerHTML = '<h7>Apellido esta vacio</h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}
function validarOficio(elEvento){
	
	var indiceElegido = document.getElementById('Comboficio').selectedIndex;
	var Oficio = document.getElementById('Oficio');
	var retorno =true;
	Oficio.innerHTML = '';
	if( indiceElegido == null || indiceElegido == 0) {
		document.getElementById('Oficio').style.visibility = 'visible';
		Oficio.innerHTML = '<h7>Oficio no esta elegido</h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}
function validarDirector(elEvento){
	
	var indiceElegido = document.getElementById('ComboDirector').selectedIndex;
	var Director = document.getElementById('Director');
	var retorno =true;
	Director.innerHTML = '';
	if( indiceElegido == null || indiceElegido == 0) {
		document.getElementById('Director').style.visibility = 'visible';
		Director.innerHTML = '<h7>Director no esta elegido</h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}
function validarFecha(elEvento){
	
	var cajaFecha = document.getElementById('cajaFecha'); //Nodo donde vamos a mostrar la validación de datos
	var Fecha = document.getElementById('Fecha');
	Fecha.innerHTML = '';
	var valor = cajaFecha.value;
	var retorno =true;
	if (/^\d{1,2}\/\d{1,2}\/\d{2,4}$/.test(Fecha.value)==false || valor==''){
		document.getElementById('Fecha').style.visibility = 'visible';
		Fecha.innerHTML = '<h7>Formato fecha invalida dd/mm/yy</h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}
function validarSalario(elEvento){
	
	var cajaSalario = document.getElementById('cajaSalario'); //Nodo donde vamos a mostrar la validación de datos
	var salario = document.getElementById('Salario');
	salario.innerHTML = '';
	var valor = cajaSalario.value;
	var retorno =true;
	if (!(/^[-+]?\d*\.?\d*$/.test(cajaSalario.value)) || valor==''){
		document.getElementById('Salario').style.visibility = 'visible';
		salario.innerHTML = '<h7>Salario tiene que ser numerico </h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}
function validarComision(elEvento){
	
	var cajaComision = document.getElementById('cajaComision'); //Nodo donde vamos a mostrar la validación de datos
	var comision = document.getElementById('Comision');
	comision.innerHTML = '';
	var valor = cajaComision.value;
	var retorno =true;
	if (!(/^[-+]?\d*\.?\d*$/.test(cajaComision.value)) || valor==''){
		document.getElementById('Comision').style.visibility = 'visible';
		comision.innerHTML = '<h7>Comision tiene que ser numerico </h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}

function validarDepartamentos(elEvento){
	
	var indiceElegido = document.getElementById('ComboDepartamentos').selectedIndex;
	var Departamentos = document.getElementById('Departamentos');
	var retorno =true;
	Departamentos.innerHTML = '';
	if( indiceElegido == null || indiceElegido == 0) {
		document.getElementById('Departamentos').style.visibility = 'visible';
		Departamentos.innerHTML = '<h7>Departamentos no esta elegido</h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}

function validar(elEvento){
	validarEmpleado(elEvento);
	validarApellido(elEvento);
	validarOficio(elEvento);
	validarDirector(elEvento);
	//validarFecha(elEvento)
	validarSalario(elEvento);
	validarComision(elEvento);
	validarDepartamentos(elEvento);
}
</script>
</head>
<body>
	
	<form name="form" id="form" method="post">
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
					<td>Departamentos</td><td> <%=combo%></td>
					
					<!-- Tendria que ser una select con option de departamentos
					<td><label>Departamento </label></td>
					<td><input type="text" name="Departamento"></td><br> -->
				</tr>
				<tr id="Departamentos"></tr>
				<tr>
				
				<td Colspan=2><input type="button" class="add" onclick="add_row();" value="Añadir"></td>
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
					<% if(request.getParameter("numempleado")!=null){
						if (elementos.equals("null")){
							elementos=request.getParameter("numempleado") + "," + 
									  request.getParameter("Apellido")+ "," +
									  request.getParameter("cmboficio")+ "," +
									  request.getParameter("cmbdirectores")+ "," +
									  request.getParameter("FechaAlta")+ "," +
									  request.getParameter("Salario")+ "," +
									  request.getParameter("Comision")+ "," +
									  request.getParameter("cmbdept") + "@";
 
						}else{
							elementos=elementos + request.getParameter("numempleado") + "," +
							  request.getParameter("Apellido")+ "," +
							  request.getParameter("cmboficio")+ "," +
							  request.getParameter("cmbdirectores")+ "," +
							  request.getParameter("FechaAlta")+ "," +
							  request.getParameter("Salario")+ "," +
							  request.getParameter("Comision")+ "," +
							  request.getParameter("cmbdept")  + "@";

						}
					%>
						<%String[] array = elementos.split("@"); 
							for (String linea : array){
								%>
								<tr>
								<%String[] campos = linea.split(",");
								for (String campo : campos){%>
									<td><%=campo%></td>
								<%}%>
								</tr>
								<%
							} %>
					
					<%}%>
				<tr>
				<td Colspan=2><button type="submit">Insertar</button></td>
				</tr>		

										
			</table>
		<!--
								%>
						<td><%=request.getParameter("numempleado") %></td>
						<td><%=request.getParameter("numempleado") %></td>
						<td><%=request.getParameter("Apellido") %></td>
						<td><%=request.getParameter("cmboficio") %></td>
						<td><%=request.getParameter("cmbdirectores") %></td>
						<td><%=request.getParameter("FechaAlta") %></td>
						<td><%=request.getParameter("Salario") %></td>
						<td><%=request.getParameter("Comision") %></td>																									
						<td><%=request.getParameter("cmbdept") %></td>
		 
		</fieldset>
		 --> 
	<% if (request.getParameter("numempleado")!=null){
	
	Empleado nuevo = new Empleado(Integer.parseInt(request.getParameter("numempleado")), 
								  request.getParameter("Apellido"),
								  request.getParameter("cmboficio"),
								  Integer.parseInt(request.getParameter("cmbdirectores")),
								  request.getParameter("FechaAlta"),
								  Double.parseDouble(request.getParameter("Salario")),
								  Double.parseDouble(request.getParameter("Comision")),
								  Integer.parseInt(request.getParameter("cmbdept")));
	listaempleados.add(nuevo);
	}
	%>
	<input type="hidden" name="txtelem" value="<%=elementos%>"/>

	</form>

	
</body>
</html>