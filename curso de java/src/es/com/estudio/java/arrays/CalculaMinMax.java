package es.com.estudio.java.arrays;
public class CalculaMinMax {

	public static void main(String args[]){
	int []array = {5, -1, 8, 90, 34, -8};
	int min, max,i, i_min, i_max;
	
	
		for (i=1, max=array[0], min=array[0], i_min = 0, i_max = 0; i < array.length ; i++){
		
			if (array[i] < min){
				min = array[i];
				i_min = i;
			}
			
			if (array[i] > max){
				max = array[i];
				i_max = i;
			}
		}
		
		System.out.println("El numero max es: " + max + " en la posici�n " + i_max + "\n" +
								 "El numero min es: " + min + " en la posici�n " + i_min);
								 
	}
}