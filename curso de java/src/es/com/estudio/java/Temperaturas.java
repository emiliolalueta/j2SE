package es.com.estudio.java;
import java.io.*;
import java.lang.*;
import java.util.*;
public class Temperaturas
{
		public static void main (String args[]) throws IOException
		{
			//Introduce 12 temperaturas devuelve la maxima,minima y la media.
			
			ArrayList <Integer> temperaturas=new ArrayList<Integer>();
			int mayor,menor,suma,media,contador,temp;
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			contador=0;			
			while(temperaturas.size()<12)
			{
				System.out.println("Introduzca temperatura:");
				temp=Integer.parseInt(teclado.readLine());
				if(temperaturas.contains(temp)==false)
				{
					temperaturas.add(temp);
				}
				else
				{
					System.out.println("Temperatura repetida:");	
				}
			}	
			mayor=temperaturas.get(0);
			menor=temperaturas.get(0);
			suma=temperaturas.get(0);
			for(int i=1;i<temperaturas.size();i++)
			{
				if (temperaturas.get(i)>mayor)
				{
					mayor=temperaturas.get(i);				
				}
				menor=Math.min(temperaturas.get(i),menor);
				suma +=temperaturas.get(i);			
			}
			media=suma/temperaturas.size();						
		}
}