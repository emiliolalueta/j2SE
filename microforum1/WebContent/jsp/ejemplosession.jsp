<%-- 
    Document   : ejemplosession
    Created on : 08-jun-2011, 9:40:23
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.sql.*,java.lang.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="../css/panel.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
    <div id="invisible"> 
    <jsp:include page="menus/horizontaldemas.jsp" flush="true"/><br><br><br>
    <center>
        <form name="jubilados" action="ejemplosession.jsp" method="POST">
            <%
            Statement sentencia;
            ResultSet registros;
            String consulta;
            int num=0;
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
            sentencia=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            consulta="select salario,apellido from emp";
            registros=sentencia.executeQuery(consulta);
            int posicion=1;
            if(request.getParameter("pos")!=null)
            {
                posicion=Integer.parseInt(request.getParameter("pos"));
            }
            registros.last();
            num=registros.getRow();
            registros.absolute(posicion);
            %>
            <center><h3>Jubilar empleados</h3></center><br><br>
            <table border="6" align="center" bgcolor="yellow">
                <%
                for(int i=0;i<3&&!registros.isAfterLast();i++)
                {%>
                <tr><td><input type="checkbox" name="empleados" value=<%=registros.getString(1)%>></td>
                <td><%=registros.getString(2)%></td>
                </tr>
                <%registros.next();
                }%>
             </table>
                <table border="6"><tr><%
                        int numpagina=1;
                        for(int i=0;i<num;i+=3)
                        {%>
                        <td><a href=ejemplosession.jsp?valor=3&pos=<%=i+1%>><%=numpagina%></a></td>
                        <%numpagina++;                    
                }%>
                    </tr>
                </table>
                <br><br>
                <center><input type="submit" name="anadir" value="AÑADIR">
                </center>                  
        </form>
                <form name ="form2" action="ahorro.jsp" method="post">
                    <input type="submit" name="suma" value="SUMA AHORRO">
                    <%cn.close();%>
                </form>
                    <%
                    HttpSession sesion=request.getSession();
                    int ahorroEmp=0;
                    String ahorroSesion="";
                    String[] salario=null;
                    if(sesion.getAttribute("ahorro")!=null)
                    {
                        ahorroSesion=sesion.getAttribute("ahorro").toString();
                        ahorroEmp=Integer.parseInt(ahorroSesion);
                        if(request.getParameterValues("empleados")!=null)
                        {
                            salario=request.getParameterValues("empleados");
                            for (int i=0;i<salario.length;i++)
                            {
                                ahorroEmp +=Integer.parseInt(salario[i]);
                            }
                            sesion.setAttribute("ahorro",String.valueOf(ahorroEmp));
                        }
                    }else
                    {
                        sesion.setAttribute("ahorro",String.valueOf(ahorroEmp));
                    }%>
    </center>
    </div>
        
        <jsp:include page="menus/menu.jsp" flush="true"/>
    </body>
</html>
