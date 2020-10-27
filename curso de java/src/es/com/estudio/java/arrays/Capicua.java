package es.com.estudio.java.arrays;
public class Capicua {

	public static void main(String args[]){
		boolean valor;
		int i, j, vector[] = {1, 2, 3, 4, 5, 0,  4, 3, 2, 1};	
		int n;
		
		if (vector.length % 2 == 0){
			n = vector.length / 2;
		
		} else {
			n = (vector.length / 2) + 1;
		
		}
	
		for (valor = true, i =	0, j = vector.length - 1; i < n ; i++, j-- ){
		
			if (vector[i] != vector[j]){
				valor = false;
				break;
			}
		}
		
		if (valor == true){
			System.out.println("El vector es capicua ...");
		
		} else {
			System.out.println("El vector no es capicua ...");		
		
		}
	}
}