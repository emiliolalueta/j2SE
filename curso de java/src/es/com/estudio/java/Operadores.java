package es.com.estudio.java;
//import java.io.BufferedReader;
import java.io.*;
public class Operadores
{
	public static void main (String args[]) throws IOException
	{
		int numero=5;
		if (numero>0)
		{
			System.out.println("positivo");		
		}
		else if(numero<0)
		{
			System.out.println("negativo");	
		}
		else
		{
			System.out.println("Cero");
		}		
		String nombre ="ANA";
		if (nombre.equals("ANA"))
		{
			System.out.println("Nombre ANA");
		}
		else
		{
			System.out.println("NO es ANA");
		}		
		int valor=1;
		switch (valor)
		{
			case 0:
			//acciones 0
			System.out.println("Cero");
			break;
			case 1:
			//acciones 1
			System.out.println("UNO");
			case 2:
			//acciones 2
			System.out.println("dos");
			default:
			//acciones default
			System.out.println("Otro");
		}	
		
		System.out.println("Introduzca un texto");
		java.io.BufferedReader teclado= new java.io.BufferedReader(new InputStreamReader(System.in));
		String dato=teclado.readLine();
		System.out.println(dato);
 		teclado.readLine();
	}	
}