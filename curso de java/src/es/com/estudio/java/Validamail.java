package es.com.estudio.java;

//Solucion del profesor
import java.io.*;
import java.lang.*;
public class Validamail
{
		public static void main (String args[]) throws IOException
		{		
			BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
			String email=teclado.readLine();
			int posarroba=email.indexOf("@");
			int pospunto=email.indexOf(".");
			if(email.indexOf(" ")!=-1)
			{
				System.out.println("Existe 1 espacio");		
			}
			else if (posarroba==-1)
			{
				System.out.println("No existe @");
			}
			else if (posarroba==0 || posarroba==email.length()-1)
			{
				System.out.println("@ al inicio o al final");
			}	
			else if (posarroba!=email.lastIndexOf("@"))
			{
				System.out.println("Existe + de 1 @");			
			}
			else if(pospunto==-1)
			{
				System.out.println("No hay punto");			
			}
			else if(email.startsWith(".") || email.endsWith("."))
			{
				System.out.println("punto al inicio o final");			
			}
			else if(email.indexOf("@.")!=-1 ||email.indexOf(".@")!=-1 || email.indexOf("..")!=-1)
			{
				System.out.println("Caracteres especiales no permitidos");			
			}	
			else 
			{
				pospunto=email.lastIndexOf(".");
				String dominio=email.substring(pospunto+1);
				if (dominio.length()>=2 && dominio.length()<=4)
				{
					System.out.println("mail correcto");		
				
				}
				else
				{
					System.out.println("dominio incorrecto");		
				}				
			}				
		}
}		
