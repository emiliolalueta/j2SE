package es.com.estudio.java.arrays;
public class HayOrden {

	public static void main(String ar[]){
		
	int vector2[] = {3, 5, 6, 7, 8, 99};
	int vector[] = {3, 5, 3, 5, 6, 7 ,8 };
	int i;
	boolean orden;
	
		for (i = 1, orden = true; i < vector.length ; i++){
			
			if (vector[i - 1] > vector[i]){
				orden = false;
				break;
			}
		
		}
		
		if (orden==true){
			System.out.println("Los elementos del array est�n ordenados ...");
		
		} else {
			System.out.println("Los elementos del array NO est�n ordenados ...");

		}   
	}
}