package es.com.estudio.java;
import java.io.*;
public class ClaseArranque

{
	public static void main (String args[]) throws IOException
	{
		//String texto;
		//ClaseMates miclase=new ClaseMates();
		//miclase.verMensaje();
		//texto.substring(2,5);	
		System.out.println("Introduzca un mail o dni:");
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		String dato=teclado.readLine();
		System.out.println("Seleccione una opcion:");
		System.out.println("1.-Validar emal:");
		System.out.println("1.-Validar dni:");
		int opcion =Integer.parseInt(teclado.readLine());
		ClaseValidacion c=new ClaseValidacion(); 
		if (opcion==1)
		{
			boolean valor=c.validarEmail(dato);
			System.out.println(valor);
		}
		else
		{
			Character letra=c.validarDni(dato);
			System.out.println(letra);
		}		
	}
}