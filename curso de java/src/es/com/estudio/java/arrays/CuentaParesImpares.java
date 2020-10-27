package es.com.estudio.java.arrays;
public class CuentaParesImpares {

	public static void main(String args[]){
		int []numeros = {4, 6, 1, 9, 10, 7, 3};
		int i, pares, impares;	
		
		for (i=0, pares=0, impares=0; i < numeros.length ; i++){
			if (numeros[i] % 2 == 0){
				pares++;
			
			} else {
				impares++;
			
			}	
		}
		
		System.out.println("El n�mero de pares es: " + pares + " y los impares son: " + impares);
	}
}