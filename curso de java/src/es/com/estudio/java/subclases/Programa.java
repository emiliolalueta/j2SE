package es.com.estudio.java.subclases;
public class Programa {

	public static void main(String[] args) 
	{
		SuperClase objeto = new SubClase();
		objeto.metodo1();//m�todo de instancia
		objeto.metodo2();//m�todo de clase
		
		SubClase objeto2 = new SubClase();
		objeto2.metodo1();//m�todo de instancia
		objeto2.metodo2();//m�todo de clase
		
		SuperClase objeto3 = new SuperClase();
		objeto3.metodo1();//m�todo de instancia
		objeto3.metodo2();//m�todo de clase
		
	}

}
