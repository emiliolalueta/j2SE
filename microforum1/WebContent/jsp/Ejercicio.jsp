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
#primeratabla{
	float: left;
	text-align: left;
	background-color: #f96;
	width: 500px;
	margin-top: 5px;
	border: 2px #f30 solid;
}
#segundatabla{

	margin-top: 5px;
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
	padding: 5px;
	align: left;
}
	
</style>
<script languaje="javascript" type="text/javascript">

</script>
</head>
<body>
	<form name="form" method="post">
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
					<td><input type="text" name="numempleado"></td>
				</tr>

				<tr>
					<td><label>Apellido</label></td>
					<td><input type="text" name="Apellido"></td>
				</tr>
				<tr> 
					<%
					DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			        Connection cn1 = DriverManager.getConnection
			        ("jdbc:oracle:thin:@localhost:1521:XE", "BBDD", "BBDD");
			        String consulta1 = "select distinct OFICIO FROM EMP";
			        Statement st1 = cn1.createStatement();
			        ResultSet rs1 = st1.executeQuery(consulta1);
			        
			        String combo1 = "<select name='cmboficio'>";
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
				<tr>
					<%
            
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection cn2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
            Statement st2=cn2.createStatement();
            String consulta2="select apellido,emp_no from emp where emp_no in (select distinct dir from emp)";
            ResultSet rs2=st2.executeQuery(consulta2);
            String combo2="<select name='cmbdirectores' onchange='document.form1.submit()'";
            while(rs2.next())
            {
                if(jefe==null)
                {
                    combo2 +="<option value='"+rs2.getString("EMP_NO")+"'>";
                }
                else
                {
                    if(jefe.equals(rs2.getString("EMP_NO")))
                    {
                         combo2 +="<option value='"+rs2.getString("EMP_NO")+"'selected>";
                    }
                    else
                    {
                        combo2 +="<option value='"+rs2.getString("EMP_NO")+"'>";
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
				<tr> 
					<td><label>Fecha Alta</label></td>
					<td><input type="text" name="FechaAlta"></td>
				</tr>
				<tr> 
					<td><label>Salario </label></td>
					<td><input type="text" name="Salario"></td>
				</tr>
				<tr> 
					<td><label>Comision </label></td>
					<td><input type="text" name="Comision"></td>
				</tr>
				<tr> 
					<%
					DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			        Connection cn = DriverManager.getConnection
			        ("jdbc:oracle:thin:@localhost:1521:XE", "BBDD", "BBDD");
			        String consulta = "select DEPT_NO, DNOMBRE FROM DEPT";
			        Statement st = cn.createStatement();
			        ResultSet rs = st.executeQuery(consulta);
			        
			        String combo = "<select name='cmbdept'>";
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
				<tr>
				<td Colspan=2><button type="submit">Añadir</button></td>
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