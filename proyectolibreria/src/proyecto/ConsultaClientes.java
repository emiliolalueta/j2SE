package proyecto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
public class ConsultaClientes {
	//ID,NOMBRE,APELLIDO1,APELLIDO2,CIFNIF,DIRECCION,POBLACION,CP,SEXO,TELEFONO,MOVIL,FAX,EMAIL,NCUENTA,FECHANACIMIENTO,FECHAINICIO,COMENTARIOS
	
	static String nombre,apellido1,apellido2,cifnif,dir,poblacion,cp,sexo,email,ncuenta,comentarios;	
	static int id,tfno,movil,fax;
	static Date fechanacimiento,fechainicio;
	//static Connection conexion = null;
	//static Statement sentencia;
	static ResultSet resultado;			
	static Clientes cliente;
	static Vector<Clientes> vector=new Vector<Clientes>();
	
	public static void insertar(int id,String nombre,String apellido1,String apellido2,String cifnif, String dir, int tfno,String poblacion,String cp,String sexo,int movil,int fax,String  email,String ncuenta,String fechanacimiento,String fechainicio,String comentarios){
		try{					
				Conexion.conectar();
		        //sentencia = conexion.createStatement();
		        Conexion.sentencia.execute( "INSERT INTO CLIENTES "+        
	        		"VALUES(" +
	        		"'" + id + "'" + "," +	
	        		"'" + nombre + "'" + "," +		
	        		"'" + apellido1 + "'" + "," +	
	        		"'" + apellido2 + "'" + "," +	
	        		"'" + cifnif + "'" + "," +	
	        		"'" + dir    + "'" + "," +
	        		"'" + tfno + "'" + "," +	
	        		"'" + poblacion + "'" + "," +
	        		"'" + cp + "'" + "," +
	        		"'" + sexo + "'" + "," +
	        		"'" + movil + "'" + "," +
	        		"'" + fax + "'" + "," +
	        		"'" + email + "'" + "," +
	        		"'" + ncuenta + "'" + "," +
	        		"'" + fechanacimiento + "'" + "," +
	        		"'" + fechainicio + "'" + "," +
	        		"'" + comentarios  + "'" + ")" );			    
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
	
	public static void modificar(int i,int id,String nombre,String apellido1,String apellido2,String cifnif, String dir, int tfno,String poblacion,String cp,boolean sexo,int movil,String fax,String  email,String ncuenta,Date fechanacimiento,Date fechainicio,String comentarios){
		try{					
				Conexion.conectar();
		        //sentencia = conexion.createStatement();
		        Conexion.sentencia.execute( "UPDATE CLIENTES SET" +	 " " + 	
		        	"ID" + "="  + "'" + id + "'" + "," +		
	        		"NOMBRE" + "=" + "'" + nombre + "'" + "," +		
	        		"APELLIDO1" + "=" + "'" + apellido1 + "'" + "," +	
	        		"APELLIDO2" + "=" + "'" + apellido2 + "'" + "," +
	        		"CIFNIF" + "=" + "'" + cifnif + "'" + "," +
	        		"DIRECCION" + "=" + "'" + dir + "'" + "," +
	        		"TELEFONO" + "=" + "'" + tfno + "'" + "," +		        		
	        		"POBLACION" + "=" + "'" + poblacion + "'" + "," +	
	        		"CP"   + "=" + "'" + cp + "'" + "," +	
	        		"SEXO" + "=" + "'" + sexo + "'" + "," +	
	        		"MOVIL" + "=" + "'" + movil + "'" + "," +	
	        		"FAX" + "=" + "'" + fax + "'" + "," +	
	        		"EMAIL" + "=" + "'" + email + "'" + "," +	
	        		"NCUENTA" + "=" + "'" + ncuenta + "'" + "," +	
	        		"FECHANACIMIENTO" + "=" + "'" + fechanacimiento + "'" + "," +	
	        		"FECHAINICIO" + "=" + "'" + fechainicio + "'" + "," +	
	        		"COMENTARIOS" + "=" + "'" + comentarios + "'" + "," +	        		
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
				  cifnif=resultado.getString("CIFNIF"); 
				  dir=resultado.getString("DIR"); 				 
				  poblacion=resultado.getString("POBLACION"); 
				  cp=resultado.getString("CP"); 
				  sexo=resultado.getString("SEXO"); 
				  movil=resultado.getInt("MOVIL"); 
				  fax=resultado.getInt("FAX"); 
				  email=resultado.getString("EMAIL"); 
				  ncuenta=resultado.getString("NCUENTA"); 
				  fechanacimiento=resultado.getDate("FECHADENACIMIENTO"); 
				  fechainicio=resultado.getDate("FECHAINICIO");  
				  comentarios=resultado.getString("COMENTARIOS"); 
				  
				  cliente.setId(id);
				  cliente.setNombre(nombre);
				  cliente.setApellido1(apellido1);
				  cliente.setApellido2(apellido2);
				  cliente.setDireccion(dir);
				  cliente.setTelefono(tfno);
				  
				  
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
				  dir=resultado.getString("DIR");
				  tfno=resultado.getInt("TFNO"); 				  		  
				  cifnif=resultado.getString("CIFNIF"); 
				  dir=resultado.getString("DIR"); 				 
				  poblacion=resultado.getString("POBLACION"); 
				  cp=resultado.getString("CP"); 
				  sexo=resultado.getString("SEXO"); 
				  movil=resultado.getInt("MOVIL"); 
				  fax=resultado.getInt("FAX"); 
				  email=resultado.getString("EMAIL"); 
				  ncuenta=resultado.getString("NCUENTA"); 
				  fechanacimiento=resultado.getDate("FECHADENACIMIENTO"); 
				  fechainicio=resultado.getDate("FECHAINICIO");  
				  comentarios=resultado.getString("COMENTARIOS"); 
				 		  
				 
				  cliente.setId(id);
				  cliente.setNombre(nombre);
				  cliente.setApellido1(apellido1);
				  cliente.setApellido2(apellido2);
				  cliente.setDireccion(dir);
				  cliente.setTelefono(tfno);
				 
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
			//return null;
		}
		return resultado;						
		
	}
}