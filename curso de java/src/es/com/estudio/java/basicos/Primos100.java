package es.com.estudio.java.basicos;
public class Primos100 {

	public static void main(String args[]){
		int i, j;
		boolean esPrimo;
		
			for (i = 1; i <= 100 ; i++ ){
			
				for (esPrimo=true, j = 2; j < i ; j++ ){
					
					if (i % j == 0){
						esPrimo = false;
						break;
					}				
				}
				
				if (esPrimo){
					System.out.println("El numero: " + i + " es primo ...");
					
				} else {
					System.out.println("El numero: " + i + " no es primo ...");
	
				}
			}
	}
}