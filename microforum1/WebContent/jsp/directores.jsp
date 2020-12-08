<%-- 
    Document   : directores
    Created on : 06-jun-2011, 12:27:23
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
            String jefe;
            jefe=request.getParameter("cmbdirectores");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
            Statement st=cn.createStatement();
            String consulta="select apellido,emp_no from emp where emp_no in (select distinct dir from emp)";
            ResultSet rs=st.executeQuery(consulta);
            String combo="<select name='cmbdirectores' onchange='document.form1.submit()'";
            while(rs.next())
            {
                if(jefe==null)
                {
                    combo +="<option value='"+rs.getString("EMP_NO")+"'>";
                }
                else
                {
                    if(jefe.equals(rs.getString("EMP_NO")))
                    {
                         combo +="<option value='"+rs.getString("EMP_NO")+"'selected>";
                    }
                    else
                    {
                        combo +="<option value='"+rs.getString("EMP_NO")+"'>";
                    }
                }
                combo +=rs.getString("APELLIDO").toUpperCase() + "</option>";
            }
            combo +="</select>";
            %>
            <%=combo%>
            <%
            int totalsalarios=0;
            String empleados="";
            if(jefe !=null){
                
                               
            consulta="Select Level as NIVEL,APELLIDO,SALARIO,EMP_NO from emp connect by PRIOR emp_no=dir start with emp_no="+ jefe + "order by level";
            rs=st.executeQuery(consulta);
            String tabla="<table border='6'>";
            tabla +="<tr><th>NIVEL</th>APELLIDO <th></th><th>SALARIO</th></tr>";
            while(rs.next())
            {
                tabla +="<tr>";
                tabla +="<td>" + rs.getString("nivel")+ "</td>";
                tabla +="<td>" + rs.getString("apellido")+ "</td>";
                tabla +="<td>" + rs.getString("salario")+ "</td>";
                tabla +="</tr>";
                totalsalarios +=rs.getInt("salario");
                empleados +=rs.getString("EMP_NO") + ",";                
           }
            empleados=empleados.substring(0,empleados.lastIndexOf(","));
            tabla +="</table>";
            tabla +="<div style='font-family:verdana;font-size:20px;color:red;'>Salarios de los empleados:" + totalsalarios + "</div>";
            
            %>
            <%=tabla%>
            <%}
            %>
        </form>
        <hr>
        <form name ="form2" method="post" action ="subordinados.jsp">
            <input type="hidden" name ="txtjefe" value="<%=jefe%>"/>
            <input type="hidden" name="txtsalario" value="<%=totalsalarios%>"/>
            <input type="hidden" name= "txtempleados" value="<%=empleados%>"/>            
            <input type="submit" value ="Mostrar Informe"/>                             
                    
        </form>
    </body>
</html>
