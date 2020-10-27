package es.com.estudio.java;
import java.io.*;
import java.lang.*;
public class Factorial{
		public static void main (String args[]) throws IOException
		{
				System.out.println("Introduzca un numero por favor:");	
				BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
				int num=Integer.parseInt(teclado.readLine());
				int resultado=num;
				while (num>2)
					{
						resultado=resultado*(num-1);
						num--;
						System.out.println("Secuencia:" + resultado);			
					} 
					System.out.println("El factorial es:" + resultado);
					teclado.readLine();
		}
}
