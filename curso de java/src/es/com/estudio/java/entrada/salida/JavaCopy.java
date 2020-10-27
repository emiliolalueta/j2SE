package es.com.estudio.java.entrada.salida;
import java.io.*;

public class JavaCopy {

	private String nombreFichero;
	
	
	public JavaCopy(String nombreFichero) {
		this.nombreFichero = nombreFichero;		
	}	


	public void copy() throws IOException {
		InputStream f_in;
		OutputStream f_out;
		int size;
		byte []bytes;
		
		String nuevoNombre = "Copia de " + nombreFichero;		
		
		f_in = new FileInputStream(nombreFichero);
		f_out = new FileOutputStream(nuevoNombre);
		
		// Capturo el tama�o en bytes del fichero y reservo memoria para podr
		// leerlos todos a la vez.
		size = f_in.available();
		bytes = new byte[size];
	
		// Leelo los bytes:
		if (f_in.read(bytes) != size){
			System.err.println("No he podido leer todos los bytes ...");
		
		} else {
		
			// Escribo en destino los bytes:
			f_out.write(bytes);
			
		}
		
		// cierro los ficheros:
		f_in.close();
		f_out.close();
	
	}
	
	
	public static void main(String args[]) throws IOException {
		JavaCopy copia = new JavaCopy("ficheroPrueba.txt");
		copia.copy();
	}
	
	
	

}