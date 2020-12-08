/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

  function informar(){    
     var mensaje="";
     mensaje+="Se ha seleccionado un procesador ";
     mensaje+=document.miFormulario.procesador.options[document.miFormulario.procesador.selectedIndex].value;
     mensaje+="\n        con sistema operativo ";
     mensaje+=document.miFormulario.soperativo.options[document.miFormulario.soperativo.selectedIndex].value;

     alert(mensaje);
  }





