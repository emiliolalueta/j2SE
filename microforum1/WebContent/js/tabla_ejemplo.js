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
	document.getElementById("anadir").addEventListener("click", add_row);
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
	
	var regEx = /^d{2}\d{2}\d{2}$/;
	var matched = regEx.test("15\11\15")
	
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
	var x = event.cancelable;
	validarEmpleado(elEvento);
	validarApellido(elEvento);
	validarOficio(elEvento);
	validarDirector(elEvento);
	//validarFecha(elEvento)
	validarSalario(elEvento);
	validarComision(elEvento);
	validarDepartamentos(elEvento);

	var retornar = true;
	if(validarEmpleado(elEvento) && validarApellido(elEvento) && validarOficio(elEvento) && validarDirector(elEvento) && validarSalario(elEvento) && validarComision(elEvento) && validarDepartamentos(elEvento)){
		return retornar;
	}else{
		retornar=false;
		return retornar;
	}

}

function add_row(elEvento){
	if(validar(elEvento))
	{
		var a = getCookie("siguiente");
		
		if (a=='si'){
			setCookie("siguiente","",-1);
			document.getElementById('valores').value="";
		}

		var new_empleado=document.getElementById("numempleado").value;
		var new_Apellido=document.getElementById("cajaApellido").value;
		var new_oficio=document.form.Comboficio.options[document.form.Comboficio.selectedIndex].value;
		var new_director=document.form.ComboDirector.options[document.form.ComboDirector.selectedIndex].value;
		var new_fecha=document.getElementById("cajaFecha").value;
		var new_salario=document.getElementById("cajaSalario").value;
		var new_comision=document.getElementById("cajaComision").value;
		var new_departamento=document.form.ComboDepartamentos.options[document.form.ComboDepartamentos.selectedIndex].value;
		
		var elementos="";
		if(document.getElementById('valores').value!=''){
			elementos=document.getElementById('valores').value;	
		}
		
		elementos=elementos+new_empleado + "," + new_Apellido + "," + new_oficio + "," + new_director + "," + new_fecha + "," + new_salario + "," + new_comision + "," + new_departamento + "@";
		
		document.getElementById("valores").value=elementos;
		
		var table=document.getElementById("segundatabla");
		var table_len=(table.rows.length)-1;
		var row = table.insertRow(table_len).outerHTML=
			"<tr id='row"+table_len+"'>"+
			"<td id='empleado_row"+table_len+"'>"+new_empleado+"</td>"+
			"<td id='apellido_row"+table_len+"'>"+new_Apellido+"</td>"+
			"<td id='oficio_row"+table_len+"'>"+new_oficio+"</td>"+
			"<td id='director_row"+table_len+"'>"+new_director+"</td>"+
			"<td id='fecha_row"+table_len+"'>"+new_fecha+"</td>"+
			"<td id='salario_row"+table_len+"'>"+new_salario+"</td>"+
			"<td id='comision_row"+table_len+"'>"+new_comision+"</td>"+
			"<td id='departamento_row"+table_len+"'>"+new_departamento+"</td>"+
			"</tr>";
	
		document.getElementById("numempleado").value="";
		document.getElementById("cajaApellido").value="";
		document.getElementById("Comboficio").innerHTML=document.getElementById("oculto").value;
		document.getElementById("ComboDirector").innerHTML=document.getElementById("oculto2").value;
		document.getElementById("cajaFecha").value="";
		document.getElementById("cajaSalario").value="";
		document.getElementById("cajaComision").value="";
		document.getElementById("ComboDepartamentos").innerHTML=document.getElementById("oculto3").value;
	}
}
function setCookie(cname, cvalue, exdays) {
	  var d = new Date();
	  d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	  var expires = "expires="+d.toUTCString();
	  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
	}

function getCookie(cname) {
	  var name = cname + "=";
	  var ca = document.cookie.split(';');
	  for(var i = 0; i < ca.length; i++) {
	    var c = ca[i];
	    while (c.charAt(0) == ' ') {
	      c = c.substring(1);
	    }
	    if (c.indexOf(name) == 0) {
	      return c.substring(name.length, c.length);
	    }
	  }
	  return "";
	}
