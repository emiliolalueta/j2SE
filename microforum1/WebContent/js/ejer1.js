/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

        function CargarModelos() {
        var Bmw=new Array('Z3','320','COMPACT','Z8');
	var Mercedes=new Array('SLK','S32','CLASE A','CLASE C');
	var Audi=new Array('A3','A4','A6','A8');
        var Volvo=new Array('S40','S60','S80','NINO');
	var Valor = document.Form1.CmbCoches.selectedIndex;
        document.Form1.TxtIndice.value =
        "Elemento: " + document.Form1.CmbCoches.value;
	LimpiarSelect();
        for (i=0;i< Bmw.length;i++)
        {
        
        a=document.createElement("OPTION");
        switch (Valor)
            {

                case 0:
                    a.text=Bmw[i];
                    a.value=i;
                break;
                case 1:
                    a.text=Mercedes[i];
                    a.value=i;
                break;
                case 2:
                    a.text=Audi[i];
                    a.value=i;
                break;
                case 3:
                    a.text=Volvo[i];
                    a.value=i;
                break;
            }
                document.Form1.CmbModelos.add(a,i);
        }
        }

        function LimpiarSelect() {
        if (document.Form1.CmbModelos.length!=0){
         for (i=0;i < 4;i++) {
          //alert(document.Form1.CmbModelos.options[i].text);
          document.Form1.CmbModelos.remove(0);
          }
         }
        }
 



