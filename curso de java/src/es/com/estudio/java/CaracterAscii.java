package es.com.estudio.java;
public class CaracterAscii
{
	public static void main (String arg[])
	{
		for (int i=0;i<=255;i++)
		{
			char caracter=(char)i;
			if(Character.isDigit(caracter))
			{
				System.out.println("Numeros:" + caracter);			
			}
			else if (Character.isLetter(caracter))
			{
				System.out.println("Letras:" + caracter);			
			}
			else if(Character.isISOControl(caracter))
			{			
				System.out.println("ISO:" + caracter);
			}
			else
			{
				System.out.println("Otros:" + caracter);				
			}		
		}	
		String texto="APP JAVA";
		texto=texto.toLowerCase();//el hecho de aplicar un metodo a un objeto no implica que cambie su valor		
		System.out.println(texto);
		System.out.println("SUBCADENA:" + texto.substring(2,5));//devuelve de la posicion 2 a la 5 no incluida
		//if (texto.toLowerCase()=="app java")
	}
}