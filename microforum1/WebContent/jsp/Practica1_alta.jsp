<%-- 
    Document   : insertardept
    Created on : 31-may-2011, 11:41:37
    Author     : Alumno
--%>

<%@page import="paqueteservlets.doble"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.text.*"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<script languaje="javascript" type="text/javascript">
window.onload = function () 
{
	setCookie("siguiente", "si", 1);
	
	function setCookie(cname, cvalue, exdays) {
		  var d = new Date();
		  d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
		  var expires = "expires="+d.toUTCString();
		  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
		}
}
</script>
    </head>
    <body>
    
	<!--
	create or replace procedure
        insertar_empleado(numero emp.emp_no%type, apellido emp.apellido%type,oficio emp.oficio%type,dir emp.dir%type,fecha_alt emp.fecha_alt%type,salario emp.salario%type,comision emp.comision%type,dept_no emp.dept_no%type)
    as    
	    --declare
		--    cadena1 varchar2(50) ;
        --    cadena2 int;
        --    cadena3 int;
	    Begin 
            insert into EMP VALUES(numero , apellido, oficio, dir, fecha_alt, salario, comision, dept_no);  
		    --DBMS_OUTPUT.PUT_LINE (cadena1);
        end;
    -->
    
        <form  method="get">
        
       <table id="primeratabla" border="2">
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
    			<%String elementos = request.getParameter("valores");
    				String[] array = elementos.split("@"); 
    				 DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
    			        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
    			               
   			        Statement s=cn.createStatement();
   			     	int numero = 0;
					for (String linea : array){%>
				<tr>
					<%String[] campos = linea.split(",");
						numero = 0;
						int campo1=0;
						double campo4=0, campo6=0, campo7=0, campo8=0;
						String campo2="",campo3="";
						java.sql.Date campo5=null;
						for (String campo : campos){%>
						<td><%=campo%></td>
						<%numero=numero+1;%>
						<%if (numero==1){campo1=Integer.parseInt(campo);}%>
						<%if (numero==2){campo2=campo;}%>
						<%if (numero==3){campo3=campo;}%>
						<%if (numero==4){campo4=Double.parseDouble(campo);}%>
						<%if (numero==5){
							SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yy");
							java.util.Date date = sdf.parse(campo);
							campo5= new java.sql.Date(date.getTime());
							}%>
						<%if (numero==6){campo6=Double.parseDouble(campo);}%>
						<%if (numero==7){campo7=Double.parseDouble(campo);}%>
						<%if (numero==8){campo8=Double.parseDouble(campo);}%>							
					<%}%>
				</tr>
					<%		CallableStatement cst=cn.prepareCall("{call insertar_empleado(?,?,?,?,?,?,?,?)}");
				        
				        	cst.setInt(1, campo1);  
				        	cst.setString(2, campo2);
				        	cst.setString(3,campo3);
				        	cst.setDouble(4, campo4);
				        	cst.setDate(5, campo5);
				        	cst.setDouble(6, campo6);
				        	cst.setDouble(7, campo7);
				        	cst.setDouble(8, campo8);
				        	
				        	cst.registerOutParameter(1, java.sql.Types.INTEGER);
				            cst.registerOutParameter(2, java.sql.Types.NVARCHAR);
				            cst.registerOutParameter(3, java.sql.Types.NVARCHAR);
				            cst.registerOutParameter(4, java.sql.Types.INTEGER);
				            cst.registerOutParameter(5, java.sql.Types.DATE);
				            cst.registerOutParameter(6, java.sql.Types.INTEGER);
				            cst.registerOutParameter(7, java.sql.Types.INTEGER);
				            cst.registerOutParameter(8, java.sql.Types.INTEGER);
				            
				            cst.execute();
				            
				            Statement st=cn.createStatement();
				            %>
				
				<%}%>

    			</tr>
    			
		</table>
        	<input type="hidden" id="valore" name="valore" value='<%=request.getParameter("valores")%>'/>
        </form>
    </body>
</html>
