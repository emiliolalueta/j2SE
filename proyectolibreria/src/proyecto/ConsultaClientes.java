package proyecto;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ConsultaClientes {
	static ResultSet resultado;			
	static Clientes cliente;

	
	public static void insertar(Clientes cliente) {
		try {

			SimpleDateFormat formatofechas = new SimpleDateFormat("yyyy-mm-dd");
			
			Date fechanaciento=formatofechas.parse(cliente.getFechaNacimiento());
			Date fechaNacTabla = new java.sql.Date(fechanaciento.getTime());
			
			Date fechalta=formatofechas.parse(cliente.getFechaAlta());
			Date fechaAltTabla = new java.sql.Date(fechalta.getTime());

			Conexion.conectar();
	        
	        Conexion.sentencia.execute( "INSERT INTO CLIENTES "+        
        		"VALUES(" +
        		"'" + cliente.getId() + "'" + "," +	
        		"'" + cliente.getNombre() + "'" + "," +		
        		"'" + cliente.getApellido1() + "'" + "," +	
        		"'" + cliente.getApellido2() + "'" + "," +	
        		"'" + cliente.getCifNif() + "'" + "," +	
        		"'" + cliente.getDireccion() + "'" + "," +
        		"'" + cliente.getPoblacion() + "'" + "," +
        		"'" + cliente.getCp() + "'" + "," +	
        		"'" + cliente.getSexo() + "'" + "," +
        		"'" + cliente.getTelefono() + "'" + "," +
        		"'" + cliente.getMovil() + "'" + "," +
        		"'" + cliente.getFax() + "'" + "," +
        		"'" + cliente.getEmail() + "'" + "," +
        		"'" + cliente.getNcuenta() + "'" + "," +
        		"'" + cliente.getFechaNacimiento() + "'" + "," +
        		"'" + cliente.getFechaAlta() + "'" + "," +
        		"'" + cliente.getComentarios() + "'" + ")" );			    

			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	/*public static void insertar(int id,String nombre,String apellido1,String apellido2,String cifnif, String dir, String poblacion,int cp,int sexo, int tfno,int movil,int fax,String  email,String ncuenta,Date fechanacimiento,Date fechainicio,String comentarios){
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
	*/
	public static void borrar(int id){
		try{					
				Conexion.conectar();
		        Conexion.sentencia.execute( "DELETE FROM CLIENTES WHERE ID=" + "'" + id + "'");		        
			}
				catch(Exception e){	
				System.out.println(e);
			}
	}

	public static void modificar(Clientes cliente){
		try{					
				
			SimpleDateFormat formatearFecha = new SimpleDateFormat("yyyy-mm-dd");
			
			Date fechaNac = formatearFecha.parse(cliente.getFechaAlta());
			Date fechaAlt = formatearFecha.parse(cliente.getFechaAlta());
			
			java.sql.Date fechaNacTab = new java.sql.Date(fechaNac.getTime());
			java.sql.Date fechaAltTab = new java.sql.Date(fechaAlt.getTime());
			
			Conexion.conectar();
	        
			Conexion.sentencia.execute( "UPDATE CLIENTES SET" +	 " " + 		
	        		"NOMBRE" + "=" + "'" + cliente.getNombre() + "'" + "," +		
	        		"APELLIDO1" + "=" + "'" + cliente.getApellido1() + "'" + "," +	
	        		"APELLIDO2" + "=" + "'" + cliente.getApellido2() + "'" + "," +
	        		"CIFNIF" + "=" + "'" + cliente.getCifNif() + "'" + "," +
	        		"DIRECCION" + "=" + "'" + cliente.getDireccion() + "'" + "," +		        		
	        		"POBLACION" + "=" + "'" + cliente.getPoblacion() + "'" + "," +	
	        		"CP"   + "=" + "'" + cliente.getCp() + "'" + "," +	
	        		"SEXO" + "=" + cliente.getSexo() + "," +	
	        		"TELEFONO" + "=" + "'" + cliente.getTelefono() + "'" + "," +
	        		"MOVIL" + "=" + "'" + cliente.getMovil() + "'" + "," +	
	        		"FAX" + "=" + "'" + cliente.getFax() + "'" + "," +	
	        		"EMAIL" + "=" + "'" + cliente.getEmail() + "'" + "," +	
	        		"NCUENTA" + "=" + "'" + cliente.getNcuenta() + "'" + "," +	
	        		"FECHANACIMIENTO" + "=" + "'" + cliente.getFechaNacimiento() + "'" + "," +	
	        		"FECHAINICIO" + "=" + "'" + cliente.getFechaAlta() + "'" + "," +	
	        		"COMENTARIOS" + "=" + "'" + cliente.getComentarios() + "'" +	        		
	        		"WHERE ID" + "=" + "'" + cliente.getId() + "'" );	
	        
			}
		catch(Exception e){	
				System.out.println(e);
			}
	}
	/*
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
	*/
	public static Vector<Clientes> consulta(){
		
		try{			  
			 Conexion.conectar();
			  						  						  
			 resultado=Conexion.sentencia.executeQuery("SELECT * FROM CLIENTES ORDER BY ID");
			 Vector<Clientes> vector=new Vector<Clientes>();
			 while(resultado.next()){	

				 Clientes cliente=new Clientes();
				 cliente.setId(resultado.getInt("ID"));
				 cliente.setNombre(resultado.getString("NOMBRE"));		
				 cliente.setApellido1(resultado.getString("APELLIDO1"));		
				 cliente.setApellido2(resultado.getString("APELLIDO2"));		
				 cliente.setCifNif(resultado.getString("CIFNIF"));
				 cliente.setDireccion(resultado.getString("DIRECCION"));
				 cliente.setPoblacion(resultado.getString("POBLACION"));
				 cliente.setCp(resultado.getInt("CP"));
				 cliente.setSexo(resultado.getBoolean("SEXO"));
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
	public static DefaultTableModel buildTableModel()
	           throws SQLException {

		try
		{			  
			 Conexion.conectar();
			  						  						  
			 resultado=Conexion.sentencia.executeQuery("SELECT * FROM CLIENTES ORDER BY ID");		 

		     Vector<String> columnNames = new Vector<String>();
		     /*
		     ResultSetMetaData metaData = resultado.getMetaData();
		     // names of columns si sacamos el nombre del campo de la tabla
		     
		     int columnCount = metaData.getColumnCount();
		     for (int column = 1; column <= columnCount; column++) {
		         columnNames.add(metaData.getColumnName(column));
		     }
		     */
		     //names of columns dado a mano
		     
		     String[] aManocolumnNames ={
					"ID",
					"Nombre",
					"Primer apellido",
					"Segundo apellido",
					"Cif/Nif",
					"Direccion",
					"Poblacion",
					"CP",
					"SEXO",
					"Telefono",
					"Movil",
					"Fax",
					"Email",
					"Ncuenta",
					"Fecha nacimiento",
					"Fecha alta",
					"Comentarios"};
		     
		     int columnCount = aManocolumnNames.length;
	 		 for(int i=0;i<aManocolumnNames.length;i++) {
	 			columnNames.addElement((String) aManocolumnNames[i]);

		     }
			
		     // data of the table
		     Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		     while (resultado.next()) 
		     {
		         Vector<Object> vector = new Vector<Object>();
		         for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) 
		         {
		             vector.add(resultado.getObject(columnIndex));
		     	
		         }
		         data.add(vector);
		     }
		     return new DefaultTableModel(data, columnNames) {
		    	 @Override
		         public boolean isCellEditable(int row, int column) {
		            //all cells false
		            return false;
		         }
		     };
	    }
		catch(Exception e){	
			System.out.println(e);
			return null;
		}	
	    
	}
}