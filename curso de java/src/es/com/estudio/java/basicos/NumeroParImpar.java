package es.com.estudio.java.basicos;
import java.io.*;

	public class NumeroParImpar{
	
		public static void main(String args[]){
		
			int x;
			
			try {
			
				System.out.print("Introduzca un numero: ");
				x = System.in.read();
					
			} catch(IOException e){
			
				System.out.println("ERROR: " + e.getMessage());
				x = 10;
			
			}				
		
			if ( x % 2 == 0){
				System.out.println("El numero es par");
			
			} else {
				System.out.println("El numero es impar");			
			}
		}
	}