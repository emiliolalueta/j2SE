<%-- 
    Document   : departamentosempleadoscheckjavascript
    Created on : 07-jun-2011, 13:59:27
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*"%>
<html>
    <head>
        <script languaje="javascript" type="text/javascript">
            function marcarSeleccionados(chk)
            {
                var elementos=document.form1.txtelem.value;
                var emp =chk.value + ",";
                if(elementos.indexOf(emp)!=-1)
                    {
                        elementos=elementos.replace(emp,"");
                    }
                    if(chk.checked==true)
                    {
                        elementos=elementos+emp;
                    }
                    document.form1.txtelem.value=elementos;                        
            }
            function mostrarDatos()
            {
                var dept=
                document.form1.cmbdept.options[document.form1.cmbdept.selectedIndex].value;
                var elem=document.form1.txtelem.value;
                var pagina="departamentosempleadoscheck.jsp?datos=1&txtelem=" + elem + "&cmbdept=" + dept;
                window.location.href=pagina;
            }
        </script> 
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title> 
        <link href="../css/panel.css" rel="stylesheet" type="text/css" />       
    </head>
    
    <body>
    <div id="invisible"> 
    <jsp:include page="menus/horizontaldemas.jsp" flush="true"/><br><br><br>
        <form name="form1" method="get">
            <h1> Datos de empleados</h1>
            <%
            String elementos=request.getParameter("txtelem");
            ArrayList<String> listaempleados=new ArrayList<String>();
            if(elementos !=null)
            {
                if(!elementos.equals(""))
                {
                    String[] datos=elementos.split(",");
                    for (String d:datos)
                    {
                     ;   listaempleados.add(d);
                    }
                }
            }
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBDD", "BBDD");
        String consulta="select DEPT_NO, DNOMBRE FROM DEPT";
        Statement st=cn.createStatement();
        ResultSet rs = st.executeQuery(consulta);
        String dept_no=request.getParameter("cmbdept");
        String combo="<selet name='cmbdept' onChange='document.form1.submit()'>";
        while(rs.next())
        {
            combo +="<option value='"+ rs.getString("DEPT_NO") + "'";
            if(dept_no !=null)
            {
                if(dept_no.equals(rs.getString("DEPT_NO")))
                {
                    combo +="selected";
                }
            }
            combo +=">" + rs.getString("DNOMBRE") + "</option>";
            
        }
            combo +="</select><hr>";
            rs.close();
            %>
            Departamentos <%=combo%>
            <%
            if(request.getParameter("datos")!=null)
            {
                elementos=elementos.substring(0,elementos.lastIndexOf(","));
                consulta="SELECT COUNT(EMP_NO) AS PERSONAS,SUM(SALARIO) AS SUMA,AVG(SALARIO) AS MEDIA FROM EMP WHERE EMP_NO IN ("+elementos+")";
                rs=st.executeQuery(consulta);
                String personas,suma,media;
                rs.next();
                personas=rs.getString("PERSONAS");
                suma=rs.getString("SUMA");
                media=rs.getString("MEDIA");
                rs.close();
                elementos=elementos + ",";
                %>
                <table border="1">
                    <tr>
                        <th>personas</th>
                        <td>
                            <input type="text" value="<%=personas%>" name="txtpersonas"/>
                        </td>           
                        
                    </tr>
                    <tr>
                        <th> Suma Salarial</th>
                        <td>
                            <input type="text" value="<%=suma%>" name="txtsuma"/>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            Media Salarial
                        </th>
                        <td>
                            <input type="text" value="<%=media%>" name="txtmedia"/>
                        </td>
                    </tr>
                </table>                        
               <%}
            if(dept_no !=null)
            {
                consulta="select emp_no,apellido,salario from emp where dept_no=?";
                PreparedStatement pst=cn.prepareStatement(consulta);
                pst.setString(1,dept_no);
                rs=pst.executeQuery();
                String tabla="<br><table border='1'>";
                tabla +="<tr><th></th>APELLIDO</th><th>SALARIO</th></tr>";
                int salarios=0;
                while(rs.next())
                {
                    tabla +="<tr>";
                    tabla +="<td>";
                    tabla +="<input onclick='marcarSeleccionados(this)' type='checkbox' name='chkemp' value='" + rs.getString("EMP_NO") + "'";
                    if(listaempleados.indexOf(rs.getString("EMP_NO"))!=-1)
                    {
                        tabla +="checked";
                    }
                    tabla +="/>";
                    tabla +="</td>";
                    tabla +="<td>" + rs.getString("APELLIDO")+ "</td>";
                    tabla +="<td>" + rs.getString("SALARIO")+ "</td>";
                    tabla +="</tr>";
                    salarios +=rs.getInt("SALARIO");
                }
                tabla +="</table>";
                %>
                <input type="button" value="Mostrar resumen" onclick="mostrarDatos()"/><br>
                <%=tabla%>
                <%}
            if(elementos!=null)                               {%>
                               <input type="hidden" name="txtelem" value="<%=elementos%>"/>
            <%}else
              {%>
            <input type="hidden" name="txtelem"/>
            <%}
            %>
        </form>
        
        </div>        
        <jsp:include page="menus/menu.jsp" flush="true"/>
    </body>
</html>
