package es.com.estudio.java;
import java.io.*;
import java.lang.*;
import java.util.*;
public class Coleccion{
		public static void main (String args[]) throws IOException
		{
			ArrayList coleccion=new ArrayList();
			int array[]=new int[4];			
			for (int i=0;i<array.length;i++)			
			{
				System.out.println("Elemento Array:" + array[i]);
			}			
				coleccion.add("Elemento 1");
				coleccion.add("Elemento 2");
				coleccion.add("25");
				coleccion.add(0,"Elemento 3");			
				coleccion.remove(1);			
			for (int i=0;i<coleccion.size();i++)			
			{
				System.out.println("Coleccion:" + coleccion.get(i));
			}
			//Ejemplo de bucle por referencia da fallo porque lo hemos definido como object********
			//	for (String N:coleccion)
			//		{
			//			System.out.println("Referencia:" + N);
			//		}
			//************** asi mejor aunque da fallo************************
			//for (Object N:coleccion)
			//{
			//	System.out.println("Referencia:" + N);
			//}
			// para diferenciar entre tipos de clase asi se distingue la clase string de las demas
			//if (N instanceof String)
			//{
				//System.out.println("Referencia:" + N);
			//}			
			ArrayList <String> lista=new ArrayList <String>();
			lista.add("25");
			lista.add("texto");			
			for (Object N:lista)
			{
				System.out.println(lista.toString().toUpperCase());
			}	
			
			String texto=("texto, desde , java");
			String elementos[]=texto.split(",");
			for (int i=0;i<elementos.length;i++)
			{
				System.out.println(elementos[i]);
			}
		}
}

