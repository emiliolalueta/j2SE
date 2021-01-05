<%-- 
    Document   : index
    Created on : 31-may-2011, 10:02:03
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><title>Ejemplo </title><meta charset="utf-8">

<style type="text/css"> 
	body {margin-left:30px; font-family: sans-serif;} 
	h4 {margin:0;} 
	div {float:left;}
	.estiloForm, #validacionDatos {background-color: #f3f3f3; border: solid 2px black; margin-left:10px; width:300px; }
	.estiloForm{ width: 330px; padding:10px;} 
	#validacionDatos {height:226px; padding:10px; background-color: yellow;}
	.estiloForm label {display: block; width: 120px; float: left; text-align:right; margin-bottom: 35px; padding-right: 20px;}
	br {clear: left;} 
	input[type="submit"], input[type="reset"] {margin:25px 5px 10px 5px;}
</style>

<script type="text/javascript">
window.onload = function () {
                formularioContacto.addEventListener("submit", validarFormulario);
                document.getElementById('validacionDatos').style.visibility = 'hidden';
                formularioContacto.addEventListener("change", ocultarAvisos);
}
 
function ocultarAvisos() {document.getElementById('validacionDatos').style.visibility = 'hidden';}
 
function validarFormulario(elEvento) {
elEvento.preventDefault(); //Impedir envío del formulario hasta que se realice la validación
var msgValidacion = '';
var casillaDatos = document.getElementById('validacionDatos'); //Nodo donde vamos a mostrar la validación de datos
casillaDatos.innerHTML = '<h4> Aviso datos a revisar o corregir: </h4>';
var radioButTrat = document.getElementsByName("tratamiento"); //Nodos radio buttons
var checkboxElements = new Array();
var elementosSelect = document.getElementsByTagName('select');
var elementosDelForm = document.getElementsByTagName('input'); //Elementos input
 
/*Validación de que se haya elegido un radio button*/
var radioButElegido = false;
for (var i=0; i<radioButTrat.length; i++) {if (radioButTrat[i].checked == true) { radioButElegido=true;} }
if (radioButElegido == false){msgValidacion = msgValidacion+'<p>(*) No hay elegido tratamiento sr. o sra. </p> ';}
/*Validación de que los campos input text no estén vacíos*/
var textosConformes = true;
for(var i=0; i<elementosDelForm.length;i++) {
                if (elementosDelForm[i].type == 'text' && elementosDelForm[i].value=='') {
                               msgValidacion = msgValidacion+'<p>(*) Campo '+ elementosDelForm[i].name +' está vacío </p> ';
                               textosConformes = false;
                }
}
 
/*Validación de que se haya elegido un elemento del select */
var ciudadElegida = true; indiceElegido = document.getElementById('ciudad').selectedIndex;
if( indiceElegido == null || indiceElegido == 0 ) {
msgValidacion = msgValidacion+'<p>(*) No hay elegida una ciudad. </p> ';
ciudadElegida = false;
}
 
/*Validación de que se haya elegido un checkbox*/
                for(var i=0; i<elementosDelForm.length;i++) {
                               if (elementosDelForm[i].type == 'checkbox') {checkboxElements.push(elementosDelForm[i]);}
                }
var checkboxMarcado = false;
for (var i=0; i<checkboxElements.length;i++) {
                if (checkboxElements[i].checked ==true) {checkboxMarcado=true;}
}
if (checkboxMarcado==false) {msgValidacion = msgValidacion+'<p>(*) No hay elegida ninguna preferencia </p> ';}
 
/*Decisión final: mostrar avisos si hay fallos o enviar el formulario si está correcto*/
if (radioButElegido == false || checkboxMarcado == false || textosConformes == false || ciudadElegida == false ) {
document.getElementById('validacionDatos').style.visibility = 'visible';
casillaDatos.innerHTML= casillaDatos.innerHTML+msgValidacion;
}
else { alert ('Se ha realizado la validación de datos y es conforme, se procede al envío del formulario');
document.forms['formularioContacto'].submit(); }
}
</script></head>

<body><h2>Validacion formulario</h2><h3>Ejemplos JavaScript</h3>

    <div class="estiloForm">

        <form name ="formularioContacto" method="get" action="http://aprenderaprogramar.com">

        <label>Tratamiento</label> <input type="radio" name="tratamiento" id="tratarSr" value="Sr."/>Sr.

       <input type="radio" name="tratamiento" id ="tratarSra" value="Sra."/>Sra.<br/>

       <label>Nombre</label><input id="nombre" name="nombre" type="text"/><br/>

        <label>Apellidos</label><input id="apellidos" name="apellidos" type="text"/><br/>

        <label>Dirección</label><input id="direccion1" name="direccion1" type="text"/><br/>

        <label>Ciudad</label><select id="ciudad" name="ciudad"><option value="">Elija opción</option>

            <option value="Mexico">México D.F. (MX)</option>   <option value="Madrid">Madrid (ES)</option>

            <option value="Santiago">Santiago (CL)</option>

        </select><br/>

                <label>Preferencias</label><input name="Libros" type="checkbox" />Libros

                <input name="Peliculas" type="checkbox"  />Películas

                <input type="submit" value="Enviar"/> <input type="reset" value="Cancelar"/>

                </form>

    </div>

<div style="float:left;"><div id="validacionDatos" style="float:left;"><h4> Aviso datos a revisar o corregir: </h4></div>

</div></body></html>