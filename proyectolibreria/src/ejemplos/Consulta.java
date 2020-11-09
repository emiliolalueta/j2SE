package ejemplos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
public class Consulta {
	
	static String nombre,apellido1,apellido2,dir,ocupacion;	
	static int id,tfno;
	//static Connection conexion = null;
	//static Statement sentencia;
	static ResultSet resultado;			
	static Clientes cliente;
	static Vector<Clientes> vector=new Vector<Clientes>();
	
	public static void insertar(int id,String nombre,String apellido1,String apellido2, String dir, int tfno,String ocupacion){
		try{					
				Conexion.conectar();
		        //sentencia = conexion.createStatement();
		        Conexion.sentencia.execute( "INSERT INTO CLIENTES "+        
	        		"VALUES(" +
	        		"'" + id + "'" + "," +	
	        		"'" + nombre + "'" + "," +		
	        		"'" + apellido1 + "'" + "," +	
	        		"'" + apellido2 + "'" + "," +	
	        		"'" + dir    + "'" + "," +
	        		"'" + tfno + "'" + "," +		
	        		"'" + ocupacion  + "'" + ")" );		        
			}
		catch(Exception e){	
				System.out.println(e);
			}
	}
	
	public static void borrar(int id){
		try{					
				Conexion.conectar();
		        //sentencia = conexion.createStatement();
		        Conexion.sentencia.execute( "DELETE FROM CLIENTES WHERE ID=" + "'" + id + "'");		        
			}
				catch(Exception e){	
				System.out.println(e);
			}
	}
	
	public static void modificar(int i,int id,String nombre,String apellido1,String apellido2, String dir, int tfno,String ocupacion){
		try{					
				Conexion.conectar();
		        //sentencia = conexion.createStatement();
		        Conexion.sentencia.execute( "UPDATE CLIENTES SET" +	 " " + 	
		        	"ID" + "="  + "'" + id + "'" + "," +		
	        		"NOMBRE" + "=" + "'" + nombre + "'" + "," +		
	        		"APELLIDO1" + "=" + "'" + apellido1 + "'" + "," +	
	        		"APELLIDO2" + "=" + "'" + apellido2 + "'" + "," +	
	        		"DIRECCION" + "=" + "'" + dir + "'" + "," +
	        		"TELEFONO" + "=" + "'" + tfno + "'" + "," +		
	        		"OCUPACION" + "=" + "'" + ocupacion  + "'" + 	
	        		"WHERE ID" + "=" + "'" + i + "'" );
		        		     
			}
		catch(Exception e){	
				System.out.println(e);
			}
	}
	public static Vector<Clientes> consultanombre(){
		//Vector<Clientes> vector;
		try{			  
			  Conexion.conectar();
			  //sentencia = conexion.createStatement();						  						  
			  resultado=Conexion.sentencia.executeQuery("SELECT * FROM CLIENTES WHERE NOMBRE=" + "'" + nombre + "'");
			   cliente=new Clientes();
			 // vector=new Vector<Clientes>();
		   	 while(resultado.next()){	
		   		  id=resultado.getInt("ID")	;
				  nombre=resultado.getString("NOMBRE");		
				  apellido1=resultado.getString("APELLIDO1");		
				  apellido2=resultado.getString("APELLIDO2");		
				  dir=resultado.getString("DIR");
				  tfno=resultado.getInt("TFNO"); 	
				  ocupacion=resultado.getString("OCUPACION");		
				  
				  cliente.setId(id);
				  cliente.setNombre(nombre);
				  cliente.setApellido1(apellido1);
				  cliente.setApellido2(apellido2);
				  cliente.setDireccion(dir);
				  cliente.setTelefono(tfno);
				  cliente.setOcupacion(ocupacion);
				  vector.addElement(cliente);
				  
				  vector.lastElement();				 
			  }
		   	return vector;
		}
		catch(Exception e){	
			System.out.println(e);
			return null;
		}								
	}
	
	public static Vector<Clientes> consulta(){		
		try{			 
			cliente=new Clientes();
			  Conexion.conectar();
			  //sentencia= conexion.createStatement();						  						  
			  resultado=Conexion.sentencia.executeQuery("SELECT * FROM CLIENTES ORDER BY ID");			  
			  
		   	 while(resultado.next()){	
		   		  id=resultado.getInt("ID")	;
				  nombre=resultado.getString("NOMBRE");		
				  apellido1=resultado.getString("APELLIDO1");		
				  apellido2=resultado.getString("APELLIDO2");		
				  dir=resultado.getString("DIRECCION");
				  tfno=resultado.getInt("TELEFONO"); 	
				  ocupacion=resultado.getString("OCUPACION");				  
				 
				  cliente.setId(id);
				  cliente.setNombre(nombre);
				  cliente.setApellido1(apellido1);
				  cliente.setApellido2(apellido2);
				  cliente.setDireccion(dir);
				  cliente.setTelefono(tfno);
				  cliente.setOcupacion(ocupacion);
				  vector.addElement(cliente);
				  
				  vector.lastElement();				 
			  }
		   	return vector;
		}
		catch(Exception e){	
			System.out.println(e);
			e.printStackTrace();
			return null;
		}						
	}
	public static ResultSet resultado(){
		try{			 
			cliente=new Clientes();
			  Conexion.conectar();			 			  						  
			  resultado=Conexion.sentencia.executeQuery("SELECT * FROM CLIENTES ORDER BY ID;");		   	
		   		return resultado;
		}
		catch(Exception e){	
			System.out.println(e);
			e.printStackTrace();
			return null;
		}						
		
	}
}