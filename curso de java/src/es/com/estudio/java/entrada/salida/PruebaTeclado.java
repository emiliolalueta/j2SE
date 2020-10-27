package es.com.estudio.java.entrada.salida;
import java.io.*;

public class PruebaTeclado {

	public static void main(String args[]){
		String linea; 
		boolean continuar = true;
		try { 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			do {
				System.out.print("Introduce frase:");
				linea= br.readLine(); 
				if (! linea.equalsIgnoreCase("*")){
					System.out.println("Eco: " + linea);
				} else { 
					continuar = false;
				}	
			} while (continuar == true);
			
		} catch(Exception e){ 
			e.printStackTrace();
		} 
		}
	}