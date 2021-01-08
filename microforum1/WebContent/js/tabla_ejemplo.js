
window.onload = function () 
{
	document.getElementById("numempleado").addEventListener("blur", validarEmpleado);
	document.getElementById("cajaApellido").addEventListener("blur", validarApellido);
	document.getElementById("Comboficio").addEventListener("blur", validarOficio);
	document.getElementById("ComboDirector").addEventListener("blur", validarDirector);
	//document.getElementById("cajaFecha").addEventListener("blur", validarFecha);
	document.getElementById("cajaSalario").addEventListener("blur", validarSalario);
	document.getElementById("cajaComision").addEventListener("blur", validarComision);
	document.getElementById("ComboDepartamentos").addEventListener("blur", validarDepartamentos);
//	document.form.addEventListener("submit", validar);
//	form.addEventListener("change", ocultarAvisos);
}
function ocultarAvisos() 
{
	document.getElementById('empleado').style.visibility = 'hidden';
	document.getElementById('Apellido').style.visibility = 'hidden';
	document.getElementById('Oficio').style.visibility = 'hidden';
	document.getElementById('Director').style.visibility = 'hidden';
	document.getElementById('Fecha').style.visibility = 'hidden';
	document.getElementById('Salario').style.visibility = 'hidden';
	document.getElementById('Comision').style.visibility = 'hidden';
	document.getElementById('Departamentos').style.visibility = 'hidden';
	
}
function validarEmpleado(elEvento){
	
	var empleado = document.getElementById('empleado'); //Nodo donde vamos a mostrar la validación de datos
	var numempleado = document.getElementById('numempleado');
	empleado.innerHTML = '';
	var valor = numempleado.value;
	var retorno =true;
	if (/^[1-9]\d$/.test(numempleado.value)==false || valor==''){
		document.getElementById('empleado').style.visibility = 'visible';
		empleado.innerHTML = '<h7>Numero empleado tiene que ser numerico </h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}
function validarApellido(elEvento){
	
	var cajaApellido = document.getElementById('cajaApellido'); //Nodo donde vamos a mostrar la validación de datos
	var Apellido = document.getElementById('Apellido');
	Apellido.innerHTML = '';
	var valor = cajaApellido.value;
	var retorno =true;
	if (valor=='' || valor==null){
		document.getElementById('Apellido').style.visibility = 'visible';
		Apellido.innerHTML = '<h7>Apellido esta vacio</h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}
function validarOficio(elEvento){
	
	var indiceElegido = document.getElementById('Comboficio').selectedIndex;
	var Oficio = document.getElementById('Oficio');
	var retorno =true;
	Oficio.innerHTML = '';
	if( indiceElegido == null || indiceElegido == 0) {
		document.getElementById('Oficio').style.visibility = 'visible';
		Oficio.innerHTML = '<h7>Oficio no esta elegido</h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}
function validarDirector(elEvento){
	
	var indiceElegido = document.getElementById('ComboDirector').selectedIndex;
	var Director = document.getElementById('Director');
	var retorno =true;
	Director.innerHTML = '';
	if( indiceElegido == null || indiceElegido == 0) {
		document.getElementById('Director').style.visibility = 'visible';
		Director.innerHTML = '<h7>Director no esta elegido</h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}
function validarFecha(elEvento){
	
	var cajaFecha = document.getElementById('cajaFecha'); //Nodo donde vamos a mostrar la validación de datos
	var Fecha = document.getElementById('Fecha');
	Fecha.innerHTML = '';
	var valor = cajaFecha.value;
	var retorno =true;
	if (/^\d{1,2}\/\d{1,2}\/\d{2,4}$/.test(Fecha.value)==false || valor==''){
		document.getElementById('Fecha').style.visibility = 'visible';
		Fecha.innerHTML = '<h7>Formato fecha invalida dd/mm/yy</h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}
function validarSalario(elEvento){
	
	var cajaSalario = document.getElementById('cajaSalario'); //Nodo donde vamos a mostrar la validación de datos
	var salario = document.getElementById('Salario');
	salario.innerHTML = '';
	var valor = cajaSalario.value;
	var retorno =true;
	if (!(/^[-+]?\d*\.?\d*$/.test(cajaSalario.value)) || valor==''){
		document.getElementById('Salario').style.visibility = 'visible';
		salario.innerHTML = '<h7>Salario tiene que ser numerico </h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}
function validarComision(elEvento){
	
	var cajaComision = document.getElementById('cajaComision'); //Nodo donde vamos a mostrar la validación de datos
	var comision = document.getElementById('Comision');
	comision.innerHTML = '';
	var valor = cajaComision.value;
	var retorno =true;
	if (!(/^[-+]?\d*\.?\d*$/.test(cajaComision.value)) || valor==''){
		document.getElementById('Comision').style.visibility = 'visible';
		comision.innerHTML = '<h7>Comision tiene que ser numerico </h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}

function validarDepartamentos(elEvento){
	
	var indiceElegido = document.getElementById('ComboDepartamentos').selectedIndex;
	var Departamentos = document.getElementById('Departamentos');
	var retorno =true;
	Departamentos.innerHTML = '';
	if( indiceElegido == null || indiceElegido == 0) {
		document.getElementById('Departamentos').style.visibility = 'visible';
		Departamentos.innerHTML = '<h7>Departamentos no esta elegido</h7>';
		elEvento.preventDefault();
		retorno=false;
	}
	return retorno;
}

function validar(elEvento){
	validarEmpleado(elEvento);
	validarApellido(elEvento);
	validarOficio(elEvento);
	validarDirector(elEvento);
	//validarFecha(elEvento)
	validarSalario(elEvento);
	validarComision(elEvento);
	validarDepartamentos(elEvento);
}

function quitar_error(){
	 document.getElementById("empleado").innerHTML="";
	 document.getElementById("Apellido").innerHTML="";
	 document.getElementById("Oficio").innerHTML="";
	 document.getElementById("Director").innerHTML="";
	 document.getElementById("Fecha").innerHTML="";
	 document.getElementById("Salario").innerHTML="";
	 document.getElementById("Comision").innerHTML="";
	 document.getElementById("Departamentos").innerHTML="";

	 document.getElementById("numempleado").value="";
	 document.getElementById("cajaApellido").value="";
	 document.getElementById("Comboficio").innerHTML=document.getElementById("oculto").value;;
	 document.getElementById("ComboDirector").innerHTML=document.getElementById("oculto2").value;;
	 document.getElementById("cajaFecha").value="";
	 document.getElementById("cajaSalario").value="";
	 document.getElementById("cajaComision").value="";
	 document.getElementById("ComboDepartamentos").innerHTML=document.getElementById("oculto3").value;
}

function desahabilitar() {
	 document.getElementById("numempleado").disabled=true;
	 document.getElementById("cajaApellido").disabled=true;
	 document.getElementById("Comboficio").disabled=true;
	 document.getElementById("ComboDirector").disabled=true;
	 document.getElementById("cajaFecha").disabled=true;
	 document.getElementById("cajaSalario").disabled=true;
	 document.getElementById("cajaComision").disabled=true;
	 document.getElementById("ComboDepartamentos").disabled=true;
	
}
function habilitar() {
	 document.getElementById("numempleado").disabled=false;
	 document.getElementById("cajaApellido").disabled=false;
	 document.getElementById("Comboficio").disabled=false;
	 document.getElementById("ComboDirector").disabled=false;
	 document.getElementById("cajaFecha").disabled=false;
	 document.getElementById("cajaSalario").disabled=false;
	 document.getElementById("cajaComision").disabled=false;
	 document.getElementById("ComboDepartamentos").disabled=false;
	
}

function edit_row(no)
{
 quitar_error();
 desahabilitar();
 
 document.getElementById("edit_button"+no).style.display="none";
 document.getElementById("save_button"+no).style.display="block";
	
 var empleado=document.getElementById("Empleado_row"+no);
 var apellido=document.getElementById("Apellido_row"+no);
 
 var oficio=document.getElementById("Oficio_row"+no);
 var toficio=document.getElementById("Oficio_row"+no).textContent;
 
 var director=document.getElementById("Director_row"+no);
 var tdirector=document.getElementById("Director_row"+no).textContent;
 
 var fecha=document.getElementById("Fecha_row"+no);
 var salario=document.getElementById("Salario_row"+no);
 var comision=document.getElementById("Comision_row"+no);
 
 var departamento=document.getElementById("Departamento_row"+no);
 var tdepartamento=document.getElementById("Departamento_row"+no).textContent;

 var combo=document.getElementById("oculto").value;
 combo=combo.replace("Comboficio","Oficios_row"+no);
 var buscar="<option value='"+ toficio +"'>";
 var reemplazar="<option value='"+ toficio +"' selected>"; 
 combo=combo.replace(buscar,reemplazar);

 var combo1=document.getElementById("oculto2").value;
 combo1=combo1.replace("ComboDirector","Directors_row"+no);
 var buscar="<option value='"+ tdirector +"'>";
 var reemplazar="<option value='"+ tdirector +"' selected>"; 
 combo1=combo1.replace(buscar,reemplazar);
 
 var combo2=document.getElementById("oculto3").value;
 combo2=combo2.replace("ComboDepartamentos","Departamentos_row"+no);
 var buscar="<option value='"+ tdepartamento +"'>";
 var reemplazar="<option value='"+ tdepartamento +"' selected>"; 
 combo2=combo2.replace(buscar,reemplazar);

 var empleado_data=empleado.innerHTML;
 var apellido_data=apellido.innerHTML;
 var fecha_data=fecha.innerHTML;
 var salario_data=salario.innerHTML;
 var comision_data=comision.innerHTML;
 
 empleado.innerHTML="<input type='text' size=5 id='Empleados_row"+no+"' value='"+empleado_data+"'>";
 apellido.innerHTML="<input type='text' id='Apellidos_row"+no+"' value='"+apellido_data+"'>";
 oficio.innerHTML=combo;
 director.innerHTML=combo1;
 fecha.innerHTML="<input type='text' size=5 id='Fechas_row"+no+"' value='"+fecha_data+"'>";
 salario.innerHTML="<input type='text' id='Salarios_row"+no+"' value='"+salario_data+"'>";
 comision.innerHTML="<input type='text' id='Comisions_row"+no+"' value='"+comision_data+"'>";
 departamento.innerHTML=combo2;
}

function save_row(no)
{
 var empleado_var=document.getElementById("Empleados_row"+no).value;
 var apellido_var=document.getElementById("Apellidos_row"+no).value;
 var oficio_var=document.getElementById("Oficios_row"+no).value;
 var director_var=document.getElementById("Directors_row"+no).value;
 var fecha_var=document.getElementById("Fechas_row"+no).value;
 var salario_var=document.getElementById("Salarios_row"+no).value;
 var comision_var=document.getElementById("Comisions_row"+no).value;
 var departamento_var=document.getElementById("Departamentos_row"+no).value;	
 validarEmpleados("Empleados_row"+no);
 
 function validarEmpleados(campo)
 {	
	var empleado = document.getElementById('empleado'); //Nodo donde vamos a mostrar la validación de datos
	var numempleado = document.getElementById(campo);
	empleado.innerHTML = '';
	var valor = numempleado.value;
	var retorno =true;
	if (/^[1-9]\d$/.test(numempleado.value)==false || valor=='')
	{
		document.getElementById('empleado').style.visibility = 'visible';
		empleado.innerHTML = '<h7>Numero empleado tiene que ser numerico </h7>';
		preventDefault();
		retorno=false;
	}
	return retorno;
	}
  
 document.getElementById("Empleado_row"+no).innerHTML=empleado_var;
 document.getElementById("Apellido_row"+no).innerHTML=apellido_var;
 document.getElementById("Oficio_row"+no).innerHTML=oficio_var;
 document.getElementById("Director_row"+no).innerHTML=director_var;
 document.getElementById("Fecha_row"+no).innerHTML=fecha_var;
 document.getElementById("Salario_row"+no).innerHTML=salario_var;
 document.getElementById("Comision_row"+no).innerHTML=comision_var;
 document.getElementById("Departamento_row"+no).innerHTML=departamento_var;

 document.getElementById("edit_button"+no).style.display="block";
 document.getElementById("save_button"+no).style.display="none";
 habilitar()
}

function delete_row(no)
{
 quitar_error();
 habilitar();
 document.getElementById("row"+no+"").outerHTML="";
}

function add_row()
{
 validar();
 var new_empleado=document.getElementById("numempleado").value;
 var new_apellido=document.getElementById("cajaApellido").value;
 var new_oficio=document.getElementById("Comboficio").value;
 var new_director=document.getElementById("ComboDirector").value;
 var new_fecha=document.getElementById("cajaFecha").value;
 var new_salario=document.getElementById("cajaSalario").value;
 var new_comision=document.getElementById("cajaComision").value;
 var new_departamento=document.getElementById("ComboDepartamentos").value;
	
 var table=document.getElementById("tabla");
 var table_len=(table.rows.length)-2;
 var row = table.insertRow(table_len).outerHTML=
	 "<tr id='row"+table_len+"'>" +
	 		"<td id='Empleado_row"+table_len+"'>"+new_empleado+"</td>" +
			"<td id='Apellido_row"+table_len+"'>"+new_apellido+"</td>" +
			"<td id='Oficio_row"+table_len+"'>"+new_oficio+"</td>" +
			"<td id='Director_row"+table_len+"'>"+new_director+"</td>" +
			"<td id='Fecha_row"+table_len+"'>"+new_fecha+"</td>" +
			"<td id='Salario_row"+table_len+"'>"+new_salario+"</td>" +
			"<td id='Comision_row"+table_len+"'>"+new_comision+"</td>" +
			"<td id='Departamento_row"+table_len+"'>"+new_departamento+"</td>" +
			"<td><input type='button' id='edit_button"+table_len+"' value='Edit' class='edit' onclick='edit_row("+table_len+")'> " +
				"<input type='button' id='save_button"+table_len+"' value='Save' class='save' onclick='save_row("+table_len+")'> " +
				"<input type='button' value='Delete' class='delete' onclick='delete_row("+table_len+")'></td></tr>";

 document.getElementById("numempleado").value="";
 document.getElementById("cajaApellido").value="";
 document.getElementById("Comboficio").value="";
 document.getElementById("ComboDirector").value="";
 document.getElementById("cajaFecha").value="";
 document.getElementById("cajaSalario").value="";
 document.getElementById("cajaComision").value="";
 document.getElementById("ComboDepartamentos").value="";
}