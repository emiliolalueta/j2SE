<%-- 
    Document   : salariomayor
    Created on : 09-jun-2011, 14:29:06
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true" errorPage="/errores.jsp"%>
<!DOCTYPE html>
<jsp:useBean id="mibean" scope="page" class="paquetebeans.buscasalario"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script languaje="JavaScript">
            function enviarDatos(tipo)
            {
                document.form1.txtaccion.value=tipo;
                document.form1.submit();
            }
        </script>
    </head>
     <body>
        <form name="form1" method="POST">     
        Apellido:<input type="text" name="txtapellido" value="" />
        <input type="submit" value="Mostrar salario" onClick="enviarDatos('apellido')"/>
        <input type="hidden" name="txtaccion"/>
        <%    
        String fallo="";
        
            String accion=request.getParameter("txtaccion");
            int salario=0;
            if(accion !=null)//if(ape !=null)
            {
                if(accion.equals("apellido"))//if(salario==-1)
                {
                        String ape = request.getParameter("txtapellido");
                        String resultado="";
                        salario=mibean.getSalario(ape);
                        if (salario == -1)
                        {
                            resultado="<h1>sin resultado</h1>";
                        }
                        else
                        {
                            resultado += "<h1>Salario: " + salario + "</h1>";
                            resultado += "<input type='submit' value='ver salarios mayores' onClick='enviarDatos(\"salario\")'/>";
                            resultado +="<input type='hidden' value='"+salario +"' name='txtsal();ario'/>";
                        }%>
                        <%=resultado%>
                <%}
                if(accion.equals("salario"))
                    {
                        int num=Integer.parseInt(request.getParameter("txtsalario"));
            %>
                        <%=mibean.getsalariomayor(num)%>;
                   <%}
               }
        
        
       if(!fallo.equals(""))
       {%>
         //<jsp:forward page="errores.jsp?error=Redireccion"/>
        <%}%> 
        </form>
    </body>
</html>
