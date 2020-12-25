<%-- 
    Document   : graficosalarial
    Created on : 31-may-2011, 13:47:55
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
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
        <form name="form1" method="POST">
        <%
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("select distinct oficio from emp");
        String oficio=request.getParameter("cmboficio");
        %>
        <select name="cmboficio">
        <%while (rs.next())
        {
            if (oficio==null)
            {%>
               <option value='<%=rs.getString(1)%>'><%=rs.getString(1)%></option>                    
            <%}else{
                if(oficio.equals(rs.getString("oficio")))
                {
                    %>     
                    <option value='<%=rs.getString("oficio")%>'selected><%=rs.getString(1)%>                          
                    </option>                 
                <%}else{%>       
                    <option value='<%=rs.getString(1)%>'><%=rs.getString(1)%></option>                    
                <%}     
                }
          }
          rs.close();%>            
        </select>
        <input type="submit" value="Buscar"/> 
        
        <%if(oficio !=null){
            PreparedStatement pst=cn.prepareStatement("select apellido,salario from emp where oficio=?");
            pst.setString(1,oficio);
            rs=pst.executeQuery();
            while(rs.next())
                               {%>
                               <div> <%=rs.getString("apellido")%></div>
                               <table width='<%=rs.getInt("SALARIO")/1000%>'
                                      style="background-color: yellow">
                                   <tr><td> <%=rs.getString("salario")%></td></tr>
                               </table>
                               <%}
            rs.close();
                       }%>    
        
        </form>
        </div>        
        <jsp:include page="menus/menu.jsp" flush="true"/>
    </body>
</html>
