package es.com.estudio.java.excepciones.excepciones;

	public class DemoEmpleado {
	
		public static void main(String args[]){
			Empleado emp1, emp2;
					
				try {
					emp1 = new Empleado("EMPLEADA", "Antonio", "12345678F", 899, 	230);
					emp2 = new Empleado("EMPLEADA", "Antonio", "12345678F", 950, 	230);
					
					emp1.setCargo("EMPLEADO");
					emp2.setSueldo(2000);
		
				} catch (ExceptionSueldo e){
					System.out.println(e.toString());
					
				} catch (ExceptionCargo e1){
					System.out.println(e1.toString());
	
			}			
		}
	}