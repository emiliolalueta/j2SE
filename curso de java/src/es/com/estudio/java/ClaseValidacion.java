package es.com.estudio.java;
import java.io.*;
public class ClaseValidacion
{
	public Character validarDni(String textodni)
	{
			boolean sonnumeros=true;
			char letra;
			String serieletras="TRWAGMYFPDXBNJZSQVHLCKET";
			for (int i=0;i< textodni.length();i++)
			{
					if(Character.isDigit(textodni.charAt(i))==false)
					{
						sonnumeros=false;
						break;
					}
			}
			if(sonnumeros==true)
			{
				int numerodni=Integer.parseInt(textodni);
				int resultado=(numerodni-(numerodni/23)*23);
				letra=serieletras.charAt(resultado);
				System.out.println("Letra:" + letra);
				return letra;	
			}else
			{
				return null;//solo las clases admiten devolver un null los tipos primitivos no
			}
	}
	
	
	public boolean validarEmail(String email)
	{
			boolean correcto=true;
			int posarroba=email.indexOf("@");
			int pospunto=email.indexOf(".");
			if(email.indexOf(" ")!=-1)
			{
				correcto=false;
				System.out.println("Existe 1 espacio");		
			}
			else if (posarroba==-1)
			{
				correcto=false;
				System.out.println("No existe @");
			}
			else if (posarroba==0 || posarroba==email.length()-1)
			{
				correcto=false;
				System.out.println("@ al inicio o al final");
			}	
			else if (posarroba!=email.lastIndexOf("@"))
			{
				correcto=false;
				System.out.println("Existe + de 1 @");			
			}
			else if(pospunto==-1)
			{
				correcto=false;
				System.out.println("No hay punto");			
			}
			else if(email.startsWith(".") || email.endsWith("."))
			{
				correcto=false;
				System.out.println("punto al inicio o final");			
			}
			else if(email.indexOf("@.")!=-1 ||email.indexOf(".@")!=-1 || email.indexOf("..")!=-1)
			{
				correcto=false;
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
					correcto=false;
					System.out.println("dominio incorrecto");		
				}				
			}
			return correcto;
	}
	
}