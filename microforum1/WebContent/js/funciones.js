/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function devolverFecha()
{
    var fecha=new Date();
    var texto=fecha.getDate() + "/" + (fecha.getMonth() + 1) + "/" + fecha.getYear();
    return texto;
}
function devolverHora()
{
    var fecha=new Date();
    var texto=fecha.getHours() + ":" + fecha.getMinutes() + ":" + fecha.getSeconds();
    return texto;    
}
function dibujarTabla()
{
    var texto=document.form1.txttexto.value;
    var tabla="<table border='1'>";
    for (var i=0; i<texto.length;i++)
        {
            tabla +="<tr><td>";
            tabla +=texto.charAt(i);
            tabla +="</td></tr>";
        }
    tabla +="</table>";
    var eti=document.getElementById("lbltabla");
    eti.innerHTML=tabla;
}


