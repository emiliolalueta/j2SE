/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function generarLink(){
    var eti=document.getElementById("lbllink");
    var direccion="";
    if (document.form1.chkincluir.checked==false){
        direccion="?" + document.form1.txtemp.value;
    }
    else
    {
        direccion="?Emp=" + document.form1.txtemp.value + "&dept=" 
            + document.form1.cmbdept.options[document.form1.cmbdept.selectedIndex].value;
        
    }
    eti.innerHTML="<a href='servletEmp" + direccion + "'>Mostrar Empleado</a>";
}
