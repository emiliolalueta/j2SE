<%-- 
    Document   : primerjsp
    Created on : 31-may-2011, 8:40:38
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
        <h1>Hello World!</h1>
        <div style="float:left">
            <%@include file="pagina.html"%>
        </div>    
        <div style="float:left;background-color: yellow">
            <h1>Primer jsp</h1>
            <%for (int i=1;i<7;i++)
            {
                %>
                <h<%=i%>>Mensaje <%=i%> </h<%=i%>>
                
                <input type="text" name="txtpar" value="" />
                <input type="sumit" value="ver par" />
                <%if (request.getParameter("txtpar")!=null)
                {
                        int num=Integer.parseInt(request.getParameter("txtpar"));
                        if(num%2==0)
                        {%>
                            <h1>Es par </h1>
                        <%}else {%>                
                        <h1>Es impar</h1>              
               
                        <%}
                        
                }
                }%>              
                        
                 
        </div>
    </body>
</html>
