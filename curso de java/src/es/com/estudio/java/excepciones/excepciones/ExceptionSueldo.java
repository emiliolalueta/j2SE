package es.com.estudio.java.excepciones.excepciones;


	public class ExceptionSueldo extends Exception {
		
		private String mensaje;
		
		public ExceptionSueldo(String mensaje){
			this.mensaje = mensaje;
		}
		
		public String toString(){
			return mensaje;
		}
	}