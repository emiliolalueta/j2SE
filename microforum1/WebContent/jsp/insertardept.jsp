<%-- 
    Document   : insertardept
    Created on : 31-may-2011, 11:41:37
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.CallableStatement"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    
    <!-- 
     CREAR EL PROCEDIMIENTO EJECUTANDO ESTO EN ORACLE
    /***********************************************
CREATE OR REPLACE PROCEDURE insertar_departamentos
(num dept.dept_no%type,nom dept.dnombre%type,loc dept.loc%type) as
        BEGIN                 
                insert into dept VALUES(num,nom,loc);  
                commit;
        END;        
***************************************/    
     -->
    
        <form  method="get">
        <span>Numero</span>
        <input type="text" name="txtnumero" value="" /><br>
        <span>Nombre</span>
        <input type="text" name="txtnombre" value="" /><br>
        <span>Localidad</span>
        <input type="text" name="txtlocalidad" value="" /><br>
        <input type="submit" value="Insertar" />
        
        
        <% //action="form1"
        String deptno = request.getParameter("txtnumero");
        String nombre = request.getParameter("txtnombre");
        String localidad = request.getParameter("txtlocalidad");
        if(request.getParameter("txtnombre") !=null && 
        	request.getParameter("txtlocalidad") !=null && 
        	request.getParameter("txtnumero") !=null){        
        
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
               
        Statement s=cn.createStatement();
        ResultSet r=s.executeQuery("select count(dept_no) as cuenta from dept");
        int contador;
        r.next();
        contador=r.getInt("cuenta");
        
       
        CallableStatement cst=cn.prepareCall("{call insertar_departamentos(?,?,?)}");
        
        cst.setInt(1,contador+10 );  
        cst.setString(2, nombre);
        cst.setString(3,localidad);
        
        cst.registerOutParameter(1, java.sql.Types.INTEGER);
        cst.registerOutParameter(2, java.sql.Types.NVARCHAR);
        cst.registerOutParameter(3, java.sql.Types.NVARCHAR);
        cst.execute();
        
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("select dnombre,loc from dept");
        %><table border="6"><%
        while (rs.next())
                       {%>                       
                           <tr>
                               <td><%=rs.getString("dnombre")%></td>
                               <td><%=rs.getString("loc")%></td>                               
                           </tr>                      
                      
            <%}
        	%><table/><%
            rs.close();%>       
        <%}%>
        
        </form>
    </body>
</html>
