package es.com.estudio.java.arrays;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class EjecutarClasesAbstractas {

	public static void main(String[] args) {


	}

}

abstract class Coche  implements Radio{

	private double peso;

	private double altura;
	private Ruedas rueda1;
	private Ruedas rueda2;
	private Ruedas rueda3;
	private Ruedas rueda4;
	private Ruedas rueda[];
	private int dimension = 10;
	
	
	private int numeros[];
	private int dimensions = 10;
		
	private boolean subirVolumenRadio;
	
	private boolean encenderRadio;
	
		
	public Coche(double peso,double altura, Ruedas rueda[])  {
	
		 this.rueda = rueda;
		 this.rueda = new Ruedas[dimension];
	
	}
	
	
	public Coche(int numeros [])  {
		
		this.numeros = numeros;
	    this.numeros = new int[dimension];
	
	}
	
//	public Ruedas arrayruedas(List<Ruedas> rued) {
//		int i=1;
//		Iterator itr=rued.iterator();
//		while(itr.hasNext()) {
//			if(i==1) {
//				this.rueda1=itr.
//			}
//		}
//	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}

	public Ruedas getRueda1() {
		return rueda1;
	}
	public void setRueda1(Ruedas rueda1) {
		this.rueda1 = rueda1;
	}
	public Ruedas getRueda2() {
		return rueda2;
	}
	public void setRueda2(Ruedas rueda2) {
		this.rueda2 = rueda2;
	}
	public Ruedas getRueda3() {
		return rueda3;
	}
	public void setRueda3(Ruedas rueda3) {
		this.rueda3 = rueda3;
	}
	public Ruedas getRueda4() {
		return rueda4;
	}
	public void setRueda4(Ruedas rueda4) {
		this.rueda4 = rueda4;
	}

	public boolean isSubirVolumenRadio() {
		return subirVolumenRadio;
	}
	
	public void setSubirVolumenRadio(boolean subirVolumenRadio) {
		this.subirVolumenRadio = subirVolumenRadio;
	}
	public boolean isApagarRadio() {
		return encenderRadio;
	}
	public void setApagarRadio(boolean apagarRadio) {
		this.encenderRadio = apagarRadio;
	}

	public void encender() {
		this.encenderRadio=true;
		System.out.println("Encendiendo la Radio");
	}
	
	public void apagar() {
		this.encenderRadio=false;
		System.out.println("Apagando la Radio");
	}
	public void subirVolumen() {
		this.subirVolumenRadio=true;
		System.out.println("Subiendo el volumen de la radio");
	}

	public void bajarVolumen() {
		this.subirVolumenRadio=false;
		System.out.println("Bajando el volumen de la radio");
	}
	
	public void inflarRueda(String rue) {
		System.out.println("Inflando la rueda " + rue);
	}

}

abstract class Ruedas{
	private String marca;
	private String modelo;
	private double presion;

	public Ruedas(String marca, String modelo , double presion) {
		this.marca=marca;
		this.modelo=modelo;
		this.presion=presion;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getPresion() {
		return presion;
	}
	public void setPresion(double presion) {
		this.presion = presion;
	}
	
	abstract void inflarRueda(String rue);
	
}

interface Radio{
	abstract void encender();
	abstract void apagar();
	abstract void subirVolumen();
	abstract void bajarVolumen();
}

