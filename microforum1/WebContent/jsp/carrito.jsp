<%-- 
    Document   : carrito
    Created on : 08-jun-2011, 11:56:38
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.sql.*,java.lang.*"%>
<!DOCTYPE html>
<html>
    <head>    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="lightblue">
    <center>
        <form name="jubilados" action="carrito.jsp" method="POST">
            <%
            Statement sentencia;
            ResultSet registros;
            String consulta;
            int num=0;
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
            sentencia=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            consulta="select titulo,precio from peliculas";
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
            <center><h3>Peliculas</h3></center><br><br>
            <table border="8" align="center" bgcolor="yellow">
                <%
                for(int i=0;i<5&&!registros.isAfterLast();i++)
                {%>
                <tr><td><input type="checkbox" name="empleados" value=""></td>
                <td><%=registros.getString(1)%></td>
                <td><%=registros.getString(2)%></td>
                </tr>
                <%registros.next();
                }%>
            </table><br><br>
            <table border="8"><tr><%
                        int numpagina=1;
                        for(int i=0;i<num;i+=3)
                        {%>
                        <td><a href=carrito.jsp?valor=3&pos=<%=i+1%>><%=numpagina%></a></td>
                        <%numpagina++;                    
                        }%>
                    </tr>
            </table>
                <br><br>
                <center><input type="submit" name="anadir" value="Comprar peliculas"></center>                  
        </form>
                <form name ="form2" action="compra.jsp" method="post">
                    <input type="submit" name="suma" value="ver carrito compra">
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
    </body>
</html>
