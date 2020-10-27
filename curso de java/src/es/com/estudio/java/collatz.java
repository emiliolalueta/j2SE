package es.com.estudio.java;
import java.io.*;
import java.lang.*;
public class collatz{
		public static void main (String args[]) throws IOException
		{
				System.out.println("Introduzca un numero:");	
				BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
				int num=Integer.parseInt(teclado.readLine());
				while (num!=1)
					{
						System.out.println("Secuencia:" + num);
						if (num%2==0)
							{
								num=num/2;
							}
						else
							{
								num=num*3+1;
							}
					} 
					teclado.readLine();
		}
}