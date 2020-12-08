<%-- 
    Document   : doctores
    Created on : 01-jun-2011, 12:01:46
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
    <body>
        <form name="form1" method="post">
        <h1>Doctores del Hospital (En revision)</h1>
        <%
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("select nombre,hospital_cod from hospital");
        ArrayList<String> cod=new ArrayList<String>();
        String[] datos;
        datos = request.getParameterValues("hospital_cod");
        if (datos != null)
        {
            for (String d: datos)
            {
                cod.add(d);
            }
        }
        while (rs.next())
            {%>                       
              <input type="checkbox" name="hospital" value='<%=rs.getString("hospital_cod")%>'/>
            <%=rs.getString("nombre")%><br>
                       <%}
        rs.close();%>
        <input type="submit" value="Mostrar doctores"/>                   
        <%if(!cod.isEmpty()){
        %><table><%
        String param=" ";
            for(int c=-1;c<=datos.length;c++)
            {
                param +=datos [c] + ",";
            }    
              param=param.substring(0,param.lastIndexOf(","));
              String consulta="select apellido,especialidad,salario from doctor where hospital_cod in (param)";
            //Statement st=cn.Statement(consulta);
            //pst.setString(1,cod.get(c));
             rs=st.executeQuery(consulta);           
            while(rs.next())
                 {%>                                
                    <tr>
                        <td> <%=rs.getString("apellido")%></td>
                        <td> <%=rs.getString("especialidad")%></td>
                        <td> <%=rs.getString("salario")%></td>
                    </tr>
                               
                 <%}           
            
            rs.close();
           %> 
            </table>
           <%}%>    
        </form>       
    </body>
</html>
