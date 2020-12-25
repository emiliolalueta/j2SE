<%-- 
    Document   : index
    Created on : 25-may-2011, 9:28:42
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Men&uacute; en arbol accesible</title>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />		
    </head>
    <body>
        <center><h1>Jsp</h1></center>
        
        
<div style="float: right;margin-right:70px;border: 1px solid #006699;border: 1px solid #000000;
-moz-border-radius: 7px;
-webkit-border-radius: 7px;
padding: 10px;width: 900px;">

<jsp:include page="../menus/horizontalotro.jsp" flush="true"/>
<br><br><br>
<div> 
<center><h5>Enlaces de interés</h5></center>
<ul>
<li><h4>Esta es una página de ejercicios que hice en Microforum y demas ejemplos que voy recopilando.</h4></li>
<li><h4>He cambiado el diseño de la página pero los ejercicios son los mismos.</h4></li>
<li><h4>En las carpetas <strong>"Ejercicios en revisión"</strong> están los ejercicios pendientes de probar.</h4></li>
<li><h4> Hazte PULL de vez  en cuando para bajar los cambios.</strong> </h4></li>

</ul>
</div>

<br><br><br>
</div>


<jsp:include page="../menus/menuotro.jsp" flush="true"/>

</body>
</html>
