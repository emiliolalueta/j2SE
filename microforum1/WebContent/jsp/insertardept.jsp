<%-- 
    Document   : insertardept
    Created on : 31-may-2011, 11:41:37
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.CallableStatement"%>
/***********************************************
CREATE OR REPLACE PROCEDURE insertar_departamentos
(num out int,nom dept.dnombre%type,loc dept.loc%type) as
        BEGIN                 
                insert into dept VALUES(num,nom,loc);  
                commit;
        END;        
***************************************/

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="form1" method="POST">
        <span>Numero</span>
        <input type="text" name="txtnumero" value="" /><br>
        <span>Nombre</span>
        <input type="text" name="txtnombre" value="" /><br>
        <span>Localidad</span>
        <input type="text" name="txtlocalidad" value="" /><br>
        <input type="submit" value="Insertar" />
        
        
        <%DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
        
        
       
        CallableStatement cst=cn.prepareCall("{call insertar_departamentos(?,?,?)}");
        String deptno = request.getParameter("txtnumero");
        String nombre = request.getParameter("txtnombre");
        String localidad = request.getParameter("txtlocalidad");
        cst.setInt(1, Integer.parseInt(deptno));
        cst.setString(2, nombre);
        cst.setString(3,localidad);
        cst.registerOutParameter(1, java.sql.Types.INTEGER);
        cst.registerOutParameter(2, java.sql.Types.NVARCHAR);
        cst.registerOutParameter(3, java.sql.Types.NVARCHAR);
        cst.execute();
        
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("select nombre,hospital_cod from hospital");
        while (rs.next())
                       {%>
                       <table border="6">
                           <td>
                               <tr>
                                    <%=rs.getString("dept_no")%>
                               </tr>
                               <tr>
                                    <%=rs.getString("dept_no")%>
                                </tr>
                                <tr>
                                    <%=rs.getString("dept_no")%>
                                </tr>    
                           </td>
                       <table/>
                      
                       <%}
                    rs.close();%>       
        
        
        </form>
    </body>
</html>
