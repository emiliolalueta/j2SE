package es.com.estudio.java.herencia;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Padre p = new Padre();
		p.metodo();
		Hijo h = new Hijo();
		h.metodo();
		Padre p2 = new Hijo();
		((Padre)p2).metodo();
		
		Padre p3 = p2;
		p3.metodo();
		Main t = test();
	}
	
	private static Main test()	
	{
		return new Main();
		
	}

}
