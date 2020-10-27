package es.com.estudio.java;
import java.io.*;
import java.lang.*;
public class Mayornumero{
public static void main (String args[]) throws IOException
	{
		System.out.println("Introduzca un numero:");		
		java.io.BufferedReader teclado= new java.io.BufferedReader(new InputStreamReader(System.in));
		int dato1=Integer.parseInt(teclado.readLine());
		
		System.out.println("Introduzca un otro numero:");		
		int dato2=Integer.parseInt(teclado.readLine());

		System.out.println("Introduzca un otro numero mas:");		
		int dato3=Integer.parseInt(teclado.readLine());
		
		if (dato1>dato2 && dato1>dato3)
		{
			if (dato2>dato3)		
			{
				System.out.println("El mayor es:" + dato1 + " mediano" + dato2 + " peque�o " + dato3 );
				teclado.readLine();
			}else
			{
				System.out.println("El mayor es:" + dato1 + " mediano" + dato3 + " peque�o " + dato2 );
				teclado.readLine();
			}
		} 
		else if (dato2>dato1 && dato2>dato3)
		{
			if (dato1>dato3)		
			{
				System.out.println("El mayor es:" + dato2 + " mediano " + dato1 + " peque�o " + dato3 );
				teclado.readLine();
			}else
			{
				System.out.println("El mayor es:" + dato2 + " mediano " + dato3 + " peque�o " + dato1 );
				teclado.readLine();
			}
		}
		else
		{
			if (dato1>dato3)		
			{
					System.out.println("El mayor es:" + dato2 + " mediano " + dato1 + " peque�o " + dato3 );
					teclado.readLine();
			}
			else
			{
					System.out.println("El mayor es:" + dato2 + " mediano " + dato3 + " peque�o " + dato1 );
					teclado.readLine();
			}
		}
	}
}