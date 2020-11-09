package es.com.estudio.java;


public class Almacen {
	//private producto prod=new producto();
	private int buffer[]= new int[10];
	private int siguiente=0;
	private boolean estaLlena=false;
	private boolean estaVacia=true;	
	public synchronized int recoger(){		
		while(estaVacia==true){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}	
			siguiente--;
			if(siguiente==0) estaVacia=true;
			estaLlena=false;
			notify();
			return(buffer[siguiente]);		
	}		
	public synchronized void lanzar(int c){
		while(estaLlena==true){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}			
		}
		buffer[siguiente]=c;
		siguiente++;
		if(siguiente==10) estaLlena=true;
		estaVacia=false;
		notify();
	}		
	//public class producto{
	//	int codigoProducto;
	//}	
	public static void main(String[] args) {
		Almacen al=new Almacen();
		Productor1 hiloA = new Productor1(al);
		Consumidor1 hiloB = new Consumidor1(al);
		  hiloA.start();
		  hiloB.start();
		    try {
		        Thread.currentThread().sleep( 10000 );
		      } catch( InterruptedException e ){}
	}
}