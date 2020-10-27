package es.com.estudio.java.excepciones;
	public class Ejemplo1 {
	
		public static void main(String args[]){
		
			try {
				System.out.println("La division por 0 da --> " + 45 / 0);
			} catch (ArithmeticException e){
				System.out.println("Se ha producido el siguiente error ..." + e.getMessage());
			}
		}
	}