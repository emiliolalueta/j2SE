<%-- 
    Document   : verdatoseleccionados
    Created on : 07-jun-2011, 12:29:23
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
 <%@page import="java.sql.*, java.util.*" %>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="newcss.css">
        <script language="javascript" type="text/javascript">
        
            function mostrarDatos()
            {            	
                //valor del departamento
                var dept = document.form1.cmbdept.options[document.form1.cmbdept.selectedIndex].value;
                var elem = document.form1.txtelem.value;
                var pagina = "departamentosempleadoscheck.jsp?datos=1&txtelem=" + elem + "&cmbdept=" + dept;
                window.location.href = pagina;
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form1" method="get">
        <h1>Datos de empleados</h1>
        <%
        //Combo tiene el departamento
        String dept_no = request.getParameter("cmbdept");

        String elementos = request.getParameter("txtelem");
        String[] seleccionados = request.getParameterValues("chkemp");
        /*for(int i=0; i<seleccionados.length; i++){
            out.println("<pre> "+seleccionados[i]+"</pre>");
         }*/
        System.out.println("<pre> "+ seleccionados + "</pre>");
        
        ArrayList<String> listaempleados = new ArrayList<String>();
        ArrayList<String> listaaux = new ArrayList<String>();
        
        if (seleccionados != null)
        {
            for (String d: seleccionados)
            {
                listaaux.add(d);
            }
        }
        
        if (elementos != null)
        {
            String[] datos = elementos.split(",");
            for (String d: datos)
            {
                if (listaaux.indexOf(d) == -1)
                {
                    listaaux.add(d);
                }
            }
            elementos = "";
        }

        for (String s:listaaux)
        {
            if (listaempleados.indexOf(s)==-1)
            {
                listaempleados.add(s);
            }
        }
        for (String elem:listaempleados)
        {
            elementos = elementos + elem + ",";
        }

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection cn = DriverManager.getConnection
        ("jdbc:oracle:thin:@localhost:1521:XE", "BBDD", "BBDD");
        String consulta = "select DEPT_NO, DNOMBRE FROM DEPT";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(consulta);
        
        String combo = "<select name='cmbdept' onchange='document.form1.submit()'>";  
        while (rs.next())
        {
            combo += "<option value='"+rs.getString("DEPT_NO")+"'";
            if (dept_no != null)
            {
                if (dept_no.equals(rs.getString("DEPT_NO")))
                {
                    combo += " selected";
                }
            }else{
            	dept_no=rs.getString("DEPT_NO");
            	combo += " selected";
            }
            combo += ">" + rs.getString("DNOMBRE") + "</option>";
        }
        combo += "</select><hr>";
        rs.close();
        %>
        Departamentos <%=combo%>

        <%
        //if (request.getParameter("datos")!= null)
        if (request.getParameter("chkemp")!= null)	
        
        {
            elementos = elementos.substring(0,elementos.lastIndexOf(","));            
            consulta = "SELECT COUNT(EMP_NO) AS PERSONAS, SUM(SALARIO) AS SUMA, AVG(SALARIO) AS MEDIA FROM EMP WHERE DEPT_NO IN (" + request.getParameter("cmbdept") + ") AND EMP_NO IN (" + request.getParameter("chkemp") + ")";
            rs = st.executeQuery(consulta);
            Double personas, suma, media;
            rs.next();
            personas = rs.getDouble("PERSONAS");
            suma = rs.getDouble("SUMA");
            media = rs.getDouble("MEDIA");
            rs.close();
            elementos = elementos + ",";
        %>
            <table border="1">
                <tr>
                    <th>Personas</th>
                    <td>
                        <input type="text" value="<%=personas%>" name="txtpersonas"/>
                    </td>
                </tr>
                <tr>
                    <th>Suma Salarial</th>
                    <td>
                        <input type="text" value="<%=suma%>" name="txtsuma"/>
                    </td>
                </tr>
                <tr>
                    <th>Media Salarial</th>
                    <td>
                        <input type="text" value="<%=media%>" name="txtmedia"/>
                    </td>
                </tr>
            </table>
        <%}
        if (dept_no != null)
        {
            consulta = "select emp_no, apellido, salario from emp where dept_no=?";
            PreparedStatement pst = cn.prepareStatement(consulta);
            pst.setString(1, dept_no);
            rs = pst.executeQuery();
            String tabla = "<br><table border='1'>";
            tabla += "<tr><th></th><th>APELLIDO</th><th>SALARIO</th></tr>";
            int salarios = 0;
            while (rs.next())
            {
                tabla += "<tr>";
                tabla += "<td>";
                tabla += "<input type='checkbox' name='chkemp' value='" + rs.getString("EMP_NO") + "'";
                if (listaempleados.indexOf(rs.getString("EMP_NO"))!= -1)
                {
                    tabla += " checked";
                }
                tabla += "/>";
                tabla += "</td>";
                tabla += "<td>"+rs.getString("APELLIDO")+"</td>";
                tabla += "<td>"+rs.getString("SALARIO")+"</td>";
                tabla += "</tr>";
                salarios += rs.getInt("SALARIO");
            }
            tabla += "</table>";
        %>
        <input type="submit" value="Mostrar resumen" onclick="mostrarDato()"/><br>
        <%=tabla%>
        <%}
        if (elementos!=null)
        {%>
            <input type="text" name="txtelem" value="<%=elementos%>"/>
       <%}else
        {%>
            <input type="text" name="txtelem"/>
        <%}
        %>
        </form>
    </body>
</html>
