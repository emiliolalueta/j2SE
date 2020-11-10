package es.com.estudio.java;
public class EjecutarHilosMultiples2 {

	public static void main(String[] args) throws InterruptedException {

		Thread padre= Thread.currentThread();
		
		System.out.println("Current thread : " + padre);
		padre.setPriority(Thread.MAX_PRIORITY);
		System.out.println("10 segundos esperando");
			
		PruebaRunnable hijo1 = new PruebaRunnable(Thread.MAX_PRIORITY);
		PruebaRunnable hijo2 = new PruebaRunnable(Thread.MIN_PRIORITY);
		
		hijo1.getHilo().start();
		hijo2.getHilo().start();
		
		padre.sleep(10000);
		
		System.out.println("Despues de los 10 segundos");
		/*hijo1.getHilo().interrupt();
		hijo2.getHilo().interrupt();*/

		System.out.println("hijo1 a dado " + hijo1.getContador() + " vueltas en el bucle");
		System.out.println("hijo2 a dado " + hijo2.getContador() + " vueltas en el bucle");

		hijo1.parar();
		hijo2.parar();
		
		System.out.println(hijo1.getHilo().isAlive());
		System.out.println(hijo2.getHilo().isAlive());
			
	}

}
class PruebaRunnable implements Runnable{
	private int prioridad;
	private double contador;
	private Thread hilo;
	private boolean ejecutar;
	
	public PruebaRunnable(int prioridad) 
	{
		this.prioridad=prioridad;
		this.contador=0;
		Thread t = new Thread(this, "Hilo hijo creado");
		System.out.println("El hilo hijo es : " + t.toString());
		t.setPriority(this.prioridad);
		this.hilo=t;
		this.ejecutar=true;
	}
	public void run() 
	{
		try {
			while(this.ejecutar==true) 
			{
				this.contador++;
			}	
		} catch (Exception e) {
			System.out.println("Error en hijo");
		}
		
		System.out.println("Muere hijo ");
		
	}
	
	public void parar() {
		setEjecutar(false);
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public double getContador() {
		return contador;
	}
	public void setContador(double contador) {
		this.contador = contador;
	}
	public Thread getHilo() {
		return hilo;
	}
	public void setHilo(Thread hilo) {
		this.hilo = hilo;
	}
	public boolean isEjecutar() {
		return ejecutar;
	}
	public void setEjecutar(boolean ejecutar) {
		this.ejecutar = ejecutar;
		System.out.println(this.ejecutar);
	}


}