package es.com.estudio.java;
import java.io.*;
public class Consumidor1 extends Thread{
	private Almacen almacen;
	public Consumidor1(Almacen a){
		almacen=a;
	}
	public void run(){
		int c;
		for(int i=0; i<10;i++){
			c=almacen.recoger();
			System.out.println("Recogido el caracter" + c);
			try{
				sleep((int)(Math.random()*2000));				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}		
}
