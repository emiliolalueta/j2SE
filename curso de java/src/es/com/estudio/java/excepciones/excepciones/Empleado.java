package es.com.estudio.java.excepciones.excepciones;


	public class Empleado {
	
		private String nombre;
		private String dni;
		private double sueldo;
		private String cargo;
		private double dietas;
		
		public Empleado(){
			this.cargo = "";
			this.nombre = "";
			this.dni = "";
			this.sueldo = 0;
			this.dietas = 0;
		}
		
		public Empleado(String cargo, String nombre, String dni, double sueldo, double dietas) throws ExceptionSueldo, ExceptionCargo {
						
			if (cargo.equalsIgnoreCase("EMPLEADO") != true){
				throw new ExceptionSueldo("El cargo no es Empleado");	
				
			} else {
				this.cargo = cargo;
				
			}
				
			this.nombre = nombre;
			this.dni = dni;
			
			if (sueldo > 1000.0){
				throw new ExceptionSueldo("El sueldo supera los 1000 �");
				
			} else {
				this.sueldo = sueldo;
				
			}
			
			this.dietas = dietas;
		}
		
		public String getNombre(){ return nombre; }
		public String getDni(){ return dni; }
		public double getSueldo(){ return sueldo; }
		public String getCargo(){ return cargo; }
		public double getDietas(){ return dietas; }
	
		
		public void setNombre(String nuevoNombre){
			this.nombre = nuevoNombre;
		}
		
		
		public void setDni(String nuevoDni){
			this.dni = nuevoDni;
		}
		
		public void setSueldo(double nuevoSueldo) throws ExceptionSueldo {		
		
			if (nuevoSueldo > 1000.0){
				throw new ExceptionSueldo("El sueldo supera los 1000 �");
			} else {
				this.sueldo = nuevoSueldo;
			}
		}

		public void setCargo(String nuevoCargo)throws ExceptionCargo {
		
		 	if (nuevoCargo.equalsIgnoreCase("EMPLEADO") != true){
				throw new ExceptionCargo("El cargo no es Empleado");	
				
			} else {
				this.cargo = nuevoCargo;
				
			}
		}
		
		public double getSueldoFinal(){
			// Redefine el m�todo de la superclase.
			return(this.getSueldo() + this.getDietas());
		}	
		
		public String toString(){
			// Redefine el m�todo de la superclase.
			return(this.getCargo() + " " + this.getNombre() + ", " + this.getDni() + ", " + this.getSueldoFinal());
		}
	}