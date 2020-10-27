package es.com.estudio.java.excepciones.excepciones;

	public class ExceptionCargo extends Exception {
		
		private String mensaje;
		
		public ExceptionCargo(String mensaje){
			this.mensaje = mensaje;
		}
		
		public String toString(){
			return mensaje;
		}
	}
