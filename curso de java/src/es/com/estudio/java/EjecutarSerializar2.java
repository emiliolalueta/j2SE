package es.com.estudio.java;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class EjecutarSerializar2 
{
	public static void main(String[] args) throws ExcLimite, ExcVacio 
	{	
		try 
		{
			String fichero="ficheros\\Facturas.txt"; 
			ContenedorFactura conten = new ContenedorFactura();
			conten.Insertar(new Factura(1, "2010-01-01", "Yo mismo", "Jose luis", 210.01));
			conten.Insertar(new Factura(2, "2010-01-02", "Yo1 mismo", "Maria", 211.01));
			conten.Insertar(new Factura(3, "2010-01-03", "Yo2 mismo", "Antonio", 212.01));
			conten.Insertar(new Factura(4, "2010-01-04", "Yo3 mismo", "Julio", 213.01));
			
			//conten.Insertar(new Factura(4, "2010-01-04", "Yo3 mismo", "Julio", 213.01));
				
			Factura [] factura= conten.listado();
			
        	//********************************************************
        	//*Parte de Serializar guardando en fichero
        	//********************************************************			
	        FileOutputStream fos = null;
	        ObjectOutputStream salida = null;

			fos = new FileOutputStream(fichero);
            salida = new ObjectOutputStream(fos);
            
			for(int i=0;i<factura.length;i++) 
				salida.writeObject(factura[i]);
			/*{
				System.out.println("Id " + factura[i].getId() +
									" Fecha " + factura[i].getFecha() +
									" Ordenante " + factura[i].getOrdenante() +
									" Pagador " + factura[i].getPagador() +
									" Importe " + factura[i].getImporte());
			}*/			
			salida.close();

			//********************************************************
        	//*Parte de Serializar leyendo del fichero
        	//********************************************************   
		     
	        Factura p = null ;	
	        FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream entrada = new ObjectInputStream(fis);           
            
    	  	p = (Factura) entrada.readObject(); 
			System.out.println("Id " + p.getId() +
					" Fecha " + p.getFecha() +
					" Ordenante " + p.getOrdenante() +
					" Pagador " + p.getPagador() +
					" Importe " + p.getImporte());
	          
	          while (p!=null){
	        	  	p = (Factura) entrada.readObject(); //es necesario el casting
	    			System.out.println("Id " + p.getId() +
	    					" Fecha " + p.getFecha() +
	    					" Ordenante " + p.getOrdenante() +
	    					" Pagador " + p.getPagador() +
	    					" Importe " + p.getImporte());	        	  
	          }           
          
		} catch (Exception e) 
		{
			System.out.println(e.toString());
		}
					
	}
}

class ContenedorFactura {
	
	private ArrayList<Factura> facturas; 
	
	public ContenedorFactura() {
		this.facturas=new ArrayList<Factura>();
	}
	public void Insertar(Factura fac) throws ExcLimite {
		if (this.facturas.size()<4) {
			this.facturas.add(fac);	
		}else {
			throw new ExcLimite("El limite de 4 facturas se ha realizado");
		}
		
	}
	public Factura[] listado() throws ExcVacio{
		if(this.facturas.isEmpty()){
			throw new ExcVacio("No tenemos datos de facturas");
			
		}else {
			Iterator<Factura> it = this.facturas.iterator();
			int tamano = this.facturas.size();
			int indice=0;
			Factura[] filas=new Factura[tamano];
			while(it.hasNext()) {
				filas[indice] = (Factura) it.next();
				indice++;
			}
			return filas;
		}
		
	}
}

class Factura implements Serializable{

	private int id;
    private String fecha;
    private String ordenante;
    //private transient String pagador;
    //***********************************************************
    //*No serializa ya que hemos puesto transient
    //***********************************************************
    private transient String pagador;
    private double importe;

    public Factura(int id, String fecha, String ordenante, String pagador, double importe) {                                                         
        this.id=id;
        this.fecha = fecha;
        this.ordenante = ordenante;
        this.pagador=pagador;
        this.importe=importe;       
    }
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getOrdenante() {
		return ordenante;
	}

	public void setOrdenante(String ordenante) {
		this.ordenante = ordenante;
	}

	public String getPagador() {
		return pagador;
	}

	public void setPagador(String pagador) {
		this.pagador = pagador;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

}
class ExcVacio extends Exception{
	private String mensaje;
	
	public ExcVacio(String mensaje) {
		this.mensaje=mensaje;
	}
	
	public String toString() {
		return this.mensaje;
	}

}

class ExcLimite extends Exception{
	private String mensaje;
	
	public ExcLimite(String mensaje) {
		this.mensaje=mensaje;
	}
	
	public String toString() {
		return this.mensaje;
	}

}
