<%-- 
    Document   : verdatoseleccionados
    Created on : 07-jun-2011, 8:30:57
    Author     : Alumno
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form1" method="POST">
            <h1>Directores de la empresa</h1>
            <%
            String departamento;
            departamento=request.getParameter("cmbdepartamentos");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
            Statement st=cn.createStatement();
            //String consulta="select apellido,emp_no from emp where emp_no in (select distinct dir from emp)";
            String consulta="select dnombre,dept_no from dept";
            ResultSet rs=st.executeQuery(consulta);
            String combo="<select name='cmbdepartamentos' onchange='document.form1.submit()'>";
                 
            while(rs.next())
            {                
                if(departamento==null)
                {
                     combo +="<option value='"+rs.getString("dept_no")+"'>";                          
                }
                else
                {
                     if(departamento.equals(rs.getString("dept_no")))
                    {
                         combo +="<option value='"+rs.getString("dept_no")+"'selected>";
                    }
                    else
                    {
                        combo +="<option value='"+rs.getString("dept_no")+"'>";
                    }
                }    
                combo +=rs.getString("dnombre").toUpperCase() + "</option>";
            }
            combo +="</select>";
            %>
            <%=combo%>
            <%
            rs.close();
            int totalsalarios=0;
            String empleados="";
            int media=0;
            if(departamento !=null){  
                               
            consulta="Select apellido,salario,emp_no from emp where dept_no=" + request.getParameter("cmbdepartamentos");
            if (consulta!=null)
            {
                rs=st.executeQuery(consulta);
                String tabla="<table border='6'>";
                tabla +="<tr><th>NIVEL</th>APELLIDO <th></th><th>SALARIO</th></tr>";
                
                while(rs.next())
                {
                    tabla +="<tr>";
                    tabla +="<td><input type='checkbox' name='persona' value='ON'/></td>";                                   
                    tabla +="<td>" + rs.getString("apellido")+ "</td>";
                    tabla +="<td>" + rs.getString("salario")+ "</td>";
                    tabla +="</tr>";                    
                    totalsalarios +=rs.getInt("salario");
                    empleados +=rs.getString("EMP_NO") + ",";                     
                }
                    rs.last();
                     
                    int filas=rs.getRow();
                    
                    media=totalsalarios/filas;
                    empleados=empleados.substring(0,empleados.lastIndexOf(","));
                    tabla +="</table>";
                    tabla +="<div style='font-family:verdana;font-size:20px;color:red;'>Salarios de los empleados:" + totalsalarios + "</div>";
            %>
            <%=tabla%>
            <%}}           
            %>
        </form>
        <hr>
        <form name ="form2" method="post" action ="verdatoseleccionados.jsp">
            <input type="text" name ="txtpersonas" value="<%=filas%>"/>
            <input type="text" name="txtsalario" value="<%=totalsalarios%>"/>
            <input type="text" name= "txtmedia" value="<%=media%>"/>             
            <input type="submit" value ="Mostrar datos"/>                            
                    
        </form>
    </body>
</html>
