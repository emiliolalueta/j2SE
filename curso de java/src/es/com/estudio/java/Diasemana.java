package es.com.estudio.java;
import java.io.*;
import java.lang.*;
public class Diasemana
{
		public static void main (String args[]) throws IOException
		{
			System.out.println("Introduzca una fecha:");	
			BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));				
			String fecha=teclado.readLine();
			int posicion =fecha.indexOf("/");
			int dia=Integer.parseInt(fecha.substring(0,posicion));
			fecha=fecha.substring(posicion +1);
			posicion=fecha.indexOf("/");
			int mes= Integer.parseInt(fecha.substring(0,posicion));
			fecha=fecha.substring(posicion+1);
			int anyo=Integer.parseInt(fecha);
			if (mes==1)
			{
					mes =13;
					anyo--;		
			}
			else if (mes==2)
			{
					mes=14;
					anyo--;					
			}
			int op1,op2,op3,op4,op5,op6,resultado;
			op1=((mes+1)*3)/5;
			op2=anyo/4;
			op3=anyo/100;
			op4=anyo/400;
			op5=dia+(mes*2)+anyo+op1+op2-op3+op4+2;
			op6=op5/7;
			resultado=op5-(op6*7);	
			String diasemana="";
			switch(resultado)
			{
				case 0:
					diasemana="sabado";
					break;
				case 1:
					diasemana="domingo";
					break;
				case 2:
					diasemana="lunes";			
					break;
				case 3:
					diasemana="martes";
					break;
				case 4:
					diasemana="miercoles";
					break;
				case 5:
					diasemana="jueves";
					break;															
				case 6:
					diasemana="viernes";			
					break;					
			}
			System.out.println("dia de la semana :" + diasemana);
			teclado.readLine();	
							
		}
}


