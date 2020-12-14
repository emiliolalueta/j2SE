<%-- 
    Document   : index
    Created on : 31-may-2011, 10:02:03
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>  
		<form name="form1" method="POST">     
        <span>Collatz</span>
        <input type="text" name="txtvalor" value="" />
        <input type="submit" value="Mostrar Serie" />
        <%        
        if(request.getParameter("txtvalor")!=null)
        {            
         %><ul><%
        int num=Integer.parseInt(request.getParameter("txtvalor"));       
        while(num!=1)
        {           
            if(num%2==0)
            {
            num=num/2;            
            }            
            else
            {
            num=num*3+1;            
            }%>
        <li><%=num%></li>
        <%}%>
        </ul>        
        <%}%>
        </form>
    </body>
</html>
