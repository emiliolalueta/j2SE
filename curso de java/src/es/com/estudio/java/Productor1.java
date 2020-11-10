package es.com.estudio.java;
import java.io.*;
//import com.atrium.mastersp.modulo2.threads.Almacen.producto;
public class Productor1 extends Thread{
	
	private Almacen almacen;
	//private String alfabeto="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	//private producto buffer[]= new producto[10];
	
	public Productor1(Almacen a){
		almacen=a;
	}
	public void run(){
		
		int cod;
		producto prod=new producto();
		for(int i=0; i<10; i++){
			//c=alfabeto.charAt((int)(Math.random()*26));
			cod=prod.producir();
			almacen.lanzar(cod);
			System.out.println("Producto con codigo: " + cod + " al almacen");
			try{
				sleep((int)(Math.random()*100));
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}	
	public class producto{
		int codigoProducto;
		public int producir(){
			//for(int x=0;x<10;x++){				
				codigoProducto=(int)(Math.random()*300);
				return codigoProducto;
			//}
		}
	}	
	
}
