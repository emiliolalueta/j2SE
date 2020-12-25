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
        <link href="../css/panel.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
    
    <div id="invisible"> 
    <jsp:include page="menus/horizontaldemas.jsp" flush="true"/><br><br><br>
    	<form name="form1" method="POST">   
        <h1>Hello World!</h1>
        <div style="float:left">
            <%@include file="pagina.html"%>
        </div>    
        <div style="float:left;background-color: yellow">
            <h1>Primer jsp</h1>
            <%
            String texto="";
            for (int i=1;i<7;i++)
            {
                %>
                <h<%=i%>>Mensaje <%=i%> </h<%=i%>>
                
                <input type="text" name="txtpar" value="" />
                <input type="submit" value="ver par" />
                
                <%= new java.util.Date().toString() %>
                <%
                
                if (request.getParameter("txtpar")!=null)
                {
                        int num=Integer.parseInt(request.getParameter("txtpar"));
                        if(num%2==0)
                        {%>
                            <h1>Es par</h1>                            
                        <%}else {%>                                    
               				<h1>Es impar</h1>               				
                        <%}
                }                
           }%>  
                 
        </div>
      </form>   
      
      </div>
        
      <jsp:include page="menus/menu.jsp" flush="true"/>
      
    </body>
</html>
