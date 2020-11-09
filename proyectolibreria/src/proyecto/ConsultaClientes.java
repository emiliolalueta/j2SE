package proyecto;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Vector;

public class ConsultaClientes {
	static ResultSet resultado;			
	static Clientes cliente;

	public static void insertar(int id,String nombre,String apellido1,String apellido2,String cifnif, String dir, String poblacion,int cp,int sexo, int tfno,int movil,int fax,String  email,String ncuenta,Date fechanacimiento,Date fechainicio,String comentarios){
		try{					
				Conexion.conectar();
		        
		        Conexion.sentencia.execute( "INSERT INTO CLIENTES "+        
	        		"VALUES(" +
	        		"'" + id + "'" + "," +	
	        		"'" + nombre + "'" + "," +		
	        		"'" + apellido1 + "'" + "," +	
	        		"'" + apellido2 + "'" + "," +	
	        		"'" + cifnif + "'" + "," +	
	        		"'" + dir    + "'" + "," +
	        		"'" + poblacion + "'" + "," +
	        		"'" + cp + "'" + "," +	
	        		"'" + sexo + "'" + "," +
	        		"'" + tfno + "'" + "," +
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
		        Conexion.sentencia.execute( "DELETE FROM CLIENTES WHERE ID=" + "'" + id + "'");		        
			}
				catch(Exception e){	
				System.out.println(e);
			}
	}
	
	public static void modificar(int id,String nombre,String apellido1,String apellido2,
			String cifnif, String dir, String poblacion,String cp,int sexo,int tfno,int movil,int fax,String  email,String ncuenta,Date fechanacimiento,Date fechainicio,String comentarios){
		try{					
				Conexion.conectar();
		        Conexion.sentencia.execute( "UPDATE CLIENTES SET" +	 " " + 		
	        		"NOMBRE" + "=" + "'" + nombre + "'" + "," +		
	        		"APELLIDO1" + "=" + "'" + apellido1 + "'" + "," +	
	        		"APELLIDO2" + "=" + "'" + apellido2 + "'" + "," +
	        		"CIFNIF" + "=" + "'" + cifnif + "'" + "," +
	        		"DIRECCION" + "=" + "'" + dir + "'" + "," +		        		
	        		"POBLACION" + "=" + "'" + poblacion + "'" + "," +	
	        		"CP"   + "=" + "'" + cp + "'" + "," +	
	        		"SEXO" + "=" + "'" + sexo + "'" + "," +	
	        		"TELEFONO" + "=" + "'" + tfno + "'" + "," +
	        		"MOVIL" + "=" + "'" + movil + "'" + "," +	
	        		"FAX" + "=" + "'" + fax + "'" + "," +	
	        		"EMAIL" + "=" + "'" + email + "'" + "," +	
	        		"NCUENTA" + "=" + "'" + ncuenta + "'" + "," +	
	        		"FECHANACIMIENTO" + "=" + "'" + fechanacimiento + "'" + "," +	
	        		"FECHAINICIO" + "=" + "'" + fechainicio + "'" + "," +	
	        		"COMENTARIOS" + "=" + "'" + comentarios + "'" + "," +	        		
	        		"WHERE ID" + "=" + "'" + id + "'" );		        		     
			}
		catch(Exception e){	
				System.out.println(e);
			}
	}

	public static Vector<Clientes> consulta(){
		Vector<Clientes> vector=new Vector<Clientes>();
		try{			  
			 Conexion.conectar();
			  						  						  
			 resultado=Conexion.sentencia.executeQuery("SELECT * FROM CLIENTES ORDER BY ID");
			 Clientes cliente=new Clientes();
		   	 while(resultado.next()){	
		   		  cliente.setId(resultado.getInt("ID"));
				  cliente.setNombre(resultado.getString("NOMBRE"));		
				  cliente.setApellido1(resultado.getString("APELLIDO1"));		
				  cliente.setApellido2(resultado.getString("APELLIDO2"));		
				  cliente.setCifNif(resultado.getString("CIFNIF"));
				  cliente.setDireccion(resultado.getString("DIRECCION"));
				  cliente.setPoblacion(resultado.getString("POBLACION"));
				  cliente.setCp(resultado.getInt("CP"));
				  cliente.setSexo(resultado.getInt("SEXO"));
				  cliente.setTelefono(resultado.getInt("TELEFONO")); 				  		  
				  cliente.setMovil(resultado.getInt("MOVIL")); 
				  cliente.setFax(resultado.getInt("FAX")); 
				  cliente.setEmail(resultado.getString("EMAIL")); 
				  cliente.setNcuenta(resultado.getString("NCUENTA")); 
				  cliente.setFechaAlta(resultado.getString("FECHANACIMIENTO")); 
				  cliente.setFechaNacimiento(resultado.getString("FECHAINICIO"));  
				  cliente.setComentarios(resultado.getString("COMENTARIOS"));  
				  
				  vector.addElement(cliente);		
				  
			  }
		   	return vector;
		}
		catch(Exception e){	
			System.out.println(e);
			return null;
		}								
	}
	
	public static ResultSet resultado(){
		try{				
			cliente=new Clientes();
			  Conexion.conectar();			 			  						  
			  resultado=Conexion.sentencia.executeQuery("SELECT ID, NOMBRE, APELLIDO1, APELLIDO2, DIRECCION, TELEFONO, POBLACION, CP, SEXO, MOVIL, FAX, EMAIL, NCUENTA, FECHANACIMIENTO, FECHAINICIO, COMENTARIOS FROM CLIENTES ORDER BY ID;");		   	
		   		return resultado;
		}
		catch(Exception e){	
			System.out.println(e);
			e.printStackTrace();

		}
		return resultado;						
		
	}
}