<%-- 
    Document   : peliculasporgeneros
    Created on : 06-jun-2011, 10:43:27
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.*"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" media="screen" href="estilo1.css" />
         <link href="../css/panel.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
    <div id="invisible"> 
    <jsp:include page="menus/horizontaldemas.jsp" flush="true"/><br><br><br>
        <%DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        	ResultSet rs = st.executeQuery("select * from generos");
        	String genero = request.getParameter("cmbgeneros");
        %>
        	<form name="form1" method="post" action="peliculasporgeneros.jsp">
            <select name="cmbgeneros">
                <%while (rs.next())
                {
                    if (genero!=null && genero.equals(rs.getString(1)))
                    {%>
<option value="<%=rs.getString(1)%>" SELECTED>"<%=rs.getString(2)%>"</option>
                  <%}else{%>
<option value="<%=rs.getString(1)%>">"<%=rs.getString(2)%>"</option>
                  <%}%>
                <%}%>
            </select>
            <input type="submit" value="Ver Peliculas">
        </form>
        <%
        if (genero!=null)
        {
PreparedStatement pst = cn.prepareStatement("select Titulo,foto from peliculas where idgenero=?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
          pst.setInt(1, Integer.parseInt(genero));
          rs = pst.executeQuery();
          rs.last();
          int ultimo = rs.getRow();
          rs.beforeFirst();
          int saltolinea=0;
        %>
<div style="text-align: left; color: #000000; background-color: #FFCC99;">Número de películas: <%=ultimo%></div>
         <table border="1">
        	<%
            while (rs.next())
            {
                if (saltolinea==3)
                {
                    saltolinea=0;%>
                    <tr>
           <%}%>
                        <td><%=rs.getString(1)%></td>
                        <td>
<img src="img/CARTELES/<%=rs.getString(2)%>" alt="<%=rs.getString(1)%>" width="50" height="70">
                        </td>
            <%if (saltolinea==3)
                {%>
                    </tr>
           <%}%>
            <%saltolinea++;
            }%>
        </table>
      <%}%>
       </div>        
        <jsp:include page="menus/menu.jsp" flush="true"/>
    </body>
</html>
