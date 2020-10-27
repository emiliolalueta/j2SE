package es.com.estudio.java;
import java.io.*;
import java.lang.*;
public class Isbn
{
		public static void main (String args[]) throws IOException
		{
				System.out.println("Introduzca un numero por favor:");	
				BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
								String isbn;
				isbn=teclado.readLine();				
				//System.out.println(texto);				
				
			if (	isbn.length()!=10)
			{
				System.out.println("la longitud debe ser de 10");
			}
			else
			{
				int suma=0;
				for(int i=0;i<isbn.length();i++)
				{
					//Character caracter =isbn.charAt(i);
					//int numero=Integer.parseInt(String.valueOf(caracter));							
					//otra forma
									Character caracter =isbn.charAt(i);
					int numero=Integer.parseInt(caracter.toString());	
					int multi=numero*(i+1);
					suma+=multi;
					//suma=suma+multi;																
				}				
				if(suma%11==0)
				{
					System.out.println("isbn correcto");				
				}				
				else
				{
					System.out.println("isbn incorrecto");
				}		
			}			
		}
}

