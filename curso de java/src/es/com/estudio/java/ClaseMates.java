package es.com.estudio.java;
public class ClaseMates

{
	public void verMensaje()
	{
		System.out.println("Mensaje pantalla");	
	}
	public int sumarNumeros(int num1,int num2)
	{
		return num1 + num2;
	}
	public boolean comprobarPar(int numero)
	{
		if (numero%2==0)
		{
			return true;
		}	
		else
		{
			return false;
		}
	}
}