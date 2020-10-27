package es.com.estudio.java;
import java.io.*;
public class teclado{
public static void main (String args[]) throws IOException
	{
		System.out.println("Introduzca un texto");
		java.io.BufferedReader teclado= new java.io.BufferedReader(new InputStreamReader(System.in));
		String dato=teclado.readLine();
		System.out.println(dato);
		teclado.readLine();	
	}
}