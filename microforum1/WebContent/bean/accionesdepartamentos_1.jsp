<%-- 
    Document   : accionesdepartamentos
    Created on : 10-jun-2011, 11:41:02
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="mibean" scope="page" class="paquetebeans.accionesdepartamentos"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <script languaje="JavaScript">
            function enviarDatos(num,nom,loc)
            {
                document.form1.txtnumero.value=num;
                document.form1.txtnombre.value=nom;
                document.form1.txtlocalidad.value=loc;
                document.form1.submit();
            }
            function buscar()
            {
               //document.form1.txtnumero.value=num;
               //document.form1.txtnombre.value=nom;
               //document.form1.txtlocalidad.value=loc; 
               document.form1.txtcajaoculta.value="a"; 
               document.form1.submit();
            }     
            function insertar()
            {
                document.form1.txtcajaoculta.value="b";
                document.form1.submit();
            }
            function modificar()
            {
                document.form1.txtcajaoculta.value="c";
                document.form1.submit();
            }
            function eliminar()
            {
                document.form1.txtcajaoculta.value="d";
                document.form1.submit();
            }
            </script>
    </head>
    <body>
        <form name="form1">
            <%String numero=""; %>
            <span>numero</span>
            <input type="text" name="txtcajaoculta" value="<%=numero%>"/><br>
            <input type="text" name="txtnumero" value="<%=numero%>"/><br>
            <span>nombre</span>
            <input type="text" name="txtnombre" value=""/><br>
            <span>localidad</span>
            <input type="text" name="txtlocalidad" value=""/><br>    
            <input type="submit" value="Buscar" onclick="buscar(numero,nombre,localidad)" /><br>
            <input type="submit" value="Insertar" onClick="insertar()" /><br>
            <input type="submit" value="Modificar" onClick="modificar()" /><br>
            <input type="submit" value="Eliminar" onClick="eliminar()"/><br>  
            
            
            
            <%
            numero=request.getParameter("txtnumero"); 
            int n;
            if (numero !=null){
            	try{
            		 n=Integer.parseInt(numero);
            	}catch(Exception e){
            		 n=0;
            	}
            	String nombre=mibean.getNombre(n);            
            	String localidad=mibean.getLocalidad(n);            
            }
            //char cajaoculta=request.getParameter("txtcajaoculta"));
            
           // int caja=String.valueOf(cajaoculta);        
           // switch(cajaoculta)
            //{
            //                   case 0:
                                   
           //                    break;                               
           //                    case 1:
                                   
            //                   break;
                               
             //                  default: 
            //}
            %>
            
            
            
                      
            <%=numero%>
        </form>
    </body>
</html>
