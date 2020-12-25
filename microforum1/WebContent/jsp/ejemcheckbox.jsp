<%-- 
    Document   : ejemcheckbox
    Created on : 01-jun-2011, 9:54:24
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
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
        <%String[] datos=request.getParameterValues("chkfruta");%>
        <%ArrayList<String> vfrutas=new ArrayList<String>();%>
        <%String[]frutas=new String[]{"coco","Manzana","Papaya","Platano"};%>
        <table border="20">
            <form name="form1" method="post">
                <%if (datos==null)
                {
                    for(int i=0;i<frutas.length;i++)
                         {%>
                            <tr><td><input type="checkbox" name="chkfruta" value="<%=frutas[i]%>"><%=frutas[i]%></td></tr>                            
                         <%}
                }else{
                            for (int i=0;i<datos.length;i++)
                            {
                                vfrutas.add(datos[i]);
                            }
                            for (int i=0;i<frutas.length;i++)
                            {
                                 if(vfrutas.indexOf(frutas[i])==-1)
                                {%>
                                    <tr><td><input type="checkbox" name="chkfruta"
                                    value="<%=frutas[i]%>"><%=frutas[i]%></td></tr>
                                    <%}else{%>
                                    <tr><td><input type="checkbox" name="chkfruta" checked value="<%=frutas[i]%>"><%=frutas[i]%></td></tr>
                                    <%}%>
                                    <%}
                                    }%>
                                    <tr><td><input type="submit" name="btnenviar" value="Enviar Datos"></td></tr>
                            
            </form>           
        </table>                  

        <%
        if(datos!=null)
        {
          for(int i=0;i<datos.length;i++)
                           {%>
                           <div style="background-color:fuchsia">
                           Elementos seleccionados:<%=datos[i]%>
                           </div>
                          <%}          
        }
        %>
        
        </div>
        
        <jsp:include page="menus/menu.jsp" flush="true"/>
    </body>
</html>
