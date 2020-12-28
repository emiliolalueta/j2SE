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
            	var accion = 0;
            	var num=document.form1.txtnumero.value;                
                var pagina = "accionesdepartamentos.jsp?cajaoculta=" + accion + "&txtnumero=" +num ;
                window.location.href = pagina;
            }
            
            function insertar()
            {                
            	var accion = 1;
            	var num=document.form1.txtnumero.value;      
            	var nom=document.form1.txtnombre.value;
            	var loc=document.form1.txtlocalidad.value; 
                var pagina = "accionesdepartamentos.jsp?cajaoculta=" + accion + "&txtnumero=" + num + "&txtnombre=" + nom + "&txtlocalidad=" + loc ;                
                window.location.href = pagina;
            }
            
            function modificar()
            {                
            	var accion = 2;
            	var num=document.form1.txtnumero.value; 
            	var nom=document.form1.txtnombre.value;
            	var loc=document.form1.txtlocalidad.value;
                var pagina = "accionesdepartamentos.jsp?cajaoculta=" + accion + "&txtnumero=" +num+ "&txtnombre=" + nom + "&txtlocalidad=" + loc ;
                window.location.href = pagina;
            }
            
            function eliminar()
            {                
            	var accion = 3;
            	var num=document.form1.txtnumero.value;                
                var pagina = "accionesdepartamentos.jsp?cajaoculta=" + accion + "&txtnumero=" +num ;
                window.location.href = pagina;
            }
            
            function seleccion(){
            	document.form1.submit();
            }
            
            </script>
    </head>
    <body>
        <form name="form1">
            <%
            String elemento = request.getParameter("cajaoculta");            
	        String numero="";
	        String nombre="";
	        String localidad=""; 

	        int nume;
	        numero=request.getParameter("txtnumero"); 
	        nombre=request.getParameter("txtnombre"); 
	        localidad=request.getParameter("txtlocalidad"); 
	        if(elemento !=null){
	            int caja=Integer.parseInt(elemento);
		          switch(caja)
		          {
		              case 0:   
		            	  nume=Integer.parseInt(numero);
		                  if (numero !=null){
		                  	try{
		                  		 nume=Integer.parseInt(numero);
		                  	}catch(Exception e){
		                  		 nume=0;
		                  	}
		                  	nombre=mibean.getNombre(nume);            
		                  	localidad=mibean.getLocalidad(nume);            
		                  }else{
		                  	numero="";
		                  }		                                    
		          	    break;                               
		              case 1:		            	  
		                   nume=Integer.parseInt(numero);
		                  if (numero !=null && nombre != null && localidad !=null){
		                  	try{
		                  		nume=Integer.parseInt(numero);
		                  	}catch(Exception e){
		                  		nume=0;
		                  	}
		                  		mibean.insertar(nume,nombre,localidad); 
		                  }		                                    
		                break;
		              case 2:
		            	  nume=Integer.parseInt(numero);
		                  if (numero !=null && nombre != null && localidad !=null){
		                  	try{
		                  		nume=Integer.parseInt(numero);
		                  	}catch(Exception e){
		                  		nume=0;
		                  	}
		                  		mibean.modificar(nume,nombre,localidad); 
		                  }
			            break;
		              case 3:
		            	  nume=Integer.parseInt(numero);
		            	  if (numero !=null){
			                  	try{
			                  		 nume=Integer.parseInt(numero);
			                  	}catch(Exception e){
			                  		 nume=0;
			                  	}
			                  	mibean.borrar(nume);            
			                  	        
			                  }else{
			                  	numero="";
			                  }		       
			            break;		                                
		              default: 
		             }       
            }
            
            
            %>
            <input type="text" name="txtcajaoculta" value="<%=elemento%>" /><br>
            <span>numero</span>
            <input type="text" name="txtnumero" value="<%=numero%>"/><br>
            <span>nombre</span>
            <input type="text" name="txtnombre" value="<%=nombre%>"/><br>
            <span>localidad</span>
            <input type="text" name="txtlocalidad" value="<%=localidad%>"/><br>    
            <input type="button" value="Buscar" onclick="buscar()" /><br>
            <input type="button" value="Insertar" onclick="insertar()" /><br>
            <input type="button" value="Modificar" onclick="modificar()" /><br>
            <input type="button" value="Eliminar" onclick="eliminar()" /><br>
            
        </form>
    </body>
</html>
